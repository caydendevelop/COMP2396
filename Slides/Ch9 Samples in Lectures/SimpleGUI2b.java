import javax.swing.*;  
import java.awt.event.*;

public class SimpleGUI2b {  

	JButton button;
	public static void main(String[] args) {  
		SimpleGUI2 gui = new SimpleGUI2();  
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("click me");  
		button.addActionListener(new ButtonListener());
		frame.add(button);  
		frame.setSize(300, 300);  
		frame.setVisible(true);
	}

	public class ButtonListener implements ActionListener { // inner class
		public void actionPerformed(ActionEvent event) {  
			button.setText("I've been clicked!");
		}
	}

}
