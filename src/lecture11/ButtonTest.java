package lecture11;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonTest extends NEUFrame {
	private JButton helloButton;
	private JButton byeButton;
	private JButton quitButton;

	@Override
	public void create() {
		helloButton = new JButton("Hello");
		byeButton = new JButton("Bye");
		quitButton = new JButton("Quit");
	}

	@Override
	public void add() {
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(helloButton);
		getContentPane().add(byeButton);
		getContentPane().add(quitButton);
	}

	class ButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == helloButton){
				System.out.println("Hello World");
			}
			if( ae.getSource() == byeButton){
				System.out.println("Bye Everybody");
			}
		}

	}

	@Override
	public void addListeners() {
		ButtonClick bc = new ButtonClick();
		helloButton.addActionListener(bc);
		byeButton.addActionListener(bc);
		quitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Quitting..");
				System.exit(0);
			}
			
		});
	}

	public static void main(String[] args) {
		new ButtonTest();

	}

}
