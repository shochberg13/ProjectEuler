import java.util.ArrayList;
import java.util.Collections;

// Heavy lifting is done. To do list:
// Still need to check for high card to dispute ties (or not having a hand)
// Should remove all the "Collections.sort" and do it once before its shuffled into everything
// Should avoid shuffling the same parameter everywhere and creating ArrayList<Integer> in every method.

public class Hand {
	private ArrayList<Card> hand;
	private int tieBreakerValue;
	private int secondTieBreaker;
	private int thirdTieBreaker;
	private int fourthTieBreaker;
	private int fifthTieBreaker;
	
	// Constructor
	public Hand() {
		this.hand = new ArrayList<Card>();
		this.tieBreakerValue = 0;
		this.secondTieBreaker = 0;
		this.thirdTieBreaker = 0;
		this.fourthTieBreaker = 0;
		this.fifthTieBreaker = 0;
	}

	public ArrayList<Card> getCards(){
		return this.hand;
	}
	
	// Method to add cards
	public void add(Card card){
		this.hand.add(card);
	}
	
	public boolean checkForOnePair() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if ((handRanks.get(0) == handRanks.get(1))
				|| (handRanks.get(1) == handRanks.get(2))
				|| (handRanks.get(2) == handRanks.get(3))
				|| (handRanks.get(3) == handRanks.get(4))) {

			// Tie Breaker
			if (handRanks.get(0) == handRanks.get(1)) {
				this.tieBreakerValue = handRanks.get(0);
				this.secondTieBreaker = handRanks.get(4);
				this.thirdTieBreaker = handRanks.get(3);
				this.fourthTieBreaker = handRanks.get(2);
				
			} else if (handRanks.get(1) == handRanks.get(2)) {
				this.tieBreakerValue = handRanks.get(1);
				this.secondTieBreaker = handRanks.get(4);
				this.thirdTieBreaker = handRanks.get(3);
				this.fourthTieBreaker = handRanks.get(0);
				
			} else if (handRanks.get(2) == handRanks.get(3)) {
				this.tieBreakerValue = handRanks.get(2);
				this.secondTieBreaker = handRanks.get(4);
				this.thirdTieBreaker = handRanks.get(1);
				this.fourthTieBreaker = handRanks.get(0);
				
			} else if (handRanks.get(3) == handRanks.get(4)) {
				this.tieBreakerValue = handRanks.get(3);
				this.secondTieBreaker = handRanks.get(2);
				this.thirdTieBreaker = handRanks.get(1);
				this.fourthTieBreaker = handRanks.get(0);
			}
				
			return true;
		}
		return false;
	}

	public boolean checkForTwoPair() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if ((handRanks.get(1) == handRanks.get(2) && handRanks.get(3) == handRanks.get(4))
				|| (handRanks.get(0) == handRanks.get(1) && handRanks.get(3) == handRanks.get(4))
				|| (handRanks.get(0) == handRanks.get(1) && handRanks.get(2) == handRanks.get(3))) {
		
			// Tie Breaker
			if (handRanks.get(1) >= handRanks.get(3)){
				this.tieBreakerValue = handRanks.get(1);
				this.secondTieBreaker = handRanks.get(3);
			}else {
				this.tieBreakerValue = handRanks.get(3);
				this.secondTieBreaker = handRanks.get(1);
			}
						
			if (handRanks.get(0) == handRanks.get(1) && handRanks.get(2) == handRanks.get(3)){
				this.thirdTieBreaker = handRanks.get(4);
			}else if(handRanks.get(0) == handRanks.get(1) && handRanks.get(3) == handRanks.get(4)){
				this.thirdTieBreaker = handRanks.get(2);
			}else if(handRanks.get(1) == handRanks.get(2) && handRanks.get(3) == handRanks.get(4)){
				this.thirdTieBreaker = handRanks.get(0);
			}
			
			return true;
		}
		return false;
	}

	public boolean checkForThreeOfAKind() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if ((handRanks.get(2) == handRanks.get(1) && handRanks.get(2) == handRanks.get(0))
			|| (handRanks.get(2) == handRanks.get(1) && handRanks.get(2) == handRanks.get(3))
			|| (handRanks.get(2) == handRanks.get(3) && handRanks.get(2) == handRanks.get(4))) {
			this.tieBreakerValue = handRanks.get(2);
			return true;
		} else {
			return false;
		}
	}

	// Works
	public boolean checkForStraightAceHigh() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		if (handRanks.get(0) + 1 == handRanks.get(1)
			&& handRanks.get(0) + 2 == handRanks.get(2)
			&& handRanks.get(0) + 3 == handRanks.get(3)
			&& handRanks.get(0) + 4 == handRanks.get(4)) {
			this.tieBreakerValue = handRanks.get(4);
			return true;
		}
		return false;
	}

	// Works (code for 3 straight checks is repetitive, but wtvr for now)

	public boolean checkForStraightAceLow() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// If there's an ace, convert it from rank 14 to rank 1
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
			this.tieBreakerValue = handRanks.get(4);
			return true;
		}
		return false;
	}

	// Works

	public boolean checkForStraight() {
		
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		if (checkForStraightAceHigh() || checkForStraightAceLow()) {
			return true;
		} else {
			return false;
		}
	}

	// Works

	public boolean checkForFlush() {
		// Put only suits and ranks from the 5 card hand into 2 different ArrayLists
		ArrayList<Character> handSuits = new ArrayList<Character>();
		
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handSuits.add(card.getSuit());
			handRanks.add(card.getRank());
		}
		
		// Analyze
		if (handSuits.get(0) == handSuits.get(1)
			&& handSuits.get(0) == handSuits.get(2)
			&& handSuits.get(0) == handSuits.get(3)
			&& handSuits.get(0) == handSuits.get(4)) {

			// TieBreaker
			Collections.sort(handRanks);
			this.tieBreakerValue = handRanks.get(4);
			this.secondTieBreaker = handRanks.get(3);
			this.thirdTieBreaker = handRanks.get(2);
			this.fourthTieBreaker = handRanks.get(1);
			this.fifthTieBreaker = handRanks.get(0);
			
			return true;
		}
		return false;
	}


	public boolean checkForFullHouse() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		
		// Check for Full House
		if (handRanks.get(0) == handRanks.get(1) && 
				handRanks.get(3) == handRanks.get(4) && 
				(handRanks.get(1) == handRanks.get(2) || handRanks.get(2) == handRanks.get(3))) {
			// Tie Breaker
			if (handRanks.get(1) == handRanks.get(2)) {
				this.tieBreakerValue = handRanks.get(1);
			} else {
				this.tieBreakerValue = handRanks.get(3);
			}
			return true;
		}
		return false;
	}


	public boolean checkForFourOfAKind() {
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		
		// Check for Four of a Kind
		if (handRanks.get(1) == handRanks.get(3) && 
				(handRanks.get(0) == handRanks.get(1) || handRanks.get(3) == handRanks.get(4))) {
			this.tieBreakerValue = handRanks.get(2);
			return true;
		}
		return false;
	}

	public void highCardTieBreaker(){
		// Put only ranks from the 5 card hand into an ArrayList and analyze
		ArrayList<Integer> handRanks = new ArrayList<Integer>();
		for (Card card : this.hand) {
			handRanks.add(card.getRank());
		}

		// Analyze
		Collections.sort(handRanks);
		this.tieBreakerValue = handRanks.get(4);
		this.secondTieBreaker = handRanks.get(3);
		this.thirdTieBreaker = handRanks.get(2);
		this.fourthTieBreaker = handRanks.get(1);
	}
	// For handling ties or high number
	// Probably will need other functions to output distinct character
	// (e.g. ACE high flush, or pair of FIVESs, or 4 of NINES)


	// Should work, but need to test once everything else is in place


	public int handRanking() {

		if (checkForFlush()) {
			if (checkForStraight()) {
				return 1; // Straight Flush
			} else {
				return 4; // Flush
			}
		}
		if (checkForStraight()) {
			return 5; // Straight
		}

		if (checkForOnePair()) {
			if (checkForThreeOfAKind()) {
				if (checkForFullHouse()) {
					return 3; // Full House
				} else if (checkForFourOfAKind()) {
					return 2; // Four of a Kind
				} else {
					return 6; // Three of a Kind
				}
			} else if (checkForTwoPair()) {
				return 7; // Two pair
			} else {
				return 8; // One Pair
			}
		}
		
		highCardTieBreaker();
		return 9; // High Card (if nothing else)
	}


	
	public int getTieBreakerValue(){
		return this.tieBreakerValue;
	}

	public int getSecondTieBreaker(){
		return this.secondTieBreaker;
	}
	
	public int getThirdTieBreaker(){
		return this.thirdTieBreaker;
	}
	
	public int getFourthTieBreaker(){
		return this.fourthTieBreaker;
	}
	
	public int getFifthTieBreaker(){
		return this.fifthTieBreaker;
	}
}
