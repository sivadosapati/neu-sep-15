package project.vehicle.management.ui ;
import java.awt.Container;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import lecture11.NEUFrame;



public class DearlerMainScreen extends NEUFrame {
	JButton addButton;//private
	JButton searchButton;
	JButton updateButton;
	JButton deleteButton;
	JTable resultTable;
	JScrollPane resultScroll;
	ArrayList<Integer> operatedList = new ArrayList<>();
	String[] items;
	Object[][] results;
	
	@Override
	public void create() {
		String[] firstline = {"Selection","id","webId","category","year","make","model","trim","type","price"};
		items = firstline;
		addButton = new JButton("Add Product");
		searchButton = new JButton("Search");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");
		try {
			results = new DataFetcher().readTheFile("D:\\yuandaima\\javawork\\git\\neu-sep-15\\gmps-aj-dohmann", items.length);
			resultTable = new JTable(new MyTableModel(items, results));
			resultScroll = new JScrollPane(resultTable);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void add() {
		Container con = getContentPane();
		con.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		placeComponent(gbc, 1, 0, 0, 0, gbc.gridwidth, gbc.gridheight, 0, 10);
		
		gbc.insets = new Insets(40,20,40,20);
		con.add(searchButton, gbc);
		placeComponent(gbc, gbc.weightx, gbc.weighty, 1, 0, gbc.gridwidth, gbc.gridheight, 0, 10);		
		con.add(addButton, gbc);
		placeComponent(gbc, gbc.weightx, gbc.weighty, 2, 0, gbc.gridwidth, gbc.gridheight, 0, 10);
		con.add(updateButton, gbc);
		placeComponent(gbc, gbc.weightx, gbc.weighty, 3, 0, gbc.gridwidth, gbc.gridheight, 0, 10);
		con.add(deleteButton, gbc);
		placeComponent(gbc, 0, 1, 0, 2, 4, 2, 0, 0);
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
	
	@Override
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
				;
			else if(e.getSource() == updateButton){
				for(int i = 0; i<operatedList.size(); i++){
					for(int l = 0; l<items.length; l++)
						System.out.print(results[operatedList.get(i)][l]);
					System.out.println("");
				}
			}
			else if(e.getSource() == deleteButton)
				new DealerDelete();;
		}
		
	}
    
	class MyTableModel extends AbstractTableModel {	
		String[] Items = null;
		Object[][] results = null;
		private boolean DEBUG = true;
		
		public MyTableModel(String[] items, Object[][] results) {
			super();
			this.Items = items;
			this.results = results;
		}

        public int getColumnCount() {
            return Items.length;
        }

        public int getRowCount() {
            return results.length;
        }

        public String getColumnName(int col) {
            return Items[col];
        }

        public Object getValueAt(int row, int col) {
            return results[row][col];
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
        	results[row][col] = value;
            fireTableCellUpdated(row, col);
            
            operatedList.add(row);
        }
	}
	
	class DataFetcher {
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
		
	}
	
	public void display() {
		setSize(900, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DearlerMainScreen();
	}

}
