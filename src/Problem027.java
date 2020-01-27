public class Problem027 {
	/*TASK: Find the coefficients of the quadratic n^2 + an + b that produce the most consecutive primes (within a range of +/- 1000)	 */
	public static void main(String[] args) {

		int maxN = 0;
		int maxA = 0;
		int maxB = 0;
		
		for (int a = -999; a <= 999; a++){
			for (int b = -1000; b <= 1000; b++){
				
				int primeCounter = 0;
				
				for (int n = 0; true; n++){
					if (isPrime(Math.abs((n * n) + (a * n) + b))){ // Abs for finding out if a negative number is prime
						primeCounter ++;
					}else{
						break;
					}
					if (primeCounter > maxN){
						maxN = primeCounter;
						maxA = a;
						maxB = b;
						System.out.println("Best Numbers so Far: \tA: " + a + "\t\tB: " + b + "\tNumberOfConsecutivePrimes: " + primeCounter);
					}
				}
			}
		}
		
		System.out.println("\nANSWER\n The coefficients " + maxA + " and " + maxB + " provide "  + maxN + " consecutive primes. The product of the coefficients is " + (maxA * maxB));
		
		
	}
	
	public static boolean isPrime(int number) {
		boolean isPrime = true;
		
		if (number == 0 || number == 1){
			return false;
		}
		
		for (int i = 2; i <= Math.sqrt(number); i ++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
