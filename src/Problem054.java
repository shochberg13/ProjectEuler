import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Still need to check for high card to dispute ties (or not having a hand)
// Should remove all the "Collections.sort" and do it once before its shuffled into everything
// Still need to convert T, J, Q, K, A into numbers

public class Problem054 {
	private int rank;
	private char suit;

	// works
	public static ArrayList<String> fileToList() throws FileNotFoundException {

		File file = new File(
				"C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem054.txt");
		Scanner scan = new Scanner(file);
		scan.useDelimiter(" ");
		ArrayList<String> input = new ArrayList<>();
		while (scan.hasNextLine()) {
			input.add((scan.nextLine()));
		}
		System.out.println(input);
		System.out.println("0.0: " + input.get(0).charAt(0));
		System.out.println("1.4: " + input.get(1).charAt(4));
		System.out.println("2.3: " + input.get(2).charAt(3));
		return input;
	}

	// Works
	public static boolean checkForOnePair(ArrayList<Integer> rank) {
		Collections.sort(rank);
		if ((rank.get(0) == rank.get(1)) || (rank.get(1) == rank.get(2))
				|| (rank.get(2) == rank.get(3)) || (rank.get(3) == rank.get(4))) {
			return true;
		}
		return false;
	}

	// Works
	public static boolean checkForTwoPair(ArrayList<Integer> rank) {
		Collections.sort(rank);
		if ((rank.get(1) == rank.get(2) && rank.get(3) == rank.get(4))
				|| (rank.get(0) == rank.get(1) && rank.get(3) == rank.get(4))
				|| (rank.get(0) == rank.get(1) && rank.get(2) == rank.get(3))

		) {
			return true;
		}
		return false;
		// Can compare index 1 and index 3 for higher of 2 pairs
	}

	// Works
	public static boolean checkForThreeOfAKind(ArrayList<Integer> rank) {
		Collections.sort(rank);
		if ((rank.get(2) == rank.get(1) && rank.get(2) == rank.get(0)) || 
			(rank.get(2) == rank.get(1) && rank.get(2) == rank.get(3)) ||
			(rank.get(2) == rank.get(3) && rank.get(2) == rank.get(4)) ){
			return true;
		}else{
			return false;
		}
	}

	// works
	public static boolean checkForStraightAceHigh(ArrayList<Integer> rank) {
		Collections.sort(rank);
		if (rank.get(0) + 1 == rank.get(1) && rank.get(0) + 2 == rank.get(2)
				&& rank.get(0) + 3 == rank.get(3)
				&& rank.get(0) + 4 == rank.get(4)) {
			return true;
		}
		return false;
	}
	
	// Works (code for 3 straight checks is repetitive, but wtvr)
	public static boolean checkForStraightAceLow(ArrayList<Integer> rank) {
		// If there's an ace, convert it to rank 1 (from 14)
		Collections.sort(rank);
		ArrayList<Integer> rankTemp = rank;
		for (int card : rank){
			if (card == 14){
				rankTemp.remove(rankTemp.size() - 1);
				rankTemp.add(1);
				break;
			}
		}
		
		// Check for straight
		Collections.sort(rankTemp);
		if (rankTemp.get(0) + 1 == rankTemp.get(1) && rankTemp.get(0) + 2 == rankTemp.get(2)
				&& rankTemp.get(0) + 3 == rankTemp.get(3)
				&& rankTemp.get(0) + 4 == rankTemp.get(4)) {
			return true;
		}
		return false;
	}
	
	// Works
	public static boolean checkForStraight(ArrayList<Integer> rank){
		if (checkForStraightAceHigh(rank) || checkForStraightAceLow(rank)){
			return true;
		}else{
			return false;
		}
	}
	
	// Works
	public static boolean checkForFlush(ArrayList<Character> suit) {
		if (suit.get(0) == suit.get(1) && suit.get(0) == suit.get(2)
				&& suit.get(0) == suit.get(3) && suit.get(0) == suit.get(4)) {
			return true;
		}
		return false;
	}

	// Works
	public static boolean checkForFullHouse(ArrayList<Integer> rank) {
		// TIE-BREAKER: 
		Collections.sort(rank);
		if (rank.get(0) == rank.get(1) && 
			rank.get(3) == rank.get(4) &&
			(rank.get(1) == rank.get(2) || rank.get(2) == rank.get(3)) ){
			return true;
		}
		return false;
	}

	// Works
	public static boolean checkForFourOfAKind(ArrayList<Integer> rank) {
		Collections.sort(rank);
		
		// 2nd and 4th card are the same AND either 1-2 or 4-5 are the same
		if (rank.get(1) == rank.get(3)
				&& (rank.get(0) == rank.get(1) || rank.get(3) == rank.get(4))) {
			return true;
		}
		return false;
	}

	// For handling ties or high number NEED TO DO 
	// Probably will need other functions to output distinct character 
	// (e.g. ACE high flush, or pair of FIVESs, or 4 of NINES)
	public static int highCard(ArrayList<Integer> rank){
		return Collections.max(rank);
	}
	
	// Should work, but need to test once everything else is in place
	public static int handRanking(ArrayList<Integer> rank, ArrayList<Character> suit) {
		if (checkForFlush(suit)) {
			if (checkForStraight(rank)) {
				return 1; // Straight Flush
			} else {
				return 4; // Flush
			}
		}
		if (checkForStraight(rank)) {
			return 5; // Straight
		}

		if (checkForOnePair(rank)) {
			if (checkForThreeOfAKind(rank)) {
				if (checkForFullHouse(rank)) {
					return 3; // Full House
				} else if (checkForFourOfAKind(rank)) {
					return 2; // Four of a Kind
				} else {
					return 6; // Three of a Kind
				}
			} else if (checkForTwoPair(rank)) {
				return 7; // Two pair
			} else {
				return 8; // One Pair
			}
		}
		return 9; // High Card (if nothing else)
	}

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> file = fileToList();
		
		ArrayList<Integer> player1Hand = new ArrayList<Integer>();
		
		player1Hand.add(5);
		player1Hand.add(14);
		player1Hand.add(10);
		player1Hand.add(4);
		player1Hand.add(8);
		
		
		System.out.println(player1Hand);

		System.out.println(checkForFourOfAKind(player1Hand));
	}

}
