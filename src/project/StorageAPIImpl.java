package project;

import project.annotations.StorageAPI;

public class StorageAPIImpl implements StorageAPI {

    @Override
    public String readInput(String source) {
        return source;
    }

    @Override
    public String parseInput(String raw) {
        return raw.replace("\n", ",");
    }

    @Override
    public String formatOutput(String data) {
        return data.trim();
    }

	@Override
	public String writeOutput(String formatted) {
		return null;
	}

	public boolean saveData(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}

