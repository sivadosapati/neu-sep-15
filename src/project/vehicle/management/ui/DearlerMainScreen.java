package project.vehicle.management.ui ;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Dealer;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;



public class DearlerMainScreen extends JFrame {
	private JButton addButton;
	private JButton searchButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JTable resultTable;
	private JScrollPane resultScroll;
	private JLabel head = null;
	private BufferedImage buttonIcon = null;
	private BufferedImage buttonIcon2 = null;
	private BufferedImage buttonIcon3 = null;
	private BufferedImage buttonIcon4 = null;
	
	private List<Car> operatedList = null;
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
		String[] firstline = {"selection","carId","dealerId","category","year","make","model","trim","type","price"};
		items = firstline;
		operatedList = new ArrayList<Car>();
		
		try {
			buttonIcon = ImageIO.read(new File("pictures/search.png"));
			buttonIcon2 = ImageIO.read(new File("pictures/add.png"));
			buttonIcon3 = ImageIO.read(new File("pictures/delete.png"));
			buttonIcon4 = ImageIO.read(new File("pictures/update.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		addButton = new JButton(new ImageIcon(buttonIcon2));
		addButton.setMargin(new Insets(0,0,0,0));
		searchButton = new JButton(new ImageIcon(buttonIcon));
		searchButton.setMargin(new Insets(0, 0, 0, 0));
		deleteButton = new JButton(new ImageIcon(buttonIcon3));
		deleteButton.setMargin(new Insets(0,0,0,0));
		updateButton = new JButton(new ImageIcon(buttonIcon4));
		updateButton.setMargin(new Insets(0, 0, 0, 0));
		head = new JLabel(new ImageIcon("pictures/DealerScreen.jpg"));
		
		resultTable = new JTable(new MyTableModel(items, dealer.listCars()));
		resultTable.setRowHeight(20);
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
		gbc.insets = new Insets(40,10,20,10);
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

	private void placeComponent(GridBagConstraints gbc, double weightx, double weighty, int gridx, int gridy, int gridwidth, int gridheight, int ipadx, int ipady) {
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.ipadx = ipadx;
		gbc.ipady = ipady;
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
			if(e.getSource() == searchButton)
				;
			else if(e.getSource() == addButton)
				;//new DeaerAddFunc(dealer);
			else if(e.getSource() == updateButton){
				;
				/*for(int i = 0; i<operatedList.size(); i++){
					for(int l = 0; l<items.length; l++)
						System.out.print(results[operatedList.get(i)][l]);
					System.out.println("");
				}*/
			}
			else if(e.getSource() == deleteButton)
				;//new DealerDelFunc(ret);
		}
		
	}
    
	class MyTableModel extends AbstractTableModel {	
		private String[] Items = null;
		private List<Car> cars = null;
		private boolean[] boolBox = null;
		
		public MyTableModel(String[] items, List<Car> cars) {
			super();
			this.Items = items;
			this.cars = cars;
			this.boolBox = new boolean[cars.size()];
			
		}

		public int getColumnCount() {
            return Items.length;
        }

        public int getRowCount() {
            return cars.size();
        }

        public String getColumnName(int col) {
            return Items[col];
        }

        public Object getValueAt(int row, int col) {
            Car oneCar = cars.get(row);
        	switch(col){
        	case 0:
        		return new Boolean(boolBox[row]);
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
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col>0) {
                return false;
            } else {
                return true;
            }
        }
        
        public void setValueAt(Object value, int row, int col) {
        	if(col == 0){
        		boolBox[row] = (boolean) value;
            	fireTableCellUpdated(row, col);
            	operatedList.add(cars.get(row));
            }
        }
	}
	
	/*class DataFetcher {
		private File file;
		private FileInputStream inputStr;
		private InputStreamReader inputReader; 
		private BufferedReader readBuffer;
		private String result;//Store one line read from file
		private ArrayList<String[]> storeBox = new ArrayList<>();//String list to store the file string
		
		public Object[][] readTheFile(String filePath, int collength) throws IOException {
			if(filePath == null)
				throw new FileNotFoundException();

			file = new File(filePath);
			inputStr = new FileInputStream(file);
			inputReader = new InputStreamReader(inputStr);
			readBuffer = new BufferedReader(inputReader);
			String[] res = new String[collength-1];
			readBuffer.readLine();
			while((result = readBuffer.readLine()) != null){
				if(!result.isEmpty()){
					res = result.split("~");
					storeBox.add(res);
				}
			}
			System.out.println(collength+" "+storeBox.size()+" "+res.length+" "+storeBox.get(1).length);
			Object[][] ret = new Object[storeBox.size()][collength+1];
			for(int i = 0; i<storeBox.size(); i++){
				ret[i][0] = new Boolean(false);
				res = storeBox.get(i);
				for(int l = 0; l<collength-1; l++)
					ret[i][l+1] = res[l];
			}
					
			return ret;
		}
		
	}*/
	
	public void display() {
		setSize(1200, 730);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			new DearlerMainScreen("gmps-camino");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			Dealer one = new Dealer("gmps-curry");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
