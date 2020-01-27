public class Problem015 {
/*TASK: Find the number of lattice paths possible in a 20x20 grid (PASCAL's TRIANGLE) */
	public static void main(String[] args) {
		
		int maxGridSquareSize = 20;
		int max = 2 * maxGridSquareSize + 1;
		long[][] pascal = new long[max][max + 1];
		pascal[0][1] = 1;
		for (int i = 1; i < pascal.length; i ++){
			for (int j = 1; j < pascal[i].length; j++){
				pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
			}
		}
		
		printMatrix(pascal);

		System.out.println("\nANSWER");
		System.out.println("The number of total paths is " + pascal[max - 1][max - (max / 2)]);
		
	}
	
	public static void printMatrix(long[][] matrix){
		for (int i = 0; i < matrix.length; i ++){
			for (int j = 1; j < matrix[i].length; j++){
			System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
