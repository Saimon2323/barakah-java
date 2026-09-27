import java.util.Scanner;

public class YearlyTaxCalculator {

    /**
     * Calculates the gross tax before any rebates/credits based on progressive tax slabs.
     *
     * @param taxableIncome Total taxable annual income
     * @param isFemaleOrSenior True if female or aged 65+, otherwise false
     * @return Gross tax amount
     */
    public static double calculateGrossTax(double taxableIncome, boolean isFemaleOrSenior) {
        // Initial exemption threshold based on category
        double initialExemption = isFemaleOrSenior ? 425000.0 : 400000.0;

        if (taxableIncome <= initialExemption) {
            return 0.0;
        }

        // Remaining income to be taxed after the basic exemption
        double remainingIncome = taxableIncome - initialExemption;
        double totalTax = 0.0;

        // Progressive Slabs: {slab limit, tax rate}
        double[][] slabs = {
                {300000.0, 0.10},   // Next 300,000 @ 10%
                {400000.0, 0.15},   // Next 400,000 @ 15%
                {500000.0, 0.20},   // Next 500,000 @ 20%
                {2000000.0, 0.25}   // Next 2,000,000 @ 25%
        };

        for (double[] slab : slabs) {
            double slabLimit = slab[0];
            double slabRate = slab[1];

            if (remainingIncome > 0) {
                double taxableInThisSlab = Math.min(remainingIncome, slabLimit);
                totalTax += taxableInThisSlab * slabRate;
                remainingIncome -= taxableInThisSlab;
            } else {
                break;
            }
        }

        // Any balance remaining above the slabs is taxed at 30%
        if (remainingIncome > 0) {
            totalTax += remainingIncome * 0.30;
        }

        return totalTax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      YEARLY INCOME TAX CALCULATOR      ");
        System.out.println("========================================");

        // Input 1: Taxable Income
        System.out.print("Enter Previous Income (Tk.): ");
        double prevYearIncome = scanner.nextDouble();

        System.out.print("Enter Current Year Income (Tk.): ");
        double currentYearIncome = scanner.nextDouble();

        double totalIncome = (prevYearIncome * 6) + (currentYearIncome * 7);

        // Determine tax-free amount (maximum 500,000 or one-third of income)
        double taxFreeAmount = Math.min(totalIncome / 3, 500000);

        double taxableIncome = totalIncome - taxFreeAmount;

        double investmentExemption = taxableIncome * 0.03;

        // Input 2: Exemption category
        System.out.print("Are you Female or Above 65 years old? (yes/no): ");
        String status = scanner.next().trim().toLowerCase();
        boolean isFemaleOrSenior = status.startsWith("y");

        // Input 3: Investment tax rebate / exemption
        System.out.print("Enter Investment Exemption / Tax Rebate (Tk., 0 if none): ");
        double investmentRebate = scanner.nextDouble();

        // Calculations
        double grossTax = calculateGrossTax(taxableIncome, isFemaleOrSenior);

        double advanceIncomeTax = grossTax - investmentExemption;

        double netTaxPayable = Math.max(0, grossTax - investmentRebate);

        // Display Breakdown
        System.out.println("\n----------------- SUMMARY -----------------");
        System.out.printf("Total Income          : %,12.2f Tk.\n", totalIncome);
        System.out.printf("Tax-Free Amount       : %,12.2f Tk.\n", taxFreeAmount);
        System.out.printf("Net Taxable Income    : %,12.2f Tk.\n", taxableIncome);
        System.out.printf("Exemption Applied     : %,12.2f Tk.\n", (isFemaleOrSenior ? 425000.0 : 400000.0));
        System.out.printf("Yearly Gross Tax      : %,12.2f Tk.\n", grossTax);
        System.out.printf("Investment Exemption  : %,12.2f Tk.\n", investmentExemption);
        System.out.println("-------------------------------------------");
        System.out.printf("AIT                   : %,12.2f Tk.\n", advanceIncomeTax);
        System.out.printf("Monthly AIT Tax       : %,12.2f Tk.\n", advanceIncomeTax / 12.0);
        System.out.println("-------------------------------------------");
        System.out.printf("Investment Rebate     : %,12.2f Tk.\n", investmentRebate);
        System.out.println("-------------------------------------------");
        System.out.printf("Net Yearly Tax to Pay : %,12.2f Tk.\n", netTaxPayable - advanceIncomeTax);
        System.out.println("===========================================");

        scanner.close();
    }
}