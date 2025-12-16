package integrationtests;
import org.junit.jupiter.api.Test;
import project.FastEngineAPIImpl;


public class TestEngineAPI {

    @Test
    public void testEngineApiInitialization() {
        FastEngineAPIImpl engineApi = new FastEngineAPIImpl();
        assert engineApi != null : "EngineAPIImpl should be created successfully";
    }

    @Test
    public void testCalculatePrimesHandlesNegativeInput() {
        FastEngineAPIImpl engineApi = new FastEngineAPIImpl();
        String result = engineApi.calculatePrimes(-5);
        assert result != null : "calculatePrimes should not return null for negative input";
    }
}
