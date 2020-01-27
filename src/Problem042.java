import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem042 {
	public static void main(String[] args) throws FileNotFoundException {
	
		File file = new File("\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem042.txt");
		Scanner scanner = new Scanner(file);
		
		String words = "";
		while(scanner.hasNextLine()){
			words = scanner.nextLine();
		}
		words = words.replaceAll("\"", "");
		String[] wordList = words.split(",");
		
		int triangleWordCounter = 0;
		for (int i = 0; i < wordList.length; i++){
			if(isTriangleWord(wordList[i])){
				System.out.println("Triangle Word: " + wordList[i] + "\t Word Value: " + getWordValueOf(wordList[i]) + "\t Is Triangle Word: " + isTriangleWord(wordList[i]));
			
				
				triangleWordCounter ++;
				
			}
		}

		System.out.println("In the list of ~2000 words, " + triangleWordCounter + " of them are Triangle Words.");
	}
	
	public static boolean isTriangleWord(String word){
		if(isTriangleNumber(getWordValueOf(word))){
			return true;
		}
		return false;
	}
	
	public static int getWordValueOf(String word){
		word = word.toUpperCase(); 
		int wordValue = 0;
		for (int i = 0; i < word.length(); i++){
			switch (word.charAt(i)) {
			case 'A':
				wordValue += 1;
				break;
			case 'B':
				wordValue += 2;
				break;
			case 'C':
				wordValue += 3;
				break;
			case 'D':
				wordValue += 4;
				break;
			case 'E':
				wordValue += 5;
				break;
			case 'F':
				wordValue += 6;
				break;
			case 'G':
				wordValue += 7;
				break;
			case 'H':
				wordValue += 8;
				break;
			case 'I':
				wordValue += 9;
				break;
			case 'J':
				wordValue += 10;
				break;
			case 'K':
				wordValue += 11;
				break;
			case 'L':
				wordValue += 12;
				break;
			case 'M':
				wordValue += 13;
				break;
			case 'N':
				wordValue += 14;
				break;
			case 'O':
				wordValue += 15;
				break;
			case 'P':
				wordValue += 16;
				break;
			case 'Q':
				wordValue += 17;
				break;
			case 'R':
				wordValue += 18;
				break;
			case 'S':
				wordValue += 19;
				break;
			case 'T':
				wordValue += 20;
				break;
			case 'U':
				wordValue += 21;
				break;
			case 'V':
				wordValue += 22;
				break;
			case 'W':
				wordValue += 23;
				break;
			case 'X':
				wordValue += 24;
				break;
			case 'Y':
				wordValue += 25;
				break;
			case 'Z':
				wordValue += 26;
				break;
			default:

			}
		}
		return wordValue;
	}

	public static boolean isTriangleNumber(int number){
		int adder = 1;
		for (int i = 1; i <= number; i += adder){
			adder += 1;
			if (i == number){
				return true;
			}
		}
		return false;
	}
}
