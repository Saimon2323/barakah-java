/**
 * Author: Muhammad Saimon
 * Since 1/6/24 1:28 AM
 */

public class DataTypeOverFlowUnderFlow {

    public static void main(String[] args) {
        int intMaxValue = Integer.MAX_VALUE;
        int intMinValue = Integer.MIN_VALUE;
        System.out.println("intMax Value: " + intMaxValue);
        System.out.println("intMin Value: " + intMinValue);
        intMaxValue++;
        intMinValue--;
        System.out.println("int OverFlow: " + intMaxValue);
        System.out.println("int OverFlow: " + intMinValue);
        System.out.println("int limit: -2147483648 to 2147483647. If we add 1 with 2147483647 then it will be -2147483648.");
        System.out.println("Anything out of this range will be overflowed.");

        System.out.println("##############################################################");

        long longMaxValue = Long.MAX_VALUE;
        long longMinValue = Long.MIN_VALUE;
        System.out.println("longMax Value: " + longMaxValue);
        System.out.println("longMin Value: " + longMinValue);
        longMaxValue++;
        longMinValue--;
        System.out.println("long OverFlow: " + longMaxValue);
        System.out.println("long OverFlow: " + longMinValue);
        System.out.println("long limit: -9223372036854775808 to 9223372036854775807. Anything out of this range will be overflowed.");

        System.out.println("########################### Under Flow ###################################");

        int a = 1;
        int b = 3;
        int c = a / b;
        System.out.println("result: " + c);
        // result: 0. Because, 1/3 = 0.3333333333333. But, int can't hold decimal value. So, it will be 0.
        // This is called under flow.

        // Note:
        // In java runtime system, java does not show any error or warning for under flow or overflow.
        // It is programmer's responsibility to check under flow or overflow.
    }
}
