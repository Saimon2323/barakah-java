import java.util.concurrent.Callable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Current Thread Name: " + Thread.currentThread().getName());

        System.out.println("Thread Developer id: " + Thread.currentThread().getId());

        System.out.println("\nThreadGroup");
        Thread.currentThread().getThreadGroup().list();

        System.out.println("\nThreadGroup details with parent");
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}

// Both Reference Handler and Finalizer threads are used by the JVM for garbage collection.
// The Reference Handler thread is responsible for cleaning up references to objects in Stack memory that are no longer needed.
// The Finalizer thread is responsible for cleaning up objects from the Heap memory whose references are no longer available in the Stack memory.


// Use of Thread[Reference Handler,10,system]
// The Reference Handler thread is started by the JVM when it is initialized, and it runs in the background to clean up references to objects that are no longer needed.
// The Reference Handler thread is a low-priority thread, which means that it runs in the background and does not interfere with the execution of other threads.
// The Reference Handler thread is an important part of the garbage collection process in Java, as it helps to free up memory by cleaning up references to objects that are no longer in use.
// Reference Handler checks which objects are unreachable and then those unreachable objects are sent to the Finalizer thread for finalization.
// The Finalizer thread is responsible for cleaning up the objects that are no longer in use.


// Use of Thread[Finalizer,8,system]
// Finalizer thread is used to clean up objects that are no longer in use.
// It takes input from the Reference Handler thread and cleans up the objects that are no longer in use.
// Garbage collection is the process of cleaning up objects that are no longer in use, and the Finalizer thread is an important part of this process.