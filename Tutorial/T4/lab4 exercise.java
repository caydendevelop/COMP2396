public class Card_o {
    public static void main(String[] args) {
        int[] deck = new int[52];
        String [] suits= {"Spade","Heart","Diamond","Club"};
        // Initialize cards
        for(int i=0;i<deck.length;i++) {
        deck[i]=i;
        }
        // Shuffle the cards.
        for(int i=0;i<deck.length;i++) {
        int index=(int)(Math.random()*deck.length);
        int temp=deck[i];
        deck[i]=deck[index]; // This is just swap the position. If using deck[i] = index, then it would overwrite with possibly repeated value which is created by Math.random()
        deck[index]=temp;
        }
        // Display the card(s) that is heart from the first five cards.
        for(int i=0;i<5;i++) {
            String suit=suits[deck[i]/13];
            if(suit.equals("Heart")) {
            System.out.println("Card number "+deck[i]+" is "+suit);
            }
        }
    }
}