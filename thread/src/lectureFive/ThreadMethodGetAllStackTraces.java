package lectureFive;

import java.util.Map;

/**
 * @Author Muhammad Saimon
 * @since Sep 08, 2024 8:46 AM
 */

public class ThreadMethodGetAllStackTraces {
    public static void main(String[] args) throws Exception {
        m1();
    }

    static void m1() {
        m2();
    }

    static void m2() {
        m3();
    }

    static void m3() {

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        allStackTraces.forEach((thread, stackTraceElement) -> {
            System.out.println("Thread Name: " + thread);
            for (StackTraceElement element : stackTraceElement) {
                System.out.println("\t" + element);
            }
        });

        System.out.println("\n====================\n");

        // Get Main thread info from allStackTraces
        for (StackTraceElement stackTraceElement : allStackTraces.get(Thread.currentThread())) {
            System.out.println("File Name: " + stackTraceElement.getFileName());
            System.out.println("Line Number: " + stackTraceElement.getLineNumber());
            System.out.println("Method Name: " + stackTraceElement.getMethodName());
            System.out.println("Class Name: " + stackTraceElement.getClassName());
            System.out.println("Is Native Method: " + stackTraceElement.isNativeMethod());
            System.out.println("ClassLoader Name: " + stackTraceElement.getClassLoaderName());
            System.out.println("Module Name: " + stackTraceElement.getModuleName());
            System.out.println("Module Version: " + stackTraceElement.getModuleVersion());
            System.out.println("HashCode: " + stackTraceElement.hashCode());
            System.out.println("Class: " + stackTraceElement.getClass());
            System.out.println("---------------------");
        }

        System.out.println("\n====================\n");

        // get Main thread stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            System.out.println(element);
        }
    }
}
