package lectureEight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Muhammad Saimon
 * @since Oct 01, 2024 9:21 AM
 */

public class ThreadLocalExample {

    // We can make the shared resource thread-safe by using ThreadLocal. below is the example:
    // ThreadLocal is a class that provides thread-local variables. These variables differ from their normal
    // counterparts in that each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable.
    // In this example, we are using ThreadLocal to make the shared resource thread-safe.
    // ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    // ThreadLocal.withInitial() method returns a ThreadLocal with an initial value of 0.
    // ThreadLocal.withInitial() method takes a Supplier as an argument.
    // Supplier is a functional interface that takes no arguments and returns a value.
    // In this case, the Supplier is a lambda expression that returns 0.
    // ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    // ThreadLocal.withInitial() method returns a ThreadLocal with an initial value of 0.
    // ThreadLocal.withInitial() method takes a Supplier as an argument.
    // Supplier is a functional interface that takes no arguments and returns a value.
    // In this case, the Supplier is a lambda expression that returns 0.

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
