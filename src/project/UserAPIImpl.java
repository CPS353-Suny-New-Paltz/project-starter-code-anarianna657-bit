package project;
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
}
