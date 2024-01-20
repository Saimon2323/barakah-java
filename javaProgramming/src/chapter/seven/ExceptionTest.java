package chapter.seven;

/**
 * Author: Muhammad Saimon
 * Since 1/21/24 1:48 AM
 */

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            int a = 5;
            if (a < 10) {
                throw new Exception("Value is too small");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block");
        }
    }
}
