package lectureTwo;

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
7. If you want to save the thread info in a file, run the following command
    jstack <process id> > thread-info.txt
8. If you want to check that the thread is acquired a lock or lock info, run the following command
    jstack -l <process id>
9. If you want to check the thread info of a specific thread, run the following command
    jstack -l <process id> | grep <thread id>
10. if you want to check State of a thread, run the following command
    jstack -l <process id> | grep <thread id> -A 1 // -A 1 means after 1 line
11. If you want to check that the thread and its sub-threads, run the following command
    jstack -l <process id> | grep <thread id> -A 10 // -A 10 means after 10 lines
*/
