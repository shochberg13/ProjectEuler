public class Problem028 {
	/*TASK: Find the sum of diagonals on a spiral square of size 1001	 */
	public static void main(String[] args) {

		// Size of half-Diagonal
		int sizeOfSquare = 1001;
		int sizeOfHalfDiagonal = (sizeOfSquare + 1) /  2 ;
		
		int sum = 1;
		for (int i = 2; i <= sizeOfHalfDiagonal; i++){
			
			sum += (4 * Math.pow(i, 2)) - (10 * i) + 7;
			sum += (4 * Math.pow(i, 2)) - (8 * i) + 5;
			sum += (4 * Math.pow(i, 2)) - (6 * i) + 3;
			sum += (4 * Math.pow(i, 2)) - (4 * i) + 1;
			
			
		}
		System.out.println("In the spiral that is sized " + sizeOfSquare + " by " + sizeOfSquare + ", the sum of all the diagonals of is: " + sum);
	}
}
