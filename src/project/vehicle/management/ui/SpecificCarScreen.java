package project.vehicle.management.ui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridLayout;
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
	private String[] dealerInfo;

	
	public SpecificCarScreen(Car car) throws IOException {
		this.car=car;
		dealerInfo = car.getDealerInfo();
		create();
		add();
		display();
		
	}

	private void display() {
		setSize(900, 600);
		setVisible(true);
		
	}
	
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
	private void add(){
		addTopPanel();
		addPhotoPanel();
		addCarInfoPanel(); 
		addDetailPanel();
		addListeners();
	}

	private void addTopPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	
	/*
	 * hard code
	 */
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
	/*
	 * hard code
	 */
	
	private void addCarInfoPanel() {
		JPanel center = new JPanel();
		center.setBounds(480, 82, 316, 234);
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
		tabbedPane.setBounds(4, 356, 896, 188);
		contentPane.add(tabbedPane);
		setFeatures(tabbedPane);
		setDealerInfo(tabbedPane);
		setMorePhotos(tabbedPane);
	}

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
	
	private void setDealerInfo(JTabbedPane tabbedPane) {
		JPanel contact = new JPanel();
		tabbedPane.addTab("Dealers ", null, contact, null);
		GridLayout gl1 = new GridLayout(2,3);
		contact.setLayout(gl1);
		info = new JLabel("Dealer Infomation:");
		contact.add(info);
		JLabel space = new JLabel("");
		contact.add(space);
		JLabel space1 = new JLabel("");
		contact.add(space1);
		JLabel dealerid = new JLabel("Dealer:"+dealerInfo[0]);
		contact.add(dealerid);
		JLabel country = new JLabel("Country:"+dealerInfo[1]);
		contact.add(country);
		LinkLabel web = new LinkLabel(dealerInfo[2],dealerInfo[2]);
		contact.add(web);
		
	}
	
	private void setMorePhotos(JTabbedPane tabbedPane) {
		/*
		 * hard code
		 */
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
		JScrollPane scrollphoto = new JScrollPane(photo);
		tabbedPane.addTab("More Photos", null, scrollphoto, null);
		/*
		 * hard code
		 */
	}

	private void create() {
		carPrice = new JLabel("Car price:"+car.getPrice()+"$");
		category= new JLabel("Category:"+car.getCategory());
		type= new JLabel("Body style:"+car.getType());
		make= new JLabel("Make:"+car.getMake());
		model= new JLabel("Model:"+car.getModel());
		year= new JLabel("Year:"+car.getYear());
		trim= new JLabel("Trim:"+car.getTrim());
		
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