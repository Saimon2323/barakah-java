package lectureEight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Muhammad Saimon
 * @since Oct 01, 2024 9:21 AM
 */

public class ThreadLocalExample {
    static ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    static List<Integer> threadCounts = new ArrayList<>();

    static void increment() {
        count.set(count.get() + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                increment();
            }
            threadCounts.add(count.get());
            System.out.println("t1: " + count.get());
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20_000; i++) {
                increment();
            }
            threadCounts.add(count.get());
            System.out.println("t2: " + count.get());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        // If we print count.get() here, it will print 0. Because count is a ThreadLocal variable.
        // The issue with using ThreadLocal is that each thread has its own separate instance of the count variable.
        // Therefore, when you print count.get() in the main thread, it only shows the value for the main thread, which hasn't been incremented.
        // System.out.println(count.get());

        // that's why we are using threadCounts list to store the count value of each thread.
        int totalCount = threadCounts.stream().mapToInt(Integer::intValue).sum();
        System.out.println(totalCount);
    }
}
