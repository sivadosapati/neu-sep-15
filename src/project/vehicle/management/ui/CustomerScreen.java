package project.vehicle.management.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CustomerScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 252713049595839409L;
	//Components that Nan added
	private JButton searchButton;
	private JTextField searchTextField;
	private JLabel searchLabel;
	private JLabel sortLabel;
	private JComboBox sortComboBox;
	
	private JTable table;
	
	public static void main(String[] args) {
		new CustomerScreen();
	}
	
	public CustomerScreen() {
		initSearchPane();
		initTablePane();
		
		JButton b = new JButton("hello.................................................................");
//		b.setSize(200,200);
		getContentPane().add("West", b);
		setTitle("Customer Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 0);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 200,
				Toolkit.getDefaultToolkit().getScreenSize().height);
		setVisible(true);
	}
	
	


	private void initSearchPane() {
		//create
		searchButton = new JButton("Search");
		searchTextField = new JTextField(20);
		searchLabel = new JLabel("Search:");
		sortLabel = new JLabel("Sort By:");
		String[] sortStrings = {"Price (Low to High)", "Price (High to Low)", "Miles (Low to High)", "Miles (High to Low)"};
		sortComboBox = new JComboBox(sortStrings);
		//add
		BorderLayout bl = new BorderLayout();
		Container con = super.getContentPane();
		con.setLayout(bl);
		JPanel searchAndSortPanel = new JPanel();
		searchAndSortPanel.add(searchLabel);
		searchAndSortPanel.add(searchTextField);
		searchAndSortPanel.add(searchButton);
		searchAndSortPanel.add(sortLabel);
		searchAndSortPanel.add(sortComboBox);
		con.add("North", searchAndSortPanel);
	}
	
	private void initTablePane() {
		String col2 = "<html>Category: "
				    + "New" + "<br/><br/>Year:   "
					+ "2012" + "<br/><br/>Make:   "
					+ "Fort" + "<br/><br/>Model:   "
					+ "SUV" + "<br/><br/>Type:   "
					+ "Car" + "<br/><br/>Price:   "
					+ "4.55" + "$</html>";
		Object[][] values = {
				{"Image", col2, ""},
				{"Image", col2, ""},
				{"Image", col2, ""},
				{"Image", col2, ""}
		};
		table = new JTable(new CustomerTableModel(values));
		table.setRowHeight(180);
		TableColumnModel tcm = table.getColumnModel();
		TableColumn tc1 = tcm.getColumn(0);
		tc1.setPreferredWidth(50);
		tc1.setCellRenderer(new ImageRenderer("http://webneel.com/wallpaper/sites/default/files/images/07-2013/1%20mercedes%20car%20wallpaper.jpg"));
		TableColumn tc2 = tcm.getColumn(2);
		tc2.setCellRenderer(new ButtonRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add("Center",scrollPane);
	}
}

class CustomerTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8292751322081951693L;
	public Object[][] values;
	public CustomerTableModel(Object[][] values) {
		this.values = values;
	}

	@Override
	public int getRowCount() {
		return values.length;		
	}

	@Override
	public int getColumnCount() {
		return values[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return values[rowIndex][columnIndex];
	}	
}

class ImageRenderer extends JLabel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1977070335905914163L;

	public ImageRenderer(String url) {
		super();
		setText("<html><body><image width='"
                + 200
                + "' height='"
                + 180
                + "' src="
                + url
                + "'></img></body></html>");
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {	
	    if (isSelected) {
	        setForeground(table.getSelectionForeground());
	        super.setBackground(table.getSelectionBackground());
	      } else {
	        setForeground(table.getForeground());
	        setBackground(table.getBackground());
	      }
		return this;
	}
}

class ButtonRenderer extends JPanel implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ButtonRenderer() {
		JButton button = new JButton("View Detail");
		add(button);
		setBackground(new Color(255,255,255));
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return this;
	}	
}

class ButtonEditor extends JButton implements TableCellEditor {
	protected EventListenerList listenerList = new EventListenerList();
	
	@Override
	public Object getCellEditorValue() {
		
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return this;
	}
	
}