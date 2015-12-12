package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManagerImpl;

@SuppressWarnings("serial")
public class DealerDelFunc extends JFrame {
	private JButton yes;
	private JButton no;
	private JLabel confirm;
	private JPanel temp;
	private JPanel button;
	private JPanel label;
	private Container con;
	String dealerid;
	static List<Car> ret;

	public DealerDelFunc(List<Car> ret) {
		setTitle("Delete");
		create();
		add();
		addListeners();
		setSize(400, 130);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void addListeners() {
		ButtonClick bc = new ButtonClick();
		yes.addActionListener(bc);
		no.addActionListener(bc);
	}

	private void create() {
		yes = new JButton("yes");
		no = new JButton("no");
		confirm = new JLabel("Delete selected rows ?");
		label = new JPanel();
		temp = new JPanel();
		con = super.getContentPane();
		button = new JPanel(new CardLayout());

	}

	private void add() {

		temp.add(yes);
		temp.add(no);
		label.add(confirm);
		button.add(temp);
		con.add(button, BorderLayout.CENTER);
		con.add(label, BorderLayout.PAGE_START);

	}

	class ButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == yes)
				try {
					delete(ret);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else
				dispose();
		}
	}

	private List<Car> delete(List<Car> ret) throws IOException {

		CarManagerImpl deletecar = new CarManagerImpl(dealerid);
		for (Car car : ret)
			deletecar.deleteCar(car.getID());
		return deletecar.listCars();

	}

	public static void main(String[] args) {
		new DealerDelFunc(ret);
	}

}