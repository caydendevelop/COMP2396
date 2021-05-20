package comp2396_a3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * GameLogic class handle the game logic of the decks, cards and player money status
 * also handle whether player win the bet and add money (1 to 1) /lose money
 */
public class GameLogic {
	
	private int money = 0, currentindex = 0;
	private ArrayList<String> deck, player, dealer;
	
	/**
	 * Constructor initialize player and dealer deck
	 * Also card in string format of suits (1-4) + card face value (1-13) (11 = J, 12 = Q, 13 = K)
	 */
	public GameLogic () {
		deck = new ArrayList<String>();
		player = new ArrayList<String>();
		dealer = new ArrayList<String>();
		money = 100;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 14; j++) {
				deck.add(String.valueOf(i) + String.valueOf(j));
			}
		}
	}
	
	/**
	 * reShuffle function swap the cards 52 times by randomize an index in (0-51) every time
	 * and swap with the i index loop to
	 */
	public void reShuffle() {
		currentindex = 0;
		Random ran = new Random();
		for (int i = 0; i < 52; i++) {
			int swap = ran.nextInt(52);
			if (swap != i)
				Collections.swap(deck, i, swap);
		}
//		for (int i = 0; i < 52; i++) {
//			System.out.print("Card " + i + ": " + deck.get(i) + "\n");
//		}
	}
	
	/**
	 * getMoney() gets the player current money amount
	 * @return the current money amount of player in integer
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * addMoney() do either addition or minus (by + -20 e.g.) from bet or award winning bet
	 * @param add - money to add (negative for minus)
	 * @return the new money amount after addition
	 */
	public int addMoney(int add) {
		this.money = this.money + add;
		return money;
	}
	
	/**
	 * dealerDeck() function draws 3 cards from deck to dealer deck
	 * @return dealerDeck in ArrayList string format
	 */
	public ArrayList<String> dealerDeck() {
		System.out.print("CurrentIndex Start Game Check: " + currentindex + "\n");
		dealer.clear();
		for (int i = 0; i < 3; i++) {
			dealer.add(deck.get(currentindex));
			currentindex++;
		}
		return dealer;	
	}
	
	/**
	 * playerDeck() function draws 3 cards from deck to player deck
	 * @return playerDeck in ArrayList string format
	 */
	public ArrayList<String> playerDeck() {
		player.clear();
		for (int i = 0; i < 3; i++) {
			player.add(deck.get(currentindex));
			currentindex++;
		}
		return player;
	}
	
	/**
	   * replaceCard() function replaces the card as specified by position on the player side
	   * 1. fit in replace card 1 or 2 or 3 by place = 1 or 2 or 3
	   * 2. replace and take one card from deck
	   * @param place - place (1/2/3) to replace and draw
	   * @return updated player deck
	   */
	public ArrayList<String> replaceCard(int place) {
		if (place == 0) {
			player.set(0, deck.get(currentindex));
			currentindex++;
		}
		if (place == 1) {
			player.set(1, deck.get(currentindex));
			currentindex++;
		}
		if (place == 2) {
			player.set(2, deck.get(currentindex));
			currentindex++;
		}
		return player;
	}
	
	/**
	   * getResult() function get the game result by calculating 
	   * 1. Number of special cards hold by dealer and player
	   * 2. Sum + remainder by mod 10 of remaining cards that are non-special (A-10)
	   * 3. Using Rule 1 and 2 of the game and get return result, 0 means dealer wins, 1 means player wins
	   * @param bet - amount of bet assigned by player of this round
	   * @return result of the game (0/1)
	   */
	public int getResult(int bet) {
		int result = 0, special1 = 0, special2 = 0, sum = 0, sum2 = 0;
		
		//Part I Check Special Card + Calculate Mod Sum
		for (int i = 0; i < 3; i++) {
			String number;
			number = dealer.get(i).substring(1, dealer.get(i).length());
			//System.out.print("Dealer " + i + ": " + number + "\n");
			if (number.equals("11") || number.equals("12") || number.equals("13")) {
				special1++;
			}
			else {
				sum = sum + Integer.parseInt(number);
			}
			
			number = player.get(i).substring(1, player.get(i).length());
			//System.out.print("Player " + i + ": " + number + "\n");
			if (number.equals("11") || number.equals("12") || number.equals("13")) {
				special2++;
			}
			else {
				sum2 = sum2 + Integer.parseInt(number);
			}
		}
		
		sum = sum % 10;
		sum2 = sum2 % 10;
//		System.out.print("Dealer: " + dealer.get(0) + " " + dealer.get(1) + " " + dealer.get(2) + "\n");
		System.out.print("Special Check: " + special1 + " " + special2 + "\n");
		System.out.print("Sum Check: " + sum + " " + sum2 + "\n");
		System.out.print("CurrentIndex End Game Check: " + currentindex + "\n");
		
		if (special1 > special2) {
			return 0;
		}
		else if (special1 < special2) {
			addMoney(bet * 2);
			return 1;
		}
		else if (special1 == special2) {
			if (sum > sum2) {
				return 0;
			}
			else if (sum < sum2) {
				addMoney(bet * 2);
				return 1;
			}
			else {
				return 0;
			}
		}
		return result;
	}


}
