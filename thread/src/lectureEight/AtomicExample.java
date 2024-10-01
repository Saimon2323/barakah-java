package lectureEight;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Muhammad Saimon
 * @since Oct 01, 2024 9:09 AM
 */

public class AtomicExample {

    // We can make the shared resource thread-safe by using Atomic classes. below is the example:
    // Atomic classes are used to make the shared resource thread-safe. It will allow only one thread to access the shared resource at a time. Other threads will wait.
    // How AtomicInteger works?
    // AtomicInteger is a class that provides atomic operations. It is used to make the shared resource thread-safe.
    // What is Atomic operation?
    // Atomic operation is an operation that is performed in a single step. It is not divided into multiple steps. It is performed in a single step.
    // here we will 30000 but why and how? below is the explanation:

     static AtomicInteger count = new AtomicInteger(0); // Create an AtomicInteger object
     static void increment() {
        count.incrementAndGet(); // Increment the value of the shared resource
     }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20_000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + count);
    }
}
