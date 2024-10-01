package lectureEight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Muhammad Saimon
 * @since Oct 01, 2024 9:02 AM
 */

public class LockAndReentrantLockExample {
    static int count = 0;

    // We can make the shared resource thread-safe by using Locks. below is the example:
    // Locks are used to make the shared resource thread-safe. It will allow only one thread to access the shared resource at a time. Other threads will wait.
    // It is called Explicit Lock. It is associated with the Lock object. It is also called Class Level Lock.
    // It is recommended to use Locks because it is faster than synchronized keyword. It is flexible. It is recommended to use Locks in the modern world.
    // ReentrantLock is a class that implements the Lock interface. It is used to make the shared resource thread-safe.
    // The lock() method is used to acquire the lock. The unlock() method is used to release the lock.
    // The use of lock() and unlock() methods is mandatory. If you forget to release the lock, then it will create a deadlock.
    // Deadlock: When a thread is waiting for a lock that is held by another thread and that thread is waiting for a lock that is held by the first thread. It is called Deadlock.
    // To avoid deadlock, you must release the lock after using it.
    // It is recommended to use try-finally block to release the lock. Because if an exception occurs, then the lock will not be released. It will create a deadlock. That's why it is recommended to use try-finally block to release the lock.
    // What is the difference between synchronized keyword and Locks?
    // synchronized keyword is slower than Locks. synchronized keyword is not flexible. synchronized keyword is not recommended to use in the modern world. Locks are faster than synchronized keyword. Locks are flexible. Locks are recommended to use in the modern world.
    // What is the difference between ReentrantLock and synchronized keyword?
    // ReentrantLock is faster than synchronized keyword. ReentrantLock is flexible. ReentrantLock is recommended to use in the modern world. synchronized keyword is slower than ReentrantLock.
    // What is ReentrantLock?
    // ReentrantLock is a class that implements the Lock interface. It is used to make the shared resource thread-safe.
    // What is Lock?
    // Lock is used to make the shared resource thread-safe. It will allow only one thread to access the shared resource at a time. Other threads will wait. It is called Explicit Lock. It is associated with the Lock object. It is also called Class Level Lock.
    // What is the difference between Intrinsic Lock and Explicit Lock?
    // Intrinsic Lock is associated with the object. It is also called Object Level Lock. Explicit Lock is associated with the Lock object. It is also called Class Level Lock.
     static Lock lock = new ReentrantLock(); // Create a Lock object
     static void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++; // Access the shared resource
        } finally {
            lock.unlock(); // Release the lock
        }
     }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20_000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + count);
    }
}
