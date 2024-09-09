package lectureFive;

/**
 * @Author Muhammad Saimon
 * @since Sep 09, 2024 7:46 AM
 */

public class ThreadMethodSetDefaultUncaughtExceptionHandler {
    public static void main(String[] args) throws Exception {

        // Set Default Uncaught Exception Handler
        // The setDefaultUncaughtExceptionHandler method is used to set the default uncaught exception handler for all threads in the JVM.
        // The default uncaught exception handler is called when a thread throws an uncaught exception.
        // here, in method m2, an exception is thrown and it is not caught in the method. So, the default uncaught exception handler is called.
        // If you handle the exception in the method m2(), then the default uncaught exception handler will not be called.
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println("Thread Name: " + thread.getName());
            System.out.println("Exception Message: " + throwable.getMessage());
            System.out.println("Exception Cause: " + throwable.getCause());
            System.out.println("Exception Stack Trace: ");
            throwable.printStackTrace();
        });

        System.out.println("in main method");
        m1();
    }

    static void m1() {
        System.out.println("in m1 method");
        m2();
    }

    static void m2() {
        System.out.println("in m2 method");

        // Throwing an exception. This exception will be caught by the default uncaught exception handler.
        // because we are not handling this exception here.
        System.out.println(1/0);

        // Handling checked exception using try-catch block. So this exception will not be caught by the default uncaught exception handler.
//        try {
//            System.out.println(1/0);
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//            e.printStackTrace();
//        }

        m3();
    }

    static void m3() {
        System.out.println("in m3 method");
    }
}
