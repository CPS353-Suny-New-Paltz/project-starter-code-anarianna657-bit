package project.annotations;

public class Main {
    public static void main(String[] args) {
        StorageAPI storage = new StorageAPI() {
            @Override
            public String readInput(String source) {
                System.out.println("readInput: " + source);
                return source;
            }

            @Override
            public String writeOutput(String destination) {
                System.out.println("writeOutput: " + destination);
                return "Output written to " + destination;
            }

			@Override
			public String parseInput(String rawData) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String formatOutput(String data) {
				// TODO Auto-generated method stub
				return null;
			}
        };
        new StoragePrototype().prototype(storage);
    }
}