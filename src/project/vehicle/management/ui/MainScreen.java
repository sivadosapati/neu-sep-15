package project.vehicle.management.ui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import lecture11.NEUFrame;
import project.vehicle.management.data.access.DealerCarManager;

public class MainScreen extends NEUFrame {
	private JLabel selectDealerLabel;
	private JComboBox dealerComboBox;
	private DealerCarManager dealerCarManager;

	public MainScreen(DealerCarManager dcm) {
		super(dcm);
	}

	protected void init(Object o) {
		DealerCarManager x = (DealerCarManager) o;
		this.dealerCarManager= x;
	}

	public static void main(String[] args) {
		DealerCarManager dcm = makeADummyDealerCarManager();
		new MainScreen(dcm);
	}

	private static DealerCarManager makeADummyDealerCarManager() {
		return new DummyDealerCarManager();
	}

	static class DummyDealerCarManager implements DealerCarManager {

		@Override
		public String[] getDealerIds() {
			String[] dealers = new String[] { "yang", "ying", "nan" };
			return dealers;
		}

	}

	@Override
	public void create() {
		selectDealerLabel = new JLabel("Select Dealer");
		dealerComboBox = new JComboBox(dealerCarManager.getDealerIds());
	}

	@Override
	public void add() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(selectDealerLabel);
		con.add(dealerComboBox);
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub

	}

}
