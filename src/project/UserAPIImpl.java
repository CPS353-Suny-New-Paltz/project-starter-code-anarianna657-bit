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
        Path outputPath = Paths.get(outputDestination);
        String outputData;

        try {
            Path inputPath = Paths.get(inputSource);
            List<Integer> rawNumbers = storage.readInput(inputPath);
            int limit = storage.parseInput(rawNumbers);

            if (limit < 0) {
                outputData = "ERROR: Invalid input.";
            } else {
                String primes = engine.calculatePrimes(limit);
                List<Integer> primeList = List.of(primes.split(","))
                        .stream()
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                outputData = storage.formatOutput(primeList);
            }
        } catch (Exception e) {
            outputData = "ERROR: Unexpected failure.";
        }

        storage.writeOutput(outputPath, outputData);
        return "SUCCESS";
    }

    public String findPrimes1(int limit) {
        return engine.calculatePrimes(limit);
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