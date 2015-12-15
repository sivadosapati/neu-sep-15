
package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Range;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.SortCriteria;
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
	private JLabel header;
	private JComboBox sortComboBox,comboBox,comboBox_1,comboBox_2,comboBox_3,comboBox_4;
	private JCheckBox chckbxNew,chckbxUsed,chckbxCertified;
	private boolean[] category={false,false,false};
	
	private JTable table;
	private SearchFilter sf = new SearchFilter(null, null, null, null, null, null,null);
	private SortCriteria sc = new SortCriteria(null, true);
    boolean initcombomodel=false;
    boolean initcombotrim=false;
	private CarManager carManager;

	List<String> make,model,trim;
	public CustomerScreen() {
		init();
	}
	
	public CustomerScreen(CarManager carManager) {
		this.carManager = carManager;
		init();
	}

	private void init() {
		initSearchPane();
		List<Car> cars;
		try {
			cars = new CarManagerImpl(((CarManagerImpl) carManager).getDealerID()).search(sf);
			initTablePane(cars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //dealerID
		
		initchoosePane(carManager);

		setTitle("CustomerScreen ——>Dealer: " + ((CarManagerImpl) carManager).getDealerID());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(100, 0);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		setVisible(true);
		addListeners();
		getRootPane().setDefaultButton(searchButton);

	}

	private void initSearchPane() {
		// create
		searchButton = new JButton("Search");
		searchTextField = new JTextField(20);
		searchLabel = new JLabel("Search:");
		sortLabel = new JLabel("Sort By:");
		String[] sortStrings = { " ", "Price (Low to High)", "Price (High to Low)", "Year (Low to High)", "Year (High to Low)"};
		sortComboBox = new JComboBox(sortStrings);
		header = new JLabel(new ImageIcon("pictures/CustomerScreen.jpg"));
		// add
		BorderLayout bl = new BorderLayout();
		Container con = super.getContentPane();
		con.setLayout(bl);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel searchAndSortPanel = new JPanel();
		searchAndSortPanel.setLayout(new FlowLayout());
		searchAndSortPanel.add(searchLabel);
		searchAndSortPanel.add(searchTextField);
		searchAndSortPanel.add(searchButton);
		searchAndSortPanel.add(sortLabel);
		searchAndSortPanel.add(sortComboBox);
		JPanel headerPanel = new JPanel();
		headerPanel.add(header);
		mainPanel.add(headerPanel);
		mainPanel.add(searchAndSortPanel);
		con.add("North", mainPanel);
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
				sf.setKeywords(searchTextField.getText());
				CarManagerImpl test;
				try {
					test = new CarManagerImpl(((CarManagerImpl) carManager).getDealerID()); //dealerID
					List<Car> carAfterSearch=test.search(sf);
					table.setModel(new CarTableModel(carAfterSearch));
					table.updateUI();
					//System.out.println(carAfterSearch);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class SortSelection implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			JComboBox sortComboBox = (JComboBox) ae.getSource();
			boolean highToLow = false;
			String selectedSort = (String) sortComboBox.getSelectedItem();
			int i = selectedSort.indexOf(" ");
			String sortKeyword = selectedSort.substring(0, i);
			if(selectedSort.contains("High to Low")){
				highToLow = false;
			}else{
				highToLow = true;
			}
			sc.setAttribute(sortKeyword);
			sc.setSequence(highToLow);
			//System.out.println(sortKeyword);
			//System.out.println(highToLow);
			
			try {
				String dealerIDS= ((CarManagerImpl) carManager).getDealerID();
				CarManagerImpl testAfterSearchSort = new CarManagerImpl(dealerIDS);
				List<Car> carAfterSearchSort = carManager.sort(sf, sc);
				table.setModel(new CarTableModel(carAfterSearchSort));
				table.updateUI();
				//System.out.println(carAfterSearchSort);
				//System.out.println(sf.getKeywords() + sf.getMake() + sf.getModel() + sf.getTrim() + sf.getCategory()[0]);
				//System.out.println(sc.getAttribute() + sc.getSequence());
				//System.out.println(dealerIDS);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
    private void initchoosePane(CarManager cm) {
		
		make = cm.setMake();
		
		
		JPanel choosecondiPanel=new JPanel();
		choosecondiPanel.setLayout(new BoxLayout(choosecondiPanel, BoxLayout.Y_AXIS)); 
		//GridLayout gl=new GridLayout(6,1);
		//choosecondiPanel.setLayout(gl);
		

		JPanel checkboxPanel=new JPanel();

		chckbxNew = new JCheckBox("New");
		checkboxPanel.add(chckbxNew);

		chckbxUsed = new JCheckBox("Used");
		checkboxPanel.add(chckbxUsed);

		chckbxCertified = new JCheckBox("Certified");
		checkboxPanel.add(chckbxCertified);

		clickCheckAction cna=new clickCheckAction();
		chckbxNew.addActionListener(cna);
		chckbxUsed.addActionListener(cna);
		chckbxCertified.addActionListener(cna);

		choosecondiPanel.add(checkboxPanel);

		JPanel brandComboPanel=new JPanel();
		brandComboPanel.setLayout(new BoxLayout(brandComboPanel, BoxLayout.Y_AXIS));
		JLabel lblBrand = new JLabel("Make");
		brandComboPanel.add(lblBrand);
		//lblBrand.setLocation(30, 100);

		make.add(0, "");
		
		comboBox = new JComboBox(make.toArray());
		comboBox.setSelectedItem(null);
		//comboBox.setLocation(30, 600);
		brandComboPanel.add(comboBox);

		selectAction sa=new selectAction();
		comboBox.addActionListener(sa);
		brandComboPanel.add(lblBrand);
		brandComboPanel.add(comboBox);
		choosecondiPanel.add(brandComboPanel);


		JPanel modelComboPanel=new JPanel();
		modelComboPanel.setLayout(new BoxLayout(modelComboPanel, BoxLayout.Y_AXIS));
		JLabel lblModel = new JLabel("Model");
		modelComboPanel.add(lblModel);


		comboBox_1 = new JComboBox();
		//comboBox_1.setSelectedItem(null);
		modelComboPanel.add(comboBox_1);
		choosecondiPanel.add(modelComboPanel);

		JPanel trimComboPanel=new JPanel();
		trimComboPanel.setLayout(new BoxLayout(trimComboPanel, BoxLayout.Y_AXIS));
		JLabel lblTrim = new JLabel("Trim");
		trimComboPanel.add(lblTrim);

		comboBox_2 = new JComboBox();
		//comboBox_2.setSelectedItem(null);
		trimComboPanel.add(comboBox_2);
		choosecondiPanel.add(trimComboPanel);
		


		JPanel yearComboPanel=new JPanel();
		yearComboPanel.setLayout(new BoxLayout(yearComboPanel, BoxLayout.Y_AXIS));
		JLabel lblYear = new JLabel("Year");
		yearComboPanel.add(lblYear);

		String yearStr[]={"<2000","2000-2005","2006-2010","2011-2015"};
		comboBox_3 = new JComboBox(yearStr);
		comboBox_3.setSelectedItem(null);
		yearComboPanel.add(comboBox_3);
		choosecondiPanel.add(yearComboPanel);

		JPanel prComboPanel=new JPanel();
		prComboPanel.setLayout(new BoxLayout(prComboPanel, BoxLayout.Y_AXIS));
		JLabel lblPR = new JLabel("Price");
		prComboPanel.add(lblPR);

		String priceStr[]={"<10000","10000-15000","15000-20000","20000-25000","25000-30000","30000-50000",">50000"};
		comboBox_4 = new JComboBox(priceStr);
		comboBox_4.setSelectedItem(null);
		prComboPanel.add(comboBox_4);
		choosecondiPanel.add(prComboPanel);

		selectAction s=new selectAction();
		comboBox.addActionListener(s);
		comboBox_1.addActionListener(s);
		comboBox_2.addActionListener(s);
		comboBox_3.addActionListener(s);
		comboBox_4.addActionListener(s);


		getContentPane().add("West",choosecondiPanel);

	}
    
    public String checknull(String s){
    	if(s==""){
    		
    		return null;
    	}else{
    		return s;
    	}
    }

	class clickCheckAction implements ActionListener{ 

		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox cb=(JCheckBox)e.getSource();
			if(cb==chckbxNew){
				category[0]=(!category[0]);
			}else if(cb==chckbxUsed){
				category[1]=(!category[1]);
			}else if(cb==chckbxCertified){
				category[2]=(!category[2]);
			}
			sf.setCategory(category);
			CarManagerImpl test;
			try {
				test = new CarManagerImpl(((CarManagerImpl) carManager).getDealerID());
				List<Car> carAfterSearch=test.search(sf);
				table.setModel(new CarTableModel(carAfterSearch));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //dealerID
			table.updateUI();
		}

	}

	class selectAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb=(JComboBox)e.getSource();
			String choice = cb.getSelectedItem().toString();
			System.out.println(choice);
			Range r,p;
			
			
			List<String> model,trim;
			if(cb==comboBox){
				//if(!initcombomodel){
				//	comboBox_1.removeAllItems();
				//}
				sf.setMake(checknull(choice));
				if(choice!=""){
					//System.out.println("here1");			       
					model=carManager.setModel(sf.getMake());
					model.add(0, "");
					
					//for(String s:model){
					DefaultComboBoxModel modelm = new DefaultComboBoxModel(model.toArray());
						comboBox_1.setModel(modelm);                    
					//}                                             
					//initcombomodel=!initcombomodel;
				}else{
					System.out.println("here1");                   //brand置空清空model后再选brand无法生成model列表
					comboBox_1.removeAllItems();
					comboBox_2.removeAllItems();
				}			
				//comboBox_1 = new JComboBox(list.get(0).toArray());
				//comboBox_1.setSelectedItem(null);
			}else if(cb==comboBox_1){
				
				sf.setModel(checknull(choice));
				if(choice!=""){
					trim=carManager.setTrim(sf.getModel(), sf.getMake());
					trim.add(0, "");
					DefaultComboBoxModel trimm = new DefaultComboBoxModel(trim.toArray());
						comboBox_2.setModel(trimm);
					
				}else{
					comboBox_2.removeAllItems();
				}
			}else if(cb==comboBox_2){
				sf.setTrim(checknull(choice));
			}else if(cb==comboBox_3){
				if (choice=="<2000"){
					r=new Range(0,2000);					
				}else if(choice=="2000-2005"){
					r=new Range(2000,2005);
				}else if(choice=="2006-2010"){
					r=new Range(2006,2010);
				}else{
					r=new Range(2011,2015);
				}
				sf.setYear(r);
			}else{
				if(choice=="<10000"){
					p=new Range(0,10000);
				}else if(choice=="10000-15000"){
					p=new Range(10000,15000);
				}else if(choice=="15000-20000"){
					p=new Range(15000,20000);
				}else if(choice=="20000-25000"){
					p=new Range(20000,25000);
				}else if(choice=="25000-30000"){
					p=new Range(25000,30000);
				}else if(choice=="30000-50000"){
					p=new Range(30000,50000);
				}else{
					p=new Range(50000,Integer.MAX_VALUE);
				}
				sf.setRange(p);
			}
			CarManagerImpl test;
			try {
				test = new CarManagerImpl(((CarManagerImpl) carManager).getDealerID());
				List<Car> carAfterSearch=test.search(sf);
				table.setModel(new CarTableModel(carAfterSearch));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} //dealerID
			table.updateUI();
		}
	}
	
	class CarTableModel extends AbstractTableModel {
		private List<Car> cars;
		private List<Object[]> carList;
		private String[] columnNames = {"Category", "Year", "Brand", 
				"Model", "Trim", "Price"};
		
		public List<Car> getCars() {
			return cars;
		}

		public void setCars(List<Car> cars) {
			this.cars = cars;
		}

		public CarTableModel(List<Car> cars) {
			this.cars = cars;
			carList = new ArrayList<Object[]>();
			for (int i = 0; i < cars.size(); i++) {
				project.vehicle.management.data.Category category = cars.get(i).getCategory();
				String year = "" + cars.get(i).getYear();
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
			fireTableCellUpdated(rowIndex, columnIndex);

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

	private void initTablePane(List<Car> cars) {
		table = new JTable(new CarTableModel(cars));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				List<Car> current_cars = ((CarTableModel) table.getModel()).getCars();
				int r = table.getSelectedRow();
				if (e.getClickCount() == 2) {
					try {
						new SpecificCarScreen(current_cars.get(r));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add("Center", scrollPane);
	}

	public static void main(String[] args) throws Exception {
		CarManager carManager = new CarManagerFactory()
				.getCarManager("gmps-bresee");
		new CustomerScreen(carManager);
		
	}
}



