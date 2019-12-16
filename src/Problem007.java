public class Problem007 {

	public static void main(String[] args) {

		int primeCounter = 2;
		boolean isPrime = true;
		for (int i = 5; primeCounter < 10001; i = i + 2) {
			isPrime = true;
			for (int j = 3; j <= Math.sqrt(i); j = j + 2) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeCounter++;
				System.out.println("Number of primes so far: " + primeCounter + "\t" + "Last Prime: " + i);
			}

		}
	}
}
