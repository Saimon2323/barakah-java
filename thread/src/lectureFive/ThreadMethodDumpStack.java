package lectureFive;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Muhammad Saimon
 * @since Sep 07, 2024 7:26 PM
 */

public class ThreadMethodDumpStack {
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
//        System.out.println(1/0);
        Thread.dumpStack();
        // Thread.dumpStack() is used to print the stack trace of the current thread to the standard error stream.
        // You can see from the output that the stack trace contains the method calls that led to the current method.
        // This can be useful for debugging purposes, as it allows you to see the sequence of method calls that led to the current method.
        // you can see the lifecycle of the thread and how the methods are called in the thread.
    }
}

// Explain How Thread is saved in Memory
// When we create a thread, it is saved in the memory in the form of a stack. The stack is a memory area that is used to store the method calls and local variables of a thread.
// Each thread has its own stack, which is created when the thread is started and destroyed when the thread is terminated.
// The stack is used to keep track of the method calls and local variables of the thread. When a method is called, a new frame is created on the stack to store the method's arguments and local variables.
// When the method returns, the frame is removed from the stack. This process continues until the thread is terminated.
// The stack is a last-in, first-out (LIFO) data structure, which means that the most recently added frame is the first to be removed.
// This allows the thread to keep track of its method calls and local variables in an efficient manner.
// The stack is also used to handle exceptions in the thread. When an exception is thrown, the stack is unwound until the exception is caught or the thread is terminated.
// This allows the thread to handle exceptions in a controlled manner. The stack is an important part of the thread's memory management, and it plays a key role in the thread's execution.
// By understanding how the stack works, we can better understand how threads work and how they interact with each other.

