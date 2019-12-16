import java.util.ArrayList;
import java.util.Collections;

/* TASK: Find the largest prime factor of 600851475143.0 */
// Much faster to do it the way I did in problem 7 //
public class Problem003 {
	public static void main(String[] args) {
		 double upperLimit = 6008514751.0;

		System.out.println("The largest prime factor is "
				+ findLargestPrimeFactor(upperLimit, createPrimes(upperLimit)));
	}

	public static ArrayList<Integer> createPrimes(double upperLimit) {

		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);

		for (int i = 3; i < Math.sqrt(upperLimit); i = i + 2) {
			boolean isPrime = true;
			for (int j = 0; j < primes.size()
					&& primes.get(j) < Math.sqrt(upperLimit); j++) {
				if (i % primes.get(j) == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		System.out.println(primes);
		System.out.println("Number of Primes found: " + primes.size());
		return primes;
	}

	public static double findLargestPrimeFactor(double largeNumber,	ArrayList<Integer> primes) {
		double tempLargeNumber = largeNumber;
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for (int primeNumber : primes) {
			
			while (tempLargeNumber % primeNumber == 0) {
				tempLargeNumber = tempLargeNumber / primeNumber;
				primeFactors.add(primeNumber);
				System.out.println("temp: " + tempLargeNumber + "\t prime number: " + primeNumber);
			}
		}
		System.out.println(primeFactors);
		return Collections.max(primeFactors);
	}
}
