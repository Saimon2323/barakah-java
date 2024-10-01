package lectureEight;

/**
 * @Author Muhammad Saimon
 * @since Oct 01, 2024 8:57 AM
 */

public class SynchronizedExample {

    // shared variable (Resource)
    // this resource is shared between two threads. That's why it's called shared resource.
    // It is not thread-safe.
    static int count = 0;

    // We can make the shared resource thread-safe by using synchronized keyword. below is the example:
    // synchronized keyword is used to make the shared resource thread-safe. It will allow only one thread to access the shared resource at a time. Other threads will wait.
    // It is called Intrinsic Lock or Monitor Lock. It is associated with the object. It is also called Object Level Lock.
    // But it is not recommended to use synchronized keyword because it is slower than Locks.
    // It is not flexible. It is not recommended to use synchronized keyword in the modern world.
    synchronized static void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20_000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // it will print 30000 because we used synchronized keyword to make the shared resource thread-safe.
        // there will be no data inconsistency.
        System.out.println(count);
    }
}
