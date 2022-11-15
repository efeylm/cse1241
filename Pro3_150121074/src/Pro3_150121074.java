import java.util.Scanner;

public class Pro3_150121074 {

	public static void main(String[] args) {
		//This program calculates your private pension saving month by month, and tells your total profit and saving amount.
		//Efe Yalım, 150121074
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your monthly salary, for example 3500: ");
		double monthlysalary = input.nextDouble();
		System.out.print("Enter the percent of your salary to save, for example 10%: ");
		double savingpercentage = input.nextDouble() / 100;
		System.out.print("Enter the monthly interest rate, for example 8,25%: ");
		double monthlyinterestrate =input.nextDouble() / 100;
		System.out.print("Enter the monthly government support rate, for example 25%: ");
		double monthlygovsuprate = input.nextDouble() / 100;
		double totalsaving = monthlysalary * savingpercentage * 6;

		double firstmonthvalue = (monthlysalary * savingpercentage * (1 + monthlygovsuprate)
				* (1 + monthlyinterestrate));
		double secondmonthvalue = (firstmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		double thirdmonthvalue = (secondmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		double fourthmonthvalue = (thirdmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		double fifthmonthvalue = (fourthmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		double sixthmonthvalue = (fifthmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		double totalprofit = sixthmonthvalue - totalsaving;

		System.out.println(
				"After the first month, the account value is " + (int) (firstmonthvalue * 100) / 100.0 + " TLs");
		System.out.println(
				"After the second month, the account value is " + (int) (secondmonthvalue * 100) / 100.0 + " TLs");
		System.out.println(
				"After the third month, the account value is " + (int) (thirdmonthvalue * 100) / 100.0 + " TLs");
		System.out.println(
				"After the fourth month, the account value is " + (int) (fourthmonthvalue * 100) / 100.0 + " TLs");
		System.out.println(
				"After the fifth month, the account value is " + (int) (fifthmonthvalue * 100) / 100.0 + " TLs");
		System.out.println(
				"After the sixth month, the account value is " + (int) (sixthmonthvalue * 100) / 100.0 + " TLs");
		System.out.println("In total, you saved " + (int) (totalsaving * 100) / 100.0 + "TLs and your total profit is "
				+ (int) (totalprofit * 100) / 100.0 + " TLs");
	}

}
