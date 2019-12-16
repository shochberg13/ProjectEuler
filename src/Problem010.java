/*TASK: Find the sum of all primes below 2M */
public class Problem010 {

	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		
		int max = 2000000;
		long primeSum = 5; // Sum of first 2 primes
		boolean isPrime = true;
	
		for (int i = 5; i < max; i += 2){
			isPrime = true;
			for (int j = 3; j <= Math.sqrt(i); j += 2){
				if (i % j == 0){
					isPrime = false;
					break;
				}
			}
			if (isPrime){
				primeSum += i;
			}
		}
		
		
		System.out.println("The sum of all primes below " + max + " is " + primeSum);
		System.out.println("Total Time: " + (System.currentTimeMillis() - timeStart)/1000);
		
	}
}
