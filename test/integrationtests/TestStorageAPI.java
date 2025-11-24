package integrationtests;
import project.StorageAPIImpl;
import org.junit.jupiter.api.Test;

public class TestStorageAPI {

    @Test
    public void testStorageApiInitialization() {
        StorageAPIImpl storageApi = new StorageAPIImpl();
        assert storageApi != null : "StorageAPIImpl should be created successfully";
    }

    @Test
    public void testSaveDataReturnsFalseByDefault() {
        StorageAPIImpl storageApi = new StorageAPIImpl();
        boolean result = storageApi.saveData("test");
        assert !result : "saveData should return false until implemented";
    }
}
