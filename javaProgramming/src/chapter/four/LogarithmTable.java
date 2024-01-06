package chapter.four;

import java.util.Arrays;

/**
 * Author: Muhammad Saimon
 * Since 1/6/24 2:08 PM
 */

public class LogarithmTable {
    public static void main(String[] args) {
        System.out.println("Logarithm Table");
        System.out.println("n \t log10(n) \t log2(2) \t loge(n)");
        int n = 1;

        while (n <= 10) {

            double log10 = Math.log10(n);
//            double log2 = Math.log10(n) / Math.log10(2);
            double log2 = Math.log(n) / Math.log(2);
            double log = Math.log(n);

            String result = String.format("%d:" + "\t" + "%.6f" + "\t" + "%.6f" + "\t" + "%.6f", n, log10, log2, log);
            System.out.println(result);
            n++;
        }

    }
}
