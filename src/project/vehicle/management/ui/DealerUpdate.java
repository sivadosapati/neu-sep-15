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
import project.vehicle.management.data.access.CarManagerImpl; 
import project.vehicle.management.ui.DearlerMainScreen.MyTableModel;

public class DealerUpdate extends JFrame {
	
	public static final int DEFAULT_WIDTH = 1000;
	public static final int DEFAULT_HEIGHT = 500;
	static Font font = new Font("Times New Roman", Font.BOLD, 18);
	private JButton cancelButton;
	private JButton submitButton;
	private JPanel panel1;
	private JPanel panel2;
	List<Integer> origin, updated;
	String DealerID;
	CarManager update;
	List<Integer> operatedList;
	private MyTableModel t;
	/////////////////////////////
	public void addTable(){
		panel1 = new JPanel();
		GridLayout lay = new GridLayout();
		panel1.setLayout(lay);
//		panel1.setOpaque(true);
		JTable table = new JTable(t);/
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane);
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
	JFrame frame = new JFrame("UPDATE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout out = new BorderLayout();
        frame.setLayout(out);
        frame.add(panel1,"Center");
        frame.add(panel2, "South"); 
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setLocation(850,400);
        frame.setVisible(true);
	}
	
	public DealerUpdate(CarManager cm, List<Integer> list, MyTableModel mtm) throws IOException {
        //DearlerMainScreen dms = new DearlerMainScreen("gmps-chaparral2");
		this.t = mtm;
	    this.operatedList = list;
	    this.update = cm;
		addButton();
        addTable(); 
        display();
        addListeners();
       
        
    }
	
	public static void main(String[] args){
		try {  
//			DearlerMainScreen dms = new DearlerMainScreen("gmps-chaparral2");
			new DealerUpdate(null, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
					update(operatedList);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
			if(e.getSource() == cancelButton){
				//operatedList = origin;
				System.exit(0);
			}
		}
	}
	
	
	
	
	private void update(List<Integer> operatedList) throws IOException {
		for (Integer index : operatedList) {
			;//update.updateCar(t.cars.get(index));
		}
	}
}
