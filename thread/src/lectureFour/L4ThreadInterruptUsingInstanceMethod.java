package lectureFour;

/**
 * @Author Muhammad Saimon
 * @since Sep 07, 2024 10:41 AM
 */

class L4TaskTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("Start Task...");

        Thread l4TaskThread = Thread.currentThread();
        // print this line to prove that this is basically the same thread (t2)
        System.out.println("Check Name: " + l4TaskThread.getName() + " and HashCode: " + l4TaskThread.hashCode());

        long count = 0;

        // Difference between isInterrupted() and interrupted()
        // isInterrupted()::
        // The isInterrupted method simply returns the value of this interrupted field. If the thread has been interrupted, the method returns true; otherwise, it returns false.
        // This method is useful for checking the interrupted status of a thread without clearing the interrupted status flag.
        // This is in contrast to the static interrupted method, which not only checks but also clears the interrupted status of the current thread.

        // interrupted()::
        // The interrupted method is a static method that checks the interrupted status of the current thread.
        // If the current thread has been interrupted, the method returns true; otherwise, it returns false.
        // This method clears the interrupted status of the current thread. If the interrupted status is cleared, the method returns false.
        // This is different from the isInterrupted method, which only checks the interrupted status without clearing it.

        System.out.println("Interrupted status out: " + l4TaskThread.isInterrupted());
        while (!l4TaskThread.isInterrupted()) {
//            System.out.println("Interrupted status inside: " + l4TaskThread.isInterrupted());
            count++;
        }

        System.out.println("Interrupted status using isInterrupted(): " + l4TaskThread.isInterrupted());
        System.out.println("Interrupted status using interrupted(): " + Thread.interrupted());
        System.out.println("Interrupted status using isInterrupted(): " + l4TaskThread.isInterrupted());
        System.out.println("Do some task..." + count);
        System.out.println("End Task...");
    }
}


public class L4ThreadInterruptUsingInstanceMethod {
    public static int value = 0;

    public static void main(String[] args) throws Exception {

        System.out.println("Start Main...");

        L4TaskTwo task = new L4TaskTwo();
        Thread t2 = new Thread(task, "Thread-2-1");

        t2.start();
        System.out.println("Check Name: " + t2.getName() + " and HashCode: " + t2.hashCode());

        Thread.sleep(2000);

        value = 10;

        t2.interrupt(); // flag is set to true

        System.out.println("state: " + t2.getState());
        System.out.println("Main is completed...");

    }
}
