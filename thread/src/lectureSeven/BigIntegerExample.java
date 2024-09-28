package lectureSeven;

import java.math.BigInteger;

/**
 * @Author Muhammad Saimon
 * @since Sep 27, 2024 6:46 PM
 */

public class BigIntegerExample {
    public static void main(String[] args) {

        // here fact method returns long type value but it will not work for big numbers like 45, 1000, 10000 because long type can't hold that big number
        // because long type has a limit from -2^63 to 2^63-1 which is -9223372036854775808 to 9223372036854775807
        // but 45! = 119622220865480194561963161495657715064383733760000000000 and it is a very big number that is outside the limit of long type
        System.out.println(factorialUsingRecursion(45));
        System.out.println(factorialUsingIteration(45));

        // So we need to use BigInteger class to hold that big number
        // BigInteger is a class in java that is used to handle very big integers that are outside the limit of all available primitive data types.
        // BigInteger class is immutable, and it provides operations for arithmetic, prime numbers testing, and other mathematical operations.
        System.out.println(bigFactorialUsingRecursion(new BigInteger("45")));
        System.out.println(bigFactorialUsingIteration(new BigInteger("1000")));

        System.out.println("====================================");

        // here, we will get a StackOverflowError because the Stack frame is limited, and it can't hold that much data in the stack frame for a RECURSIVE call
        // of bigFact method with a big number like 10000 or more than that number
        // because Recursion uses the stack frame to store the method calls. Those methods create a lot of stack frames in the stack memory.
        // So, we need to increase the stack size to avoid this error.
        // By default, the stack size is 1MB. We can increase the stack size by using -Xss flag in the JVM.
        // For example, java -Xss10m BigIntegerExample will increase the stack size to 10mb.
        // But it is not recommended to increase the stack size because it will consume more memory, and it is not a good practice for a big number.
        // So, we can use the iterative approach to avoid this error. (Given below)
        // But for learning purposes, you can increase the stack size to avoid this error.
        System.out.println(bigFactorialUsingRecursion(new BigInteger("10000")));

        System.out.println("=============== Iterative Approach =====================");
        // Comment in above line to avoid StackOverFlowError
        // For big numbers, it is recommended to use the iterative approach instead of the recursive approach
        // Because Iterative approach doesn't have method calls in the stack frame like recursive approach
        // So, it will not cause StackOverFlowError for big numbers
        System.out.println("Using Iterative approach: " + bigFactorialUsingIteration(new BigInteger("10000")));

        // TODO:: additionally, we can set the stackSize (Memory) for a thread to calculate this Big Number using Recursion. (SEE ThreadStackSizeUsingBigInteger.java)
    }

    static long factorialUsingRecursion(int num) {

        if (num == 1 || num == 0) {
            return 1;
        }

        return num * factorialUsingRecursion(num - 1);
    }

    static long factorialUsingIteration(int num) {

        long result = 1;

        if (num == 1 || num == 0) return result;

        for (int i = num; i > 0; i--) {
            result = i * result;
        }

//        for (int i = 1; i <= num; i++) {
//            result = i * result;
//        }

        return result;
    }

    static BigInteger bigFactorialUsingRecursion(BigInteger num) {
        if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        return num.multiply(bigFactorialUsingRecursion(num.subtract(BigInteger.ONE)));
    }

    static BigInteger bigFactorialUsingIteration(BigInteger num) {

        BigInteger result = BigInteger.ONE;

        if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)) return result;

        for (BigInteger i = num; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            result = result.multiply(i);
        }

//        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
//            result = result.multiply(i);
//        }

        return result;
    }
}
