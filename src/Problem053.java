public class Problem053 {
	public static void main(String[] args) {
		int counter = 0;
		
		for (int n = 1; n <= 100; n++){
			for (int r = 1; r <= n; r++){
				if (combination(n, r) > 1000000){
					
					// Determined from pattern recognition of small sample
					counter += (n - (r * 2)) + 1;
					System.out.println("Combination of (" + n + ", " + r + ") is greater than 1M\tCounter: " + counter);
					break;
				}
			}
		}
		System.out.println("\n\nANSWER");
		System.out.println("There are " + counter + " combinations in this range greater than 1M");
	}
	
	public static long combination(int n, int r){
		assert(n >= r);
		
		long numerator = 1;
		for (int i = n; i > n - r; i--){
			numerator *= i;
		}
		
		long denominator = factorial(r);
		
		return numerator/denominator;
	}
	
	public static long factorial(int n){
		assert(n >= 0);
		
		long factorial = 1;
		for (int i = 2; i <= n; i++){
			factorial *= i;
		}
		return factorial;
	}
}
