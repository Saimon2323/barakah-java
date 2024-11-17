import java.util.Scanner;

/**
 * @Author Muhammad Saimon
 * @since Nov 17, 2024 9:05 AM
 */

public class BDTaxCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Previous and current monthly salary
        System.out.print("Enter your previous year salary per month: ");
        double prevSalary = scanner.nextDouble();

        System.out.print("Enter your current year salary per month: ");
        double currSalary = scanner.nextDouble();

        // Calculate total yearly income
        double yearlyIncome = (prevSalary * 6) + (currSalary * 7);
        System.out.println("Yearly Income: " + yearlyIncome);

        // Determine tax-free amount (maximum 450,000 or one-third of income)
        double taxFreeAmount = Math.min(yearlyIncome / 3, 450000);

        // Calculate taxable income after tax-free amount and basic exemption
        double tax = getTax(yearlyIncome, taxFreeAmount);

        System.out.println("Tax to be paid: " + tax);
    }

    private static double getTax(double yearlyIncome, double taxFreeAmount) {
        double taxableIncome = yearlyIncome - taxFreeAmount - 350000;

        // Initialize tax to 0
        double tax = 0;

        // If taxable income is positive, calculate tax based on brackets
        if (taxableIncome > 0) {
            if (taxableIncome <= 100000) {
                tax = taxableIncome * 0.05;
            } else if (taxableIncome <= 500000) {
                tax = 5000 + (taxableIncome - 100000) * 0.1;
            } else if (taxableIncome <= 1000000) {
                tax = 45000 + (taxableIncome - 500000) * 0.15;
            } else if (taxableIncome <= 1500000) {
                tax = 120000 + (taxableIncome - 1000000) * 0.2;
            } else {
                tax = 220000 + (taxableIncome - 1500000) * 0.25;
            }
        }
        return tax;
    }
}
