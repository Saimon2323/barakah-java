package lectureEight;

/**
 * @Author Muhammad Saimon
 * @since Nov 22, 2024 12:20 AM
 */
// Method Level Locking vs Block Level Locking
public class MethodLevelVsBlockLevelLocking {

    static int count = 0; // shared resource


    static synchronized void increment() {
        count++;
    }
    // here above, method level lock is used.
    // Method level lock is used when you use synchronized keyword in a method.
    // Suppose you have a method that has 100 lines of code and from them only 10 lines of code need to be synchronized.
    // in that case, if you use synchronized keyword in the method, then the whole method will be synchronized. It is called
    // Method Level Locking. It is not recommended because it will decrease the performance as the whole method will be synchronized.

    // So in that case, you can use Block Level Locking. Check below:
    static void increment2() {
        // other code
        // other code

        // Block Level Locking. Only this block of code will be synchronized or locked, not the whole method.
        // it will increase the performance as the whole method is not synchronized.
        synchronized (MethodLevelVsBlockLevelLocking.class) {
            count++;
        }

        // other code
        // other code
    }
    // Or
    void increment3() {
        // other lines of code

        System.out.println("Thread: " + Thread.currentThread().getName());

        // Block Level Locking. Only this block of code will be synchronized or locked, not the whole method.
        // it will increase the performance as the whole method is not synchronized.
        synchronized (this) {
            System.out.println("In Critical Section: " + Thread.currentThread().getName());
            count++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // other lines of code
    }

    public static void main(String[] args) throws Exception {

        MethodLevelVsBlockLevelLocking obj1 = new MethodLevelVsBlockLevelLocking();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
//                increment2();
                obj1.increment3();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
//                increment2();
                obj1.increment3();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}
