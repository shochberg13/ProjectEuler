public class Problem034 {
	public static void main(String[] args) {
	
		long max = 10000000;
		long sumOfCuriousNumbers = 0;
		for (long i = 3; i < max; i++){
			if (isCuriousNumber(i)){
				sumOfCuriousNumbers += i;
				System.out.println("I found a curious number: " + i + "\t Current Sum: " + sumOfCuriousNumbers);
			}
		}
	
	}

	public static int factorial(long number) {
		int factorial = 1;
		for (int i = 2; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	/**
	 * A curious number is a number that is equal to the sum of the factorial of
	 * their digits
	 */
	public static boolean isCuriousNumber(long number) {
		String numberString = Long.toString(number);

		long sumOfFactorial = 0;
		for (int i = 0; i < numberString.length(); i++) {
			sumOfFactorial += factorial(Character.getNumericValue(numberString.charAt(i)));
		}

		if (sumOfFactorial == number) {
			return true;
		}
		return false;
	}
}
