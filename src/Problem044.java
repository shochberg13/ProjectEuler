public class Problem044 {
	public static void main(String[] args) {

		double timeStart = System.currentTimeMillis();
	
		int adderI = -2;
		int adderJ = -2;
		
		System.out.println("I wasn't sure how to optimize for smallest difference, so I just tried");
		System.out.println("finding any two numbers that worked. The first one I found worked!");
		System.out.println("They seem super rare!\n\n");
		
		for (int i = 1; true; i += (3 + adderI)){
			adderI += 3;
			adderJ = -2;
			for (int j = 1; j <= i; j += (3 + adderJ)){
				adderJ += 3;
				if (isPentagonal(i - j) && isPentagonal(i + j)){
					System.out.println("The numbers " + i + " and " + j + " are both pentagonal and have a pentagonal difference of " + (i - j) + " and have a pentagonal sum of " + (i + j));
					System.out.println("Time Elapsed: " + (double)((System.currentTimeMillis() - timeStart )/ 1000.000) + " seconds");
					System.out.println("~~~~~~~~~~~");
					
				}
			}
		}
		
	}
	
	public static boolean isPentagonal(int number){
		int pentagonalNumber = 1;
		for (int n = 1; pentagonalNumber <= number; n ++){
			pentagonalNumber = (n * (3 * n - 1)) / 2; 
			if (number == pentagonalNumber){
				return true;
			}
		}
		return false;
	}
}
