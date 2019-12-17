import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem054 {
/*TASK: Given a large text file of poker hands, determine how many times player 1 wins. */
	public static void main(String[] args) throws FileNotFoundException {

		// Get file into ArrayList<String>
		File file = new File("C:\\Users\\Seth\\Desktop\\Java\\Java Text Files\\EP_Problem054.txt");
		Scanner scan = new Scanner(file);
		ArrayList<String> inputFileList = new ArrayList<>();
		while (scan.hasNextLine()) {
			inputFileList.add((scan.nextLine()));
		}

		// Go through file, create hands, and determine winner
		int player1WinCounter = 0;
		
		for (int handNumber = 0; handNumber < inputFileList.size(); handNumber++) {
			Hand player1Hand = new Hand();
			Hand player2Hand = new Hand();
			
			// Player 1 Hand
			for (int i = 0; i <= 12; i += 3) {
				Card card = new Card();
				card.setRank(fileToRank(inputFileList.get(handNumber).charAt(i)));
				card.setSuit(inputFileList.get(handNumber).charAt(i + 1));
				player1Hand.add(card);
			}

			// Player 2 Hand
			for (int i = 15; i <= 27; i += 3) {
				Card card = new Card();
				card.setRank(fileToRank(inputFileList.get(handNumber).charAt(i)));
				card.setSuit(inputFileList.get(handNumber).charAt(i + 1));
				player2Hand.add(card);
			}
			
			// Determine winner
			if (didPlayer1Win(player1Hand, player2Hand)){
				player1WinCounter ++;
				System.out.println("Player 1 won hand " + (handNumber + 1));
			}else {
				System.out.println("Player 2 won hand " + (handNumber + 1));
			}
		}
		System.out.println("\nANSWER\nPlayer 1 won " + player1WinCounter + " times.");
	}
	 
	public static int fileToRank(char cardFromFile) {

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
	
	public static boolean didPlayer1Win(Hand hand1, Hand hand2) {
		int hand1HandRanking = hand1.handRanking();
		int hand2HandRanking = hand2.handRanking();
		
		if (hand1HandRanking < hand2HandRanking) {
			return true;
		} else if (hand1HandRanking > hand2HandRanking) {
			return false;
		}

		// Tie Breaker
		if (hand1HandRanking == hand2HandRanking) {
			// FIRST TIE BREAKER
			if (hand1.getTieBreakerValue() > hand2.getTieBreakerValue()) {
				return true;
			} else if (hand1.getTieBreakerValue() < hand2.getTieBreakerValue()) {
				return false;
			} else {

				// SECOND TIE BREAKER
				if (hand1.getSecondTieBreaker() > hand2.getSecondTieBreaker()) {
					return true;
				} else if (hand1.getSecondTieBreaker() < hand2.getSecondTieBreaker()) {
					return false;
				} else {

					// THIRD TIE BREAKER
					if (hand1.getThirdTieBreaker() > hand2.getThirdTieBreaker()) {
						return true;
					} else if (hand1.getThirdTieBreaker() < hand2.getThirdTieBreaker()) {
						return false;
					} else {
						
						// FOURTH TIE BREAKER
						if (hand1.getFourthTieBreaker() > hand2.getFourthTieBreaker()) {
							return true;
						} else if (hand1.getFourthTieBreaker() < hand2.getFourthTieBreaker()) {
							return false;
						} else {
						
								// FIFTH TIE BREAKER
							if (hand1.getFifthTieBreaker() > hand2.getFifthTieBreaker()) {
								return true;
							} else if (hand1.getFifthTieBreaker() < hand2.getFifthTieBreaker()) {
								return false;
							} else {
								System.out.println("There is a tie!(Shouldn't happen in this problem)");
							}
						}
					}
				}
			}
		}
		// Shouldn't ever reach this line...
		System.out.println("A problem fell through the cracks...");
		return false;
	}
}
