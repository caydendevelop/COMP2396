/**
 * This class creates the Card structure for the card used in Main.java
 * 
 * @author Ngai Cheuk Hin, Cayden 
 * @see Main.java
 * 
 */

public class Card {
  private int face;
  private int value;  

  /**
	 * This is the constructor of Card
	 */
  public Card(int face, int value) {
    this.face = face;
    this.value = value;
  }
  /**
	 * Get the face of the Card
	 * 
	 * @return the face of the Card as int
	 * 
	 */
  public int getFace(){
    return face;
  }

  /**
	 * Get the value of the Card
	 * 
	 * @return the value of the Card as int
	 * 
	 */
  public int getValue(){
    return value;
  }
}
