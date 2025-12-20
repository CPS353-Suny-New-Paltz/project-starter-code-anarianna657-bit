package benchmark;

import org.junit.jupiter.api.Test;
import project.FastEngineAPIImpl;
import project.SlowEngineAPIImpl;
import project.annotations.EngineAPI;

public class EnginePerformanceBenchmarkTest {

    @Test
    public void benchmarkPrimeComputation() {
        EngineAPI slow = new SlowEngineAPIImpl();
        EngineAPI fast = new FastEngineAPIImpl();

        int limit = 100_000;

        long slowStart = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            slow.calculatePrimes(limit);
        }
        long slowEnd = System.nanoTime();

        long fastStart = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            fast.calculatePrimes(limit);
        }
        long fastEnd = System.nanoTime();

        System.out.println("Slow Engine time (ns): " + (slowEnd - slowStart));
        System.out.println("Fast Engine time (ns): " + (fastEnd - fastStart));
    }
}