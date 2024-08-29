/**
 * @Author Muhammad Saimon
 * @since Aug 29, 2024 9:29 AM
 */

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Start :: " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i + " exe by " + Thread.currentThread().getName());
        }
        System.out.println("Thread End :: " + Thread.currentThread().getName());
    }
}


public class L2ThreadBasic {
    public static void main(String[] args) {
        System.out.println("main Start :: " + Thread.currentThread().getName());

        // this is like Task class. Same thing can be done by using Task class
        Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Start :: " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println("i = " + i + " exe by " + Thread.currentThread().getName());
                }
                System.out.println("Thread End :: " + Thread.currentThread().getName());
            }
        };

        Runnable targetTask = new Task();
        Thread t = new Thread(targetTask, "MyThread");

        // if I execute run() in lieu of start() method, it will not create a new thread with the name "MyThread"
        // [as I provide a name], then will call run() method internally
//        t.run();

        // start() method will create a new thread with the name "MyThread" [as I provide a name],
        // then will call run() method internally
        t.start();


        // To show separate path of execution. ek bar ei thread ar ekbar oi thread.
        // when to execute which thread is decided by Thread Scheduler. It is not guaranteed that which thread will execute first.
        // It is decided by Thread Scheduler.
        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i + " exe by " + Thread.currentThread().getName());
        }


        System.out.println("main End :: " + Thread.currentThread().getName());
    }
}
