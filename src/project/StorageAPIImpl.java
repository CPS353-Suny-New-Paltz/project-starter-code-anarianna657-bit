package project;

import project.annotations.StorageAPI;

public class StorageAPIImpl implements StorageAPI {

    public StorageAPIImpl() {
    }

    @Override
    public String readInput(String source) {
        return source;
    }

    @Override
    public String writeOutput(String destination) {
        return "Output written to " + destination;
    }

    public boolean saveData(String data) {
        return false;
    }

    public void saveData(String output, String result) {
    }
}

