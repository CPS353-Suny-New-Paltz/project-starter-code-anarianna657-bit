package project.annotations;

@ProcessAPI
public interface StorageAPI {
    String readInput(String source);
    String writeOutput(String destination);
}
