import java.util.ArrayList;

public class Card_oa {

	public static void main(String[] args) {
		ArrayList<Integer> deck = new ArrayList<Integer>();
		ArrayList<String> suits= new ArrayList<String>();
		suits.add("Spade");
		suits.add("Heart");
		suits.add("Diamond");
		suits.add("Club");
		// Initialize cards
		for(int i = 0; i < 52; i++) {
			deck.add(i); // auto-boxing
		}
		// Shuffle the cards.
		for(int i = 0; i < deck.size(); i++) {
			int index = (int)(Math.random() * deck.size());
			int temp = deck.get(i);
			deck.set(i, deck.get(index));
			deck.set(index, temp);
		}
		// Display the card(s) that is heart from the first five cards.
		for(int i = 0; i < 5; i++) {
			String suit = suits.get(deck.get(i) / 13);
			if (suit.equals("Heart")) {
				System.out.println("Card number "+ deck.get(i) + " is " + suit);
			}
		}
	}
	
}