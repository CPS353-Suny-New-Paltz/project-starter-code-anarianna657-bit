package project.checkpoint4;
import java.util.ArrayList;
import java.util.List;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public abstract class ComputationComponent {

    public List<Integer> compute(int limit) {
        List<Integer> primes = new ArrayList<>();

        if (limit <= 2) {
            return primes; 
        }

        for (int i = 2; i < limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
