import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class uses GUI programming to implement a simple card game
 * 
 * @author Krystal
 *
 */
public class Main {

	boolean game_started = false;
	boolean game_ended = false;

	JTextField bet = new JTextField(10);

	JLabel player1;
	JLabel player2;
	JLabel player3;

	JLabel dealer1;
	JLabel dealer2;
	JLabel dealer3;

	String dcardno1;
	String dcardno2;
	String dcardno3;

	String pcardno1;
	String pcardno2;
	String pcardno3;

	JLabel info;

	Deck mydeck = new Deck();

	int replaceCount = 0;
	boolean replaced1 = false;
	boolean replaced2 = false;
	boolean replaced3 = false;

	int betamt;
	int money = 100;

	/**
	 * This is the main method of the program
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Main gui = new Main();
		gui.go();
	}

	/**
	 * This is the method where the GUI is created
	 * 
	 */
	public void go() {

		JPanel MainPanel = new JPanel();
		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();

		ImageIcon card_back = new ImageIcon(this.getClass().getResource("card_back.gif"));

		dealer1 = new JLabel(card_back);
		dealer2 = new JLabel(card_back);
		dealer3 = new JLabel(card_back);

		DealerPanel.add(dealer1);
		DealerPanel.add(dealer2);
		DealerPanel.add(dealer3);

		player1 = new JLabel(card_back);
		player2 = new JLabel(card_back);
		player3 = new JLabel(card_back);

		PlayerPanel.add(player1);
		PlayerPanel.add(player2);
		PlayerPanel.add(player3);

		JButton replace1 = new JButton("Replace Card 1");
		JButton replace2 = new JButton("Replace Card 2");
		JButton replace3 = new JButton("Replace Card 3");

		replace1.addActionListener(new ReplaceListener1());
		replace2.addActionListener(new ReplaceListener2());
		replace3.addActionListener(new ReplaceListener3());

		RpCardBtnPanel.add(replace1);
		RpCardBtnPanel.add(replace2);
		RpCardBtnPanel.add(replace3);

		JButton start = new JButton("Start");
		start.addActionListener(new StartListener());
		JButton result = new JButton("Result");
		result.addActionListener(new ResultListener());

		ButtonPanel.add(new JLabel("Bet: $ "));
		ButtonPanel.add(bet);
		ButtonPanel.add(start);
		ButtonPanel.add(result);

		info = new JLabel("Please place you bet! Amount of money you have: $100");
		InfoPanel.add(info);

		JMenuBar menuBar = new JMenuBar();
		JMenu control = new JMenu("Control");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitListener());
		control.add(exit);

		JMenu help = new JMenu("Help");
		JMenuItem intruction = new JMenuItem("Intruction");
		intruction.addActionListener(new HelpListener());
		help.add(intruction);

		menuBar.add(control);
		menuBar.add(help);

		MainPanel.setLayout(new GridLayout(5, 1));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);

		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(MainPanel);
		frame.setJMenuBar(menuBar);
		frame.setTitle("A Simple Card Game");
		frame.setSize(400, 700);
		frame.setVisible(true);
		frame.add(MainPanel);

	}

	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if ((game_started == false) && (game_ended == false)) {

				if (bet.getText().contains(".")) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame,
							"WARNING: The bet you place must be a positive integer!");
					return;
				}

				betamt = Integer.parseInt(bet.getText());
				if (betamt < 0) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame,
							"WARNING: The bet you place must be a positive integer!");
					return;
				}

				if (betamt > money) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame, "WARNING: You only have $" + money);
					return;
				}

				game_started = true;

				mydeck = new Deck();

				pcardno1 = mydeck.getCard();
				pcardno2 = mydeck.getCard();
				pcardno3 = mydeck.getCard();

				dcardno1 = mydeck.getCard();
				dcardno2 = mydeck.getCard();
				dcardno3 = mydeck.getCard();

				ImageIcon card1 = new ImageIcon(this.getClass().getResource("card_" + pcardno1 + ".gif"));
				ImageIcon card2 = new ImageIcon(this.getClass().getResource("card_" + pcardno2 + ".gif"));
				ImageIcon card3 = new ImageIcon(this.getClass().getResource("card_" + pcardno3 + ".gif"));

				player1.setIcon(card1);
				player2.setIcon(card2);
				player3.setIcon(card3);

				info.setText("Your current bet is: $" + betamt + " Amount of money you have: $" + money);
			}

		}
	}

	class ReplaceListener1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if ((game_started == true) && (replaceCount < 2) && (replaced1 == false)) {
				pcardno1 = mydeck.getCard();

				// System.out.println(pcardno1);

				ImageIcon thiscard = new ImageIcon(this.getClass().getResource("card_" + pcardno1 + ".gif"));
				player1.setIcon(thiscard);

				replaceCount++;
				replaced1 = true;
			}
		}
	}

	class ReplaceListener2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if ((game_started == true) && (replaceCount < 2) && (replaced2 == false)) {
				pcardno2 = mydeck.getCard();

				// System.out.println(thiscardno);

				ImageIcon thiscard = new ImageIcon(this.getClass().getResource("card_" + pcardno2 + ".gif"));
				player2.setIcon(thiscard);

				replaceCount++;
				replaced2 = true;

			}
		}
	}

	class ReplaceListener3 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if ((game_started == true) && (replaceCount < 2) && (replaced3 == false)) {
				pcardno3 = mydeck.getCard();

				// System.out.println(pcardno3);

				ImageIcon thiscard = new ImageIcon(this.getClass().getResource("card_" + pcardno3 + ".gif"));
				player3.setIcon(thiscard);

				replaceCount++;
				replaced3 = true;
			}
		}
	}

	class ResultListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (game_started == true) {

				ImageIcon card1 = new ImageIcon(this.getClass().getResource("card_" + dcardno1 + ".gif"));
				ImageIcon card2 = new ImageIcon(this.getClass().getResource("card_" + dcardno2 + ".gif"));
				ImageIcon card3 = new ImageIcon(this.getClass().getResource("card_" + dcardno3 + ".gif"));

				dealer1.setIcon(card1);
				dealer2.setIcon(card2);
				dealer3.setIcon(card3);

				boolean playerwin = false;
				int dspcard = 0;
				int pspcard = 0;
				int pcount = 0;
				int dcount = 0;

				if (dcardno1.length() == 3) {
					System.out.println(dcardno1.substring(2));
					if ((dcardno1.substring(2).equals("1")) || (dcardno1.substring(2).equals("2"))
							|| (dcardno1.substring(2).equals("3"))) {
						dspcard++;
					} else {
						dcount = dcount + 10;
					}
				} else {
					dcount = dcount + Integer.valueOf(dcardno1.substring(1));
				}

				if (dcardno2.length() == 3) {
					System.out.println(dcardno2.substring(2));
					if ((dcardno2.substring(2).equals("1")) || (dcardno2.substring(2).equals("2"))
							|| (dcardno2.substring(2).equals("3"))) {
						dspcard++;
					} else {
						dcount = dcount + 10;
					}
				} else {
					dcount = dcount + Integer.valueOf(dcardno2.substring(1));
				}

				if (dcardno3.length() == 3) {
					System.out.println(dcardno3.substring(2));
					if ((dcardno3.substring(2).equals("1")) || (dcardno3.substring(2).equals("2"))
							|| (dcardno3.substring(2).equals("3"))) {
						dspcard++;
					} else {
						dcount = dcount + 10;
					}
				} else {
					dcount = dcount + Integer.valueOf(dcardno3.substring(1));
				}

				if (pcardno1.length() == 3) {
					if ((pcardno1.substring(2).equals("1")) || (pcardno1.substring(2).equals("2"))
							|| (pcardno1.substring(2).equals("3"))) {
						pspcard++;
					} else {
						pcount = pcount + 10;
					}
				} else {
					pcount = pcount + Integer.valueOf(pcardno1.substring(1));
				}

				if (pcardno2.length() == 3) {
					if ((pcardno2.substring(2).equals("1")) || (pcardno2.substring(2).equals("2"))
							|| (pcardno2.substring(2).equals("3"))) {
						pspcard++;
					} else {
						pcount = pcount + 10;
					}
				} else {
					pcount = pcount + Integer.valueOf(pcardno2.substring(1));
				}

				if (pcardno3.length() == 3) {
					if ((pcardno3.substring(2).equals("1")) || (pcardno3.substring(2).equals("2"))
							|| (pcardno3.substring(2).equals("3"))) {
						pspcard++;
					} else {
						pcount = pcount + 10;
					}
				} else {
					pcount = pcount + Integer.valueOf(pcardno3.substring(1));
				}

				if (pspcard > dspcard) {
					playerwin = true;
				}

				if (pspcard == dspcard) {
					if (pcount % 10 > dcount % 10) {
						playerwin = true;
					}
				}

				System.out.println("Player " + pspcard + " count = " + pcount);
				System.out.println("Dealer " + dspcard + " count = " + dcount);

				System.out.println(playerwin);

				if (playerwin == true) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame, "Congratuation! You win this round!");
					money = money + betamt;
				} else {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame, "Sorry! The dealer wins this round!");
					money = money - betamt;
				}

				game_started = false;

				ImageIcon card_back = new ImageIcon(this.getClass().getResource("card_back.gif"));
				player1.setIcon(card_back);
				player2.setIcon(card_back);
				player3.setIcon(card_back);
				dealer1.setIcon(card_back);
				dealer2.setIcon(card_back);
				dealer3.setIcon(card_back);
				replaceCount = 0;
				replaced1 = false;
				replaced2 = false;
				replaced3 = false;

				bet.setText("");

				if (money <= 0) {
					JFrame DialogFrame = new JFrame("Message");
					JOptionPane.showMessageDialog(DialogFrame,
							"Game Over!\nYou have no more money!\nPlease start a new game!");
					game_ended = true;
					info.setText("You have no more money! Please start a new game!");
					return;
				}

				info.setText("Please place you bet! Amount of money you have: $" + Integer.toString(money));

			}
		}
	}

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

	class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JFrame Helpframe = new JFrame("Message");
			JOptionPane.showMessageDialog(Helpframe,
					"Rules to determine who has better cards: \nJ,Q,K are regarded as special cards. \nRule 1: The one with more special cards wins. \nRule 2: If both have the same number of special card, add the face value of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1). \nRule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
		}

	}

}
