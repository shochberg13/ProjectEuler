import java.util.ArrayList;

public class Problem037 {
	public static void main(String[] args) {

		int truncCounter = 0;
		int sum = 0;
		int truncMax = 11;
		ArrayList<Integer> truncNumbers = new ArrayList<Integer>();
		
		for (int i = 11; truncCounter < truncMax; i++){
			if (isPrimeBothWays(i)){
				sum += i;
				truncCounter ++;
				System.out.println("Truncatable Prime Found! It's " + i);
				System.out.println("Total sum so far: " + sum);
				System.out.println("Number Of Truncatable Primes Found So Far: " + truncCounter);
				System.out.println("~~~~~~~~~~~~");
				truncNumbers.add(i);
			}
		}
		
		System.out.println("\n ANSWER \nThe total sum of the " + truncMax + " truncatable prime numbers are " + sum);
		System.out.println("Those numbers are: " + truncNumbers);
		
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

	public static boolean isPrimeBothWays(int number){
		String numHolder = Integer.toString(number);
		boolean allPrime = true;
		for (int i = 0; i < numHolder.length(); i++){
			allPrime = true;
			
			int numLeft = Integer.parseInt(numHolder.substring(i));
			int numRight = Integer.parseInt(numHolder.substring(0, numHolder.length() - i));
			
			if (!isPrime(numLeft) || !isPrime(numRight)){
				allPrime = false;
				break;
			}
		}
		
		return allPrime;
	}
}