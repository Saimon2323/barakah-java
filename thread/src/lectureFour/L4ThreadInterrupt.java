package lectureFour;

/**
 * @Author Muhammad Saimon
 * @since Sep 04, 2024 9:49 PM
 */

 // Another way of Interrupt without using Exception
class L4Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Start Task...");
        
        long count = 0;

        while (!Thread.interrupted()) {
            count++;
        }

        System.out.println("Do some task..." + count);
        System.out.println("End Task...");
    }
}

public class L4ThreadInterrupt {

    public static int value = 0;

    public static void main(String[] args) throws Exception {


        // Interrupt using Exception
        Thread t1 = new Thread(() -> {
            System.out.println("Start Task inside...");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted...");
                e.printStackTrace();
            }
            System.out.println("Do some task..." + value);
            System.out.println("End Task inside...");
        }, "Thread-1");



        System.out.println("Start Main...");

        L4Task task = new L4Task();
        Thread t2 = new Thread(task, "Thread-2");

        // t1.start();
        t2.start();

        Thread.sleep(4_000);

        value = 10;

        // t1.interrupt();
         t2.interrupt();

        System.out.println("state: " + t2.getState());
        System.out.println("Main is completed...");

    }
}
