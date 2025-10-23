package project.annotations.api;
import project.annotations.ProcessAPIPrototype;

public class StoragePrototype {
	@ProcessAPIPrototype
    public void prototype(StorageAPI storageapi) {
        storageapi.readInput("Hello world!");
        storageapi.writeOutput(null);
    }
}