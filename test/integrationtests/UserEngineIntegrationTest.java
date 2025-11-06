package integrationtests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import project.EngineAPIImpl;
import project.StorageAPIImpl;
import project.UserAPIImpl;

public class UserEngineIntegrationTest {

    @Test
    public void testUserAndEngineInteraction() {
        EngineAPIImpl engineApi = new EngineAPIImpl();
        StorageAPIImpl storageApi = new StorageAPIImpl();
        UserAPIImpl userApi = new UserAPIImpl(engineApi, storageApi);

        String output = engineApi.calculatePrimes(10);
        assertNotNull(output);
        assertEquals("2, 3, 5, 7", output);
    }

    @Test
    public void testEngineComputeIntegration() {
        EngineAPIImpl engineApi = new EngineAPIImpl();
        StorageAPIImpl storageApi = new StorageAPIImpl();
        UserAPIImpl userApi = new UserAPIImpl(engineApi, storageApi);

        String result = engineApi.compute(5);
        assertNotNull(result);
    }
}

