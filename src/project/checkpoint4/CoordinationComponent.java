package project.checkpoint4;

import java.io.IOException;
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
            throw new IllegalArgumentException("Input file path cannot be null.");
        }

        if (outputFile == null) {
            throw new IllegalArgumentException("Output file path cannot be null.");
        }
        

        try {
            // Step b: read integers from file
            List<Integer> numbers = storage.readInputFile(inputFile);

            // Step c: pass integers to the compute component
            int limit = numbers.get(0);
            List<Integer> results = compute.compute(limit);

            // Step d: write results to file
            storage.writeOutputFile(outputFile, results);

            return "SUCCESS: Computation complete.";
        } catch (IOException e) {
            return "ERROR: File operation failed - " + e.getMessage();
        } catch (NumberFormatException e) {
            return "ERROR: Invalid number in input file.";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }
}