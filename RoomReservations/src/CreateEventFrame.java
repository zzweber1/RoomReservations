import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;



public class CreateEventFrame extends JFrame{
	JPanel mainPanel;
	JLabel test1;
	
	public int eventID, orgID, roomID;
	public String name, desc;
	public Date date;
	public Time start, end;
	
	public CreateEventFrame() {
		JFrame cef = new JFrame("Create Event");
		cef.setPreferredSize(new Dimension(400, 300));
		cef.pack();
	    cef.setLocationRelativeTo(null);
	    
		
	    JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		JPanel north= new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		JPanel west = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel cent = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel east = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel south = new JPanel();
		south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		west.setMaximumSize(new Dimension(100, 200));
		cent.setMaximumSize(new Dimension(100, 200));
		east.setMaximumSize(new Dimension(100, 200));
		JTextField jtitle = new JTextField("Name");
		JTextField jroom = new JTextField(("roomID"));
		north.add(jtitle);
		north.add(jroom);
		
		
		cef.add(north);
		
		cef.setVisible(true);
	}
	
}
