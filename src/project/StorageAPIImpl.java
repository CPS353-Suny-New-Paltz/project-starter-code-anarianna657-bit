package project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import project.annotations.StorageAPI;

public class StorageAPIImpl implements StorageAPI {

    private String rawInput;
    private String parsedInput;
    private String formattedOutput;

    @Override
    public String readInput(String source) {
        this.rawInput = source;
        return rawInput;
    }

    @Override
    public String parseInput(String raw) {
        this.parsedInput = raw.replace("\n", ",");
        return parsedInput;
    }

    @Override
    public String formatOutput(String data) {
        this.formattedOutput = data.trim();
        return formattedOutput;
    }

    @Override
    public String writeOutput(String destination) {
        try {
            Path path = Paths.get(destination);
            Files.write(path, formattedOutput.getBytes());
        } catch (Exception e) {
            return "";
        }
        return formattedOutput;
    }

	public boolean saveData(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}

