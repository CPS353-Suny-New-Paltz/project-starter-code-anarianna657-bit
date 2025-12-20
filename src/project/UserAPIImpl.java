package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        if (engine == null || storage == null) {
            throw new IllegalArgumentException("Engine and Storage APIs must not be null");
        }
        this.engine = engine;
        this.storage = storage;
    }

    @Override
    public void setInput(String sourceUri) {
        if (sourceUri == null || sourceUri.isBlank()) {
            throw new IllegalArgumentException("Input source cannot be null or empty");
        }
        this.inputSource = sourceUri;
    }

    @Override
    public void setOutput(String sinkUri) {
        if (sinkUri == null || sinkUri.isBlank()) {
            throw new IllegalArgumentException("Output destination cannot be null or empty");
        }
        this.outputDestination = sinkUri;
    }

    @Override
    public void setDelimiters(String pairDelimiter, String kvDelimiter) {
        //Not implemented
    }

    @Override
    public void useDefaultDelimiters() {
        //Not implemented
    }

    @Override
    public String run() {

        //Network level validation
        if (inputSource == null) {
            return "ERROR: Input source not set";
        }
        if (outputDestination == null) {
            return "ERROR: Output destination not set";
        }

        Path inputPath;
        Path outputPath;

        try {
            inputPath = Paths.get(inputSource);
            outputPath = Paths.get(outputDestination);
        } catch (Exception e) {
            return "ERROR: Invalid input or output path";
        }

        String outputData;

        try {
            List<Integer> inputs = storage.readInput(inputPath);
            List<Integer> results = new ArrayList<>();

            for (int limit : inputs) {
                if (limit < 0) {
                    results.add(-1);
                } else {
                    String primes = engine.calculatePrimes(limit);

                    if (primes == null || primes.isBlank()) {
                        results.add(0);
                    } else {
                        results.add(primes.split(",").length);
                    }
                }
            }

            outputData = storage.formatOutput(results);

        } catch (RuntimeException e) {
            outputData = "ERROR: " + e.getMessage();
        }

        boolean writeOk = storage.writeOutput(outputPath, outputData);
        if (!writeOk) {
            return "ERROR: Failed to write output";
        }

        return "SUCCESS";
    }

    //Helper/test support methods

    public String findPrimes(int input) {
        return engine.calculatePrimes(input);
    }

    public String runEngineTask(EngineAPI mockEngine, int i) {
        if (mockEngine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        return mockEngine.compute(i);
    }

    public String displayComputationSummary() {
        return "Computation complete for " + inputSource + " → " + outputDestination;
    }
}