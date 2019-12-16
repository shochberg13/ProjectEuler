import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem013 {
/*TASK: Given a hundred 50-digit numbers, find the first 10 digits of the sum	 */

	public static void main(String[] args) throws FileNotFoundException {
		// Retrieve File
		ArrayList<String> hundredNumbers = new ArrayList<String>();
		File file = new File("C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem013.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			hundredNumbers.add(scan.nextLine());
		}

		// Create calculator
		int carryOver = 0;
		int digitAdder = 0;
		String finalSum = "";

		for (int i = hundredNumbers.get(1).length() - 1; i >= 0; i--) {
			digitAdder = 0;

			for (int j = 0; j < hundredNumbers.size(); j++) {
				digitAdder += Character.getNumericValue((hundredNumbers.get(j).charAt(i)));
			}

			digitAdder += carryOver;

			carryOver = digitAdder / 10;
			String newDigit = Integer.toString(digitAdder % 10);
			finalSum = newDigit + finalSum;
		}
		
		if (carryOver > 0) {
			finalSum = Integer.toString(carryOver) + finalSum;
		}
		System.out.println("Final Sum: " + finalSum);
		System.out.println("The first 10 digits are : " + finalSum.substring(0, 10));
	}
}
