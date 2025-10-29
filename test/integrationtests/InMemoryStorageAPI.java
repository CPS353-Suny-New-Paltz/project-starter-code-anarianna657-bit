package integrationtests;
import java.util.List;
import project.annotations.StorageAPI;

//Reads integers from InMemoryInput and writes results to InMemoryOutput. 
public abstract class InMemoryStorageAPI implements StorageAPI {

    private final InMemoryInput input;
    private final InMemoryOutput output;

    public InMemoryStorageAPI(InMemoryInput input, InMemoryOutput output) {
        this.input = input;
        this.output = output;
    }

    public List<Integer> readInput() {
        return input.getInputNumbers();
    }

    public void writeOutput(String data) {
        output.write(data);
    }
}
