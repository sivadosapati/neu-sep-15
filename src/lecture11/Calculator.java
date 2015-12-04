package lecture11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator extends NEUFrame {
	private JButton clickEquals;
	private JLabel resultNumber;
	private JTextField firstNumber;
	private JTextField secondNumber;
	private JComboBox choiceBox;

	@Override
	public void create() {
		clickEquals = new JButton("=");
		resultNumber = new JLabel();
		firstNumber = new JTextField(5);
		secondNumber = new JTextField(5);
		choiceBox = new JComboBox(new String[] { "+", "-", "%", "X" });
	}

	@Override
	public void add() {
		FlowLayout fl = new FlowLayout();
		Container con = getContentPane();
		con.setLayout(fl);
		con.add(firstNumber);
		con.add(choiceBox);
		con.add(secondNumber);
		con.add(clickEquals);
		con.add(resultNumber);
	}

	@Override
	public void addListeners() {
		clickEquals.addActionListener(new CalculatorAction());
	}

	class CalculatorAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int fn = Integer.parseInt(firstNumber.getText());
			int sn = Integer.parseInt(secondNumber.getText());
			String choice = choiceBox.getSelectedItem().toString();
			int result = 0;
			if (choice.equals("+")) {
				result = fn + sn;
			}
			if (choice.equals("-")) {
				result = fn - sn;
			}
			if (choice.equals("%")) {
				result = fn % sn;
			}
			if (choice.equals("X")) {
				result = fn * sn;
			}
			resultNumber.setText(result + "");
		}

	}

	public static void main(String args[]) {
		new Calculator();
	}
}
