package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import project.annotations.EngineAPI;
import project.annotations.StorageAPI;
import project.annotations.UserAPI;

public class UserAPIImpl implements UserAPI {

    private final EngineAPI engine;
    private final StorageAPI storage;
    private String inputSource;
    private String outputDestination;

    public UserAPIImpl(EngineAPI engine, StorageAPI storage) {
        this.engine = engine;
        this.storage = storage;
    }

    public String findPrimes1(int limit) {
        return engine.calculatePrimes(limit);
    }

    @Override
    public void setInput(String sourceUri) {
        this.inputSource = sourceUri;
    }

    @Override
    public void setOutput(String sinkUri) {
        this.outputDestination = sinkUri;
    }

    @Override
    public void setDelimiters(String pairDelimiter, String kvDelimiter) {
    }

    @Override
    public void useDefaultDelimiters() {
    }

    @Override
    public String run() {
        try {
            Path inputPath = Paths.get(inputSource);
            Path outputPath = Paths.get(outputDestination);
            List<Integer> rawNumbers = storage.readInput(inputPath);
            System.out.println("RAW: " + rawNumbers);
            int limit = storage.parseInput(rawNumbers);
            System.out.println("PARSED (limit): " + limit);

            if (limit < 0) {
                return "ERROR: Invalid input.";
            }

            String primes = engine.calculatePrimes(limit);
            System.out.println("COMPUTED PRIMES: " + primes);
            String formatted = storage.formatOutput(List.of(Integer.valueOf(primes)));
            System.out.println("FORMATTED: " + formatted);
            boolean written = storage.writeOutput(outputPath, formatted);
            System.out.println("OUTPUT DEST: " + outputDestination);

            return written ? "SUCCESS" : "ERROR: Could not write output.";

        } catch (Exception e) {
            return "ERROR: Unexpected failure - " + e.getMessage();
        }
    }

    public String runEngineTask(EngineAPI mockEngine, int i) {
        return mockEngine.compute(i);
    }

    public String findPrimes(int input) {
        return engine.calculatePrimes(input);
    }

    public String displayComputationSummary() {
        return "Computation complete for " + inputSource + " → " + outputDestination;
    }
}
