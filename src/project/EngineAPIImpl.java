package project;
import java.util.List;

import project.annotations.EngineAPI; 

public class EngineAPIImpl implements EngineAPI {

    public EngineAPIImpl() {
        // no setup yet
    }

	@Override
	public String compute(int n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String calculatePrimes(int limit) {
		
	    project.checkpoint4.ComputationComponent computation = new project.checkpoint4.ComputationComponent();
	    List<Integer> primes = computation.compute(limit);

	    return primes.toString().replace("[", "").replace("]", "").trim();
	}

}
