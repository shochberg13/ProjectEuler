
public class Card {
	private int rank;
	private char suit;
	
	public Card(int rank, char suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public Card(){
		this.rank = 0; // Nonsense
		this.suit = 'x'; // Nonsense
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public char getSuit(){
		return this.suit;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public void setSuit(char suit){
		this.suit = suit;
	}
}
