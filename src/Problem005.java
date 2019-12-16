public class Problem005 {
	// TASK: Find the first number that is divisible by all numbers between 1 and 20
	public static void main(String[] args) {
		firstDivisibleNumber();
	}

	public static int firstDivisibleNumber() {
		int max = 20;
		int i = max;
		while (true) {
			for (int j = 3; j <= max; j++) { // No need to count 1 and 2, if it's divisible by 20 already.
				if (i % j != 0) {
					break;
				}
				if (j == max) {
					System.out.println("The super divisible number is " + i);
					return i;
				}
			}
			i = i + max; // Has to be divisible by max, so might as well count by max
		}
	}
}
