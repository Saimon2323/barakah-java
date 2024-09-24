package lectureSix;

/**
 * @Author Muhammad Saimon
 * @since Sep 24, 2024 11:05 PM
 */

public class BeforeJoin {

    private static int[] arr = {1, 2, 3, 4, 5};
    private static int sum = 0;


    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int num : arr) {
                    sum += num;
                }
                System.out.println("Inside Thread 1: " + sum); // 15
            }
        };

        t1.start();

        // print 0 because the main thread is not waiting for the thread t1 to complete.
        System.out.println("In Main thread: " + sum); // 0
    }
}
