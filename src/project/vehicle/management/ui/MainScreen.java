package project.vehicle.management.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import project.vehicle.management.data.access.DealerCarManagerImpl;

public class MainScreen extends JFrame {
    
  
	private static final long serialVersionUID = 20151212L;
	
	private JButton dealer ;
    private JButton customer ;
    private JLabel head ;
    private Box box ;
    private JPanel jp1;
    private JPanel jp2 ;
    private DealerCarManagerImpl dealerModel ;
    private String[] model ;
    private JComboBox<String> dealerComboBox ;
    private String selectedDealer ;
    private Dimension buttonDimension;
    final int width = 950;
    final int height = 540;

   
    public MainScreen(String name){
    	this.setTitle(name);
    }
    public void initComponent(){
    	dealer = new JButton("DEALER");
    	customer = new JButton("CUSTOMER");
    	head = new JLabel(new ImageIcon("head.jpg"));
    	box = Box.createVerticalBox();
    	jp1 = new JPanel();
    	jp2 = new JPanel();
    	dealerModel = new DealerCarManagerImpl();
    	model = appendStringAtFirst(dealerModel.getDealerIds());
    	dealerComboBox = new JComboBox<>(model);
    	selectedDealer = "";
    	buttonDimension =new Dimension(200,39);
    }
    
    public String[] appendStringAtFirst(String[] arr) {
        String[] newArr = new String[arr.length+1];
        newArr[0] = "Please select a dealer !";
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        return newArr;
    }
    
    public void initFrame() throws Exception {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        
        jp1.add(head);

        FlowLayout flo = new FlowLayout();
        flo.setHgap(135);
        jp2.setLayout(flo);
        dealer.setPreferredSize(buttonDimension);
        customer.setPreferredSize(buttonDimension);

        jp2.add(dealer);
        jp2.add(customer);

        dealerComboBox.setMaximumSize(new Dimension(534, 80));
        dealerComboBox.setToolTipText("Please select dealer's name!");


        box.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        box.add(jp1);
        box.add(jp2);
        box.add(dealerComboBox);

        JPanel jpBlank = new JPanel();
        jpBlank.setPreferredSize(new Dimension(950, 350));
        box.add(jpBlank);

        this.add(box);

        this.setBounds((screen.width - width) / 2, (screen.height - height) / 2, width, height);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public void addListener(){
    	
    	  dealer.addActionListener(e -> {
              if (selectedDealer.equals("")||selectedDealer.equals("Please select a dealer !")) {
                  JOptionPane.showMessageDialog(this, "You must select a dealer first!");
              }

              else {
              
                  System.out.println(selectedDealer);// for test
                  // new DealerScreen();
                  // jf.dispose();
              }
          });


          customer.addActionListener(e -> {
              if (selectedDealer.equals("")||selectedDealer.equals("Please select a dealer !")) {
                  JOptionPane.showMessageDialog(this, "You must select a dealer first!");
              } else {
                  System.out.println(selectedDealer);// for test
                  // new CustomerScreen();
                  // jf.dispose();
              }
          });

          dealerComboBox.addItemListener(e -> {
        	  
        	  DefaultComboBoxModel mo=(DefaultComboBoxModel)dealerComboBox.getModel();
              
        	  
        	  if(mo.getElementAt(0).equals("Please select a dealer !")){
        		  mo.removeElement(mo.getElementAt(0));
        	  }
        	  
              if (e.getStateChange() == ItemEvent.SELECTED) {

                  Object[] a = e.getItemSelectable().getSelectedObjects();
                  selectedDealer = (String) a[0];

              }

          });
    }

    public static void main(String[] args) throws Exception {
       MainScreen ms= new MainScreen("Car Management System");
       ms.initComponent();
       ms.initFrame();
       ms.addListener();
       
    }

}
