import java.util.HashSet;
import java.util.Set;

public class Problem060 {
	private Set<Integer> primeSet;
	private int primeCeiling;
	
	
	public Problem060(){
		this.primeSet = new HashSet<Integer>();
		this.primeCeiling = 100000000;
		
		primeSet.add(2);
		primeSet.add(3);
		
		
		for (int i = 5; i < primeCeiling; i += 2){
			boolean isPrime = true;
			for (int j = 3; j <= Math.sqrt(i); j += 2){
				if (i % j == 0){
					isPrime = false;
					break;
				}
			}
			
			
			if (isPrime){
				primeSet.add(i);
			}
		}
	}
	
	public void run(){
		System.out.println(concatenateIsPrime(3, 7));
		
		int max = 10000;
		int[] fivePrimes = new int[5];
		int minSum = Integer.MAX_VALUE;
		
		for (int a = 3; a < max; a = nextPrime(a)){
			int sum = 0;
			for (int b = nextPrime(a); b < max; b = nextPrime(b)){
				
				if (!concatenateIsPrime(a, b)) continue;
				
				for (int c = nextPrime(b); c < max; c = nextPrime(c)){
					
					if (!concatenateIsPrime(a, c) || !concatenateIsPrime(b, c)) continue;
					
					for (int d = nextPrime(c); d < max; d = nextPrime(d)){
						if (!concatenateIsPrime(a, d) || !concatenateIsPrime(b, d) || !concatenateIsPrime(c, d)) continue;
						
						for (int e = nextPrime(d); e < max; e = nextPrime(e)){
							if (!concatenateIsPrime(a, e) || !concatenateIsPrime(b, e) || !concatenateIsPrime(c, e) || !concatenateIsPrime(d, e)) continue;
							
							sum = a + b + c + d + e;
							if (sum < minSum){
								minSum = sum;
							}
							
							fivePrimes[0] = a;
							fivePrimes[1] = b;
							fivePrimes[2] = c;
							fivePrimes[3] = d;
							fivePrimes[4] = e;
							System.out.println("Sum: " + sum + "\tFive Primes: " + fivePrimes[0] + " " + fivePrimes[1] + " " + fivePrimes[2] + " " + fivePrimes[3] + " " + fivePrimes[4]);	
						
						}
					}
				}
			}
		}
		System.out.println("\n\n\nANSWER");
		System.out.println("Lowest Sum: " + minSum + "\tFive Primes: " + fivePrimes[0] + " " + fivePrimes[1] + " " + fivePrimes[2] + " " + fivePrimes[3] + " " + fivePrimes[4]);
		
	}
	
	public boolean concatenateIsPrime(int num1, int num2){
		String numStr1 = Integer.toString(num1) + Integer.toString(num2);
		if (!this.primeSet.contains(Integer.parseInt(numStr1))){
			return false;
		}
		
		String numStr2 = Integer.toString(num2) + Integer.toString(num1);
		if (!this.primeSet.contains(Integer.parseInt(numStr2))){
			return false;
		}
		
		return true;
	}
	
	public int nextPrime(int current){
		int nextPrime = current;
		while(nextPrime < primeCeiling){
			nextPrime++;
			if (primeSet.contains(nextPrime)){
				return nextPrime;
			}
;		}
		System.out.println("ERROR: No more primes left");
		return -1;
	}
	
	public static void main(String[] args) {
		Problem060 program = new Problem060();
		program.run();
	}
	
}
