package lectureEight;

/**
 * @Author Muhammad Saimon
 * @since Nov 21, 2024 10:20 PM
 */

public class ObjectLevelLockExample2 {

    int count = 0;
//    static int count = 0;

    synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws Exception {

        // Every object has a lock. If you use synchronized keyword in a method, then the lock is the object itself.
        // If you create two objects of the same class, then the lock will be different for each object.
        // each object will acquire lock on itself separately.
        // That's why the output will be different for each object.
        // check ObjectLevelLockExample2.png
        ObjectLevelLockExample2 obj1 = new ObjectLevelLockExample2();
        ObjectLevelLockExample2 obj2 = new ObjectLevelLockExample2();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                obj1.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20_000; i++) {
                obj2.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(obj1.count);
        System.out.println(obj2.count);
//        System.out.println(count);
    }
}
