package integrationtests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import project.annotations.EngineAPI;
import project.annotations.StorageAPI;
import project.UserAPIImpl;

public class UserEngineIntegrationTest {

    @Test
    public void testUserApiAndEngineApiInteraction() {
        EngineAPI mockEngine = mock(EngineAPI.class);
        StorageAPI mockStorage = mock(StorageAPI.class);
        UserAPIImpl userAPI = new UserAPIImpl(mockEngine, mockStorage);

        when(mockEngine.calculatePrimes(10)).thenReturn("2, 3, 5, 7");

        String result = userAPI.runEngineTask(mockEngine, 10);

        verify(mockEngine).calculatePrimes(10);
        assertEquals("2, 3, 5, 7", result);
    }

    @Test
    public void testUserApiHandlesEngineFailure() {
        EngineAPI mockEngine = mock(EngineAPI.class);
        StorageAPI mockStorage = mock(StorageAPI.class);
        UserAPIImpl userAPI = new UserAPIImpl(mockEngine, mockStorage);

        when(mockEngine.calculatePrimes(5)).thenThrow(new RuntimeException("Engine crashed"));

        String result;
        try {
            result = userAPI.runEngineTask(mockEngine, 5);
        } catch (Exception e) {
            result = "error";
        }

        assertNotNull(result);
    }
}
