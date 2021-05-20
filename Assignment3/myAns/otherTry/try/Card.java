public class Card {
  private int face;
  private int value;  

  public Card(int face, int value) {
    this.face = face;
    this.value = value;
  }

  public int getFace(){
    return face;
  }
  public int getValue(){
    return value;
  }
}
