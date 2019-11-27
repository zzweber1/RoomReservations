import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditEventFrame extends JFrame{
	JPanel mainPanel;
	
	JLabel test;
	
	public EditEventFrame() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setSize(50, 100);
		mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		test = new JLabel("Hello");
		
		mainPanel.add(test);
		
		add(mainPanel);
	}
}
