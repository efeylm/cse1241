import java.util.Iterator;
import java.util.Scanner;

public class Main {
	//Efe Yalım,150121074
	//This program prints different matrixes according to given rule in every steps.
	public static void main(String[] args) {
		Boolean condition = true; 
		String decvals;
		int step;
		while (condition) {
			Scanner input = new Scanner(System.in);

			System.out.print("Welcome to our program.\nEnter a string:");
			decvals = input.nextLine();
			System.out.print("Enter a number of steps: ");
			step = input.nextInt();
			int countofnumbers = 0;
			for (int i = 0; i < decvals.length(); i++) {
				if (decvals.charAt(i) == '-') {
					countofnumbers++;
				}
			}
			countofnumbers += 1;// current count of decimals

			int[][] binaryvals = new int[countofnumbers][countofnumbers];

			for (int i = 0; i < countofnumbers; i++) {
				String temp = "";
				if (i == countofnumbers - 1) {
					temp = decvals;
				} else {
					temp = decvals.substring(0, decvals.indexOf('-'));
				}

				int intValue = Integer.parseInt(temp);

				double maxNum = Math.pow(2, countofnumbers) - 1;// to check if the user types a wrong input
				if (intValue > maxNum) {
					System.out.println("The number " + intValue + " cannot be represented with " + countofnumbers + "x"
							+ countofnumbers + " array!");
					break;
				}

				binaryvals[i] = convertDectoB(intValue, countofnumbers);
				decvals = decvals.substring(decvals.indexOf('-') + 1);

				if (i == countofnumbers - 1) {
					printMatrix(binaryvals);
				}

			}

			int[] countsofneigbors = counttheNeigbours(countofnumbers, binaryvals); // counts the neighbors and add them in an array

			int[][] newbinaryvals = new int[binaryvals.length][binaryvals.length];
			
			int[][] finalbinvals= new int[binaryvals.length][binaryvals.length];
			for (int i = 0; i < step; i++) {
				System.out.println("It is converted to the following table after "+(i+1)+". step:");

				int temp = 0;

				for (int a = 0; a < binaryvals.length; a++) {
					for (int j = 0; j < binaryvals.length; j++) {
						if (binaryvals[a][j] == 1) {
							if (countsofneigbors[temp] < 2 || countsofneigbors[temp] > 3) {
								newbinaryvals[a][j] = 0;
							} else if (countsofneigbors[temp] == 2 || countsofneigbors[temp] == 3) {
								newbinaryvals[a][j] = 1;
							}
						} else {
							if (countsofneigbors[temp] == 3) {
								newbinaryvals[a][j] = 1;
							} else {
								newbinaryvals[a][j] = 0;
							}
						}
						temp++;
					}

				}
				printMatrix(newbinaryvals);
				countsofneigbors = counttheNeigbours(countofnumbers, newbinaryvals);

				
				for (int j = 0; j < binaryvals.length; j++) {
					for (int j2 = 0; j2 < newbinaryvals.length; j2++) {
						binaryvals[j][j2]=newbinaryvals[j][j2];
					}
				}
				
				if(i==step-1) {
					for (int j = 0; j < newbinaryvals.length; j++) {
						for (int j2 = 0; j2 < newbinaryvals.length; j2++) {
							finalbinvals[j][j2]=newbinaryvals[j][j2];
						}
					}
				}
				
				newbinaryvals = new int[binaryvals.length][binaryvals.length];

			}
		
			
			
			
			
			
		}

	}

	public static int[] counttheNeigbours(int countofnumbers, int[][] binaryvals) {
		int[] countsofneigbors = new int[countofnumbers * countofnumbers];

		int countofones = 0, countofzeros = 0;
		int counter = -1;
		for (int i = 0; i < binaryvals.length; i++) {
			for (int j = 0; j < binaryvals.length; j++) {
				if (j > 0) {
					if (binaryvals[i][j - 1] == 1) { // to check left neighbor
						countofones++;
					} else if (binaryvals[i][j - 1] == 0) {
						countofzeros++;
					}
				}
				if (i > 0) {
					if (binaryvals[i - 1][j] == 1) { // to check top neighbor
						countofones++;
					} else if (binaryvals[i - 1][j] == 0) {
						countofzeros++;
					}
				}
				if (j < binaryvals[i].length - 1) {
					if (binaryvals[i][j + 1] == 1) { // to check right neighbor
						countofones++;
					} else if (binaryvals[i][j + 1] == 0) {
						countofzeros++;
					}
				}
				if (i < binaryvals[i].length - 1) {
					if (binaryvals[i + 1][j] == 1) { // to check bottom neighbor
						countofones++;
					} else if (binaryvals[i + 1][j] == 0) {
						countofzeros++;
					}
				}
				if (i > 0 && j > 0) { // to check upperleft corner
					if (binaryvals[i - 1][j - 1] == 1) {
						countofones++;
					} else {
						countofzeros++;
					}
				}
				if (i > 0 && j < binaryvals[i].length - 1) { // to check upperright corner
					if (binaryvals[i - 1][j + 1] == 1) {
						countofones++;
					} else {
						countofzeros++;
					}
				}
				if (i < binaryvals[i].length - 1 && j < binaryvals[i].length - 1) {
					if (binaryvals[i + 1][j + 1] == 1) { // to check bottomright corner
						countofones++;
					} else {
						countofzeros++;
					}
				}
				if (i < binaryvals[i].length - 1 && j > 0) {
					if (binaryvals[i + 1][j - 1] == 1) { // to check bottomleft corner
						countofones++;
					} else {
						countofzeros++;
					}
				}
				if (counter < 8) {
					counter++;
				}

				countsofneigbors[counter] = countofones; // first index belongs to ones and second belongs to zeros

				countofones = 0;

			}

		}
		return countsofneigbors;
	}

	public static void printMatrix(int[][] binaryvals) {
		for (int i = 0; i < binaryvals.length; i++) {
			for (int j = 0; j < 4 * binaryvals.length + 1; j++) {
				System.out.print("-");
			}
			System.out.println();
			System.out.print("| ");
			for (int j = 0; j < binaryvals.length; j++) {
				System.out.print(binaryvals[i][j] + " | ");
			}
			System.out.println();
			if (i == binaryvals.length - 1) {
				for (int j = 0; j < 4 * binaryvals.length + 1; j++) {
					System.out.print("-");
				}
			}
		}
		System.out.println();
	}

	public static int[] convertDectoB(int number, int size) {
		int[] binaryval = new int[size];
		for (int i = 0; i < binaryval.length; i++) {
			binaryval[(binaryval.length - 1) - i] = number % 2;
			number /= 2;
		}

		return binaryval;
	}

}