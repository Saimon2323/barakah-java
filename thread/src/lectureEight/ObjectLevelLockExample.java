package lectureEight;

/**
 * @Author Muhammad Saimon
 * @since Nov 21, 2024 10:20 PM
 */

public class ObjectLevelLockExample {

    static int count = 0; // shared resource
//    int count = 0; // shared resource

    // here, object level lock is used.
    synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws Exception {

        // Every object has a lock. If you use synchronized keyword in a method, then the lock is the object itself.
        // Check ObjectLevelLockExample.png
        ObjectLevelLockExample obj1 = new ObjectLevelLockExample();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                obj1.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20_000; i++) {
                obj1.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
//        System.out.println(obj1.count);
    }
}
