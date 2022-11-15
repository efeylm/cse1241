import java.util.Scanner;

public class Hw2_150121074 {

	public static void main(String[] args) {
		// This program makes the given calculation in given bases.
		// Efe Yalım,150121074

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the base of the number system: ");
		int baseNumber = input.nextInt();
		System.out.print("Enter the type of operation: ");
		char operation = input.next().charAt(0);
		System.out.print("Enter the input numbers: ");
		int number1 = input.nextInt();// 1010
		int number2 = input.nextInt();
		int decimalNumber1 = 0;
		int decimalNumber2 = 0;
		System.out.println();

		switch (operation) {
		case 'a':

			for (int i = 0; number1 > 0; i++) { // in order to convert binary number to decimal
				int digit = number1 % 10;
				decimalNumber1 += digit * Math.pow(baseNumber, i);
				number1 = number1 / 10;
			}
			for (int i = 0; number2 > 0; i++) { // in order to convert binary number to decimal
				int digit = number2 % 10;
				decimalNumber2 += digit * Math.pow(baseNumber, i);
				number2 = number2 / 10;
			}
			int decimalAddition = decimalNumber1 + decimalNumber2;
		

			int binaryNumber = 0;

			for (int i = 0; decimalAddition > 0; i++) {
				int remainder = decimalAddition % baseNumber;
				double c = Math.pow(10, i);
				binaryNumber += remainder * c;
				decimalAddition /= baseNumber;
			}

			System.out.println("Output: " + binaryNumber);

			break;
		case 's':

			for (int i = 0; number1 > 0; i++) { // in order to convert binary number to decimal
				int digit = number1 % 10;
				decimalNumber1 += digit * Math.pow(baseNumber, i);
				number1 = number1 / 10;
			}
			for (int i = 0; number2 > 0; i++) { // in order to convert binary number to decimal
				int digit = number2 % 10;
				decimalNumber2 += digit * Math.pow(baseNumber, i);
				number2 = number2 / 10;
			}
			int decimalSubtraction = decimalNumber1 - decimalNumber2;

			int subtractedBinaryNumber = 0;
			for (int i = 0; decimalSubtraction > 0; i++) {
				int remainder = decimalSubtraction % baseNumber;
				double c = Math.pow(10, i);
				subtractedBinaryNumber += remainder * c;
				decimalSubtraction /= baseNumber;
			}

			System.out.println("Output: " + subtractedBinaryNumber);

			break;
		case 'd':

			for (int i = 0; number1 > 0; i++) { // in order to convert binary number to decimal
				int digit = number1 % 10;
				decimalNumber1 += digit * Math.pow(baseNumber, i);
				number1 = number1 / 10;
			}
			for (int i = 0; number2 > 0; i++) { // in order to convert binary number to decimal
				int digit = number2 % 10;
				decimalNumber2 += digit * Math.pow(baseNumber, i);
				number2 = number2 / 10;
			}
			int decimalDivision = decimalNumber1 / decimalNumber2;

			int dividedBinaryNumber = 0;
			for (int i = 0; decimalDivision > 0; i++) {
				int remainder = decimalDivision % baseNumber;
				double c = Math.pow(10, i);
				dividedBinaryNumber += remainder * c;
				decimalDivision /= baseNumber;
			}

			System.out.println("Output: " + dividedBinaryNumber);

			break;
		case 'm':
			for (int i = 0; number1 > 0; i++) { // in order to convert binary number to decimal
				int digit = number1 % 10;
				decimalNumber1 += digit * Math.pow(baseNumber, i);
				number1 = number1 / 10;
			}
			for (int i = 0; number2 > 0; i++) { // in order to convert binary number to decimal
				int digit = number2 % 10;
				decimalNumber2 += digit * Math.pow(baseNumber, i);
				number2 = number2 / 10;
			}
			int decimalMultiplication = decimalNumber1 * decimalNumber2;
			int multiplicatedBinaryNumber = 0;

			for (int i = 0; decimalMultiplication > 0; i++) {  //in order to convert decimal to binary
				int remainder = decimalMultiplication % baseNumber;
				double c = Math.pow(10, i);
				multiplicatedBinaryNumber += remainder * c;
				decimalMultiplication /= baseNumber;
			}

			System.out.println("Output: " + multiplicatedBinaryNumber);

			break;

		default:
			break;
		}

	}

}
