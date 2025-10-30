package project;
import java.util.List;

import project.annotations.EngineAPI; 

public class EngineAPIImpl implements EngineAPI {

    public EngineAPIImpl() {
        // no setup yet
    }
    
	 @Override
	    public String compute(int n) {
	        return calculatePrimes(n);
	    }

	    @Override
	    public String calculatePrimes(int limit) {
	        project.checkpoint4.ComputationComponent computation = new project.checkpoint4.ComputationComponent();
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
	        return builder.toString();
	    }
}
