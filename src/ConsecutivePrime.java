
public class ConsecutivePrime {
	private int startingNumber;
	private int max;
	private int maxNumberOfConsecutivePrimes;
	private int maxConsecutivePrimeSum;
	
	
	public ConsecutivePrime(int startingNumber, int max){
		this.startingNumber = startingNumber;
		this.max = max;
		
		this.maxConsecutivePrimeSum = startingNumber;
		this.maxNumberOfConsecutivePrimes = 0;
	}
	
	public int getNumberOfConsecutivePrimes(){
		return this.maxNumberOfConsecutivePrimes;
	}
	
	public int getSumOfConsecutivePrimes(){
		return this.maxConsecutivePrimeSum;
	}
	
	public  boolean isPrime(int number) {
		boolean isPrime = true;
		if (number <= 1){
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
	
	public int nextPrime(int number) {
		int i = 2;
		while (true) {
			if (number % 2 == 0) {
				number--;
			}
			
			if (isPrime(number + i)) {
				return number + i;
			}
			i += 2;
		}
	}
	
	public void runProgram(int max) {
		if(!isPrime(this.startingNumber)){
			return;
		}
		
		int consecutivePrimeSum = this.startingNumber;
		int nextPrimeNumber = this.startingNumber;
		int howManyConsecutivePrimes = 1;
	
		while(true) {
			nextPrimeNumber = nextPrime(nextPrimeNumber);
			
			if (consecutivePrimeSum + nextPrimeNumber > this.max){
				break;
			}
			
			consecutivePrimeSum += nextPrimeNumber;
			howManyConsecutivePrimes ++;
			
			if (isPrime(consecutivePrimeSum)){
				this.maxConsecutivePrimeSum = consecutivePrimeSum;
				this.maxNumberOfConsecutivePrimes = howManyConsecutivePrimes;
			}
		}
	}
	
}
