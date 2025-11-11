package project.annotations;

public class StoragePrototype {

    @ProcessAPIPrototype
    public String prototype(StorageAPI storage) {
        String inputData = storage.readInput("Hello world!");
        String result = storage.writeOutput(inputData);
        return result;
    }
}
