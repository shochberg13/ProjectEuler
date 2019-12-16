public class Problem014 {
	/*TASK: Find the number that has the longest chain in the Collatz Sequence (under 1M)	 */
	public static void main(String[] args) {
		double timeStart = System.currentTimeMillis();
		
		int longestChain = 0;
		long longestInitialNumber = 1;
		
		int chainLength = 0;
		long number;
		
		for (long i = 2; i < 1000000; i++){
			number = i;
			chainLength = 0;
			while (number != 1){
				if (number % 2 == 0){
					number = number / 2;
					chainLength ++;
				}else{
					number = 3 * number + 1;
					chainLength++;
				}
			}
			if (chainLength > longestChain){
				longestChain = chainLength;
				longestInitialNumber = i;
			}
		}
		
		System.out.println("The longest chain is " + longestChain + " long and the initial number is " + longestInitialNumber);
		System.out.println("Time: " + (System.currentTimeMillis() - timeStart) / 1000);
	}
}
