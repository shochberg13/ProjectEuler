import java.util.PrimitiveIterator;

public class Problem047 {

	public static boolean isPrime(int number) {
		boolean isPrime = true;

		if (number < 2) {
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

	public static boolean isFactor(int number, int divisor) {
		if (number % divisor == 0) {
			return true;
		}
		return false;
	}

	public static int howManyPrimeFactors(int number) {
		int primeFactorCounter = 0;
		for (int j = 2; j < number; j++) {
			if (isFactor(number, j) && isPrime(j)) {
				primeFactorCounter++;
			}
		}

		// System.out.println("The number " + number + " has " +
		// primeFactorCounter + " prime factors.");
		return primeFactorCounter;
	}

	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		for (int i = 11; true; i++) {
			if (i % 10000 == 0){
				System.out.println("Status: " + i);
			}
			
			if ((howManyPrimeFactors(i) == 4) 
					&& (howManyPrimeFactors(i + 1) == 4)
					&& (howManyPrimeFactors(i + 2) == 4) 
					&& (howManyPrimeFactors(i + 3) == 4)) {

					System.out.println("ANSWER");
					System.out.println("The four consecutive numbers that all have 4 distinct prime numbers are "+ i + ", " + (i + 1) + ", " + (i + 2) + ", and " + (i + 3));
					System.out.println("Total Time: " + ((System.currentTimeMillis() - timeStart) / 1000));
					break;
				
			}

		}
	}
}
