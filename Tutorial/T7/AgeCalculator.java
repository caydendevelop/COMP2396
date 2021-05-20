import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgeCalculator implements ActionListener {

	JTextField currentYearTextField = new JTextField(4);
	JTextField birthdayYearTextField = new JTextField(4);

	JLabel result = new JLabel("Your age: ");

	public static void main(String[] args) {
		AgeCalculator t = new AgeCalculator();
		t.go();
	}

	public void go() {

		JFrame frame = new JFrame("My Age Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_north = new JPanel();
		panel_north.setLayout(new BoxLayout(panel_north, BoxLayout.Y_AXIS));
		// panel_north.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel panel_current_year = new JPanel();
		panel_current_year.add(new JLabel("Please enter the current year: "));
		panel_current_year.add(currentYearTextField);

		JPanel panel_birth_year = new JPanel();

		panel_birth_year.add(new JLabel("Please enter the year of your birth: "));
		panel_birth_year.add(birthdayYearTextField);

		panel_north.add(panel_current_year);
		panel_north.add(panel_birth_year);

		JPanel panel_west = new JPanel();
		panel_west.add(result);
		// panel_west.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel panel_east = new JPanel();
		// pane_east.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(this);

		panel_east.add(confirm);

		frame.add(panel_north, BorderLayout.NORTH);
		frame.add(panel_west, BorderLayout.WEST);
		frame.add(panel_east, BorderLayout.EAST);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		int current = Integer.parseInt(currentYearTextField.getText());
		int birthday = Integer.parseInt(birthdayYearTextField.getText());
		String s = "Your age: " + String.valueOf(current - birthday);
		result.setText(s);
	}

}
