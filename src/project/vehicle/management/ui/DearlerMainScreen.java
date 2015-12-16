package project.vehicle.management.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class DearlerMainScreen extends JFrame {
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

	private List<Integer> operateIndex = null;
	private String[] items;

	private CarManager dealer;

	public DearlerMainScreen(String dealerID) throws IOException {
		this.dealer = new CarManagerFactory().getCarManager(dealerID);
		create();
		add();
		addListeners();
		display();
	}

	public DearlerMainScreen() {
		create();
		add();
		addListeners();
		display();
	}

	public void create() {
		String[] firstline = { "selection", "carId", "dealerId", "category", "year", "make", "model", "trim", "type",
				"price" };
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
		resultTable.setRowHeight(20);
		setColumn();
		resultScroll = new JScrollPane(resultTable);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public void add() {
		Container con = getContentPane();
		con.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		placeComponent(gbc, 0, 0, 0, 0, 4, gbc.gridheight, 0, 0);
		con.add(head, gbc);
		placeComponent(gbc, 1, 0, 0, 1, 1, gbc.gridheight, 0, 0);
		gbc.insets = new Insets(40, 10, 20, 10);
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

	private void placeComponent(GridBagConstraints gbc, double weightx, double weighty, int gridx, int gridy,
			int gridwidth, int gridheight, int ipadx, int ipady) {
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.ipadx = ipadx;
		gbc.ipady = ipady;
	}

	private void setColumn() {
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

	public void addListeners() {
		BottonClicked buttonListener = new BottonClicked();
		searchButton.addActionListener(buttonListener);
		addButton.addActionListener(buttonListener);
		updateButton.addActionListener(buttonListener);
		deleteButton.addActionListener(buttonListener);
	}

	class BottonClicked implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == searchButton) {
				new DealerSearchFunc(dealer, tableM);
			} else if (e.getSource() == addButton)
				new DealerAddFunc((CarManagerImpl) dealer, tableM);
			else if (e.getSource() == updateButton) {
				try {
					if (operateIndex.isEmpty())
						JOptionPane.showMessageDialog(new JButton(), "You have to select at least one car !",
								"Can't update!", JOptionPane.ERROR_MESSAGE);
					else
						new DealerUpdate(dealer, operateIndex, tableM);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (e.getSource() == deleteButton) {
				if (operateIndex.isEmpty())
					JOptionPane.showMessageDialog(new JButton(), "You have to select at least one car !",
							"Can't delete", JOptionPane.ERROR_MESSAGE);
				else
					new DealerDelFunc(dealer, operateIndex, tableM);
			}
		}

	}

	class MyTableModel extends AbstractTableModel {
		private String[] Items = null;
		private List<Car> cars = null;
		private List<Boolean> boolBox = null;
		private boolean updatePermition;

		public MyTableModel(String[] items, List<Car> cars) {
			super();
			this.updatePermition = false;
			this.Items = items;
			this.setCars(cars);
			this.boolBox = new ArrayList<>();
			for (int i = 0; i < cars.size(); i++)
				boolBox.add(new Boolean(false));
		}

		public int getColumnCount() {
			return Items.length;
		}

		public int getRowCount() {
			return getCars().size();
		}

		public String getColumnName(int col) {
			return Items[col];
		}

		public Object getValueAt(int row, int col) {
			Car oneCar = getCars().get(row);
			switch (col) {
			case 0:
				return boolBox.get(row);
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

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			// Note that the data/cell address is constant,
			// no matter where the cell appears onscreen.
			if (col > 0) {
				if (updatePermition == false)
					return false;
				else
					return true;
			} else {
				return true;
			}
		}

		public void setValueAt(Object value, int row, int col) {
			if (col == 0) {
				boolBox.set(row, (Boolean) value);
				fireTableCellUpdated(row, col);
				// System.out.println(value);
				if (boolBox.get(row).equals(true)) {
					operateIndex.add(row);
				} else {
					operateIndex.remove((Integer) row);
				}
			} else if (updatePermition) {
				Car val = ((Car) value);
				cars.get(row).setCategory(val.getCategory());
				cars.get(row).setMake(val.getMake());
				cars.get(row).setModel(val.getModel());
				cars.get(row).setTrim(val.getTrim());
				cars.get(row).setType(val.getType());
				cars.get(row).setYear(val.getYear());
				cars.get(row).setPrice(val.getPrice());
				this.fireTableRowsUpdated(0, cars.size() - 1);
			}
		}

		public List<Car> getCars() {
			return cars;
		}

		public void setCars(List<Car> cars) {
			this.cars = cars;
		}

		public void searchCars(List<Car> cars) {
			this.cars = cars;
			this.fireTableRowsUpdated(0, tableM.getRowCount() - 1);
			resultTable.updateUI();
		}

		public void deleteTable(List<Integer> ret) {
			this.fireTableRowsDeleted(0, this.getRowCount() - 1);
			resultTable.updateUI();
		}

		public void addTable(Car addedCar) {
			boolBox.add(new Boolean(false));
			this.fireTableRowsInserted(this.getRowCount() - 3, this.getRowCount() - 1);
			resultTable.updateUI();
		}

		public void updateTable(List<Integer> ret, List<Car> updatedCars) {
			updatePermition = true;
			for (int i = 0; i < ret.size(); i++)
				this.setValueAt(updatedCars.get(i), ret.get(i), 1);
			resultTable.updateUI();
			updatePermition = false;
		}

	}

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
