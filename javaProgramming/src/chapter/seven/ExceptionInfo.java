package chapter.seven;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Muhammad Saimon
 * Since 1/20/24 7:06 PM
 */

public class ExceptionInfo {

    private final static Logger LOGGER =  Logger.getLogger(ExceptionInfo.class.getName());

    public static void main(String[] args) {

//        int[] numbers = {10, 20, 30, 40, 50};
//
//        try {
//            System.out.println(numbers[5]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Exception: " + e);
//            System.out.println("Exception msg: " + e.getMessage());
//            e.printStackTrace();
//            System.out.println("Exception cause: " + e.getCause());
//            System.out.println("Exception class: " + e.getClass());
//        } finally {
//            System.out.println("Finally block");
//        }

        try {
            int result = divide(10, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.err.println("Exception: " + e);
            System.err.println("Exception msg: " + e.getMessage());
            e.printStackTrace();
            System.err.println("Exception cause: " + e.getCause());
            System.err.println("Exception class: " + e.getClass());
        }

    }

    private static int divide(int num1, int num2) {
        return num1 / num2;
    }
}
