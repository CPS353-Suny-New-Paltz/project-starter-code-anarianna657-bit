package project.annotations.api;

public class StoragePrototype {
    public void prototype(StorageAPI storageapi) {
        storageapi.readInput("Hello world!");
        storageapi.writeOutput(null);
    }
}