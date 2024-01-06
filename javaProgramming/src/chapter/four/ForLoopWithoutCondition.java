package chapter.four;

/**
 * Author: Muhammad Saimon
 * Since 1/6/24 3:32 PM
 */

public class ForLoopWithoutCondition {

    public static void main(String[] args) {

        // Main component of For loop are TWO semicolons in the parenthesis.
        // for (initialization; condition; increment/decrement)

        int i = 1;
        for (;;) {
            System.out.println("Hello World! " + i + " times");
            i++;
            if (i == 10) {
                break;
            }
        }

        System.out.println("########## Another One #########");

        for (int j = 1; ; j++) {
            System.out.println("Hello World! " + j + " times");
            if (j == 10) {
                break;
            }
        }
    }
}
