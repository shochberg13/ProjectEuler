import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem022 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> nameList = new ArrayList<String>();
		
		File file = new File("C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem022.txt");
		Scanner reader = new Scanner(file);
		while(reader.hasNext()){
			nameList.add(reader.next());
		}
		Collections.sort(nameList);
		System.out.println(nameList.get(0));
		
		System.out.println("Name Score of Seth: " + nameScore("SETH"));
	}
	
	public static int nameScore(String name){
		int nameScore = 0;
		
		for (int i = 0; i < name.length(); i++){
			switch (name.charAt(i)) {
			case 'A':
				nameScore++;
				break;
			case 'B':
				nameScore += 2;
				break;
			case 'C':
				nameScore += 3;
				break;
			case 'D':
				nameScore += 4;
				break;
			case 'E':
				nameScore += 5;
				break;
			case 'F':
				nameScore += 6;
				break;
			case 'G':
				nameScore += 7;
				break;
			case 'H':
				nameScore += 8;
				break;
			case 'I':
				nameScore += 9;
				break;
			case 'J':
				nameScore += 10;
				break;
			case 'K':
				nameScore += 11;
				break;
			case 'L':
				nameScore += 12;
				break;
			case 'M':
				nameScore += 13;
				break;
			case 'N':
				nameScore += 14;
				break;
			case 'O':
				nameScore += 15;
				break;
			case 'P':
				nameScore += 16;
				break;
			case 'Q':
				nameScore += 17;
				break;
			case 'R':
				nameScore += 18;
				break;
			case 'S':
				nameScore += 19;
				break;
			case 'T':
				nameScore += 20;
				break;
			case 'U':
				nameScore += 21;
				break;
			case 'V':
				nameScore += 22;
				break;
			case 'W':
				nameScore += 23;
				break;
			case 'X':
				nameScore += 24;
				break;
			case 'Y':
				nameScore += 25;
				break;
			case 'Z':
				nameScore += 26;
				break;
			default:
				break;
			}
		}
		return nameScore;
	}
}
