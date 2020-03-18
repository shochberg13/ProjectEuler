import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem018 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem018.txt");
		Scanner reader = new Scanner(file);
		int triSize = 15;
		
		int[][] input = new int[triSize][triSize]; 
		for(int row = 0; row < triSize; row++){
			for(int col = 0; col <= row; col ++){
				input[row][col] = Integer.parseInt(reader.next());
			}
		}
		
		int maxPath = DFS(input, 0, 0, 0);
		System.out.println("The maximum path is: " + maxPath);
		
	}
	
	public static int DFS(int[][]input, int row, int col, int sum){
		
		if (row == input.length - 1){
			return sum + input[row][col];
		}
		return Math.max(DFS(input, row + 1, col, sum + input[row][col]), DFS(input, row + 1, col + 1, sum + input[row][col]));
		
	}
	
}
