/**
 * @Author Muhammad Saimon
 * @since Feb 04, 2023 11:36 PM
 */

public class Literal {
    public static void main(String[] args) {

        System.out.println("################ Integer Literal #############################");

        int decVal = 26; // here, 26 is a decimal number
        int hexVal = 0x1a; // here, the number 26 is shown as hexa-decimal number. where 0x is fixed for hexadecimal and 1a is hexaD of 26.
        int binVal = 0b11010; // here, the number 26 is shown as Binary number. where 0b is fixed for Binary and 11010 is Binary of 26.

        System.out.println("Decimal Value: " + decVal);
        System.out.println("Hexa-Decimal Value: " + hexVal);
        System.out.println("Binary Value: " + binVal);

        System.out.println("##############################################################");


        System.out.println("############ Floating Point Literal ##########################");

        double d1 = 123.4;
        double d2 = 1.234e2;
        float  f1 = 123.4F;

        System.out.println("Double Value 1: " + d1);
        System.out.println("Double Value 2: " + d2);
        System.out.println("Float Value 1: " + f1);

        System.out.println("##############################################################");


        System.out.println("############ Use of Underscore ###############################");

        int x1 = 21_01_969;
        int x2= 21__969;
        double uInDouble = 2_97_635.0919;

        System.out.println("Underscore in Integer: " + x1);
        System.out.println("Multiple Underscore: " + x2);
        System.out.println("Underscore in Double Literal: " + uInDouble);

        System.out.println("##############################################################");

    }
}