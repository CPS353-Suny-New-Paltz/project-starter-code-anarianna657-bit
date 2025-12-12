package testharness;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import project.checkpoint4.CoordinationComponent;

public class TestUser {

    // TODO 3: change the type of this variable to the name you're using for your
    // @NetworkAPI interface; also update the parameter passed to the constructor
    private final CoordinationComponent coordinator;

    public TestUser(CoordinationComponent coordinator) {
        this.coordinator = coordinator;
    }

    public void run(String outputPath) {
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "testInputFile.test";
        
        try {
            File f = new File(inputPath);
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
                Files.writeString(f.toPath(), "10");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // TODO 4: Call the appropriate method(s) on the coordinator to get it to
        // run the compute job specified by inputPath, outputPath, and delimiter
        coordinator.startComputation(
                Path.of(inputPath),
                Path.of(outputPath)
        );
    }

}