package lectureFive;

/**
 * @Author Muhammad Saimon
 * @since Sep 07, 2024 10:59 AM
 */

public class ThreadMethodsActiveCountAndEnumerate {
    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().getThreadGroup().getParent().list();

        System.out.println("=====================================");

        // activeCount() method returns the Estimate number of active threads in the current thread's thread group and its subgroups.
        int activeThread = Thread.activeCount();
        System.out.println("Active Thread: " + activeThread); // suppose activeThread = 5

        Thread[] threads = new Thread[activeThread]; // create an array of Thread with size 5

        // enumerate() method copies into the specified array every active thread in the current thread's thread group and its subgroups.
        int actualThreadCount = Thread.enumerate(threads);

        // when enumerate() method is working, some threads may be terminated. So, actualThreadCount may be less than activeThread.
        // for example, suppose 2 threads are terminated. So, actualThreadCount = 3
        System.out.println("Actual Thread Count: " + actualThreadCount);

        // If we print this way, we will see only 3 threads. Because 2 threads are terminated. it will print only 3 threads. rest of the 2 threads are null.
        for (Thread thread : threads) {
            System.out.println(thread);
        }

        System.out.println("=====================================");

        // If we print this way, we will find all the active threads. Because we are printing only the actualThreadCount.
        for (int i = 0; i < actualThreadCount; i++) {
            System.out.println(threads[i]);
        }

        Thread.sleep(10_000);

        System.out.println("Main Thread is finished...");
    }
}

// Thread[Monitor Ctrl-Break,5,main]
// This is the thread that is responsible for monitoring the Ctrl-Break signal. It is created by the JVM and runs in the background.
// If anyone types Ctrl+\ in the console when the program is running, this thread will receive the signal and create a thread dump.

