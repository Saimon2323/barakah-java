import java.util.Scanner;

/**
 * @Author Muhammad Saimon
 * @since Nov 10, 2024 8:14 AM
 */

public class TaxCalculation {
    public static void main(String[] args) {
        // Tax Calculation in Bangladesh 2024
        double incomePerYear;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your income per year: ");
        incomePerYear = scanner.nextDouble();

        double tax = 0;

        double taxableIncome = (incomePerYear - (incomePerYear / 3)) - 350000;
        System.out.println("Taxable Income: " + taxableIncome);

        if (taxableIncome < 0) {
            tax = 0;
        } else if (taxableIncome > 0 && taxableIncome <= 100000) {
            tax = 5000;
        } else if (taxableIncome > 100000) {
            tax = 5000;
            taxableIncome = taxableIncome - 100000;

            if (taxableIncome >= 400000) {
                tax = tax + (400000 * 0.1);
                taxableIncome = taxableIncome - 400000;

                if(taxableIncome >= 500000) {
                    tax = tax + (500000 * 0.15);
                    taxableIncome = taxableIncome - 500000;

                    if (taxableIncome >= 500000) {
                        tax = tax + (500000 * 0.2);
                        taxableIncome = taxableIncome - 500000;

                        if (taxableIncome > 0) {
                            tax = tax + (taxableIncome * 0.25);
                        }
                    } else {
                        tax = tax + (taxableIncome * 0.2);
                        taxableIncome = 0;
                    }

                } else {
                    tax = tax + (taxableIncome * 0.15);
                    taxableIncome = 0;
                }
            } else {
                tax = tax + (taxableIncome * 0.1);
                taxableIncome = 0;
            }
        }
        System.out.println("Tax: " + tax);
    }
}
