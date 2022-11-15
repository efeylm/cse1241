import java.util.Scanner;

public class Pro2_150121074 {

	public static void main(String[] args) {
		// This program calculates the amount of your eggs in terms of dozens and gross.
		// Efe Yalım , 150121074
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your total number of eggs: ");
		int totalnumberofeggs = input.nextInt();
		int grossofeggs = totalnumberofeggs / 144;
		int leftfromgross = totalnumberofeggs % 144;
		int dozenofeggs = leftfromgross / 12;
		int leftfromdozen = totalnumberofeggs % 12;
		System.out.println("Your number of eggs is " + grossofeggs + " gross," + dozenofeggs + " dozen, and "
				+ leftfromdozen + ".");

	}

}
