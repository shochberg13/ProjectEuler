public class Problem006 {
	// TASK: Find the difference between sum of squares and square of sums from 1 - 100 //
	public static void main(String[] args) {
		int max = 100;
		System.out.println("The square of the sum: " + squareOfSum(max));
		System.out.println("The sum of the squares: " + sumOfSquares(max));
		System.out.println("The difference is: "
				+ (squareOfSum(max) - sumOfSquares(max)));
	}

	public static double sumOfSquares(int max) {
		double sumOfSquares = 0;
		for (int i = 1; i <= max; i++) {
			sumOfSquares += Math.pow(i, 2);
		}
		return sumOfSquares;
	}

	public static double squareOfSum(int max) {
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum += i;
		}
		return Math.pow(sum, 2);
	}

}
