public class Problem035 {
	public static void main(String[] args) {
		int circlePrimeCounter = 1; // Include 2
		int max = 1000000;
		for (int i = 1; i < max; i += 2){
			if (isCircularPrime(i)){
				circlePrimeCounter ++;
			}
		}
		
		System.out.println("\nANSWER");
		System.out.println("There are " + circlePrimeCounter + " circular primes under " + max);
	}
	
	public static boolean isCircularPrime(int number){
		if (!isPrime(number)){
			return false;
		}
		
		String numberString = Integer.toString(number);
		for (int i = 1; i < numberString.length(); i++){
			char firstChar = numberString.charAt(0);
			numberString = numberString.substring(1) + firstChar;
			int circledNumber = Integer.parseInt(numberString);
			
			if (!isPrime(circledNumber)){
				return false;
			}
		}
		System.out.println("Circular Prime found: " + number);
		return true;
	}
	
	public static boolean isPrime(int number) {
		boolean isPrime = true;
		
		if (number < 2){
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
