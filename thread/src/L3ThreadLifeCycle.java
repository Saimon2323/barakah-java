/**
 * @Author Muhammad Saimon
 * @since Aug 29, 2024 10:08 PM
 */

class Task3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i + ", State: " + Thread.currentThread().getState());
        }
        System.out.println(Thread.currentThread().getName() + " is completed.");
    }
}

// NEW, RUNNABLE and TERMINATED states are shown here.
public class L3ThreadLifeCycle {
    public static void main(String[] args) throws Exception {

        Task3 target = new Task3();

        // Thread State. Thread state is the state of the thread at a particular point of time.
        // The life cycle of the thread in Java is controlled by JVM.
        // NEW, RUNNABLE, RUNNING(not in list), WAITING, TIMED_WAITING, BLOCKED, TERMINATED
        Thread t = new Thread(target, "Thread-lifecycle");

        // NEW is the initial state of the thread. When we create an instance of a Thread class, it is in the NEW state.
        System.out.println(t.getState() + " " + t.getId() + " " + t.getName()); // NEW

        // When we call the start() method on the thread object, the thread moves from the NEW state to the RUNNABLE state.
        // The thread is in the RUNNABLE state when the thread scheduler picks up the thread in OS Level for execution.
        // It is ready to run but the thread scheduler has not selected it.
        t.start();
        System.out.println(t.getState()); // RUNNABLE

        // When the thread scheduler picks up the thread from the RUNNABLE state and starts executing the thread's run() method, the thread is in the RUNNING state.
        // The thread is in the RUNNING state until it is executing the run() method. The time is very less.
        // The thread scheduler picks up the thread from the RUNNING state and moves it to the RUNNABLE state. That's why here RUNNABLE state is printed.
        // That's why RUNNING state is not in the list of Thread.State enum. It is not a valid state. It is just a state of execution.
        System.out.println(t.getState()); // RUNNABLE


        // Put Sleep here to complete the run() method of the thread. So that we can see the TERMINATED state.
        Thread.sleep(2_000);

        // TERMINATED state is the final state of the thread. The thread is in the TERMINATED state when the thread's run() method is completed.
        System.out.println(t.getState()); // TERMINATED
    }
}
