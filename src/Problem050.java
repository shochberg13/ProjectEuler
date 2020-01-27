public class Problem050 {
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		int max = 1000000;
		int initialNumberWithLongestChain = 0;
		int lengthOfLongestChain = 0;
		int sumOfLongestChain = 0;
		
		for (int i = 2; i < Math.sqrt(max); i++){
			ConsecutivePrime program = new ConsecutivePrime(i, max);
			program.runProgram(max);
			System.out.println("The number " + i + " has a maximum consecutive sum: " + program.getSumOfConsecutivePrimes() + " from the " + program.getNumberOfConsecutivePrimes() + " consecutive primes following it.");
			
			if(program.getNumberOfConsecutivePrimes() > lengthOfLongestChain){
				lengthOfLongestChain = program.getNumberOfConsecutivePrimes();
				sumOfLongestChain = program.getSumOfConsecutivePrimes();
				initialNumberWithLongestChain = i;
			}
		}
		
			
			System.out.println("\nANSWER");
			System.out.println("The starting number " + initialNumberWithLongestChain + " has the longest chain of length " + lengthOfLongestChain + " which produces a sum of " + sumOfLongestChain);
			System.out.println("Time elapsed: " + (System.currentTimeMillis() - timeStart) / 1000.00 + " seconds");
	}

}