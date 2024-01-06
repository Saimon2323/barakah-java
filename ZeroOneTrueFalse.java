/**
 * Author: Muhammad Saimon
 * Since 1/6/24 11:57 AM
 */

public class ZeroOneTrueFalse {

    public static void main(String[] args) {

        int zero = 0;

        if (zero == 0) {
            System.out.println("Zero");
        } else {
            System.out.println("Not Zero");
        }

        int one = 1;

        if (one == 1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Not Possible. It throws error.
        // In C++, it is possible. But, in Java it is not possible.
        // In C++, 0 means false and any positive or negative number means true.
        if (1) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

}
