package lecture11;

import javax.swing.JFrame;

public abstract class NEUFrame extends JFrame {
	public NEUFrame() {
		create();
		add();
		addListeners();
		display();
	}

	public abstract void create();

	public abstract void add();

	public abstract void addListeners();

	public void display() {
		setSize(500, 500);
		setVisible(true);
	}
}
