public class Problem012 {
	/*TASK: Find the first triangle number to have > 500 divisors */
	// SO MUCH cleaner (sexier?) and quicker than last attempt
	
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		long triangleNumber = 1;
		for (int i = 2; divisorCounter(triangleNumber) <= 500; i++) {
			triangleNumber = triangleNumber + i;
		}
		
		// Result
		System.out.println("The number " + triangleNumber
				+ " is the first number to have over 500 divisors. It has "
				+ divisorCounter(triangleNumber) + " divisors.");
		
		// Time
		System.out.println("Time: " + (System.currentTimeMillis() - timeStart) / 1000 + " seconds");
		System.out.println(339/10);
	}

	public static int divisorCounter(long dividend) {
		int divisorCounter = 2; // Already include 1 and dividend itself
		for (int i = 2; i < Math.sqrt(dividend); i++) {
			if (dividend % i == 0) {
				divisorCounter += 2;
			}
		}
		if (Math.sqrt(dividend) % 1 == 0) {
			divisorCounter++;
		}
		return divisorCounter;
	}
}
