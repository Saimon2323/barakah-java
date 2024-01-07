package chapter.five;

import java.util.Arrays;

/**
 * Author: Muhammad Saimon
 * Since 1/7/24 7:16 AM
 */

public class ArrayCheck {
    public static void main(String[] args) {
        int[][] numbers = {{10, 20, 30}, {3, 4}, {40, 50, 60, 70}};
        System.out.println(numbers[2][3]);

        int[][] numbers2 = new int[3][];

        int[] primitiveDefaultValue = new int[10]; // default value is 0
        System.out.println(Arrays.toString(primitiveDefaultValue));

        Integer[] refDefaultValue = new Integer[10]; // default value is "null"
        System.out.println(Arrays.toString(refDefaultValue));
    }
}
