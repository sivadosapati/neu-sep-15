package project.vehicle.management.ui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
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
	private JButton backhome;
	private JLabel carName;
	private JLabel carPrice;
	private JLabel date;
	private JLabel category;
	private JLabel style;
	private JLabel color;
	private JLabel make;
	private JLabel model;
	private JLabel year;
	private JLabel trim;
	private JPanel contentPane;
	private JLabel label;
	private JLabel lblSnapshot;
	private JLabel picture;
	private JLabel picture1;
	private JLabel info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SpecificCarScreen();
	}

	/**
	 * Create the frame.
	 */
	public SpecificCarScreen() {
		create();
		add();
		addListeners();
		display();
	}

	private void display() {
		setSize(450, 300);
		setVisible(true);
		
	}

	private void addListeners() {
		// back to home
		//back to search
	}

	private void add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backhome = new JButton("Home");
		backhome.setBounds(2, 6, 62, 23);
		contentPane.add(backhome);
		
		search = new JButton("Search");
		search.setBounds(69, 6, 74, 23);
		contentPane.add(search);
		
		label = new JLabel(">");
		label.setBounds(59, 8, 10, 16);
		contentPane.add(label);
		
		lblSnapshot = new JLabel("> Snapshot");
		lblSnapshot.setBounds(139, 8, 74, 16);
		contentPane.add(lblSnapshot);
		
		// set photo
//		JLabel picture = new JLabel(); 
//		picture.setIcon(new ImageIcon("http://forum.csdn.net/PointForum/ui/scripts/csdn/Plugin/003/monkey/16.gif"));
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
		picture.setBounds(2, 41, 211, 125);
		contentPane.add(picture);
		
		
		JPanel center = new JPanel();
		center.setBounds(240, 41, 158, 117);
		contentPane.add(center);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(Box.createVerticalStrut(15));
		center.add(carName);
		center.add(Box.createVerticalStrut(15));
		center.add(carPrice);
		center.add(Box.createVerticalStrut(15));
		center.add(date);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(2, 178, 448, 94);
		contentPane.add(tabbedPane);
		
		JPanel features = new JPanel();
		tabbedPane.addTab("Features", null, features, null);
		GridLayout gl = new GridLayout(3,3);
		features.setLayout(gl);
		features.add(category);
		features.add(style);
		features.add(color);
		features.add(make);
		features.add(model);
		features.add(year);
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
		picture1.setBounds(2, 2, 2, 2);
		photo.add(picture1);
		tabbedPane.addTab("Photos", null, photo, null);
		
		
		JPanel contact = new JPanel();
		tabbedPane.addTab("Dealers ", null, contact, null);
		info = new JLabel("Dealers Infomation:");
		contact.add(info);
		
	}

	private void create() {
		carName = new JLabel("Car name:");
		carPrice = new JLabel("Car price:");
		date= new JLabel("Manufacturing date:");
		category= new JLabel("Category:");
		style= new JLabel("Body style:");
		color= new JLabel("Exterior color:");
		make= new JLabel("Make:");
		model= new JLabel("Model:");
		year= new JLabel("Year:");
		trim= new JLabel("Trim:");
		
	}
}
