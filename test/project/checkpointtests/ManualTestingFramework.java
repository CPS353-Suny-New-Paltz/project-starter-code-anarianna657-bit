package project.checkpointtests;
import project.EngineAPIImpl;
import project.StorageAPIImpl;
import project.UserAPIImpl;

public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {

        EngineAPIImpl engine = new EngineAPIImpl() {
            @Override
            public String calculatePrimes(int input) {
                return "2, 3, 5, 7, 11, 13, 17, 19";
            }

			@Override
			public String compute(int n) {
				// TODO Auto-generated method stub
				return null;
			}
        };

        StorageAPIImpl storage = new StorageAPIImpl() {
            @Override
            public void saveData(String output, String result) {
                System.out.println("Pretending to save to " + output + ": " + result);
            }

			@Override
			public void readInput(String source) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void writeOutput(String destination) {
				// TODO Auto-generated method stub
				
			}
        };

        UserAPIImpl user = new UserAPIImpl(engine, storage) {
            @Override
            public String findPrimes(int input) {
                return engine.calculatePrimes(input);
            }

            @Override
            public void displayComputationSummary() {
                System.out.println("Manual test run complete.");
            }

			@Override
			public void setInput(String sourceUri) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setOutput(String sinkUri) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setDelimiters(String pairDelimiter, String kvDelimiter) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void useDefaultDelimiters() {
				// TODO Auto-generated method stub
				
			}
        };
        
        System.out.println("Running manual test...");
        String result = user.findPrimes(20);
        storage.saveData(OUTPUT, result);
        user.displayComputationSummary();

        System.out.println("Manual test completed successfully!");
        System.out.println("Input:  " + INPUT);
        System.out.println("Output: " + OUTPUT);
    }
}
