package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import UI.MainScreen;
//import UI.MainScreen.DummyDealerCarManager;
import lecture11.NEUFrame;
import project.vehicle.management.data.access.DealerCarManager;


public class MainScreen extends NEUFrame {
    private JLabel selectDealerLabel;
    private JComboBox<String> dealerComboBox;
    private DealerCarManager dealerCarManager;
    private JPanel buttonPanel;
    private JLabel title;
    private JButton dealer;
    private JButton customer;

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
        title = new JLabel("Car Management System");
        dealer = new JButton("Dealer");
        customer = new JButton("Customer");
        dealerComboBox = new JComboBox<String>(dealerCarManager.getDealerIds());
        buttonPanel = new JPanel(new GridLayout(5,5));
    }

    @Override
    public void add() {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        con.add(title, BorderLayout.PAGE_START);
        buttonPanel.add(dealer);
        buttonPanel.add(customer);
        buttonPanel.add(selectDealerLabel);
        buttonPanel.add(dealerComboBox);
        con.add(buttonPanel, BorderLayout.CENTER);
        
    }

    @Override
    public void addListeners() {
        // TODO Auto-generated method stub

    }
}
