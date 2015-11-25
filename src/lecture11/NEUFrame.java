package lecture11;

import javax.swing.JFrame;

public abstract class NEUFrame extends JFrame {
	public NEUFrame() {
		initialize();
	}

	protected void initialize() {
		create();
		add();
		addListeners();
		display();
	}

	public NEUFrame(Object input) {
		init(input);
		initialize();
	}

	protected void init(Object input) {

	}

	public abstract void create();

	public abstract void add();

	public abstract void addListeners();

	public void display() {
		setSize(500, 500);
		setVisible(true);
	}
}
