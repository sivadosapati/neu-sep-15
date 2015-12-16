package project.vehicle.management.ui;

/**
 * Author: Xin DING
 * Team 3: DealerScreen
 */
import javax.swing.*;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;
import project.vehicle.management.data.access.CarManagerImpl;
import project.vehicle.management.ui.DearlerMainScreen.MyTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class DealerAddFunc extends JFrame {
	private JLabel noteInformation, ID, Model, Trim;
	private JLabel jCategory, Year, Type, Price;
	private JTextField textModel, textTrim, textMake, textID, textPrice;
	private JRadioButton NewType, OldType, CerType, Type1, Type2, Type3, Type4, Type5;
	private JComboBox year;
	private JButton submit, cancel;
	private JLabel head;
	private Category category;
	private CarManager dealer;
	private Car car = null;
	private MyTableModel mtm;
	private String did;

	GridBagLayout g = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	DealerAddFunc(CarManagerImpl dealerid, MyTableModel mtm) {
		setTitle("Add Function");
		setSize(590, 470);
		setLayout(g);
		// use functions
		addComponent();
		addListeners();
		// display in the middle
		setLocationRelativeTo(null);
		setVisible(true);
		this.dealer = dealerid;
		this.mtm = mtm;
		did = dealerid.getDealerID();

	}

	private void addListeners() {
		ButtonClick bc = new ButtonClick();
		submit.addActionListener(bc);
		cancel.addActionListener(bc);
		NewType.addActionListener(bc);
	}

	class ButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// event for cancel
			if (e.getSource() == cancel) {
				dispose();
			}
			// event for submit

			if (e.getSource() == submit) {
				// choose the category
				if (e.getSource() == NewType) {
					category = Category.NEW;
				}

				else if (e.getSource() == OldType) {
					category = Category.USED;
				} else {
					category = Category.CERTIFIED;
				}

				String id = textID.getText();

				String stringyear = year.getSelectedItem().toString();
				int y = Integer.parseInt(stringyear);
				String m = textMake.getText();
				String mo = textModel.getText();
				String t = textTrim.getText();
				String t1 = Type1.getText();
				String t2 = Type2.getText();
				String t3 = Type3.getText();
				String t4 = Type4.getText();
				String t5 = Type5.getText();
				String p = textPrice.getText();
				float pf;
				if(p.isEmpty()){
					JOptionPane.showMessageDialog(new JButton(),
						    "Some information of this car is empty, you have to fill in all of them !",
						    "Can't add this car",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				else
					pf = Float.parseFloat(p);

				String type;
				if (t1 != null) {
					type = t1;
				} else if (t2 != null) {
					type = t2;
				} else if (t3 != null) {
					type = t3;
				} else if (t4 != null) {
					type = t4;
				} else {
					type = t5;
				}

				Car car = new Car(id, did, category, y, m, mo, t, type, pf);
				try {
					if(carHasEmpty(car))
						JOptionPane.showMessageDialog(new JButton(),
							    "Some information of this car is empty, you have to fill in all of them !",
							    "Can't add this car",
							    JOptionPane.ERROR_MESSAGE);
					else{
						dealer.addCar(car);
						mtm.addTable(car);
						dispose();
					}
					;// mtm.addCar();
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}
		}
	}

	// Add all components
	public void addComponent() {
		car = new Car();
		head = new JLabel(new ImageIcon("pictures/DealerScreen2.jpg"));
		add(g, c, head, 0, 0, 3, c.gridheight);
		// Title

		noteInformation = new JLabel("Add A Car!");
		add(g, c, noteInformation, 0, 1, 1, 1);
		// ID
		ID = new JLabel("ID:");
		add(g, c, ID, 0, 2, 1, 1);
		// Input ID
		textID = new JTextField(10);
		add(g, c, textID, 1, 2, 2, 1);

		// jCategory
		jCategory = new JLabel("Category:");
		add(g, c, jCategory, 0, 4, 1, 1);

		// Choose from the new and old
		NewType = new JRadioButton("New");
		OldType = new JRadioButton("Used");
		CerType = new JRadioButton("Certified");
		ButtonGroup group = new ButtonGroup();
		group.add(NewType);
		group.add(OldType);
		group.add(CerType);
		add(g, c, NewType, 1, 4, 1, 1);
		add(g, c, OldType, 2, 4, 1, 1);
		add(g, c, CerType, 1, 5, 1, 1);
		// Year
		Year = new JLabel("Year:");
		add(g, c, Year, 0, 6, 1, 1);
		// content of year
		String[] YEARS = new String[16];
		for (int i = 2000, k = 0; i <= 2015; i++, k++) {
			YEARS[k] = i + "";
		}
		year = new JComboBox(YEARS);
		add(g, c, year, 1, 6, 1, 1);
		// Make
		Model = new JLabel("Make:");
		add(g, c, Model, 0, 7, 1, 1);
		// Input Make
		textMake = new JTextField(10);
		add(g, c, textMake, 1, 7, 2, 1);
		// Model
		Model = new JLabel("Model:");
		add(g, c, Model, 0, 8, 1, 1);
		// Input Model
		textModel = new JTextField(10);
		add(g, c, textModel, 1, 8, 2, 1);
		// Trim
		Trim = new JLabel("Trim:");
		add(g, c, Trim, 0, 9, 1, 1);
		// Input Trim
		textTrim = new JTextField(20);
		add(g, c, textTrim, 1, 9, 2, 1);
		// Type
		Type = new JLabel("Type:");
		add(g, c, Type, 0, 10, 1, 1);
		// Choose from the types
		Type1 = new JRadioButton("CAR");
		add(g, c, Type1, 1, 10, 1, 1);
		Type2 = new JRadioButton("TRUCK");
		add(g, c, Type2, 2, 10, 1, 1);
		Type3 = new JRadioButton("WAGON");
		add(g, c, Type3, 1, 12, 1, 1);
		Type4 = new JRadioButton("VAN");
		add(g, c, Type4, 1, 11, 1, 1);
		Type5 = new JRadioButton("SUV");
		add(g, c, Type5, 2, 11, 1, 1);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(Type1);
		group1.add(Type2);
		group1.add(Type3);
		group1.add(Type4);
		group1.add(Type5);
		// Price
		Price = new JLabel("Price:");
		add(g, c, Price, 0, 13, 1, 1);
		// Input Price
		textPrice = new JTextField(10);
		add(g, c, textPrice, 1, 13, 2, 1);

		// Submit button
		submit = new JButton("Submit");
		add(g, c, submit, 1, 15, 1, 1);
		// Cancel button
		cancel = new JButton("Cancel");
		add(g, c, cancel, 2, 15, 1, 1);

	}

	public void add(GridBagLayout g, GridBagConstraints c, JComponent jc, int x, int y, int gw, int gh) {
		c.weightx = 0;
		c.weighty = 1;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = x;
		c.gridy = y;
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = gw;
		c.gridheight = gh;
		g.setConstraints(jc, c);
		add(jc);
	}

	public boolean carHasEmpty(Car car) {
		if(car.getID()==null||car.getCategory()==null||car.getMake()==null||car.getModel()==null||
				car.getTrim()==null||car.getType()==null||car.getYear()==null||car.getPrice()==null)
			return true;
		else
			return false;
	}

	
	public void windowClosing(WindowEvent e) {
		this.dispose();

	}


	public static void main(String args[]) {

		// new DealerAddFunc();
	}

}
