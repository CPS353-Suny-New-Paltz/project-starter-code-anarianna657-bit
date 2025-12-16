package project.checkpointtests;

import project.FastEngineAPIImpl;
import project.StorageAPIImpl;
import project.UserAPIImpl;

public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {

        FastEngineAPIImpl engine = new FastEngineAPIImpl();
        StorageAPIImpl storage = new StorageAPIImpl();
        UserAPIImpl user = new UserAPIImpl(engine, storage);

        user.setInput(INPUT);
        user.setOutput(OUTPUT);

        user.run();
    }
}
