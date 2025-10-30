package project;
import java.util.List;

import project.annotations.EngineAPI;
import project.annotations.StorageAPI;
import project.annotations.UserAPI;

public class UserAPIImpl implements UserAPI {

    private EngineAPI engineApi;
    private StorageAPI storageApi;

    public UserAPIImpl(EngineAPI engineApi, StorageAPI storageApi) {
        this.engineApi = engineApi;
        this.storageApi = storageApi;
    }

    // Example empty method, return default values
    public String findPrimes(int input) {
        return "";
    }

	@Override
	public void setInput(String sourceUri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOutput(String sinkUri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDelimiters(String pairDelimiter, String kvDelimiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useDefaultDelimiters() {
		// TODO Auto-generated method stub
		
	}
	
	public String calculatePrimes(int limit) {
	    project.checkpoint4.ComputationComponent computation = new project.checkpoint4.ComputationComponent();
	    List<Integer> primes = computation.compute(limit);

	    if (primes.isEmpty()) {
	        return "";
	    }

	    return primes.toString().replace("[", "").replace("]", "").trim();
	}

}
