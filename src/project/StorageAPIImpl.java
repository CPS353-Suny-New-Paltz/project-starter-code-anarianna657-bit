package project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import project.annotations.StorageAPI;

public class StorageAPIImpl implements StorageAPI {

    @Override
    public List<Integer> readInput(Path filePath) {

        if (filePath == null) {
            throw new IllegalArgumentException("Input file path cannot be null");
        }

        List<Integer> values = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int value = Integer.parseInt(line);
                    if (value < 0) {
                        throw new IllegalArgumentException(
                                "Negative input not allowed: " + value);
                    }
                    values.add(value);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read or parse input file: " + filePath, e);
        }

        return values;
    }

    @Override
    public int parseInput(List<Integer> rawData) {
        if (rawData == null || rawData.isEmpty()) {
            return -1;
        }
        return rawData.get(0);
    }

    @Override
    public String formatOutput(List<Integer> primes) {
        if (primes == null) {
            return "ERROR: No results";
        }
        return primes.toString();
    }

    @Override
    public boolean writeOutput(Path destination, String formattedOutput) {

        if (destination == null || formattedOutput == null) {
            return false;
        }

        try {
            Files.writeString(destination, formattedOutput);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}