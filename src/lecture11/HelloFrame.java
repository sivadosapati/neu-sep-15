package lecture11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HelloFrame extends JFrame {
	private JButton clickMeButton;
	private JLabel enterStringLabel;
	private JTextField enterStringTextField;

	public HelloFrame() {
		setTitle("Hello Everyone");
		create();
		setFonts();
		add();
		addListeners();
		setSize(500, 500);
		setVisible(true);
	}

	private void setFonts() {
		Font font = new Font("Arial", Font.BOLD, 24);
		
		enterStringLabel.setFont(font);
		enterStringTextField.setFont(font);
	}

	private void addListeners() {
		ClickMeAction cma = new ClickMeAction();
		clickMeButton.addActionListener(cma);
	}

	private void add() {
		BorderLayout bl = new BorderLayout();
		Container con = super.getContentPane();
		con.setLayout(bl);
		JPanel panel = new JPanel();
		panel.add(enterStringLabel);
		panel.add(enterStringTextField);
		con.add("North", panel);
		con.add("South", clickMeButton);
	}

	class ClickMeAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String word = enterStringTextField.getText();
			String reverse = new StringBuffer(word).reverse().toString();
			enterStringTextField.setText(reverse);
		}

	}

	private void create() {
		clickMeButton = new JButton("Click me..");
		enterStringLabel = new JLabel("Enter something..");
		enterStringTextField = new JTextField(20);
	}

	public static void main(String[] args) {
		HelloFrame frame = new HelloFrame();
	}

}
