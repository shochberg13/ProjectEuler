import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Scanner;

// Heavy lifting is done. To do list:
// Still need to check for high card to dispute ties (or not having a hand)
// Should remove all the "Collections.sort" and do it once before its shuffled into everything
// Should avoid shuffling the same parameter everywhere and creating ArrayList<Integer> in every method.
// Why did I have to make checkForOnePair() method static?

public class Hand {
	private ArrayList<Card> hand;
	private ArrayList<String> inputFile;

	// Constructor
	public Hand() {
		ArrayList<Card> hand = new ArrayList<Card>();
	}

	public String toString() {
		return "";
	}

	public void fileToList() throws FileNotFoundException {

		File file = new File(
				"C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem054.txt");
		Scanner scan = new Scanner(file);

		ArrayList<String> inputFile = new ArrayList<>();
		while (scan.hasNextLine()) {
			inputFile.add((scan.nextLine()));
		}
		this.inputFile = inputFile;
	}

	// Complete, not tested
	public int fileToRank(char cardFromFile) {

		switch (cardFromFile) {
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'T':
			return 10; // Ten
		case 'J':
			return 11; // Jack
		case 'Q':
			return 12; // Queen
		case 'K':
			return 13; // King
		case 'A':
			return 14; // Ace

		default:
			return -1; // Error
		}
	}

	// Initialize
	ArrayList<Card> hand1 = new ArrayList<Card>();
	ArrayList<Card> hand2 = new ArrayList<Card>();

	// Complete not tested
	public void dealCardsfromFileToHand(int handNumber) {

		for (int i = 0; i <= 12; i += 3) {

			Card card = new Card();

			card.setRank(fileToRank(this.inputFile.get(handNumber).charAt(i)));
			card.setSuit(this.inputFile.get(handNumber).charAt(i + 1)); // Don't
																		// need
																		// fileToSuit()
																		// method!
																		// Format
																		// in
																		// file
																		// is
																		// fine

			hand1.add(card);

		}

		for (int i = 15; i <= 27; i += 3) {

			Card card = new Card();

			card.setRank(fileToRank(this.inputFile.get(handNumber).charAt(i)));
			card.setSuit(this.inputFile.get(handNumber).charAt(i + 1)); // Don't
																		// need
																		// a
																		// fileToSuit()
																		// method!
																		// Format
																		// in
																		// file
																		// is
																		// fine

			hand2.add(card);
		}
	}

	// Works
	public static boolean checkForOnePair(ArrayList<Card> hand) {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if ((handRanks.get(0) == handRanks.get(1))
				|| (handRanks.get(1) == handRanks.get(2))
				|| (handRanks.get(2) == handRanks.get(3))
				|| (handRanks.get(3) == handRanks.get(4))) {

			return true;
		}
		return false;
	}

	// Works
	public static boolean checkForTwoPair(ArrayList<Card> hand) {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if ((handRanks.get(1) == handRanks.get(2) && handRanks.get(3) == handRanks
				.get(4))
				|| (handRanks.get(0) == handRanks.get(1) && handRanks.get(3) == handRanks
						.get(4))
				|| (handRanks.get(0) == handRanks.get(1) && handRanks.get(2) == handRanks
						.get(3))) {
			return true;
		}
		return false;
		// FUTURE: Can compare index 1 and index 3 for higher of 2 pairs
	}

	// Works
	public static boolean checkForThreeOfAKind(ArrayList<Card> hand) {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if ((handRanks.get(2) == handRanks.get(1) && handRanks.get(2) == handRanks
				.get(0))
				|| (handRanks.get(2) == handRanks.get(1) && handRanks.get(2) == handRanks
						.get(3))
				|| (handRanks.get(2) == handRanks.get(3) && handRanks.get(2) == handRanks
						.get(4))) {
			return true;
		} else {
			return false;
		}
	}

	// Works
	public static boolean checkForStraightAceHigh(ArrayList<Card> hand) {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if (handRanks.get(0) + 1 == handRanks.get(1)
				&& handRanks.get(0) + 2 == handRanks.get(2)
				&& handRanks.get(0) + 3 == handRanks.get(3)
				&& handRanks.get(0) + 4 == handRanks.get(4)) {
			return true;
		}
		return false;
	}

	// Works (code for 3 straight checks is repetitive, but wtvr for now)
	public static boolean checkForStraightAceLow(ArrayList<Card> hand) {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// If there's an ace, convert it to rank 1 (from 14)
		Collections.sort(handRanks);
		ArrayList<Integer> rankTemp = handRanks;
		for (int card : handRanks) {
			if (card == 14) {
				rankTemp.remove(rankTemp.size() - 1);
				rankTemp.add(1);
				break;
			}
		}

		// Check for straight
		Collections.sort(rankTemp);
		if (rankTemp.get(0) + 1 == rankTemp.get(1)
				&& rankTemp.get(0) + 2 == rankTemp.get(2)
				&& rankTemp.get(0) + 3 == rankTemp.get(3)
				&& rankTemp.get(0) + 4 == rankTemp.get(4)) {
			return true;
		}
		return false;
	}

	// Works
	public static boolean checkForStraight(ArrayList<Card> hand) {
		
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		if (checkForStraightAceHigh(hand) || checkForStraightAceLow(hand)) {
			return true;
		} else {
			return false;
		}
	}

	// Works
	public static boolean checkForFlush(ArrayList<Card> hand) {
		// TIE BREAKER: Get MAX (may need to repeat)
		
		// Put only SUITS from the 5 card hand into an ArrayList and analyze
		ArrayList<Character> handSuits = new ArrayList<Character>();
		for (Card card : hand) {
			handSuits.add(card.getSuit());
		}

		// Analyze
		if (handSuits.get(0) == handSuits.get(1)
				&& handSuits.get(0) == handSuits.get(2)
				&& handSuits.get(0) == handSuits.get(3)
				&& handSuits.get(0) == handSuits.get(4)) {
			return true;
		}
		return false;
	}

	public static boolean checkForFullHouse(ArrayList<Card> hand) {
		// TIE-BREAKER: ONLY ONE NEEDED
//		if (handRanks.get(1) == handRanks.get(2){
//			// TIEBREAKER is handRanks.get(1)
//		}else{
//			// TIEBREAKER is handRanks.get(3);
//		}
		
		
		
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if (handRanks.get(0) == handRanks.get(1)
				&& handRanks.get(3) == handRanks.get(4)
				&& (handRanks.get(1) == handRanks.get(2) || handRanks.get(2) == handRanks
						.get(3))) {
			return true;
		}
		return false;
	}

	public static boolean checkForFourOfAKind(ArrayList<Card> hand) {
		// TIE-BREAKER: rank.get(2) (ONLY 1 NEEDED)
		
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);

		// 2nd and 4th card are the same AND either 1-2 or 4-5 are the same
		if (handRanks.get(1) == handRanks.get(3)
				&& (handRanks.get(0) == handRanks.get(1) || handRanks.get(3) == handRanks
						.get(4))) {
			return true;
		}
		return false;
	}

	// NEED TO DO
	// For handling ties or high number
	// Probably will need other functions to output distinct character
	// (e.g. ACE high flush, or pair of FIVESs, or 4 of NINES)
	public static int highCard(ArrayList<Integer> rank) {
		return Collections.max(rank);
	}

	// Should work, but need to test once everything else is in place
	public static int handRanking(ArrayList<Card> hand) {

		if (checkForFlush(hand)) {
			if (checkForStraight(hand)) {
				return 1; // Straight Flush
			} else {
				return 4; // Flush
			}
		}
		if (checkForStraight(hand)) {
			return 5; // Straight
		}

		if (checkForOnePair(hand)) {
			if (checkForThreeOfAKind(hand)) {
				if (checkForFullHouse(hand)) {
					return 3; // Full House
				} else if (checkForFourOfAKind(hand)) {
					return 2; // Four of a Kind
				} else {
					return 6; // Three of a Kind
				}
			} else if (checkForTwoPair(hand)) {
				return 7; // Two pair
			} else {
				return 8; // One Pair
			}
		}
		return 9; // High Card (if nothing else)
	}

}
