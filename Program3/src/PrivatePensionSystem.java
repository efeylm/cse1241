import java.util.Scanner;

public class PrivatePensionSystem {

	public static void main(String[] args) {
		//This program calculates your private pension saving month by month, and tells your total profit and saving amount.
		//Efe Yalım, 150121074
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your monthly salary, for example 3500: ");
		float monthlysalary = (float) input.nextFloat();
		System.out.print("Enter the percent of your salary to save, for example 10%: ");
		float savingpercentage = (float) input.nextFloat() / 100;
		System.out.print("Enter the monthly interest rate, for example 8.25%: ");
		float monthlyinterestrate = (float) input.nextFloat() / 100;
		System.out.print("Enter the monthly government support rate, for example 25%: ");
		float monthlygovsuprate = (float) input.nextFloat() / 100;
		float totalsaving = monthlysalary * savingpercentage * 6;

		float firstmonthvalue = (monthlysalary * savingpercentage * (1 + monthlygovsuprate)
				* (1 + monthlyinterestrate));
		float secondmonthvalue = (firstmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		float thirdmonthvalue = (secondmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		float fourthmonthvalue = (thirdmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		float fifthmonthvalue = (fourthmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		float sixthmonthvalue = (fifthmonthvalue + monthlysalary * savingpercentage * (1 + monthlygovsuprate))
				* (1 + monthlyinterestrate);
		float totalprofit = sixthmonthvalue - totalsaving;

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
