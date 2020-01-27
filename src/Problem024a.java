public class Problem024a {
	public static void main(String[] args) {

		int digits = 3;

		int maxPermutations = 1;
		for (int i = 1; i <= digits; i++) {
			maxPermutations *= i;
		}



		for (int permutation = 1; permutation <= maxPermutations; permutation++) {
			int h = 0;
			int i = 1;
			int j = 2;
			
			if(permutation % 2 == 0){
				
			}
			
			
			System.out.println("Permutation: " + permutation + "\t" + Integer.toString(h) + Integer.toString(i)+ Integer.toString(j));
		}
	

	}
}
