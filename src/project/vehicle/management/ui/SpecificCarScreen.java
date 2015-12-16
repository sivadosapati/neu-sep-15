package project.vehicle.management.ui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import project.vehicle.management.data.Car;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SpecificCarScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton search;
	private JLabel carPrice,category,type,make,model,year,trim,info,dealerid,country;
	private JPanel contentPane;
	private JLabel lblSnapshot,picture,picture1,picture2,picture3,picture4,picture5;
	private LinkLabel web;
	private Car car;
	private String[] dealerInfo;

	
	public SpecificCarScreen(Car car) throws IOException {
		this.car=car;
		dealerInfo = car.getDealerInfo();
		setTitle("Car Detail");
		create();
		setFonts();
		add();
		addListeners();
		display();
		
	}
	
	private void create() {
		search = new JButton("Back to Search");
		lblSnapshot = new JLabel("> Snapshot");
		

		picture = new JLabel(new ImageIcon("pictures/carDetail.png"));
		
		carPrice = new JLabel("Car price: "+"$"+car.getPrice());
		category= new JLabel("Category: "+car.getCategory());
		type= new JLabel("Body style: "+car.getType());
		make= new JLabel("Make: "+car.getMake());
		model= new JLabel("Model: "+car.getModel());
		year= new JLabel("Year: "+car.getYear());
		trim= new JLabel("Trim: "+car.getTrim());

		info = new JLabel("Dealer Infomation:");
		dealerid = new JLabel("Dealer: "+dealerInfo[0]);
		country = new JLabel("Country: "+dealerInfo[1]);
		web = new LinkLabel(dealerInfo[2],dealerInfo[2]);
		

		picture1 = new JLabel(new ImageIcon("pictures/cardetial1.jpeg"));
		picture2 = new JLabel(new ImageIcon("pictures/cardetail2.jpeg"));
		picture3 = new JLabel(new ImageIcon("pictures/cardetail3.jpeg"));
		picture4 = new JLabel(new ImageIcon("pictures/cardetail4.jpeg"));
		picture5 = new JLabel(new ImageIcon("pictures/cardetail5.jpeg"));
	}
	
	private void setFonts() {
		Font font = new Font("Arial", Font.BOLD, 24);
		year.setFont(font);
		carPrice.setFont(font);
		make.setFont(font);
		Font font1 = new Font("Arial", Font.BOLD, 18);
		trim.setFont(font1); 
		model.setFont(font1);
		type.setFont(font1);
		category.setFont(font1);
		info.setFont(font1);
		dealerid.setFont(font1);
		country.setFont(font1);
		web.setFont(font1);
	}
	
	private void add(){
		addTopPanel();
		addPhotoPanel();
		addCarInfoPanel(); 
		addDetailPanel();
	}
	
	private void addTopPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(w, h,w, h);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		search.setBounds(10, 9, 140, 35);
		contentPane.add(search);
		
		lblSnapshot.setBounds(160, 12, 111, 24);
		contentPane.add(lblSnapshot);
	}
	
	/*
	 * hard code
	 */
	private void addPhotoPanel() {
		// set photo
		JPanel panelpicture = new JPanel();
		panelpicture.setBounds(16, 91, 640, 320);
		panelpicture.add(picture);
		contentPane.add(panelpicture);
	}
	/*
	 * hard code
	 */
	
	private void addCarInfoPanel() {
		JPanel center = new JPanel();
		center.setBounds(775, 104, 255, 247);
		contentPane.add(center);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(Box.createVerticalStrut(30));
		center.add(year);
		center.add(Box.createVerticalStrut(30));
		center.add(make);
		center.add(Box.createVerticalStrut(30));
		center.add(carPrice);
	}
	
	private void addDetailPanel() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(16, 420, 1241, 281);
		contentPane.add(tabbedPane);
		setFeatures(tabbedPane);
		setDealerInfo(tabbedPane);
		setMorePhotos(tabbedPane);
	}

	//first part of detail panel
	private void setFeatures(JTabbedPane tabbedPane) {
		JPanel features = new JPanel();
		tabbedPane.addTab("Features", null, features, null);
		GridLayout gl = new GridLayout(2,2);
		features.setLayout(gl);
		features.add(category);
		features.add(type);
		features.add(model);
		features.add(trim);
		
	}
	
	//second part of detail panel
	private void setDealerInfo(JTabbedPane tabbedPane) {
		JPanel contact = new JPanel();
		tabbedPane.addTab("Dealers ", null, contact, null);
		GridLayout gl = new GridLayout(2,3);
		contact.setLayout(gl);
		contact.add(info);
		JLabel space = new JLabel("");
		contact.add(space);
		JLabel space1 = new JLabel("");
		contact.add(space1);
		contact.add(dealerid);
		contact.add(country);
		contact.add(web);
		
	}
	
	//third part
	private void setMorePhotos(JTabbedPane tabbedPane) {
		/*
		 * hard code
		 */
		JPanel photo = new JPanel();
		JScrollPane scrollphoto = new JScrollPane(photo);
		tabbedPane.addTab("More Photos", null, scrollphoto, null);
		FlowLayout fl = new FlowLayout();
		photo.setLayout(fl);
		//more photos
		photo.add(picture1);
		photo.add(picture2);
		photo.add(picture3);
		photo.add(picture4);
		photo.add(picture5);
		/*
		 * hard code
		 */
	}
	
	
	//add button function
	private void close() {
		this.dispose();
		
	}

	private void addListeners() {
		search.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
	}
	
	//display
	private void display() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		setVisible(true);
		
	}
}


class LinkLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String text, url;
	private boolean isSupported;
	public LinkLabel(String text, String url) {
	     this.text = text;
	     this.url = "http://"+url;
	     try {
	      this.isSupported = Desktop.isDesktopSupported()
	        && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
	     } catch (Exception e) {
	      this.isSupported = false;
	     }
	     setText(false);
	     addMouseListener(new MouseAdapter() {
	      public void mouseEntered(MouseEvent e) {
	       setText(isSupported);
	       if (isSupported)
	        setCursor(new Cursor(Cursor.HAND_CURSOR));
	      }
	      public void mouseExited(MouseEvent e) {
	       setText(false);
	      }
	      public void mouseClicked(MouseEvent e) {
	       try {
	        Desktop.getDesktop().browse(
	          new java.net.URI(LinkLabel.this.url));
	       } catch (Exception ex) {
	       }
	      }
	     });
	}
	private void setText(boolean b) {
	     if (!b)
	      setText("<html><font color=blue><u>" + text);
	     else
	      setText("<html><font color=red><u>" + text);
	}
}