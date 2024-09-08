package lectureFive;

/**
 * @Author Muhammad Saimon
 * @since Sep 08, 2024 9:08 AM
 */

public class ThreadMethodYield {
    public static void main(String[] args) {
        // Yield method is used to pause the execution of the current thread and give a chance to the other threads to execute.
        // The yield method is a static method of the Thread class, which means that it is called on the current thread.
        // When the yield method is called, the current thread is paused and placed in the ready queue, allowing other threads to execute.
        // The yield method is used to improve the performance of the application by giving a chance to other threads to execute.
        // The yield method is a hint to the JVM that the current thread is willing to give up its current CPU time to other threads.
        // The JVM may or may not honor this hint, depending on the implementation of the JVM.
        // The yield method is a non-blocking method, which means that it does not block the current thread.


        // Example of yield method
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                Thread.yield();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
                Thread.yield();
            }
        });

        thread1.start();
        thread2.start();

        // In this example, we have two threads, thread1 and thread2, that are running concurrently.
        // Both threads are printing the numbers from 0 to 4, and after printing each number, they are calling the yield method.
        // The yield method is used to pause the execution of the current thread and give a chance to the other threads to execute.
        // When the yield method is called, the current thread is paused and placed in the ready queue, allowing other threads to execute.
        // This allows the two threads to run concurrently and share the CPU time.



        // Yield is appropriately used in Java Virtual Thread.
        // We can actual effect of yield method in Java Virtual Thread.
        // TODO :: Mamun Bhai will explain this when he will discuss Java Virtual Thread.
        // Same for holdsLock() method.
        // TODO :: Mamun Bhai will explain this when he will study about Locks in Java.
    }
}
