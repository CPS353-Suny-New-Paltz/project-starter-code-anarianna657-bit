package project.annotations;

@ProcessAPI
public interface StorageAPI {
    String readInput(String filePath);
    String parseInput(String rawData);
    String formatOutput(String data);
	String writeOutput(String formatted);
}
