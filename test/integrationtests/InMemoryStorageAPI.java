package integrationtests;

import project.annotations.StorageAPI;

public class InMemoryStorageAPI implements StorageAPI {

    private String storedInput;
    private String storedOutput;

    @Override
    public String readInput(String source) {
        this.storedInput = source;
        return storedInput;
    }

    @Override
    public String writeOutput(String destination) {
        this.storedOutput = destination;
        return storedOutput;
    }

    public String getStoredInput() {
        return storedInput;
    }

    public String getStoredOutput() {
        return storedOutput;
    }
    
    public String getOutputData() {
        return storedOutput;
    }

	@Override
	public String parseInput(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatOutput(String data) {
		// TODO Auto-generated method stub
		return null;
	}
}

