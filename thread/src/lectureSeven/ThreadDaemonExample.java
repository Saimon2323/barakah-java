package lectureSeven;

/**
 * @Author Muhammad Saimon
 * @since Sep 26, 2024 9:04 AM
 */

public class ThreadDaemonExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Thread.currentThread().getThreadGroup().list();
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 2 is finished");
        });

        // Daemon thread
        // what I understand is that, if we set a thread as a daemon thread, then it will be terminated automatically when all the working thread like main, thread-2 is finished.
        // By default, all the threads are non-daemon threads means setDaemon(false)
        // here, t1 is a daemon thread as I set t1.setDaemon(true) and comment in t2.start()
        // now, when main thread is finished, t1 will be terminated automatically
        // but if I uncomment t2.start() then t1 will not be terminated automatically after main thread finished because t2 is a non-daemon thread and is in the same group as t1.
        // t1's group is main group and t2's group is also main group. So as long as t2 is running, t1 will not be terminated automatically although t1 is a daemon thread.


        t1.setDaemon(true); // Daemon thread
        t1.start();
        t2.start();

        Thread.sleep(3000);
        System.out.println("Main Thread is finished");
    }
}
