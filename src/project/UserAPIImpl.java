package project;

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
        String raw = storage.readInput(inputSource);
        String parsed = storage.parseInput(raw);
        String formatted = storage.formatOutput(parsed);
        engine.compute(42);
        return storage.writeOutput(formatted);
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

