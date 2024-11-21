package lectureFour;

/**
 * @Author Muhammad Saimon
 * @since Oct 03, 2024 5:44 PM
 */

public class ThreadInterruptExample {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            System.out.println("t start....");

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println("Error:" + e.getMessage());
                    Thread.currentThread().interrupt();
//                    System.out.println("inside " + Thread.currentThread().isInterrupted());
                    throw new RuntimeException(e.getMessage());
                }
                System.out.println("Outside: " + Thread.currentThread().isInterrupted());
            }
        });

        t.start();


        Thread.sleep(5_000);

        t.interrupt();
//        Thread.currentThread().interrupt();

        System.out.println("Main End");
    }
}
