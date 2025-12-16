package integrationtests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import project.FastEngineAPIImpl;
import project.UserAPIImpl;

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
}

