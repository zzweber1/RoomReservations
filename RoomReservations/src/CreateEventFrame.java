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
	
<<<<<<< HEAD
	public JPanel getJPanel2() {
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
		JTextField jroom = new JTextField(("RoomID"));
		north.add(jtitle);
		north.add(jroom);
		
		JTextField jmonth = new JTextField("Month");
		JLabel div = new JLabel(" / ");
		JTextField jday = new JTextField("Day");
		JLabel div2 = new JLabel(" / ");
		JTextField jyear = new JTextField("Year");
		jmonth.setColumns(2);
		jday.setColumns(2);
		jyear.setColumns(5);
		west.add(jmonth);
		west.add(div);
		west.add(jday);
		west.add(div2);
		west.add(jyear);
		
		
		JLabel jstart = new JLabel("Start: ");
		JTextField jshour = new JTextField("Hour");
		JLabel colon = new JLabel(":");
		JTextField jsmin = new JTextField("Minutes");
		jshour.setColumns(2);
		jsmin.setColumns(2);
		cent.add(jstart);
		cent.add(jshour);
		cent.add(colon);
		cent.add(jsmin);
		
		JLabel jend = new JLabel("End: ");
		JTextField jehour = new JTextField("Hour");
		JLabel colon2 = new JLabel(":");
		JTextField jemin = new JTextField("Minutes");
		jehour.setColumns(2);
		jemin.setColumns(2);
		east.add(jend);
		east.add(jehour);
		east.add(colon2);
		east.add(jemin);
		
		JTextArea jdesc = new JTextArea(desc);
		jdesc.setBorder(new EmptyBorder(5, 5, 5, 5));
		JSeparator sep = new JSeparator();
		sep.setBorder(new EmptyBorder(1, 1, 1, 1));
		south.add(jdesc);
		
		
		south.add(sep);
		
		p.add(north, BorderLayout.NORTH);
		p.add(east, BorderLayout.EAST);
		p.add(cent, BorderLayout.CENTER);
		p.add(west, BorderLayout.WEST);
		p.add(south, BorderLayout.SOUTH);
		
		return p;

	}
	
=======
>>>>>>> branch 'master' of https://github.com/zzweber1/RoomReservations.git
}
