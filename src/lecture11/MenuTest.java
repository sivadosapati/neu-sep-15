package lecture11;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTest extends NEUFrame {
	private JMenuBar menuBar;

	@Override
	public void create() {
		menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu newItem = new JMenu("New");
		JMenuItem openItem = new JMenuItem("Open");
		file.add(newItem);
		file.add(openItem);
		JMenuItem javaProject = new JMenuItem("Java Project");
		JMenuItem project = new JMenuItem("Project");
		newItem.add(javaProject);
		newItem.add(project);
		menuBar.add(file);
	}

	@Override
	public void add() {
		this.setJMenuBar(menuBar);
	}

	@Override
	public void addListeners() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MenuTest();
	}

}
