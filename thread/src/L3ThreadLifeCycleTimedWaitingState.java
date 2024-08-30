/**
 * @Author Muhammad Saimon
 * @since Aug 30, 2024 8:13 PM
 */

public class L3ThreadLifeCycleTimedWaitingState implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i + ", State: " + Thread.currentThread().getState());
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        L3ThreadLifeCycleTimedWaitingState target = new L3ThreadLifeCycleTimedWaitingState();
        Thread t = new Thread(target, "Thread-lifecycle-2");
        System.out.println(t.getState() + " " + t.getId() + " " + t.getName()); // NEW
        t.start();

        // TIMED_WAITING state is shown here. Because we put the thread to sleep for 5 seconds in run().
        // The thread is in the TIMED_WAITING state when the thread is in the sleep state.
        Thread.sleep(10_000);

        // When Thread waits for some time in the middle of the execution (here 5 seconds in run()), it will be in TIMED_WAITING state.
        // After 5 seconds, the thread will be in the RUNNABLE state.
        System.out.println(t.getState()); // TIMED_WAITING

    }
}
