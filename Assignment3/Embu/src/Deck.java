import java.util.ArrayList;
import java.util.Collections;

/**
 * This class stimulates a real deck of card and is used in the simple card game
 * in Main.java
 * 
 * @author Krystal
 * @see Main.java
 * 
 */

public class Deck {

	private ArrayList<String> deckOfcards;

	/**
	 * This method initialize the deck and then shuffle it.
	 * 
	 */
	public Deck() {
		deckOfcards = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				deckOfcards.add(String.valueOf(i) + String.valueOf(j));
			}
		}

		Collections.shuffle(deckOfcards);
	}

	/**
	 * This method draw a card from the top of the deck.
	 * 
	 * @return the serial number of the card drawn
	 * 
	 */
	public String getCard() {
		String tar = deckOfcards.get(0);
		deckOfcards.remove(0);
		return tar;
	}

	/**
	 * This method shuffles the deck.
	 * 
	 */
	public void shuffle() {
		Collections.shuffle(deckOfcards);
	}

}
