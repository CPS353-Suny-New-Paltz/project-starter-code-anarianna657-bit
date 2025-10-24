package project;

import project.annotations.UserAPI;

@UserAPI
public class UserAPIImpl {

    private EngineAPIImpl engineApi;
    private StorageAPIImpl storageApi;

    public UserAPIImpl(EngineAPIImpl engineApi, StorageAPIImpl storageApi) {
        this.engineApi = engineApi;
        this.storageApi = storageApi;
    }

    public String handleUserRequest(int input) {
        return ""; // placeholder return
    }
}