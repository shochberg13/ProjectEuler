import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem018 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem018.txt");
		Scanner reader = new Scanner(file);


		ArrayList<Integer> numberList = new ArrayList<Integer>(); 
		while(reader.hasNextLine()){
			numberList.add(Integer.parseInt(reader.next()));
		}
		System.out.println(numberList);
		// Don't know how to make the triangle shape!
	}
}
