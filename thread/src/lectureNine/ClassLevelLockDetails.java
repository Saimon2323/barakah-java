package lectureNine;

/**
 * @Author Muhammad Saimon
 * @since Nov 23, 2024 3:54 PM
 */

public class ClassLevelLockDetails {

        synchronized static void even() {
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even: " + i + " " + Thread.currentThread().getName());
                }
            }
        }

        synchronized static void odd() {
            for (int i = 0; i < 20; i++) {
                if (i % 2 != 0) {
                    System.out.println("Odd: " + i + " " + Thread.currentThread().getName());
                }
            }
        }

        public static void main(String[] args) {

            Thread t1 = new Thread(ClassLevelLockDetails::even); // class level lock

            Thread t2 = new Thread(ClassLevelLockDetails::odd); // class level lock

            // before starting t1 and t2, comment t3 and t4.
            t1.start();
            t2.start();

            // We already know that one object has one lock and Lock is applied on the OBJECT.
            // here both methods are static (not instance methods). So, Class Level Lock will be applied.
            // When a Class is loaded, in JVM, a Class<ClassName> object is created. So, the lock will be on that Class<ClassName> object.
            // Here, as no object of ClassLevelLockDetails is created, the lock will be on Class<ClassName> object in JVM.
            // Class<ClassLevelLockDetails> objOfClassLevelLockDetails = ClassLevelLockDetails.class; this is the Class<ClassName> object in JVM for this class.
            // As Object is same for both methods, the output will be in sequence not parallel.

            // Even if we create two objects of this class and then call these two STATIC methods, the output will be in sequence not parallel.
            // As both methods are static, the lock will be on the Class<ClassName> object in JVM, not on the created objects.
            // see following example:

            ClassLevelLockDetails m1 = new ClassLevelLockDetails();
            ClassLevelLockDetails m2 = new ClassLevelLockDetails();

            Thread t3 = new Thread(() -> {
                m1.even(); // class level lock
            }, "Thread-3");

            Thread t4 = new Thread(() -> {
                m2.odd(); // class level lock
            }, "Thread-4");

            // before starting t3 and t4, comment t1 and t2.
            t3.start();
            t4.start();
        }
}
