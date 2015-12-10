package project.vehicle.management.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import project.vehicle.management.data.access.DealerCarManagerImpl;

public class MainScreen {
	JFrame jf = new JFrame("Car Management System");
	JButton dealer = new JButton("DEALER");
	JButton customer = new JButton("CUSTOMER");
	JLabel head = new JLabel(new ImageIcon("head.jpg"));
	Box box = Box.createVerticalBox();
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();

	final int width = 950;
	final int height = 540;

	DealerCarManagerImpl dealerModel = new DealerCarManagerImpl();
	String[] model = dealerModel.getDealerIds();
	JComboBox<String> dealerComboBox = new JComboBox<>(model);
	String selectedDealer = "";

	public void init() throws Exception {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		jp1.add(head);

		FlowLayout flo = new FlowLayout();
		flo.setHgap(135);
		jp2.setLayout(flo);
		dealer.setPreferredSize(new Dimension(200, 39));
		customer.setPreferredSize(new Dimension(200, 39));

		jp2.add(dealer);
		jp2.add(customer);

		dealerComboBox.setMaximumSize(new Dimension(534, 80));
		dealerComboBox.setToolTipText("Please select dealer's name!");

		box.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		box.add(jp1);
		box.add(jp2);
		box.add(dealerComboBox);

		JPanel jpBlank = new JPanel();
		jpBlank.setPreferredSize(new Dimension(950, 350));
		box.add(jpBlank);

		jf.add(box);

		dealer.addActionListener(e -> {
			if (selectedDealer.equals("")) {
				JOptionPane.showMessageDialog(jf,
						"You must select a dealer first!");
			}

			else {
				System.out.println(selectedDealer);// for test
				// new DealerScreen();
				// jf.dispose();
			}
		});

		customer.addActionListener(e -> {
			if (selectedDealer.equals("")) {
				JOptionPane.showMessageDialog(jf,
						"You must select a dealer first!");
			} else {
				System.out.println(selectedDealer);// for test
				// new CustomerScreen();
				// jf.dispose();
			}
		});

		dealerComboBox.addItemListener(e -> {

			if (e.getStateChange() == ItemEvent.SELECTED) {

				Object[] a = e.getItemSelectable().getSelectedObjects();
				selectedDealer = (String) a[0];

			}

		});

		jf.setBounds((screen.width - width) / 2, (screen.height - height) / 2,
				width, height);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) throws Exception {
		new MainScreen().init();
	}

}
