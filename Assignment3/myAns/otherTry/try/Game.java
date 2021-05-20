import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // import the ArrayList class

public class Game extends JPanel {
  public static int balance = 100;
  public static int f;
  public static int[] dealerValue;
  public static int[] playerValue;

  public static String path;
  public static int replaceChance = 2;
  public static Boolean replace1 = true;
  public static Boolean replace2 = true;
  public static Boolean replace3 = true;
  public static Boolean startChance = true;
  public static Boolean resultChance = false;

  public static String string_textFieldValue;
  public static int int_textFieldValue;

  public static ArrayList<Card> cardDeck;

  public static JMenuBar menuBar;
  public static JMenu menu1;
  public static JMenuItem menuItem1;
  public static JMenu menu2;
  public static JMenuItem menuItem2;

  public static JLabel label_Image1;
  public static JLabel label_Image2;
  public static JLabel label_Image3;
  public static JLabel label_Image4;
  public static JLabel label_Image5;
  public static JLabel label_Image6;

  // Create panel
  public static JPanel MainPanel;
  public static JPanel DealerPanel;
  public static JPanel PlayerPanel;
  public static JPanel RpCardBtnPanel;
  public static JPanel ButtonPanel;
  public static JPanel InfoPanel;

  public static JButton btn_rpcard1;
  public static JButton btn_rpcard2;
  public static JButton btn_rpcard3;
  public static JButton btn_start;
  public static JButton btn_result;

  public static JLabel label_bet;
  JLabel label_info;
  JLabel label_money;

  public static JTextField txt_inputbet;

  public static ImageIcon Image1;
  public static ImageIcon Image2;
  public static ImageIcon Image3;
  public static ImageIcon image4;
  public static ImageIcon Image5;
  public static ImageIcon Image6;

  public Game() {
    balance = 100;
    dealerValue = new int[3];
    playerValue = new int[3];

    replaceChance = 2;
    replace1 = true;
    replace2 = true;
    replace3 = true;
    startChance = true;
    resultChance = false;

    menuBar = new JMenuBar();
    menu1 = new JMenu("Control");
    menuItem1 = new JMenuItem("Exit");
    menu2 = new JMenu("Help");
    menuItem2 = new JMenuItem("Instruction");

    label_Image1 = new JLabel();
    label_Image2 = new JLabel();
    label_Image3 = new JLabel();
    label_Image4 = new JLabel();
    label_Image5 = new JLabel();
    label_Image6 = new JLabel();

    // Create panel
    MainPanel = new JPanel();
    DealerPanel = new JPanel();
    PlayerPanel = new JPanel();
    RpCardBtnPanel = new JPanel();
    ButtonPanel = new JPanel();
    InfoPanel = new JPanel();

    btn_rpcard1 = new JButton("Replace Card 1");
    btn_rpcard2 = new JButton("Replace Card 2");
    btn_rpcard3 = new JButton("Replace Card 3");
    btn_start = new JButton("Start");
    btn_result = new JButton("Result");

    label_bet = new JLabel("Bet: $");
    label_info = new JLabel("Please place your bet!");
    label_money = new JLabel("Amount of money you have: $" + String.valueOf(balance));
    txt_inputbet = new JTextField(10);

    Image1 = new ImageIcon("./images/card_back.gif");
    Image2 = new ImageIcon("./images/card_back.gif");
    Image3 = new ImageIcon("./images/card_back.gif");
    Image4 = new ImageIcon("./images/card_back.gif");
    Image5 = new ImageIcon("./images/card_back.gif");
    Image6 = new ImageIcon("./images/card_back.gif");

    

  }
}

  /*
  void main(String[] args) {

    // Create menuBar
    menu1.add(menuItem1);
    menuItem1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        System.exit(0);
      }
    });
    menu2.add(menuItem2);
    menuItem2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null,
            "J, Q, K are regarded as specialcards. \n Rule 1:The one with more special cards wins. \n Rule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1). \nRule 3:The dealer wins if both rule 1 and rule 2 cannot distinguish the winner");
      }
    });

    menuBar.add(menu1);
    menuBar.add(menu2);

    label_Image1.setIcon(Image1);
    // Repeat this for the other 5 JLabel components
    label_Image2.setIcon(Image2);
    label_Image3.setIcon(Image3);
    label_Image4.setIcon(Image4);
    label_Image5.setIcon(Image5);
    label_Image6.setIcon(Image6);

    DealerPanel.add(label_Image1);
    // Repeat this for all other components
    DealerPanel.add(label_Image2);
    DealerPanel.add(label_Image3);

    PlayerPanel.add(label_Image4);
    PlayerPanel.add(label_Image5);
    PlayerPanel.add(label_Image6);

    RpCardBtnPanel.add(btn_rpcard1);
    btn_rpcard1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (replaceChance > 0 && replace1 == true) {
          f = cardDeck.get(0).getFace();
          playerValue[0] = cardDeck.get(0).getValue();
          path = "./images/card_" + String.valueOf(f) + String.valueOf(playerValue[0]) + ".gif";
          Image4 = new ImageIcon(path);
          label_Image4.setIcon(Image4);
          cardDeck.remove(0);
          replaceChance -= 1;
          replace1 = false;
        }
      }
    });
    RpCardBtnPanel.add(btn_rpcard2);
    btn_rpcard2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (replaceChance > 0 && replace2 == true) {
          f = cardDeck.get(0).getFace();
          playerValue[1] = cardDeck.get(0).getValue();
          path = "./images/card_" + String.valueOf(f) + String.valueOf(playerValue[2]) + ".gif";
          Image5 = new ImageIcon(path);
          label_Image5.setIcon(Image5);
          cardDeck.remove(0);
          replaceChance -= 1;
          replace2 = false;
        }
      }
    });
    RpCardBtnPanel.add(btn_rpcard3);
    btn_rpcard3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (replaceChance > 0 && replace3 == true) {
          f = cardDeck.get(0).getFace();
          playerValue[2] = cardDeck.get(0).getValue();
          path = "./images/card_" + String.valueOf(f) + String.valueOf(playerValue[2]) + ".gif";
          Image6 = new ImageIcon(path);
          label_Image6.setIcon(Image6);
          cardDeck.remove(0);
          replaceChance -= 1;
          replace3 = false;

        }
      }
    });

    ButtonPanel.add(label_bet);
    ButtonPanel.add(txt_inputbet);
    ButtonPanel.add(btn_start);
    btn_start.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        string_textFieldValue = txt_inputbet.getText();
        if (startChance == true) {
          if (string_textFieldValue.contains(".") || string_textFieldValue.contains("-")) {
            JOptionPane.showMessageDialog(null, "WARNING: The bet you place must be a positive integer!");
          } else {
            startChance = false;
            replaceChance = 2;
            replace1 = true;
            replace2 = true;
            replace3 = true;
            int_textFieldValue = Integer.parseInt(txt_inputbet.getText());
            label_info.setText("Your current bet is: $" + string_textFieldValue);
            // balance -= int_textFieldValue;
            label_money.setText("Amount of money you have: $" + balance);

            cardDeck = new ArrayList<Card>();
            for (int j = 1; j < 5; j++) {
              for (int i = 1; i < 14; i++) {
                cardDeck.add(new Card(j, i));
              }
            }

            // shuffle the cardDeck
            for (int i = 0; i < cardDeck.size(); i++) {
              int index = (int) (Math.random() * cardDeck.size());
              Card temp = cardDeck.get(i);
              cardDeck.set(i, cardDeck.get(index));
              cardDeck.set(index, temp);
            }

            f = cardDeck.get(0).getFace();
            playerValue[0] = cardDeck.get(0).getValue();
            path = "./images/card_" + String.valueOf(f) + String.valueOf(playerValue[0]) + ".gif";
            Image4 = new ImageIcon(path);
            label_Image4.setIcon(Image4);
            cardDeck.remove(0);

            f = cardDeck.get(0).getFace();
            playerValue[1] = cardDeck.get(0).getValue();
            path = "./images/card_" + String.valueOf(f) + String.valueOf(playerValue[1]) + ".gif";
            Image5 = new ImageIcon(path);
            label_Image5.setIcon(Image5);
            cardDeck.remove(0);

            f = cardDeck.get(0).getFace();
            playerValue[2] = cardDeck.get(0).getValue();
            path = "./images/card_" + String.valueOf(f) + String.valueOf(playerValue[2]) + ".gif";
            Image6 = new ImageIcon(path);
            label_Image6.setIcon(Image6);
            cardDeck.remove(0);

            // startChance = true;
            resultChance = true;
          }

        }
        // else {
        // JOptionPane.showMessageDialog(null, "You have to finish this game first!");
        // }
      }
    });

    ButtonPanel.add(btn_result);
    btn_result.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if (resultChance == true) {
          resultChance = false;
          f = cardDeck.get(0).getFace();
          dealerValue[0] = cardDeck.get(0).getValue();
          path = "./images/card_" + String.valueOf(f) + String.valueOf(dealerValue[0]) + ".gif";
          Image1 = new ImageIcon(path);
          label_Image1.setIcon(Image1);
          cardDeck.remove(0);

          f = cardDeck.get(0).getFace();
          dealerValue[1] = cardDeck.get(0).getValue();
          path = "./images/card_" + String.valueOf(f) + String.valueOf(dealerValue[1]) + ".gif";
          Image2 = new ImageIcon(path);
          label_Image2.setIcon(Image2);
          cardDeck.remove(0);

          f = cardDeck.get(0).getFace();
          dealerValue[2] = cardDeck.get(0).getValue();
          path = "./images/card_" + String.valueOf(f) + String.valueOf(dealerValue[2]) + ".gif";
          Image3 = new ImageIcon(path);
          label_Image3.setIcon(Image3);
          cardDeck.remove(0);

          int dealerSC = 0;
          int playerSC = 0;
          for (int k = 0; k < 3; k++) {
            if (dealerValue[k] > 10)
              dealerSC++;
          }

          for (int k = 0; k < 3; k++) {
            if (playerValue[k] > 10)
              playerSC++;
          }

          if (dealerSC > playerSC) {
            startChance = true;
            JOptionPane.showMessageDialog(null, "Sorry! The Dealer winds this round!");
            balance -= int_textFieldValue;
            if (balance == 0) {

              replace1 = false;
              replace2 = false;
              replace3 = false;
              startChance = false;
              resultChance = false;
              label_info.setText("You have no more money!");
              label_money.setText("Please start a new game!");
              JOptionPane.showMessageDialog(null, "Game over! \n You have no more money! \n Please start a new game!");
            } else {
              label_info.setText("Please place your bet!");
              label_money.setText("Amount of money you have: $" + balance);

              Image1 = new ImageIcon("./images/card_back.gif");
              label_Image1.setIcon(Image1);
              Image2 = new ImageIcon("./images/card_back.gif");
              label_Image2.setIcon(Image2);
              Image3 = new ImageIcon("./images/card_back.gif");
              label_Image3.setIcon(Image3);
              Image4 = new ImageIcon("./images/card_back.gif");
              label_Image4.setIcon(Image4);
              Image5 = new ImageIcon("./images/card_back.gif");
              label_Image5.setIcon(Image5);
              Image6 = new ImageIcon("./images/card_back.gif");
              label_Image6.setIcon(Image6);
            }
          } else if (dealerSC < playerSC) {
            startChance = true;
            JOptionPane.showMessageDialog(null, "Congrauations! You win this round!");
            balance += int_textFieldValue;
            label_info.setText("Please place your bet!");
            label_money.setText("Amount of money you have: $" + balance);

            Image1 = new ImageIcon("./images/card_back.gif");
            label_Image1.setIcon(Image1);
            Image2 = new ImageIcon("./images/card_back.gif");
            label_Image2.setIcon(Image2);
            Image3 = new ImageIcon("./images/card_back.gif");
            label_Image3.setIcon(Image3);
            Image4 = new ImageIcon("./images/card_back.gif");
            label_Image4.setIcon(Image4);
            Image5 = new ImageIcon("./images/card_back.gif");
            label_Image5.setIcon(Image5);
            Image6 = new ImageIcon("./images/card_back.gif");
            label_Image6.setIcon(Image6);
          } else {
            int dealerSum = 0;
            int playerSum = 0;
            int dealerRemainder = 0;
            int playerRemainder = 0;
            for (int k = 0; k < 3; k++) {
              if (dealerValue[k] <= 10)
                dealerSum = dealerSum + dealerValue[k];
            }
            dealerRemainder = dealerSum % 10;

            for (int k = 0; k < 3; k++) {
              if (playerValue[k] <= 10)
                playerSum = playerSum + playerValue[k];
            }
            playerRemainder = playerSum % 10;

            if (dealerRemainder > playerRemainder) {
              startChance = true;
              JOptionPane.showMessageDialog(null, "Sorry! The Dealer winds this round!");
              balance -= int_textFieldValue;
              if (balance == 0) {

                replace1 = false;
                replace2 = false;
                replace3 = false;
                startChance = false;
                resultChance = false;
                label_info.setText("You have no more money!");
                label_money.setText("Please start a new game!");
                JOptionPane.showMessageDialog(null,
                    "Game over! \n You have no more money! \n Please start a new game!");
              } else {
                label_info.setText("Please place your bet!");
                label_money.setText("Amount of money you have: $" + balance);

                Image1 = new ImageIcon("./images/card_back.gif");
                label_Image1.setIcon(Image1);
                Image2 = new ImageIcon("./images/card_back.gif");
                label_Image2.setIcon(Image2);
                Image3 = new ImageIcon("./images/card_back.gif");
                label_Image3.setIcon(Image3);
                Image4 = new ImageIcon("./images/card_back.gif");
                label_Image4.setIcon(Image4);
                Image5 = new ImageIcon("./images/card_back.gif");
                label_Image5.setIcon(Image5);
                Image6 = new ImageIcon("./images/card_back.gif");
                label_Image6.setIcon(Image6);
              }

            } else if (dealerRemainder < playerRemainder) {
              startChance = true;
              JOptionPane.showMessageDialog(null, "Congrauations! You win this round!");
              balance += int_textFieldValue;
              label_info.setText("Please place your bet!");
              label_money.setText("Amount of money you have: $" + balance);

              Image1 = new ImageIcon("./images/card_back.gif");
              label_Image1.setIcon(Image1);
              Image2 = new ImageIcon("./images/card_back.gif");
              label_Image2.setIcon(Image2);
              Image3 = new ImageIcon("./images/card_back.gif");
              label_Image3.setIcon(Image3);
              Image4 = new ImageIcon("./images/card_back.gif");
              label_Image4.setIcon(Image4);
              Image5 = new ImageIcon("./images/card_back.gif");
              label_Image5.setIcon(Image5);
              Image6 = new ImageIcon("./images/card_back.gif");
              label_Image6.setIcon(Image6);
            } else {
              startChance = true;
              JOptionPane.showMessageDialog(null, "Sorry! The Dealer winds this round!");
              balance -= int_textFieldValue;

              if (balance == 0) {

                replace1 = false;
                replace2 = false;
                replace3 = false;
                startChance = false;
                resultChance = false;
                label_info.setText("You have no more money!");
                label_money.setText("Please start a new game!");
                JOptionPane.showMessageDialog(null,
                    "Game over! \n You have no more money! \n Please start a new game!");
              } else {
                label_info.setText("Please place your bet!");
                label_money.setText("Amount of money you have: $" + balance);

                Image1 = new ImageIcon("./images/card_back.gif");
                label_Image1.setIcon(Image1);
                Image2 = new ImageIcon("./images/card_back.gif");
                label_Image2.setIcon(Image2);
                Image3 = new ImageIcon("./images/card_back.gif");
                label_Image3.setIcon(Image3);
                Image4 = new ImageIcon("./images/card_back.gif");
                label_Image4.setIcon(Image4);
                Image5 = new ImageIcon("./images/card_back.gif");
                label_Image5.setIcon(Image5);
                Image6 = new ImageIcon("./images/card_back.gif");
                label_Image6.setIcon(Image6);
              }
            }

          }

        }

      }
    });

    InfoPanel.add(label_info);
    InfoPanel.add(label_money);

    MainPanel.setLayout(new GridLayout(5, 1));
    MainPanel.add(DealerPanel);
    // Repeat this for other sub-panels
    MainPanel.add(PlayerPanel);
    MainPanel.add(RpCardBtnPanel);
    MainPanel.add(ButtonPanel);
    MainPanel.add(InfoPanel);

    // Optional background color setting
    DealerPanel.setBackground(Color.green);
    PlayerPanel.setBackground(Color.green);
    RpCardBtnPanel.setBackground(Color.green);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(MainPanel);
    frame.setTitle("A Simple Card Game");
    frame.setSize(400, 700);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);

    // Here begins all functions

  }
}
*/