public class Problem046 {
/* TASK: Find the smallest odd composite number that can't be written as a sum of a prime or twice a squire */
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
	
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		int squareNumber = 0;
		int primeNumber = 0;

		wholeLoop:
		for (int compositeNum = 9; true; compositeNum += 2) {
			// First filter out the primes
			while (isPrime(compositeNum)) {
				compositeNum += 2;
			}
//			System.out.println("CompositeNumber: " + compositeNum);
			boolean proof = false;
			outerloop: 
				for (squareNumber = 1; compositeNum >= 2 * Math.pow(squareNumber, 2); squareNumber++) {
					for (primeNumber = 2; compositeNum >= primeNumber + 2 * Math.pow(squareNumber, 2); primeNumber++) {
						if (isPrime(primeNumber)) {
							if (compositeNum == primeNumber + 2 * Math.pow(squareNumber, 2)) {
//								System.out.println(compositeNum + " = "	+ primeNumber + " + 2 x " + " (" + squareNumber + ")^2");
								proof = true;
								break outerloop;
							}
						}
					}
				}
			
			if (!proof){
				System.out.println("ANSWER");
				System.out.println("The smallest odd composite number that can't be written as a sum of a prime and twice a square is " + compositeNum);
				break wholeLoop;
			}
		}
		
		System.out.println("Total Time: " + ((System.currentTimeMillis() - timeStart )/ 1000) + " seconds");
	}
}
