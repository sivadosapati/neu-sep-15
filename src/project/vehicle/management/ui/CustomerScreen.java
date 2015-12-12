package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;
import project.vehicle.management.data.access.CarManagerImpl;

public class CustomerScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 252713049595839409L;
	
	private JButton searchButton;
	private JTextField searchTextField;
	private JLabel searchLabel;
	private JLabel sortLabel;
	private JComboBox sortComboBox;
	private JCheckBox chckbxNew,chckbxUsed,chckbxCertified;
	private boolean[] Category={false,false,false};
	private JTable table;

	private CarManager carManager;

	public CustomerScreen() {
		init();
	}
	
	public CustomerScreen(CarManager carManager) {
		this.carManager = carManager;
		init();
	}

	public static void main(String[] args) throws Exception {
		CarManager carManager = new CarManagerFactory()
				.getCarManager("gmps-bresee");
		new CustomerScreen(carManager);
	}

	private void init() {
		initSearchPane();
		initTablePane();
		initchoosePane();

		
		setTitle("CustomerScreen ——>Dealer: " + ((CarManagerImpl) carManager).getDealerID());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 0);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 200,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		setVisible(true);
		addListeners();
		
	}

	private void addListeners() {
		ButtonClick bc = new ButtonClick();
		searchButton.addActionListener(bc);
		SortSelection ss = new SortSelection();
		sortComboBox.addActionListener(ss);
		
	}
	
	
	class ButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == searchButton){
				String text = searchTextField.getText()+" ";
				if(text.endsWith(" ")){
					String words[] = text.split(" ");
					for (int i=0; i< words.length; i++){
						System.out.println(words[i]);
					}
				} else {
					System.out.println("Wrong");
				}
			}
			
		}
		
	} 
	
	class SortSelection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			JComboBox sortComboBox = (JComboBox) ae.getSource();
			String selectedSort = (String) sortComboBox.getSelectedItem();
			System.out.println(selectedSort);
			
			}
		
	} 
		
	private void initchoosePane() {

		JPanel choosecondiPanel=new JPanel();
		choosecondiPanel.setLayout(new BoxLayout(choosecondiPanel, BoxLayout.Y_AXIS)); 
		//GridLayout gl=new GridLayout(6,1);
		//choosecondiPanel.setLayout(gl);
		
		JPanel checkboxPanel=new JPanel();
		
		chckbxNew = new JCheckBox("new");
		checkboxPanel.add(chckbxNew);
		
		chckbxUsed = new JCheckBox("used");
		checkboxPanel.add(chckbxUsed);
		
		chckbxCertified = new JCheckBox("certified");
		checkboxPanel.add(chckbxCertified);
		
		clickCheckAction cna=new clickCheckAction();
		chckbxNew.addActionListener(cna);
		chckbxUsed.addActionListener(cna);
		chckbxCertified.addActionListener(cna);
		
		choosecondiPanel.add(checkboxPanel);
		
		JPanel brandComboPanel=new JPanel();
		JLabel lblBrand = new JLabel("brand");
		brandComboPanel.add(lblBrand);
		
		String brandStr[]={"BMW","Toyota","Cameri"};
		JComboBox comboBox = new JComboBox(brandStr);
		comboBox.setSelectedItem(null);
		brandComboPanel.add(comboBox);
		selectAction sa=new selectAction();
		comboBox.addActionListener(sa);
		brandComboPanel.add(lblBrand);
		brandComboPanel.add(comboBox);
		choosecondiPanel.add(brandComboPanel);
		
		
		JPanel modelComboPanel=new JPanel();
		//modelComboPanel.setLayout(new FlowLayout());
		JLabel lblModel = new JLabel("model");
		modelComboPanel.add(lblModel);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setSelectedItem(null);
		modelComboPanel.add(comboBox_1);
		choosecondiPanel.add(modelComboPanel);
		
		JPanel trimComboPanel=new JPanel();
		JLabel lblTrim = new JLabel("trim");
		trimComboPanel.add(lblTrim);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setSelectedItem(null);
		trimComboPanel.add(comboBox_2);
		choosecondiPanel.add(trimComboPanel);
		
 
		JPanel yearComboPanel=new JPanel();
		JLabel lblYear = new JLabel("year");
		yearComboPanel.add(lblYear);
		
		String yearStr[]={"<2000","2000-2005","2006-2010","2011-2015"};
		JComboBox comboBox_3 = new JComboBox(yearStr);
		comboBox_3.setSelectedItem(null);
		yearComboPanel.add(comboBox_3);
		choosecondiPanel.add(yearComboPanel);
		
		JPanel prComboPanel=new JPanel();
		JLabel lblPR = new JLabel("price");
		prComboPanel.add(lblPR);
		
		String priceStr[]={"<10000","10000-15000","15000-20000","20000-25000","25000-30000","30000-50000",">50000"};
		JComboBox comboBox_4 = new JComboBox(priceStr);
		comboBox_4.setSelectedItem(null);
		prComboPanel.add(comboBox_4);
		choosecondiPanel.add(prComboPanel);
		
		
		
		getContentPane().add("West",choosecondiPanel);
		
	}
	class clickCheckAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox cb=(JCheckBox)e.getSource();
			if(cb==chckbxNew){
			Category[0]=true;
			System.out.print("here");
			}else if(cb==chckbxUsed){
				Category[1]=true;
			}else if(cb==chckbxCertified){
				Category[2]=true;
			}
			                                                 //add calling method(Category[]) here
			//SearchTilter sf=new SearchFilter();
			//sf.setCategory(Category[]);
		}
		
	}
	class selectAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb=(JComboBox)e.getSource();
			String choice = cb.getSelectedItem().toString();
			//add set(choice) method
			
		}
		
	}

	private void initSearchPane() {
		// create
		searchButton = new JButton("Search");
		searchTextField = new JTextField(20);
		searchLabel = new JLabel("Search:");
		sortLabel = new JLabel("Sort By:");
		String[] sortStrings = { "Price (Low to High)", "Price (High to Low)"};
		sortComboBox = new JComboBox(sortStrings);
		// add
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

	class CarTableModel implements TableModel {
		private List<Car> cars;
		private List<Object[]> carList;
		private String[] columnNames = {"Category", "Year", "Brand", 
				"Model", "Trim", "Price", "Detail" };
		
		public CarTableModel(List<Car> cars) {
			this.cars = cars;
			carList = new ArrayList<Object[]>();
			for (int i = 0; i < cars.size(); i++) {
				project.vehicle.management.data.Category category = cars.get(i).getCategory();
				String year = cars.get(i).getYear().toString();
				String make = cars.get(i).getMake();
				String model = cars.get(i).getModel();
				String trim = cars.get(i).getTrim();
				float price = cars.get(i).getPrice();
				Object[] object = {category, year, make, model, trim, price};
				carList.add(object);
			}
		}
		
		@Override
		public int getRowCount() {
			return cars.size();
		}

		@Override
		public int getColumnCount() {
			return 6;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if (columnIndex == 0) {
				return project.vehicle.management.data.Category.class;
			}
			if (columnIndex == 1) {
				return Integer.class;
			}
			if (columnIndex >= 2 && columnIndex <= 5) {
				return String.class;
			}
			return float.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {			
			return carList.get(rowIndex)[columnIndex];
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}
	}


	private void initTablePane() {
		List<Car> cars = new ArrayList<Car>();
		Car car1 = new Car("iddd", "gumenee", project.vehicle.management.data.Category.USED, 1990, 
				"makehahah", "heihei", "enne", "123456", (float) 8);
		Car car2 = new Car("iddd", "gumenee", project.vehicle.management.data.Category.NEW, 1990, 
				"makehahah", "heihei", "enne", "123456", (float) 8);
		cars.add(car1);
		cars.add(car2);
		table = new JTable(new CarTableModel(cars));
		TableColumnModel tcm = table.getColumnModel();
		TableColumn tc1 = tcm.getColumn(0);
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add("Center", scrollPane);
	}
}

class CustomerTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8292751322081951693L;
	public Object[][] values;

	public CustomerTableModel(Object[][] values) {
		this.values = values;
	}

	@Override
	public int getRowCount() {
		return values.length;
	}

	@Override
	public int getColumnCount() {
		return values[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return values[rowIndex][columnIndex];
	}
}

class ImageRenderer extends JLabel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1977070335905914163L;

	public ImageRenderer(String url) {
		super();
		setText("<html><body><image width='" + 200 + "' height='" + 180
				+ "' src=" + url + "'></img></body></html>");
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			super.setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}
		return this;
	}
}

class ButtonRenderer extends JPanel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonRenderer() {
		JButton button = new JButton("View Detail");
		add(button);
		setBackground(new Color(255, 255, 255));
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		return this;
	}
}

class ButtonEditor extends JButton implements TableCellEditor {
	protected EventListenerList listenerList = new EventListenerList();

	@Override
	public Object getCellEditorValue() {

		return null;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		return this;
	}

}