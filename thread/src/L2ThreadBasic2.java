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
        }
        System.out.println("Thread End :: " + Thread.currentThread().getName());
    }
}

public class L2ThreadBasic2 {
    public static void main(String[] args) {
        System.out.println("main Start :: " + Thread.currentThread().getName());

        Task2 t = new Task2();
        t.start();

        System.out.println("main End :: " + Thread.currentThread().getName());
    }
}
