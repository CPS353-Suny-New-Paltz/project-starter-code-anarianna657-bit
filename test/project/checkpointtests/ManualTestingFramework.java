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
    	            return "2,3,5"; 
    	        }
    	    };

    	    StorageAPIImpl storage = new StorageAPIImpl() {
    	        @Override
    	        public void saveData(String output, String result) {
    	            try {
    	                java.nio.file.Files.write(java.nio.file.Paths.get(output), result.getBytes());
    	                System.out.println("Output written to " + output);
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	        }
    	    };

    	    UserAPIImpl user = new UserAPIImpl(engine, storage) {
    	        @Override
    	        public String findPrimes(int input) {
    	            return engine.calculatePrimes(input);
    	        }

    	        @Override
    	        public void displayComputationSummary() {
    	            System.out.println("Manual test complete.");
    	        }
    	    };

    	    System.out.println("Running manual test...");
    	    String result = user.findPrimes(3);
    	    storage.saveData(OUTPUT, result);
    	    user.displayComputationSummary();
    	}
}
