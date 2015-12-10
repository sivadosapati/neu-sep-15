package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DealerDelete extends JFrame {
	JButton yes;
	JButton no;
	JLabel confirm;
	JPanel temp;
	JPanel button;
	JPanel label;
	Container con;
	boolean confirmdelete = false;

	public DealerDelete() {
		setTitle("Delete");
		create();
		add();
		addListeners();
		setSize(400, 130);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void addListeners() {
		ButtonYesClick byc = new ButtonYesClick();
		ButtonNoClick bnc = new ButtonNoClick();
		yes.addActionListener(byc);
		no.addActionListener(bnc);
	}

	private void create() {
		yes = new JButton("yes");
		no = new JButton("no");
		confirm = new JLabel("Delete selected rows ?");
		label = new JPanel();
		temp = new JPanel();
		con = super.getContentPane();
		button = new JPanel(new CardLayout());
	}

	private void add() {

		temp.add(yes);
		temp.add(no);
		label.add(confirm);
		button.add(temp);
		con.add(button, BorderLayout.CENTER);
		con.add(label, BorderLayout.PAGE_START);
		
	}

	class ButtonYesClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			confirmdelete = true;

		}

	}

	class ButtonNoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DealerDelete();
	}

}
