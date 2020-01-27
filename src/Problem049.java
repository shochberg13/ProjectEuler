import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem049 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();

		for (int i = 1000; i < 9997; i++) {
			for (int j = 1; j < 4999; j++) {

				if (isPrime(i)) {
					if (isPrime(i + j) && arePermutationsOfEachOther(i, i + j)) {
						if (isPrime(i + j + j) && arePermutationsOfEachOther(i + j, i + j + j)) {
							System.out.println("The numbers " + i + ", " + (i + j) + ", and " + (i + j + j) + " are both separated by " + j + ", are all prime, and are all permutations of each other.");
							System.out.println("The three terms concatenated is: " + i + (i + j) + (i + j + j));
							System.out.println("~~~~~~~~");
						}
					}
				}
			}
		}

		System.out.println("Time elapsed: " + (double) ((System.currentTimeMillis() - timeStart) / 1000.00));
	}

	public static boolean arePermutationsOfEachOther(int number1, int number2) {
		List<Integer> num1 = new ArrayList<Integer>();
		List<Integer> num2 = new ArrayList<Integer>();

		String numberString1 = Integer.toString(number1);
		String numberString2 = Integer.toString(number2);

		if (numberString1.length() != numberString2.length()) {
			return false;
		}

		for (int i = 0; i < numberString1.length(); i++) {
			num1.add(Character.getNumericValue(numberString1.charAt(i)));
			num2.add(Character.getNumericValue(numberString2.charAt(i)));
		}

		Collections.sort(num1);
		Collections.sort(num2);

		if (num1.equals(num2)) {
			return true;
		}

		return false;
	}

	public static boolean isPrime(int number) {
		boolean isPrime = true;
		if (number <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
