package integrationtests;
import org.junit.jupiter.api.Test;
import project.EngineAPIImpl;
import project.annotations.EngineAPI;


public class TestEngineAPI {

    @Test
    public void testEngineApiInitialization() {
        EngineAPIImpl engineApi = new EngineAPIImpl();
        assert engineApi != null : "EngineAPIImpl should be created successfully";
    }

    @Test
    public void testCalculatePrimesReturnsEmptyString() {
        EngineAPIImpl engineApi = new EngineAPIImpl();
        String result = engineApi.calculatePrimes(10);
        assert result.isEmpty() : "calculatePrimes should return empty string until implemented";
    }
}
