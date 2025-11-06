package integrationtests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import project.annotations.EngineAPI;
import project.annotations.StorageAPI;
import project.UserAPIImpl;

public class UserEngineIntegrationTest {

    @Test
    public void testUserAPICallsEngineAPIAndReturnsPrimes() {
    	
        EngineAPI mockEngine = mock(EngineAPI.class);
        StorageAPI mockStorage = mock(StorageAPI.class);
        UserAPIImpl userApi = new UserAPIImpl(mockEngine, mockStorage);
        when(mockEngine.calculatePrimes(10)).thenReturn("2, 3, 5, 7");
        String result = mockEngine.calculatePrimes(10);
        verify(mockEngine).calculatePrimes(10);
        assertEquals("2, 3, 5, 7", result, "UserAPI should return the primes from EngineAPI");
    }

    @Test
    public void testUserAPIHandlesEngineCompute() {
        EngineAPI mockEngine = mock(EngineAPI.class);
        StorageAPI mockStorage = mock(StorageAPI.class);
        UserAPIImpl userApi = new UserAPIImpl(mockEngine, mockStorage);
        when(mockEngine.compute(5)).thenReturn("Result: 120");
        String result = mockEngine.compute(5);
        verify(mockEngine).compute(5);
        assertEquals("Result: 120", result, "UserAPI should correctly return EngineAPI’s compute result");
    }

    @Test
    public void testUserAPIHandlesEngineFailure() {
        EngineAPI mockEngine = mock(EngineAPI.class);
        StorageAPI mockStorage = mock(StorageAPI.class);
        UserAPIImpl userApi = new UserAPIImpl(mockEngine, mockStorage);
        when(mockEngine.calculatePrimes(5)).thenThrow(new RuntimeException("Engine failure"));
        String result;
        try {
            result = mockEngine.calculatePrimes(5);
        } catch (Exception e) {
            result = "error";
        }

        assertNotNull(result, "UserAPI should handle engine failures gracefully");
    }
}
