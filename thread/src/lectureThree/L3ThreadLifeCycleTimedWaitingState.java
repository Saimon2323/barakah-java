package lectureThree;

/**
 * @Author Muhammad Saimon
 * @since Aug 30, 2024 8:13 PM
 */

public class L3ThreadLifeCycleTimedWaitingState implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Before Sleep... and State: " + Thread.currentThread().getState());
            Thread.sleep(8_000);
            System.out.println("After Sleep timeout - rest of the work... and State: " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted..." + e);
        }
    }

    public static void main(String[] args) throws Exception {
        L3ThreadLifeCycleTimedWaitingState target = new L3ThreadLifeCycleTimedWaitingState();
        Thread t = new Thread(target, "Thread-lifecycle-2");
        t.start();

        // TIMED_WAITING state is shown here. Because we put the thread to sleep for 5 seconds in run().
        // The thread is in the TIMED_WAITING state when the thread is in the sleep state.
        Thread.sleep(3_000);

        // When Thread waits for some time in the middle of the execution (here 5 seconds in run()), it will be in TIMED_WAITING state.
        // After 5 seconds, the thread will be in the RUNNABLE state.
        System.out.println("\nState of " + t.getName() + " :: " + t.getState()); // TIMED_WAITING
        System.out.println("\nMain end...");

    }
}
