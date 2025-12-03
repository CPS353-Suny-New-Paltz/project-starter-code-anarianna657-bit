package project.checkpoint4;

import java.nio.file.Path;
import java.util.List;
import project.annotations.NetworkAPI;

@NetworkAPI
public class CoordinationComponent {

    private final DataStorageComponent storage;
    private final ComputationComponent compute;

    public CoordinationComponent() {
        this.storage = new DataStorageComponent();
        this.compute = new ComputationComponent();
    }

    public String startComputation(Path inputFile, Path outputFile) {

        if (inputFile == null) {
            return "ERROR: Input file path is null.";
        }

        if (outputFile == null) {
            return "ERROR: Output file path is null.";
        }

        try {
            List<Integer> numbers = storage.readInputFile(inputFile);
            if (numbers.isEmpty()) {
                return "ERROR: Could not read valid numbers from input file.";
            }

            int limit = numbers.get(0);
            List<Integer> results = compute.compute(limit);

            boolean success = storage.writeOutputFile(outputFile, results);
            if (!success) {
                return "ERROR: Failed to write output to file.";
            }

            return "SUCCESS: Computation complete.";

        } catch (Exception e) {
            return "ERROR: Unexpected failure - " + e.getMessage();
        }
    }
}
