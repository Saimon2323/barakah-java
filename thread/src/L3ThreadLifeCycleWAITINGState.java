/**
 * @Author Muhammad Saimon
 * @since Aug 30, 2024 11:43 PM
 */


class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("I am going to WAITING state...");

        // This thread will go to WAITING state and will wait for another thread to call notify() or notifyAll() method.
        synchronized (this) {
            try {
                // this wait() method is called on the current thread object. So, the current thread will go to WAITING state.
                wait(); // or this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted..." + e);
            }
        }

        System.out.println("Rest of the task...");
    }
}


// When the thread is in the WAITING state, it is waiting for another thread to perform a particular action.
// The thread is in the WAITING state until another thread calls the notify() or notifyAll() method on the object.
public class L3ThreadLifeCycleWAITINGState {

    public static void main(String[] args) throws Exception {
        MyThread t = new MyThread();
        t.start();


        // Sleeping for 3 seconds for the thread to go to WAITING state.
        Thread.sleep(3000);

        // Thread state is WAITING because notify() or notifyAll() method is not called yet.
        System.out.println(t.getState()); // WAITING


        // This will notify the thread to come out of the WAITING state.
        // If we use notifyAll() method, then all the threads will come out of the WAITING state.
        // If we use notify() method, then only one thread will come out of the WAITING state.
        synchronized (t) {
            t.notify(); // or t.notifyAll();
        }

        System.out.println("Main end...");
    }
}
