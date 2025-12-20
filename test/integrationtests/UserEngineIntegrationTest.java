package integrationtests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.List;

import project.FastEngineAPIImpl;
import project.UserAPIImpl;
import project.annotations.EngineAPI;
import project.annotations.StorageAPI;

public class UserEngineIntegrationTest {

    @Test
    public void testUserAndEngineInteraction() {
        FastEngineAPIImpl engineApi = new FastEngineAPIImpl();
        InMemoryStorageAPI storageApi = new InMemoryStorageAPI();
        UserAPIImpl userApi  = new UserAPIImpl(engineApi, storageApi);

        String output = engineApi.calculatePrimes(10);
        assertNotNull(output);
        assertEquals("2, 3, 5, 7", output);
    }

    @Test
    public void testEngineComputeIntegration() {
        FastEngineAPIImpl engineApi = new FastEngineAPIImpl();
        InMemoryStorageAPI storageApi = new InMemoryStorageAPI();
        UserAPIImpl userApi = new UserAPIImpl(engineApi, storageApi);

        String result = engineApi.compute(5);
        assertNotNull(result);
    }

    @Test
    public void testStorageFailureIsHandledGracefully() {
        EngineAPI engine = new FastEngineAPIImpl();

        StorageAPI failingStorage = new StorageAPI() {
            @Override
            public List<Integer> readInput(Path filePath) {
                throw new RuntimeException("Simulated read failure");
            }
            @Override 
            public int parseInput(List<Integer> rawData) { 
            	return 0; 
            }
            
            @Override 
            public String formatOutput(List<Integer> primes) { 
            	return ""; 
            	
            }
            @Override 
            public boolean writeOutput(Path destination, String formattedOutput) {
                return true;
            }
        };

        UserAPIImpl userApi = new UserAPIImpl(engine, failingStorage);
        userApi.setInput("input.txt");
        userApi.setOutput("out.txt");

        String result = userApi.run();

        assertEquals("SUCCESS", result);
    }

    @Test
    public void testWriteFailureCausesRunToFail() {
        EngineAPI engine = new FastEngineAPIImpl();

        StorageAPI failingWriteStorage = new StorageAPI() {
            @Override
            public List<Integer> readInput(Path filePath) {
                return List.of(10);
            }
            
            @Override 
            public int parseInput(List<Integer> rawData) { 
            	return 10; 
            }
            @Override public String formatOutput(List<Integer> primes) {
                return "[4]";
            }
            @Override public boolean writeOutput(Path destination, String formattedOutput) {
                return false;
            }
        };

        UserAPIImpl userApi = new UserAPIImpl(engine, failingWriteStorage);
        userApi.setInput("input.txt");
        userApi.setOutput("out.txt");

        String result = userApi.run();

        assertEquals("ERROR: Failed to write output", result);
    }
}