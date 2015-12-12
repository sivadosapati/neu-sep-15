package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

import finalProject.CustomerScreen.clickCheckAction;
import finalProject.CustomerScreen.selectAction;
import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;

public class CustomerScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 252713049595839409L;
	// Components that Nan added
	private JButton searchButton;
	private JTextField searchTextField;
	private JLabel searchLabel;
	private JLabel sortLabel;
	private JComboBox sortComboBox;
	private JCheckBox chckbxNew,chckbxUsed,chckbxCertified;
	private boolean[] Category={false,false,false};

	private JTable table;

	private CarManager carManager;

	public CustomerScreen(CarManager carManager) {
		this.carManager = carManager;
		init();
	}

	public static void main(String[] args) throws Exception {
		CarManager carManager = new CarManagerFactory()
				.getCarManager("gmps-bresee");
		new CustomerScreen(carManager);
	}

	public CustomerScreen() {
		init();
	}

	private void init() {
		initSearchPane();
		initTablePane();
		initchoosePane();

		
		setTitle("Customer Screen");
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
		// SortSelection ss = new SortSelection();
		//sortComboBox.addActionListener(ss);
		
	}
	
	
	class ButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == searchButton){
				String text = searchTextField.getText();
				if(text.endsWith(" ")){
					String words[] = text.split(" ");
					for (int i=0; i< words.length; i++){
						System.out.println(words[i]);
					}
				} else {
					System.out.println("Test");
				}
			}
			
		}
		
	}
	
	/* class SortSelection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			JComboBox<String> combo = (JComboBox<String>)ae.getSource();
			String sortString = (String)combo.getSelectedItem();
			if(sortString.equals("Price (Low to High)")){
				System.out.println("1");
			} else if(sortString.equals("Price (High to Low)")){
				System.out.println("2");
		}
		
	} */
	
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
		private String[] columnNames = { "Photo", "Specs", "Detail" };

		@Override
		public int getRowCount() {
			return cars.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if (columnIndex == 0) {
				return ImageIcon.class;
			}
			if (columnIndex == 1) {
				return String.class;
			}
			return JButton.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Car c = cars.get(rowIndex);
			if (columnIndex == 0) {
				// return c.getImage();
			}
			return null;
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
		String col2 = "<html>Category: " + "New" + "<br/><br/>Year:   "
				+ "2012" + "<br/><br/>Make:   " + "Fort"
				+ "<br/><br/>Model:   " + "SUV" + "<br/><br/>Type:   " + "Car"
				+ "<br/><br/>Price:   " + "4.55" + "$</html>";
		Object[][] values = { { "Image", col2, "" }, { "Image", col2, "" },
				{ "Image", col2, "" }, { "Image", col2, "" } };
		table = new JTable(new CustomerTableModel(values));
		// table = new JTable( )
		table.setRowHeight(180);
		TableColumnModel tcm = table.getColumnModel();
		TableColumn tc1 = tcm.getColumn(0);
		tc1.setPreferredWidth(50);
		tc1.setCellRenderer(new ImageRenderer(
				"http://webneel.com/wallpaper/sites/default/files/images/07-2013/1%20mercedes%20car%20wallpaper.jpg"));
		TableColumn tc2 = tcm.getColumn(2);
		tc2.setCellRenderer(new ButtonRenderer());
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