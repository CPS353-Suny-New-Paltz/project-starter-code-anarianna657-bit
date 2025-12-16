package project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.annotations.EngineAPI;
import project.checkpoint4.ComputationComponent;

/**
 * Optimized Engine implementation for Checkpoint 8.
 * Uses caching to avoid recomputing prime results for repeated inputs.
 */
public class FastEngineAPIImpl implements EngineAPI {

    private final Map<Integer, String> primeCache = new HashMap<>();

    @Override
    public String compute(int n) {
        if (n <= 2) {
            return "";
        }
        return calculatePrimes(n);
    }

    @Override
    public String calculatePrimes(int limit) {
        if (limit <= 2) {
            return "";
        }

        if (primeCache.containsKey(limit)) {
            return primeCache.get(limit);
        }

        ComputationComponent computation = new ComputationComponent();
        List<Integer> primes = computation.compute(limit);

        if (primes == null || primes.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < primes.size(); i++) {
            builder.append(primes.get(i));
            if (i < primes.size() - 1) {
                builder.append(", ");
            }
        }

        String result = builder.toString().trim();
        primeCache.put(limit, result);

        return result;
    }
}