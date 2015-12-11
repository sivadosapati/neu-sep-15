package lecture11;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class TextAndList extends NEUFrame {
	private JTextField wordsText;
	private JList wordsList;
	private MyListModel listModel;

	@Override
	public void create() {
		wordsText = new JTextField(50);
		listModel = new MyListModel();
		listModel.addWord("Words..");
		listModel.addWord("Words again..");
		wordsList = new JList(listModel);
	}

	class MyListModel implements ListModel {
		private ArrayList<String> words = new ArrayList<String>();

		@Override
		public int getSize() {
			return words.size();
		}

		@Override
		public Object getElementAt(int index) {
			return words.get(index);
		}

		public void addWord(String word) {
			words.add(word);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void add() {
		Container con = getContentPane();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter words..."));
		panel.add(wordsText);
		con.add("North", panel);

		panel = new JPanel();
		panel.add(new JLabel("Words List.."));
		JScrollPane jsp = new JScrollPane(wordsList);
		// panel.add(wordsList);
		panel.add(jsp);
		con.add("Center", panel);
	}

	class MyWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			/*
			 * JDialog jd = new JDialog(); jd.setTitle("Bye Bye..");
			 * jd.setSize(200, 200); jd.setVisible(true);
			 */
			Other other = new Other();
			other.some.someOther();
			JOptionPane.showMessageDialog(null, "Bye bye..");
		}
		
		class Other{
			
			public void other(){
				System.out.println("Other");
			}
			class SomeOther{
				public void someOther(){
					System.out.println("Some other..");
				}
			}
			SomeOther some = new SomeOther();
		}

	}

	class KeyAction implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			String text = wordsText.getText();
			if (text.endsWith(" ")) {
				String words[] = text.split(" ");
				String lastWord = words[words.length - 1];
				listModel.addWord(lastWord);
				System.out.println(lastWord);
				
				wordsList.updateUI();
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void addListeners() {
		KeyAction ka = new KeyAction();
		wordsText.addKeyListener(ka);
		this.addWindowListener(new MyWindowAdapter());
	}

	public static void main(String[] args) {
		new TextAndList();

	}

}
