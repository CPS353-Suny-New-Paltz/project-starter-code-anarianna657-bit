package project;
import java.util.List;

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
