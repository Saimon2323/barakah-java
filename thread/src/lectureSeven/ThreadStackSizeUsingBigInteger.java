package lectureSeven;

import java.math.BigInteger;

/**
 * @Author Muhammad Saimon
 * @since Sep 27, 2024 7:45 PM
 */

public class ThreadStackSizeUsingBigInteger {
    public static void main(String[] args) {

        // In Java, if you provide memory to Java, it can do anything. So, if you provide enough memory to Java, it can calculate big numbers using recursion.
        // Here, I have set 10MB memory to Stack as StackSize for this thread using the constructor of Thread class to calculate 100000! using recursion.
        // But it is not recommended to use this approach because it will consume more memory.
        // So, it is recommended to use the iterative approach to calculate big numbers. (SEE BigIntegerExample.java)
        // now, we will not get StackOverFlowError because we have provided enough memory to the stack and it can hold that much data in the stack frame.
        // Now, it will provide the result of 100000! using recursion.
        Thread thread1 = new Thread(
                Thread.currentThread().getThreadGroup(),
                () -> System.out.println(bigFactorialUsingRecursion(new BigInteger("100000"))),
                "Thread-Factorial",
                10 * 1024 * 1024
        );
        thread1.start();
    }

    static long factorialUsingRecursion(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * factorialUsingRecursion(num - 1);
    }

    static BigInteger bigFactorialUsingRecursion(BigInteger num) {
        if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return num.multiply(bigFactorialUsingRecursion(num.subtract(BigInteger.ONE)));
    }
}
