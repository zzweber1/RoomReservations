import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class eventFrame extends JFrame {
JPanel mainPanel;
	
	JLabel test;
	
	public eventFrame(ArrayList<Event> e, int stuNum) {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setSize(400, 200 * e.size());
		
		for(int i = 0; i < e.size(); i++) {
			try {
				add(e.get(i).getUpcoming(stuNum));
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
