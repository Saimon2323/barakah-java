/**
 * @Author Muhammad Saimon
 * @since Aug 29, 2024 8:11 PM
 */

class Task2 extends Thread {

    public Task2() {
        super("My-Thread-2");
    }

    @Override
    public void run() {
        System.out.println("Thread Start :: " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i + " exe by " + Thread.currentThread().getName());
            System.out.println("My-Thread-2 Thread developer id: " + Thread.currentThread().getId());
            try {
                // Use this sleep() to show the thread info in terminal using jstack command,
                // otherwise it will be terminated, and we will not see the thread info
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread End :: " + Thread.currentThread().getName());
    }
}

public class L2ThreadBasic2 {
    public static void main(String[] args) throws Exception {
        System.out.println("main Start :: " + Thread.currentThread().getName());

        Task2 t = new Task2();
        t.start();

        System.out.println("Main Thread developer id: " + Thread.currentThread().getId());

        // Use sleep() to keep the Main thread running, so that we can see the thread info.
        // Otherwise, the main thread will be terminated, and we will not see the thread info
        Thread.sleep(10000000L);

        System.out.println("main End :: " + Thread.currentThread().getName());
    }
}



/*
To check Thread info
1. Open terminal
2. Run the following command
    jps -l
4. Copy the process id of the project
5. Run the following command
    jstack <process id>
6. You will see the thread info

*/
