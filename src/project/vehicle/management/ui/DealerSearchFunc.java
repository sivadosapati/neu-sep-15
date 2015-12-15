package project.vehicle.management.ui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Range;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;
import project.vehicle.management.data.access.CarManagerImpl;
import project.vehicle.management.ui.DearlerMainScreen.MyTableModel;

public class DealerSearchFunc {

	private JFrame frame;
	private JCheckBox categoryNew;
	private JCheckBox used;
	private JCheckBox categoryCertified;
	private JCheckBox categoryUsed;
	private JComboBox comboBox, comboBox_model, comboBox_trim, comboBox_price, comboBox_year, comboBox_brand;
	public CarManager carManager;
	private JButton btnSearch;
	private JButton Cancel;
	private JTextField keyWords;
	private SearchFilter sf = new SearchFilter();
	private boolean category[] = { false, false, false };
	List<List<String>> list;
	List<Car> carList;
	public MyTableModel tableM;
	public List<Integer> ret;
	public CarManagerImpl cmi;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// try {
		// CarManager carManager = new
		// CarManagerFactory().getCarManager("gmps-bresee");
		// new DealerSearchFunc(carManager, null, null).frame.setVisible(true);
		// // window.;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// });
	}

	/**
	 * Create the application.
	 */
	public DealerSearchFunc(CarManager carManager, MyTableModel tableM) {
		this.carManager = carManager;
		this.tableM = tableM;
		initialize();
		addListeners();
		create();

	}

	private void create() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		list = carManager.listInitralize(carManager.listCars());

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DealerSearchFunc.class.getResource("/sun/print/resources/oneside.png")));
		frame.setTitle("Search");
		frame.setBounds(100, 100, 700, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 60, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		/* category selection */

		JLabel Category = new JLabel("Category");
		GridBagConstraints gbc_Category = new GridBagConstraints();
		gbc_Category.anchor = GridBagConstraints.WEST;
		gbc_Category.insets = new Insets(45, 50, 5, 5);
		gbc_Category.gridx = 0;
		gbc_Category.gridy = 0;
		frame.getContentPane().add(Category, gbc_Category);

		categoryNew = new JCheckBox("New");
		GridBagConstraints gbc_New = new GridBagConstraints();
		gbc_New.anchor = GridBagConstraints.WEST;
		gbc_New.insets = new Insets(45, 0, 5, 5);
		gbc_New.gridx = 1;
		gbc_New.gridy = 0;
		frame.getContentPane().add(categoryNew, gbc_New);

		categoryUsed = new JCheckBox("Used");
		GridBagConstraints gbc_used_1 = new GridBagConstraints();
		gbc_used_1.insets = new Insets(45, 0, 5, 15);
		gbc_used_1.gridx = 1;
		gbc_used_1.gridy = 0;
		frame.getContentPane().add(categoryUsed, gbc_used_1);

		categoryCertified = new JCheckBox("Certified");
		GridBagConstraints gbc_categoryCertified_1 = new GridBagConstraints();
		gbc_categoryCertified_1.anchor = GridBagConstraints.EAST;
		gbc_categoryCertified_1.insets = new Insets(45, 0, 5, 0);
		gbc_categoryCertified_1.gridx = 1;
		gbc_categoryCertified_1.gridy = 0;
		frame.getContentPane().add(categoryCertified, gbc_categoryCertified_1);

		JLabel lblMake = new JLabel("Brand");
		GridBagConstraints gbc_lblMake = new GridBagConstraints();
		gbc_lblMake.anchor = GridBagConstraints.WEST;
		gbc_lblMake.insets = new Insets(0, 50, 5, 5);
		gbc_lblMake.gridx = 0;
		gbc_lblMake.gridy = 1;
		frame.getContentPane().add(lblMake, gbc_lblMake);

		String brandStr[] = { "BMW", "Toyota", "Cameri" };
		comboBox_brand = new JComboBox(brandStr);
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.gridx = 1;
		gbc_comboBox_4.gridy = 1;
		frame.getContentPane().add(comboBox_brand, gbc_comboBox_4);

		JLabel lblModel = new JLabel("Model");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.anchor = GridBagConstraints.WEST;
		gbc_lblModel.insets = new Insets(0, 50, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 2;
		frame.getContentPane().add(lblModel, gbc_lblModel);

		comboBox_model = new JComboBox(list.get(0).toArray());
		GridBagConstraints gbc_comboBox_model = new GridBagConstraints();
		gbc_comboBox_model.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_model.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_model.gridx = 1;
		gbc_comboBox_model.gridy = 2;
		frame.getContentPane().add(comboBox_model, gbc_comboBox_model);

		JLabel lblTrim = new JLabel("Trim");
		GridBagConstraints gbc_lblTrim = new GridBagConstraints();
		gbc_lblTrim.anchor = GridBagConstraints.WEST;
		gbc_lblTrim.insets = new Insets(0, 50, 5, 5);
		gbc_lblTrim.gridx = 0;
		gbc_lblTrim.gridy = 3;
		frame.getContentPane().add(lblTrim, gbc_lblTrim);

		comboBox_trim = new JComboBox(list.get(2).toArray());
		GridBagConstraints gbc_comboBox_trim = new GridBagConstraints();
		gbc_comboBox_trim.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_trim.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_trim.gridx = 1;
		gbc_comboBox_trim.gridy = 3;
		frame.getContentPane().add(comboBox_trim, gbc_comboBox_trim);

		JLabel lblYear = new JLabel("Year");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.WEST;
		gbc_lblYear.insets = new Insets(0, 50, 5, 5);
		gbc_lblYear.gridx = 0;
		gbc_lblYear.gridy = 4;
		frame.getContentPane().add(lblYear, gbc_lblYear);

		String yearStr[] = { "<2000", "2000-2005", "2006-2010", "2011-2015" };
		comboBox_year = new JComboBox(yearStr);
		GridBagConstraints gbc_comboBox_year = new GridBagConstraints();
		gbc_comboBox_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_year.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_year.gridx = 1;
		gbc_comboBox_year.gridy = 4;
		frame.getContentPane().add(comboBox_year, gbc_comboBox_year);

		JLabel lblPricerange = new JLabel("PriceRange");
		GridBagConstraints gbc_lblPricerange = new GridBagConstraints();
		gbc_lblPricerange.anchor = GridBagConstraints.EAST;
		gbc_lblPricerange.insets = new Insets(0, 50, 5, 20);
		gbc_lblPricerange.gridx = 0;
		gbc_lblPricerange.gridy = 5;
		frame.getContentPane().add(lblPricerange, gbc_lblPricerange);

		String priceStr[] = { "<10000", "10000-15000", "15000-20000", "20000-25000", "25000-30000", "30000-50000",
				">50000" };
		comboBox_price = new JComboBox(priceStr);
		GridBagConstraints gbc_comboBox_price = new GridBagConstraints();
		gbc_comboBox_price.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_price.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_price.gridx = 1;
		gbc_comboBox_price.gridy = 5;
		frame.getContentPane().add(comboBox_price, gbc_comboBox_price);

		JLabel lblKeyWords = new JLabel("Key Words");
		GridBagConstraints gbc_lblKeyWords = new GridBagConstraints();
		gbc_lblKeyWords.anchor = GridBagConstraints.WEST;
		gbc_lblKeyWords.insets = new Insets(0, 50, 5, 5);
		gbc_lblKeyWords.gridx = 0;
		gbc_lblKeyWords.gridy = 6;
		frame.getContentPane().add(lblKeyWords, gbc_lblKeyWords);

		keyWords = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		frame.getContentPane().add(keyWords, gbc_textField);
		keyWords.setColumns(13);

		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 7;
		frame.getContentPane().add(btnSearch, gbc_btnSearch);

		Cancel = new JButton("Cancel");
		GridBagConstraints gbc_Cancel = new GridBagConstraints();
		gbc_Cancel.anchor = GridBagConstraints.EAST;
		gbc_Cancel.gridx = 1;
		gbc_Cancel.gridy = 7;
		frame.getContentPane().add(Cancel, gbc_Cancel);

	}

	private void addListeners() {
		ButtonClick bc = new ButtonClick();
		categoryNew.addActionListener(bc);
		categoryUsed.addActionListener(bc);
		categoryCertified.addActionListener(bc);
		btnSearch.addActionListener(bc);
		Cancel.addActionListener(bc);
		selectAction s = new selectAction();
		comboBox_brand.addActionListener(s);
		comboBox_trim.addActionListener(s);
		comboBox_model.addActionListener(s);
		comboBox_price.addActionListener(s);
		comboBox_year.addActionListener(s);

	}

	class ButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (categoryNew.isSelected())
				category[0] = categoryNew.isSelected();

			if (!categoryNew.isSelected())
				category[0] = categoryNew.isSelected();

			if (categoryUsed.isSelected())
				category[1] = categoryUsed.isSelected();
			if (!categoryUsed.isSelected())
				category[1] = categoryUsed.isSelected();
			if (categoryCertified.isSelected())
				category[2] = categoryCertified.isSelected();
			if (!categoryCertified.isSelected())
				category[2] = categoryCertified.isSelected();

			if (e.getSource() == btnSearch) {
				sf.setKeywords(keyWords.getText());
				sf.setCategory(category);
				tableM.setCars(carManager.search(sf));
				frame.dispose();
			}

			if (e.getSource() == Cancel) {

				frame.dispose();
			}
		}

	}

	class selectAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			String choice = cb.getSelectedItem().toString();
			Range r, p;

			if (cb == comboBox) {
				sf.setMake(choice);
			} else if (cb == comboBox_model) {
				sf.setModel(choice);
			} else if (cb == comboBox_trim) {
				sf.setTrim(choice);
			} else if (cb == comboBox_price) {
				if (choice == "<2000") {
					r = new Range(0, 2000);
				} else if (choice == "2000-2005") {
					r = new Range(2000, 2005);
				} else if (choice == "2006-2010") {
					r = new Range(2006, 2010);
				} else {
					r = new Range(2011, 2015);
				}
				sf.setYear(r);
			} else {
				if (choice == "<10000") {
					p = new Range(0, 10000);
				} else if (choice == "10000-15000") {
					p = new Range(10000, 15000);
				} else if (choice == "15000-20000") {
					p = new Range(15000, 20000);
				} else if (choice == "20000-25000") {
					p = new Range(20000, 25000);
				} else if (choice == "25000-30000") {
					p = new Range(25000, 30000);
				} else if (choice == "30000-50000") {
					p = new Range(30000, 50000);
				} else {
					p = new Range(50000, Integer.MAX_VALUE);
				}
				sf.setRange(p);
			}
		}

	}

}
