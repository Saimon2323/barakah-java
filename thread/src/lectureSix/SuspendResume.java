package lectureSix;

/**
 * @Author Muhammad Saimon
 * @since Sep 25, 2024 1:11 AM
 */

// suspend() and resume() methods are deprecated in Java 1.2
public class SuspendResume {

        public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(() -> {
                System.out.println("In Thread 1: ");
                for (int i = 0; i < 100; i++) {
                    System.out.print(i + " ");
//                    try {
//                        Thread.sleep(1_000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
                System.out.println("\nThread 1 is completed...");
            });

            t1.start();

            Thread.sleep(14);

            System.out.println("\nStatus before suspend: " + t1.getState());
            t1.suspend(); // suspend the thread t1

            // for this println() method, the thread t1 can go to BLOCKED state because println() method is synchronized.
            System.out.println("Thread 1 is suspended for 3 secs here...");
            System.out.println("Status after suspend: " + t1.getState());
            Thread.sleep(3_000);

            t1.resume(); // resume the thread t1
            System.out.println("Status after resume: " + t1.getState());

            t1.join(); // main thread will wait for t1 to complete
            System.out.println("Main thread is completed...");
        }
}
