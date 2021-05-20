import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the chat client program. Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class ChatClient extends JPanel {
    private String hostname;
    private int port;
    private String userName;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            new ReadThread(socket, this).start();
            new WriteThread(socket, this).start();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserName() {
        return this.userName;
    }

    // menubar component
    static JMenuBar menuBar = new JMenuBar();
    static JMenu menu1 = new JMenu("Control");
    static JMenuItem menuItem1 = new JMenuItem("Exit");
    static JMenu menu2 = new JMenu("Help");
    static JMenuItem menuItem2 = new JMenuItem("Instruction");

    static JPanel upperPanel = new JPanel();
    static JPanel middlePanel = new JPanel();
    static JPanel lowerPanel = new JPanel();

    // upper panel component
    static JLabel label_text = new JLabel("Enter your player name...");

    // middle panel component
    static JLabel label_Image1 = new JLabel();
    static JLabel label_Image2 = new JLabel();
    static JLabel label_Image3 = new JLabel();
    static JLabel label_Image4 = new JLabel();
    static JLabel label_Image5 = new JLabel();
    static JLabel label_Image6 = new JLabel();
    static JLabel label_Image7 = new JLabel();
    static JLabel label_Image8 = new JLabel();
    static JLabel label_Image9 = new JLabel();

    static ImageIcon Image1 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image2 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image3 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image4 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image5 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image6 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image7 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image8 = new ImageIcon("./img/Blank.jpg");
    static ImageIcon Image9 = new ImageIcon("./img/Blank.jpg");

    // lower panel component
    static JTextField textBox = new JTextField(40);
    static JButton btn = new JButton("Submit");
    static String string_textFieldValue;

    public static void main(String[] args) {
        menu1.add(menuItem1);
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menu2.add(menuItem2);
        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Some information about the game: \n"
                        .concat("Criteria for a valid move: \n").concat("-The move is not occupied by any mark. \n")
                        .concat("-The move is made in the player's turn. \n")
                        .concat("-The move is made within 3 x 3 board. \n")
                        .concat("The game would continue and switch among the opposite player until it reaches either one of the following conditions: \n")
                        .concat("-Player 1 wins. \n").concat("-Player 2 wins. \n").concat("-Draw."));
            }
        });
        menuBar.add(menu1);
        menuBar.add(menu2);

        // upper panel
        upperPanel.add(label_text);
        upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // text align left

        // middle panel
        middlePanel.setBackground(Color.white);
        label_Image1.setIcon(Image1);
        label_Image2.setIcon(Image2);
        label_Image3.setIcon(Image3);
        label_Image4.setIcon(Image4);
        label_Image5.setIcon(Image5);
        label_Image6.setIcon(Image6);
        label_Image7.setIcon(Image7);
        label_Image8.setIcon(Image8);
        label_Image9.setIcon(Image9);

        middlePanel.add(label_Image1);
        middlePanel.add(label_Image2);
        middlePanel.add(label_Image3);
        middlePanel.add(label_Image4);
        middlePanel.add(label_Image5);
        middlePanel.add(label_Image6);
        middlePanel.add(label_Image7);
        middlePanel.add(label_Image8);
        middlePanel.add(label_Image9);

        FlowLayout layout = new FlowLayout(); // remove padding between JLabel
        layout.setHgap(0);
        layout.setVgap(0);
        middlePanel.setLayout(layout);

        // lower panel
        lowerPanel.add(textBox);
        lowerPanel.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                string_textFieldValue = textBox.getText();
                label_text.setText("WELCOME " + string_textFieldValue);
                textBox.setEnabled(false);
                btn.setEnabled(false);
                ChatClient client = new ChatClient(string_textFieldValue, 5000);
                client.execute();
            }
        });

        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(515, 485);
        frame.setJMenuBar(menuBar);
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(lowerPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        // if (args.length < 2)
        //     return;

        // // String hostname = args[0];
        // String playerName = string_textFieldValue;
        // //int port = Integer.parseInt(args[1]);
        // int port = 5000;

        // ChatClient client = new ChatClient(playerName, port);
        // client.execute();
    }
}