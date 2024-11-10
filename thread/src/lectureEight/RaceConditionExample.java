package lectureEight;

/**
 * @Author Muhammad Saimon
 * @since Sep 28, 2024 11:26 PM
 */

public class RaceConditionExample {

    // shared variable (Resource)
    // this resource is shared between two threads. That's why it's called shared resource.
    // It is not thread-safe.
    static int count = 0;

    static void increment() {
        count++;
        // count = count + 1; > 1 statement > 3 steps or instructions >>
        // 1. Read the value of count
        // 2. Increment the value of count
        // 3. Write the value of count
    }

    public static void main(String[] args) throws InterruptedException {
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


        thread1.join();
        thread2.join();


        // sometimes it will print 20_000, sometimes it will print less than 20_000
        // because both threads are trying to access the shared resource at the same time. That's why it's called Race Condition.
        // Race Condition: When multiple threads are trying to access the shared resource at the same time.
        // That's why sometimes it will print 20_000, sometimes it will print less than 20_000.
        // It is creating Data Inconsistency. (see Data-inconsistency-example.png)
        System.out.println(count);


        // To solve this problem we need to make the shared resource thread-safe.
        // We can make the shared resource thread-safe by using synchronized keyword. (see SynchronizedExample.java)
        // We can make the shared resource thread-safe by using Locks. (see LockAndReentrantLockExample.java)
        // We can make the shared resource thread-safe by using Atomic classes. (see AtomicExample.java)
        // We can make the shared resource thread-safe by using ThreadLocal. (see ThreadLocalExample.java)
        // then you will see the result is always 30_000.
        // because we made the shared resource thread-safe.
    }
}

// you can see the bytecode of the class file by the following command:
// Go to the directory where the class file is located then Type the following command:
// javap -v -p RaceConditionExample
// you can see the instructions of the increment method
// you can see the instructions of the main method
// etc.