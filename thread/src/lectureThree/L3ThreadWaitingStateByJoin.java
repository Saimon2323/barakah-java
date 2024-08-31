package lectureThree;

/**
 * @Author Muhammad Saimon
 * @since Aug 31, 2024 11:44 PM
 */

class ThreadJoin2 extends Thread {

    public ThreadJoin2() {
        super("ThreadJoin-2");
    }

    @Override
    public void run() {
        System.out.println("Thread 2 is running...");
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadTwo-" + i);
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 2 is completed...");
    }
}

class ThreadJoin1 extends Thread {

    public ThreadJoin1() {
        super("ThreadJoin-1");
    }

    @Override
    public void run() {
        System.out.println("Thread Join 1 is running...");

        ThreadJoin2 t2 = new ThreadJoin2();
        t2.start();

        System.out.println(Thread.currentThread().getName() + " will be halted here and will wait for the thread 'ThreadJoin-2' to complete...");
        try {
            // join() method will make this 'ThreadJoin-1' to wait for the thread 'ThreadJoin-2' to complete.
            // So, this 'ThreadJoin-1' will go to WAITING state.
            // When the thread 'ThreadJoin-2' completes, this 'ThreadJoin-1' will come out of the WAITING state and will continue its execution.
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadOne-" + i);
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 1 is completed...");
    }
}

public class L3ThreadWaitingStateByJoin {
    public static void main(String[] args) throws Exception {

        ThreadJoin1 t1 = new ThreadJoin1();
        t1.start();

        Thread.sleep(5_000);
        System.out.println("State of ThreadJoin1: " + t1.getState());
        System.out.println("Main end...");
    }
}