package gadek.com.multithread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapExecutor {
    public static void main(String[] args) throws InterruptedException {
//        Map<Integer, Integer> visits = new HashMap<>();
        Map<Integer, Integer> visits = new ConcurrentHashMap<>();
        ExecutorService executors = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; ++i) {
            final int key = i % 10;
            executors.execute(() -> {
                for (int j = 0; j < 100; ++j) {
                    visits.compute(key, (k, value) -> (value == null ? 0 : value) + 1);
                }
            });
        }
        executors.shutdown();  // 4
        executors.awaitTermination(10, TimeUnit.MINUTES);
        int totalSum = visits.values().stream().mapToInt(x -> x).sum();
        System.out.println("Total sum is: " + totalSum);
    }


}
