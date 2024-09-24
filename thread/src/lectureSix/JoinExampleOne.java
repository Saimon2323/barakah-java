package lectureSix;

/**
 * @Author Muhammad Saimon
 * @since Sep 24, 2024 11:38 PM
 */

public class JoinExampleOne {

    private static int[] arr = {1, 2, 3, 4, 5};
    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int num : arr) {
                    sum += num;
                    JoinExampleOne.sleep(1_000);
                }
                System.out.println("Inside Thread 1: " + sum); // 15
            }
        };

        t1.start();

        t1.join(); // main thread will wait for t1 to complete
        // or
//        t1.join(2_000); // main thread will wait for thread t1 for 2 seconds


        System.out.println("In Main thread: " + sum); // "15" for join() or "3" for join(2_000)
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
