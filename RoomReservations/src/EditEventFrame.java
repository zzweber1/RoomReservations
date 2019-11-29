import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditEventFrame extends JFrame{
	JPanel mainPanel;
	
	JLabel test;
	
	public EditEventFrame(ArrayList<Event> e) {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setSize(600, 800);
		
		for(int i = 0; i < e.size(); i++) {
			add(e.get(i).getJPanel());
		}
	}
}
