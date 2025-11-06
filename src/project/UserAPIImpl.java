package project;
import project.annotations.EngineAPI;
import project.annotations.StorageAPI;
import project.annotations.UserAPI;

public class UserAPIImpl implements UserAPI {

	    private final EngineAPI engine;
	    private final StorageAPI storage;

	    public UserAPIImpl(EngineAPI engine, StorageAPI storage) {
	        this.engine = engine;
	        this.storage = storage;
	    }
	    
	    public String findPrimes(int limit) {
	        return engine.calculatePrimes(limit);
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

		public String runEngineTask(EngineAPI mockEngine, int i) {
			// TODO Auto-generated method stub
			return null;
		}
}
