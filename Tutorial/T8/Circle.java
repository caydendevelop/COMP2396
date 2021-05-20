import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Circle extends JFrame {
	private JButton enlarge = new JButton("Enlarge");
	private JButton shrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();

	public Circle() {
		JPanel panel = new JPanel(); // Use the panel to group buttons
		panel.add(enlarge);
		panel.add(shrink);

		this.add(canvas, BorderLayout.CENTER); // Add canvas to the center
		this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

		enlarge.addActionListener(new Listener());
		shrink.addActionListener(new Listener());

	}

	public static void main(String[] args) {
		JFrame frame = new Circle();
		frame.setTitle("Circle_Ani1");
		frame.setLocationRelativeTo(null); // center the frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 250);
		frame.setVisible(true);
	}

	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == enlarge) {
				canvas.enlarge();
			}

			else if (e.getSource() == shrink) {
				canvas.shrink();
			}
		}
	}

	class CirclePanel extends JPanel {
		private int radius = 17; // Default circle radius

		public void enlarge() { // Enlarge the circle
			radius++;
			repaint();
		}

		public void shrink() { // Shrink the circle
			radius--;
			repaint();
			
		}

		// Repaint the circle.
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
		}

	}

}
