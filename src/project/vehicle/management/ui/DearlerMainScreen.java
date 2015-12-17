package project.vehicle.management.ui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;
import project.vehicle.management.data.access.CarManagerImpl;


/**
 * The class of dealer main screen, containing four buttons and a table.
 * This class could show the dealer's car list in the table and
 * search, add, update, and delete cars for dealers.
 * 
 * @author Anderson (Jian Hou)
 * @version 11.2
 * 
 * @see JFrame
 * */
public class DearlerMainScreen extends JFrame {
	/** The components of dealer main screen. */
	private JButton addButton;
	private JButton searchButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JTable resultTable;
	private JScrollPane resultScroll;
	private JLabel head = null;
	private MyTableModel tableM = null;
	private BufferedImage buttonIcon = null;
	private BufferedImage buttonIcon2 = null;
	private BufferedImage buttonIcon3 = null;
	private BufferedImage buttonIcon4 = null;

	/** The data structure of dealer operation */
	private List<Integer> operateIndex = null;
	private String[] items;
	private CarManager dealer;

	/** 
	 * The constructor of class dealer main screen.
	 * 
	 * @see project.vehicle.management.data.Dealer
	 * @see CarManagerFactory
	 * @see CarManager
	 * 
	 * @param dealerID the id of dealer who performing the operation
	 * @exception IOException throw when file of dealer is not opened successfully
	 * 
	 *  */
	public DearlerMainScreen(String dealerID) throws IOException {
		this.dealer = new CarManagerFactory().getCarManager(dealerID);
		create();
		add();
		addListeners();
		display();
	}

	/** 
	 * The constructor of class dealer main screen.
	 *  */
	public DearlerMainScreen() {
		create();
		add();
		addListeners();
		display();
	}

	/** 
	 * Creating the components of dealer screen and pictures of page head and buttons
	 * 
	 * @see ArrayList
	 * @see ImageIO#read(File)
	 * @see JButton
	 * @see JTable
	 * @see JScrollPane
	 *  */
	private void create() {
		String[] firstline = { "selection", "carId", "dealerId", "category", "year",
								"make", "model", "trim", "type", "price" };
		items = firstline;
		operateIndex = new ArrayList<>();

		try {
			buttonIcon = ImageIO.read(new File("pictures/search.png"));
			buttonIcon2 = ImageIO.read(new File("pictures/add.png"));
			buttonIcon3 = ImageIO.read(new File("pictures/delete.png"));
			buttonIcon4 = ImageIO.read(new File("pictures/update.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addButton = new JButton(new ImageIcon(buttonIcon2));
		addButton.setMargin(new Insets(0, 0, 0, 0));
		searchButton = new JButton(new ImageIcon(buttonIcon));
		searchButton.setMargin(new Insets(0, 0, 0, 0));
		deleteButton = new JButton(new ImageIcon(buttonIcon3));
		deleteButton.setMargin(new Insets(0, 0, 0, 0));
		updateButton = new JButton(new ImageIcon(buttonIcon4));
		updateButton.setMargin(new Insets(0, 0, 0, 0));

		addButton.setBorderPainted(false);
		searchButton.setBorderPainted(false);
		deleteButton.setBorderPainted(false);
		updateButton.setBorderPainted(false);

		head = new JLabel(new ImageIcon("pictures/DealerScreen.jpg"));

		tableM = new MyTableModel(items, dealer.listCars());
		resultTable = new JTable(tableM);
		setColumn();
		resultScroll = new JScrollPane(resultTable);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/** 
	 * Adding the components to the dealer screen 
	 * 
	 * @see Container#add(java.awt.Component, Object)
	 * @see GridBagConstraints
	 *  */
	private void add() {
		Container con = getContentPane();
		con.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		placeComponent(gbc, 0, 0, 0, 0, 4, gbc.gridheight, 0, 0);
		con.add(head, gbc);
		placeComponent(gbc, 1, 0, 0, 1, 1, gbc.gridheight, 0, 0);
		gbc.insets = new Insets(20, 12, 20, 12);
		con.add(searchButton, gbc);
		placeComponent(gbc, gbc.weightx, gbc.weighty, 1, 1, gbc.gridwidth, gbc.gridheight, 0, 0);
		con.add(addButton, gbc);
		placeComponent(gbc, gbc.weightx, gbc.weighty, 2, 1, gbc.gridwidth, gbc.gridheight, 0, 0);
		con.add(updateButton, gbc);
		placeComponent(gbc, gbc.weightx, gbc.weighty, 3, 1, gbc.gridwidth, gbc.gridheight, 0, 0);
		con.add(deleteButton, gbc);
		placeComponent(gbc, 0, 1, 0, 3, 4, 2, 0, 0);
		gbc.insets = new Insets(0, 5, 0, 5);
		con.add(resultScroll, gbc);
	}

	/** 
	 * Placing the components on the screen
	 * 
	 * @see GridBagConstraints
	 *  */
	private void placeComponent(GridBagConstraints gbc, double weightx, double weighty, int gridx, int gridy,
								int gridwidth, int gridheight, int ipadx, int ipady) {
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.ipadx = ipadx;
		gbc.ipady = ipady;
	}

	/** 
	 * Setting the table columns and rows
	 * 
	 * @see JTable#getColumnModel()
	 * @see DefaultTableCellRenderer#setHorizontalAlignment(int)
	 *  */
	private void setColumn() {
		resultTable.setRowHeight(20);
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
		resultTable.setDefaultRenderer(Object.class, dtcr);
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		resultTable.getColumnModel().getColumn(0).setMaxWidth(90);
		resultTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		resultTable.getColumnModel().getColumn(1).setMaxWidth(120);
		resultTable.getColumnModel().getColumn(2).setPreferredWidth(130);
		resultTable.getColumnModel().getColumn(2).setMaxWidth(130);
		resultTable.getColumnModel().getColumn(3).setMaxWidth(70);
		resultTable.getColumnModel().getColumn(4).setMaxWidth(70);
		resultTable.getColumnModel().getColumn(5).setMaxWidth(70);
		resultTable.getColumnModel().getColumn(6).setPreferredWidth(150);
		resultTable.getColumnModel().getColumn(6).setMaxWidth(150);
		resultTable.getColumnModel().getColumn(8).setMaxWidth(70);
		resultTable.getColumnModel().getColumn(9).setMaxWidth(70);
	}
	
	/** 
	 * Adding the button actionListeners
	 * 
	 * @see JButton#addActionListener(java.awt.event.ActionListener)
	 * @see JOptionPane#showMessageDialog(java.awt.Component, Object, String, int)
	 * @see DealerSearchFunc
	 * @see DealerAddFunc
	 * @see DealerUpdateFunc
	 * @see DealerDelFunc
	 *  */
	private void addListeners() {
		searchButton.addActionListener(e->{
			new DealerSearchFunc(dealer, tableM);});//Open the dealer search screen
		addButton.addActionListener(e -> {
			new DealerAddFunc((CarManagerImpl) dealer, tableM);});//Open the dealer addition screen
		updateButton.addActionListener(e -> {
			try {
				if (operateIndex.isEmpty())//Popping a message when the dealer didn't select any car
					JOptionPane.showMessageDialog(new JButton(), "You have to select at least one car !",
							"Can't update!", JOptionPane.ERROR_MESSAGE);
				else
					new DealerUpdate(dealer, operateIndex, tableM);//Open the dealer update screen
				} catch (IOException e1) {
				e1.printStackTrace();
				}
			});
		
		deleteButton.addActionListener(e -> {
			if (operateIndex.isEmpty())//Popping a message when the dealer didn't select any car
				JOptionPane.showMessageDialog(new JButton(), "You have to select at least one car !",
						"Can't delete", JOptionPane.ERROR_MESSAGE);
			else
				new DealerDelFunc(dealer, operateIndex, tableM);//Open the dealer deletion screen
			});
	}

	/**
	 * The class of table model which will show the list of cars of each dealer,
	 * and refresh the table when a dealer adds, updates, searches or deletes cars.
	 * 
	 * @see AbstractTableModel
	 * */
	class MyTableModel extends AbstractTableModel {
		private String[] Items = null;
		private List<Car> cars = null;
		private List<Boolean> boolBox = null;
		private boolean updatePermition;

		/** 
		 * The constructor of class MyTableModel.
		 * 
		 * @see Car
		 * 
		 * @param items the items of table
		 * @param cars the list of cars would show in the table
		 *  */
		public MyTableModel(String[] items, List<Car> cars) {
			super();
			this.updatePermition = false;
			this.Items = items;
			this.setCars(cars);
			this.boolBox = new ArrayList<>();
			for (int i = 0; i < cars.size(); i++)
				boolBox.add(new Boolean(false));
		}

		/** 
		 * Get the number of columns
		 * 
		 * @return the length of items String array
		 *  */
		public int getColumnCount() {
			return Items.length;
		}

		/** 
		 * Get the number of rows
		 * 
		 * @return the size of list of cars
		 * @see #getCars()
		 *  */
		public int getRowCount() {
			return getCars().size();
		}

		/** 
		 * Get the name of columns
		 * 
		 * @param the number of column
		 * @return the String of item in this position
		 *  */
		public String getColumnName(int col) {
			return Items[col];
		}

		/** 
		 * Get the value of this position (row, col)
		 * 
		 * @param row the row number of table
		 * @param col the column number of table
		 * @return the value of this position(row, col)
		 * @see Car
		 *  */
		public Object getValueAt(int row, int col) {
			Car oneCar = getCars().get(row);
			switch (col) {
			case 0:
				return this.boolBox.get(row);
			case 1:
				return oneCar.getID();
			case 2:
				return oneCar.getDealerID();
			case 3:
				return oneCar.getCategory();
			case 4:
				return oneCar.getYear();
			case 5:
				return oneCar.getMake();
			case 6:
				return oneCar.getModel();
			case 7:
				return oneCar.getTrim();
			case 8:
				return oneCar.getType();
			case 9:
				return oneCar.getPrice();
			default:
				return null;
			}
		}

		/** 
		 * Get the class of one column
		 * 
		 * @param the column number of table
		 * @return the class of this column
		 * @see #getValueAt(int, int)
		 * @see #getClass()
		 *  */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/** 
		 * Judging if this cell is editable.
		 * 
		 * @param row the row number of table
		 * @param col the column number of table
		 * @return true if this cell is editable, false if this cell is not editable
		 *  */
		public boolean isCellEditable(int row, int col) {
			if (col > 0) {
				if (updatePermition == false)
					return false;
				else
					return true;
			} else {
				return true;
			}
		}

		/** 
		 * Set the value of this position
		 * 
		 * @param row the row number of table
		 * @param col the column number of table
		 * @param value the value will fill into the cell
		 * @see #fireTableRowsUpdated(int, int)
		 * @see #fireTableCellUpdated(int, int)
		 * @see Car
		 *  */
		public void setValueAt(Object value, int row, int col) {
			if (col == 0) {
				boolBox.set(row, (Boolean) value);
				fireTableCellUpdated(row, col);
				if (boolBox.get(row).equals(true)) {
					operateIndex.add(row);
				} else {
					operateIndex.remove((Integer) row);
				}
			} else if (updatePermition) {
				if(value == null){//if value is null delete this row
					boolBox.remove(row);
					cars.remove(row);
				}
				else{
					Car val = ((Car) value);
					cars.get(row).setCategory(val.getCategory());
					cars.get(row).setMake(val.getMake());
					cars.get(row).setModel(val.getModel());
					cars.get(row).setTrim(val.getTrim());
					cars.get(row).setType(val.getType());
					cars.get(row).setYear(val.getYear());
					cars.get(row).setPrice(val.getPrice());
					boolBox.set(row, new Boolean(false));
				}
				this.fireTableRowsUpdated(0, cars.size() - 1);
			}
		}

		/** 
		 * Get the list of cars of this table
		 * 
		 * @return the list of cars of this table
		 *  */
		public List<Car> getCars() {
			return cars;
		}

		/** 
		 * Set the list of cars of table
		 * 
		 * @param cars the list of cars will show in the table
		 *  */
		public void setCars(List<Car> cars) {
			this.cars = cars;
		}

		/** 
		 * Refresh the table after dealer finish the search operation
		 * 
		 * @param cars the list of cars getting from the Search function
		 * @see JTable#updateUI()
		 *  */
		public void searchCars(List<Car> cars) {
			this.cars = cars;
			if(cars.size()<boolBox.size())
				for(int i = boolBox.size()-1; i>=cars.size(); i--)
					this.boolBox.remove(i);
			else
				for(int i = boolBox.size()-1; i<cars.size()-1; i++)
					this.boolBox.add(new Boolean(false));
			operateIndex.clear();
			resultTable.updateUI();
		}

		/** 
		 * Refresh the table after dealer finish the delete operation
		 * 
		 * @param ret the list of indexes of rows at which car has been deleted
		 * @see JTable#updateUI()
		 * @see #fireTableRowsDeleted(int, int)
		 * @see #setValueAt(Object, int, int)
		 *  */
		public void deleteTable(List<Integer> ret) {
			updatePermition = true;
			for(int i = 0; i<ret.size(); i++){
				this.setValueAt(null, ret.get(i), 1);
			} 
			this.fireTableRowsDeleted(0, tableM.getRowCount() - 1);
			resultTable.updateUI();
			updatePermition = false;
		}

		/** 
		 * Refresh the table after dealer finish the addition operation
		 * 
		 * @param addedCar the car has been added into the car list of this dealer
		 * @see #fireTableRowsInserted(int, int)
		 * @see JTable#updateUI()
		 *  */
		public void addTable(Car addedCar) {
			boolBox.add(new Boolean(false));
			this.fireTableRowsInserted(this.getRowCount() - 3, this.getRowCount() - 1);
			resultTable.updateUI();
		}

		/** 
		 * Refresh the table after dealer finish the update operation
		 * 
		 * @param updatedCars the list of cars which has been modified
		 * @param ret the list of indexes of rows at which car has been modified
		 * @see #fireTableRowsUpdated(int, int)
		 * @see JTable#updateUI()
		 * @see #setValueAt(Object, int, int)
		 *  */
		public void updateTable(List<Integer> ret, List<Car> updatedCars) {
			updatePermition = true;
			for (int i = 0; i < ret.size(); i++)
				this.setValueAt(updatedCars.get(i), ret.get(i), 1);
			resultTable.updateUI();
			updatePermition = false;
		}

	}

	/** 
	 * Display the dealer main screen
	 * 
	 * @see #fireTableRowsUpdated(int, int)
	 * @see java.awt.Window#setSize(int width, int height)
	 * @see java.awt.Window#setVisible(boolean)
	 *  */
	public void display() {
		setSize(1200, 730);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			new DearlerMainScreen("gmps-chaparral2");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
