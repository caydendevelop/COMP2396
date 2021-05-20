package comp2396_a3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * GameBackend class handle the display of the main game screen
 * and call the logic functions for card or user money under GameLogic.java
 */
public class GameBackend {
	
	private JLabel label_Image1, label_Image2, label_Image3, label_Image4, label_Image5, label_Image6;
	private JButton btn_rpcard1, btn_rpcard2, btn_rpcard3, btn_start, btn_result; 
	private JLabel label_bet, label_info, label_money;
	private JTextField txt_inputbet;
	private JMenuBar menubar;
	private JMenu controlmenu;
	private JMenuItem help, exit;
	private JFrame mainframe;
	private GameLogic logic;
	private ArrayList<String> displayDealer;
	private ArrayList<String> displayPlayer;
	private int replacecount;
	private Boolean gamestarted = false;
	private int bet;
	
	/**
	 * GameBackend() constructor initialize GameLogic class to logic variable
	 */
	public GameBackend() {
		logic = new GameLogic();
	}
	
	/**
	 * initialize() function initialize the main game screen, card icons for displaying cards, 
	 * buttons, menu and their respective listeners.
	 */
	public void initialize() {
		
		//Card Images
		label_Image1 = new JLabel ();
		label_Image2 = new JLabel ();
		label_Image3 = new JLabel ();
		label_Image4 = new JLabel ();
		label_Image5 = new JLabel ();
		label_Image6 = new JLabel ();
		label_Image1.setIcon( new ImageIcon(getClass().getResource("./Images/card_back.gif")));
		label_Image2.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
		label_Image3.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
		label_Image4.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
		label_Image5.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
		label_Image6.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
		
		//Buttons
		btn_rpcard1 = new JButton ("Replace Card 1");
		btn_rpcard2 = new JButton ("Replace Card 2");
		btn_rpcard3 = new JButton ("Replace Card 3");
		btn_start = new JButton ("Start");
		btn_result = new JButton ("Result");
		
		//Label for text output
		label_bet = new JLabel ();
		label_info = new JLabel ();
		label_money = new JLabel ();
		label_bet.setText("Bet: $ ");
		
		//TextField to bet
		txt_inputbet = new JTextField (10);
		
		JPanel MainPanel = new JPanel();
		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		
		//Add Components, Set 5 Panels Layout
		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);
		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);
		
		//Add Listener to replace card
		RpCardBtnPanel.add(btn_rpcard1, BorderLayout.EAST);
		btn_rpcard1.addActionListener(new RpCard1Listener());
		RpCardBtnPanel.add(btn_rpcard2, BorderLayout.CENTER);
		btn_rpcard2.addActionListener(new RpCard2Listener());
		RpCardBtnPanel.add(btn_rpcard3, BorderLayout.WEST);
		btn_rpcard3.addActionListener(new RpCard3Listener());
		
		ButtonPanel.add(label_bet);
		ButtonPanel.add(txt_inputbet);
		ButtonPanel.add(btn_start);
		btn_start.addActionListener(new StartListener());
		ButtonPanel.add(btn_result);
		btn_result.addActionListener(new ResultListener());
		
		InfoPanel.add(label_info);
		label_info.setText("Please place your bet!");
		InfoPanel.add(label_money);
		label_money.setText("Amount of money you have: $" + logic.getMoney());
		
		//Set Main Layout
		MainPanel.setLayout(new GridLayout(5,1));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		
		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green);
		
		
		JFrame mainframe = new JFrame();
		
		//Menu Bar
		menubar = new JMenuBar();
		controlmenu = new JMenu("Control");
		exit = new JMenuItem("Exit");
		controlmenu.add(exit);
		help = new JMenuItem("Help");
		menubar.add(controlmenu);
		menubar.add(help);
		help.addActionListener(new HelpListener());
		exit.addActionListener(new ExitListener());
		mainframe.setJMenuBar(menubar);
		
		//Main Frame Display
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.getContentPane().add(MainPanel);
		mainframe.setTitle("A Simple Card Game");
		mainframe.setSize(450, 700);
		mainframe.setVisible(true);
		logic.reShuffle();
		//logic.getDeck();
	}
	
	/**
	 * gameStart() function starts a game by getting bet and handling incorrect bet/insufficient bet.
	 * After success of checking bet amount and whether a game is running, then start game by
	 * 1. Shuffling deck
	 * 2. getDealer deck and hide (covered card shown)
	 * 3. getPlayer deck and show 
	 */
	public void gameStart() {
		if (txt_inputbet.getText().length() == 0) {
			JOptionPane.showMessageDialog(mainframe, "WARNING: The bet can't be empty to start!", "Message", JOptionPane.INFORMATION_MESSAGE);	
		}
		else if (gamestarted == false){
			bet = -999;
			try {
				bet = Integer.parseInt(txt_inputbet.getText());
				if (bet <= 0) {
					JOptionPane.showMessageDialog(mainframe, "WARNING: The bet you place must be a positive integer!", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(mainframe, "WARNING: The bet you place must be a positive integer!", "Message", JOptionPane.INFORMATION_MESSAGE);	
			}
			
			if (bet > logic.getMoney()) {
				JOptionPane.showMessageDialog(mainframe, "WARNING: You only have $" + logic.getMoney() + "!", "Message", JOptionPane.INFORMATION_MESSAGE);	
				
			} else if (bet > 0) {
				gamestarted = true;
				replacecount = 0;
				logic.addMoney(-bet);
				logic.reShuffle();
				System.out.print("Bet Complete! " + bet + " " + logic.getMoney() + "\n");
				label_info.setText("Your current bet is: $" + bet);
				displayDealer = logic.dealerDeck();
//				for (int i = 0; i < 3; i++) {
//					String card = displayDealer.get(i);
//					if (i == 0)
//						label_Image1.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
//					if (i == 1)
//						label_Image2.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
//					if (i == 2)
//						label_Image3.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
//				}
				displayPlayer = logic.playerDeck();
				for (int i = 0; i < 3; i++) {
					String card = displayPlayer.get(i);
					if (i == 0)
						label_Image4.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
					if (i == 1)
						label_Image5.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
					if (i == 2)
						label_Image6.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
				}
			}
		}
	}

	/**
	 * HelpListener function display game help info when help is clicked in menu
	 */
	class HelpListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(mainframe, 
					"Rules to determine who has better cards:\n"
					+ "J, Q, K are regarded as special cards.\n"
					+ "Rule 1: The one with more special cards wins.\n"
					+ "Rule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).\n"
					+ "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.", 
                    "Message", 
                    JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	/**
	 * ExitListener function exit game when clicked
	 */
	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	/**
	 * StartListener function run gameStart above
	 */
	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			gameStart();
		}
	}
	
	/**
	 *  RpCard1Listener function replace card 1 of player by game logic behind
	 *  update the card icon image, and disable this self button
	 *  If 2 cards already replaced then disable other replace card buttons other than rpcard1 button
	 */
	class RpCard1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (gamestarted == true) {
				displayPlayer = logic.replaceCard(0);
				label_Image4.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + displayPlayer.get(0) + ".gif")));
				replacecount++;
				btn_rpcard1.setEnabled(false);
				if (replacecount == 2) {
					btn_rpcard2.setEnabled(false);
					btn_rpcard3.setEnabled(false);
				}
			}
		}
	}
	
	/**
	 *  RpCard2Listener function replace card 2 of player by game logic behind
	 *  , update the card icon image and disable this self button
	 *  If 2 cards already replaced then disable other replace card buttons other than rpcard2 button
	 */
	class RpCard2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (gamestarted == true) {
				displayPlayer = logic.replaceCard(1);
				label_Image5.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + displayPlayer.get(1) + ".gif")));
				replacecount++;
				btn_rpcard2.setEnabled(false);
				if (replacecount == 2) {
					btn_rpcard1.setEnabled(false);
					btn_rpcard3.setEnabled(false);
				}
			}
		}
	}
	
	
	/**
	 *  RpCard1Listener function replace card 3 of player by game logic behind
	 *  update the card icon image, and disable this self button
	 *  If 2 cards already replaced then disable other replace card buttons other than rpcard3 button
	 */
	class RpCard3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (gamestarted == true) {
				displayPlayer = logic.replaceCard(2);
				label_Image6.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + displayPlayer.get(2) + ".gif")));
				replacecount++;
				btn_rpcard3.setEnabled(false);
				if (replacecount == 2) {
					btn_rpcard1.setEnabled(false);
					btn_rpcard2.setEnabled(false);
				}
			}
		}
	}
	
	/**
	 *  ResultListener function get game result by calling logic.getResult
	 *  , show message dialogue of winning or losing and update user status/money/ to game over (money = 0)
	 *  If money = 0 then disable all buttons and force user to start a new game by exit and run again.
	 */
	class ResultListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (gamestarted == true) {
				int result = logic.getResult(bet);
				for (int i = 0; i < 3; i++) {
					String card = displayDealer.get(i);
					if (i == 0)
						label_Image1.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
					if (i == 1)
						label_Image2.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
					if (i == 2)
						label_Image3.setIcon(new ImageIcon(getClass().getResource("./Images/card_" + card + ".gif")));
				}
				if (result == 0) {
					JOptionPane.showMessageDialog(mainframe, "Sorry! The Dealer wins this round!", "Message", JOptionPane.INFORMATION_MESSAGE);
					if (logic.getMoney() < 1) {
						JOptionPane.showMessageDialog(mainframe, "Game Over!\nYou have no more money!\nPlease start a new game!", "Message", JOptionPane.INFORMATION_MESSAGE);
						btn_rpcard1.setEnabled(false);
						btn_rpcard2.setEnabled(false);
						btn_rpcard3.setEnabled(false);
						btn_start.setEnabled(false);
						btn_result.setEnabled(false);
						gamestarted = false;
						label_info.setText("You have no more money!");
						label_money.setText("Please start a new game!");
					}
					else {
						label_info.setText("Please place your bet!");
						label_money.setText("Amount of money you have: $" + logic.getMoney());
						btn_rpcard1.setEnabled(true);
						btn_rpcard2.setEnabled(true);
						btn_rpcard3.setEnabled(true);
						gamestarted = false;
					}
				}
				else if (result == 1) {
					JOptionPane.showMessageDialog(mainframe, "Congratulations! You win this round!", "Message", JOptionPane.INFORMATION_MESSAGE);
					label_info.setText("Please place your bet!");
					label_money.setText("Amount of money you have: $" + logic.getMoney());
					btn_rpcard1.setEnabled(true);
					btn_rpcard2.setEnabled(true);
					btn_rpcard3.setEnabled(true);
					gamestarted = false;
				}
				for (int i = 0; i < 6; i++) {
					if (i == 0)
						label_Image1.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
					if (i == 1)
						label_Image2.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
					if (i == 2)
						label_Image3.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
					if (i == 3)
						label_Image4.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
					if (i == 4)
						label_Image5.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
					if (i == 5)
						label_Image6.setIcon(new ImageIcon(getClass().getResource("./Images/card_back.gif")));
				}
			}
		}
	}
}
