package project.checkpoint4;
<<<<<<< Updated upstream
import java.io.IOException;
=======

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        try {
            //Step b: read integers from file
=======

        if (inputFile == null) {
            return "ERROR: Input file path is null.";
        }

        if (outputFile == null) {
            return "ERROR: Output file path is null.";
        }

        try {
>>>>>>> Stashed changes
            List<Integer> numbers = storage.readInputFile(inputFile);
            if (numbers.isEmpty()) {
                return "ERROR: Could not read valid numbers from input file.";
            }

<<<<<<< Updated upstream
            //Step c: pass integers to the compute component
            int limit = numbers.get(0);
            List<Integer> results = compute.compute(limit);

            //Step d: write results to file
            storage.writeOutputFile(outputFile, results);
=======
            int limit = numbers.get(0);
            List<Integer> results = compute.compute(limit);

            boolean success = storage.writeOutputFile(outputFile, results);
            if (!success) {
                return "ERROR: Failed to write output to file.";
            }
>>>>>>> Stashed changes

            return "SUCCESS: Computation complete.";

        } catch (Exception e) {
            return "ERROR: Unexpected failure - " + e.getMessage();
        }
    }
}
