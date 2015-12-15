package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.ui.DearlerMainScreen.MyTableModel;

public class DealerUpdate extends JFrame {
	
	public static final int DEFAULT_WIDTH = 1200;
	public static final int DEFAULT_HEIGHT = 800;
	static Font font = new Font("Times New Roman", Font.BOLD, 18);
	private JButton cancelButton;
	private JButton submitButton;
	private JPanel panel1;
	private JPanel panel2;
	private MyTableModel t;
	private JFrame frame;
	List<Integer> origin, updated;
	List<Integer> operatedList;
	List<Car> cars;
	List<Car> operatedCars;
	CarManager update;
	

	public void addTable(){
		panel1 = new JPanel();
		GridLayout lay = new GridLayout();
		panel1.setLayout(lay);
		MyTable mytable = new MyTable(getCarList(operatedList));
		JTable table = new JTable(mytable);
//		panel1.setOpaque(true);
        	table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        	table.setFillsViewportHeight(true);
        	JScrollPane scrollPane = new JScrollPane(table);
        	panel1.add(scrollPane);
	}
	
	private List<Car> getCarList(List<Integer> carIndex) {
		operatedCars = new ArrayList<>();
		List<Car> ori = t.getCars();
		for(int i = 0; i<carIndex.size();i++){
			operatedCars.add(ori.get(carIndex.get(i)));
		}
		return operatedCars;
	}

	public void addButton(){
		cancelButton = new JButton("CANCEL");
        	submitButton = new JButton("SUBMIT");
        	cancelButton.setFont(font);
        	submitButton.setFont(font);
        	panel2 = new JPanel();
        	FlowLayout out = new FlowLayout();
        	panel2.setLayout(out);
        	panel2.add(submitButton);
        	panel2.add(cancelButton);
	}
	
	public  void display(){
		frame = new JFrame("UPDATE");
        	BorderLayout out = new BorderLayout();
        	frame.setLayout(out);
        	frame.add(panel1,"Center");
        	frame.add(panel2, "South"); 
        	frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        	frame.setLocation(850,400);
        	frame.setVisible(true);
	}
	
	public DealerUpdate(CarManager cm, List<Integer> list, MyTableModel mtm) throws IOException {
		this.t = mtm;
	    	this.operatedList = list;
	    	this.update = cm;
		addButton();
        	addTable(); 
        	display();
        	addListeners();
       
    	}

	public void addListeners() {
		ButtonClick bc = new ButtonClick();
		cancelButton.addActionListener(bc);
		submitButton.addActionListener(bc);
	}
	
	class ButtonClick implements ActionListener { 
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == submitButton){
				try {
					update(operatedCars);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
			if(e.getSource() == cancelButton){
				operatedList = origin;
				frame.dispose();
			}
		}
	}
	
	class MyTable extends AbstractTableModel {
		private String[] Items = {"ID","DealerID","Category", "Year", "Make","Model", "Trim", "Type", "Price"};
		private List<Car> cars = null;
		
		//copy data from dealer main
		public List<Integer> copy(List<Integer> operatedList){
			origin = new ArrayList<Integer>();
			for(int i = 0; i < operatedList.size(); i++){
				origin.add(operatedList.get(i));
			}
			return origin;
		}
		
		public MyTable(List<Car> cars) {
			super();
			this.cars = cars;
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
            Car oneCar = getCars().get(row);
        	switch(col){
        	case 0:
        		return oneCar.getID();
        	case 1:
        		return oneCar.getDealerID();
        	case 2:
        		return oneCar.getCategory();
        	case 3:
        		return oneCar.getYear();
        	case 4:
        		return oneCar.getMake();
        	case 5:
        		return oneCar.getModel();
        	case 6:
        		return oneCar.getTrim();
        	case 7:
        		return oneCar.getType();
        	case 8:
        		return oneCar.getPrice();
        	default:
        		return null;
        	}
        }

        public List<Car> getCars() {
		return cars;
	}


	public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        public boolean isCellEditable(int row, int col) {
            if (col > 1) {
                return true;
            } else {
                return false;
            }
        }
        
        public void setValueAt(Object value, int row, int col) {
        	if(true){
        		System.out.println("Setting value at " + row + "," + col + " to " + value);
            	fireTableCellUpdated(row, col);
            }
        }
		
}
	
	
	private void update(List<Car> updatedCarList) throws IOException {		
		for (int i = 0 ; i<updatedCarList.size(); i++) {
			update.updateCar(updatedCarList.get(i));
		}
	}
}
