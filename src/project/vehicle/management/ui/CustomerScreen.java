package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerScreen extends JFrame {
	private JButton searchButton;
	private JTextField searchTextField;
	private JLabel searchLabel;
	private JLabel sortLabel;
	private JComboBox sortComboBox;
	
	public CustomerScreen() {
		setTitle("Customer Screen");
		create();
		add();
		addListeners();
		setVisible(true);
		setSize(1000,1000);
	}
	
	
	public static void main(String[] args) {
		new CustomerScreen();

	}

	private void create() {
		searchButton = new JButton("Search");
		searchTextField = new JTextField(20);
		searchLabel = new JLabel("Search:");
		sortLabel = new JLabel("Sort By:");
		String[] sortStrings = {"Price (Low to High)", "Price (High to Low)", "Miles (Low to High)", "Miles (High to Low)"};
		sortComboBox = new JComboBox(sortStrings);
		
	}

	private void add() {
		BorderLayout bl = new BorderLayout();
		Container con = super.getContentPane();
		con.setLayout(bl);
		JPanel searchAndSortPanel = new JPanel();
		searchAndSortPanel.add(searchLabel);
		searchAndSortPanel.add(searchTextField);
		searchAndSortPanel.add(searchButton);
		searchAndSortPanel.add(sortLabel);
		searchAndSortPanel.add(sortComboBox);
		con.add("North", searchAndSortPanel);
		
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		
	}

}
