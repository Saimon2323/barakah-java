import java.util.Scanner;

/**
 * @Author Muhammad Saimon
 * @since Nov 10, 2024 8:14 AM
 */

public class TaxCalculation {
    public static void main(String[] args) {
        // Tax Calculation in Bangladesh 2024 for private job holders
        double incomePerYear, taxFreeAmount;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your previous year salary per Month: ");
        double prevSalary = scanner.nextDouble();

        System.out.print("Enter your current year salary per Month: ");
        double currSalary = scanner.nextDouble();

        incomePerYear = (prevSalary * 6) + (currSalary * 7);
        System.out.println("Income Per Year: " + incomePerYear);

        double tax = 0;

        taxFreeAmount = Math.min(incomePerYear / 3, 450000);

        double taxableIncome = (incomePerYear - taxFreeAmount) - 350000;
        System.out.println("Taxable Income: " + taxableIncome);

        if (taxableIncome < 0) {
            tax = 0;
        } else if (taxableIncome > 0 && taxableIncome <= 100000) {
            tax = taxableIncome * 0.05;
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
                            taxableIncome = 0;
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
