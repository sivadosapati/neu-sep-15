package project.vehicle.management.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.Dealer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SpecificCarScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton search;
	private JLabel carPrice,category,type,make,model,year,trim;
	private JPanel contentPane;
	private JLabel lblSnapshot,picture,picture1,info;
	private Car car;
	private Dealer dealer;
	/*
	 * hard code
	 */
	public static void main(String[] args) {
		Integer test=2013;
		Category ca=Category.NEW;
		Car c = new Car("id","dealerid",ca, test, "BMW",
	            "Encore", "Convenience", "SUV", 11123.12f);
		Dealer d=new Dealer();
		new SpecificCarScreen(c,d);
	}
	/*
	 * hard code
	 */
	
	public SpecificCarScreen(Car car,Dealer dealer) {
		this.car=car;
		this.dealer=dealer;
		create();
		addTopPanel();
		addPhotoPanel();
		addCarInfoPanel(); 
		addDetailPanel();
		addListeners();
		display();
		
	}

	private void display() {
		setSize(900, 600);
		setVisible(true);
		
	}

	private void addListeners() {
		//back to search
	}

	private void addTopPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		search = new JButton("Back to Search");
		search.setBounds(10, 9, 140, 35);
		contentPane.add(search);
		

		lblSnapshot = new JLabel("> Snapshot");
		lblSnapshot.setBounds(160, 12, 111, 24);
		contentPane.add(lblSnapshot);
	}
	
	
	private void addPhotoPanel() {
		// set photo
		picture = new JLabel();
        int h = this.getHeight();
        int w = this.getWidth();
        picture.setText("<html><body><image width='"
                        + w
                        + "' height='"
                        + h
                        + "' src="
                        + "http://i01.i.aliimg.com/wsphoto/v0/798703829/Toy-car-automobile-race-2-alloy-car-models-large-die-model.jpg"
                        + "'></img></body></html>");
		picture.setBounds(4, 82, 422, 250);
		contentPane.add(picture);
	}
	
	private void addCarInfoPanel() {
		JPanel center = new JPanel();
		center.setBounds(480, 82, 316, 234);
		contentPane.add(center);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(Box.createVerticalStrut(30));
		center.add(type);
		center.add(Box.createVerticalStrut(30));
		center.add(carPrice);
		center.add(Box.createVerticalStrut(30));
		center.add(year);
	}
	
	private void addDetailPanel() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(4, 356, 896, 188);
		contentPane.add(tabbedPane);
		
		JPanel features = new JPanel();
		tabbedPane.addTab("Features", null, features, null);
		GridLayout gl = new GridLayout(2,2);
		features.setLayout(gl);
		features.add(category);
		features.add(make);
		features.add(model);
		features.add(trim);
		
		JPanel photo = new JPanel();
		//more photos
		picture1 = new JLabel();
        // set photo
        int h1 = this.getHeight();
        int w1 = this.getWidth();
        picture1.setText("<html><body><image width='"
                        + w1
                        + "' height='"
                        + h1
                        + "' src="
                        + "https://i.ytimg.com/vi/aBDHBJ-yQWc/maxresdefault.jpg"
                        + "'></img></body></html>");
		picture1.setBounds(4, 4, 4, 4);
		photo.add(picture1);
		tabbedPane.addTab("Photos", null, photo, null);
		
		
		JPanel contact = new JPanel();
		tabbedPane.addTab("Dealers ", null, contact, null);
		info = new JLabel("Dealers Infomation:");/*+dealer.getName());*/
		contact.add(info);
		
	}

	private void create() {
		carPrice = new JLabel("Car price:"+car.getPrice());
		category= new JLabel("Category:"+car.getCategory());
		type= new JLabel("Body style:"+car.getType());
		make= new JLabel("Make:"+car.getMake());
		model= new JLabel("Model:"+car.getModel());
		year= new JLabel("Year:"+car.getYear());
		trim= new JLabel("Trim:"+car.getTrim());
		
	}
}
