package lectureNine;

/**
 * @Author Muhammad Saimon
 * @since Nov 23, 2024 9:28 AM
 */

public class ObjectLevelLockDetails {

    synchronized void even() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i + " " + Thread.currentThread().getName());
            }
        }
    }

    synchronized void odd() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd: " + i + " " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {

        ObjectLevelLockDetails m1 = new ObjectLevelLockDetails();

        Thread t1 = new Thread(m1::even);

        Thread t2 = new Thread(m1::odd);

        t1.start();
        t2.start();

        // We already know that one object has one lock and Lock is applied on the OBJECT.
        // So, if we create two objects of the same class, then the lock will be different for each object.
        // each object will acquire lock on itself separately.
        // here, we have called two methods of the SAME OBJECT m1. So, the output will be in sequence not parallel.
        // when t1 is running, t2 will wait. When t2 is running, t1 will wait. It will not run parallel. It will run in sequence. Because the lock is the same object m1.
        // when m1 calls even() method in Thread t1, it will acquire the lock on m1 object as even() method is synchronized.
        // then in Thread t2, when SAME OBJECT m1 calls odd() method that is synchronized, it will try to acquire the lock on m1 object. But the lock on m1 object is already acquired by t1. So, t2 will wait until t1 releases the lock.
        // when t1 releases the lock, then t2 will acquire the lock and run the odd() method.
        // So, the output will be in sequence not parallel.
        // check ObjectLevelLockDetails.png
        // even though we are using two threads here, the output will be in sequence not parallel.

        System.out.println("=====================================");

        // If we create two objects of the same class, then the lock will be different for each object.
        // each object will acquire lock on itself separately.
        // then the output will be parallel. Because the lock is different for each object.
        // For Example: (comment t1 and t2)

        ObjectLevelLockDetails m2 = new ObjectLevelLockDetails();

        Thread t3 = new Thread(m1::even);
        Thread t4 = new Thread(m2::odd);

        t3.start();
        t4.start();

        // here, we have called two methods of the DIFFERENT OBJECTS m1 and m2. So, the output will be parallel not in sequence.
        // when t3 is running, t4 will run parallel. When t4 is running, t3 will run parallel. It will run parallel.
        // Because the lock is different for each object.
    }
}
