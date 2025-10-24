package project;

import project.annotations.EngineAPI;

@EngineAPI
public class EngineAPIImpl {

    private StorageAPIImpl storageApi;

    public EngineAPIImpl(StorageAPIImpl storageApi) {
        this.storageApi = storageApi;
    }

    public String processRequest(int input) {
        return null; // placeholder return
    }
}
