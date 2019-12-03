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
	
	public JPanel getJPanel() {
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
		
		JTextField jmonth = new JTextField(Integer.toString(date.getMonth()));
		JLabel div = new JLabel(" / ");
		JTextField jday = new JTextField(Integer.toString(date.getDay()));
		JLabel div2 = new JLabel(" / ");
		JTextField jyear = new JTextField(Integer.toString(date.getYear()));
		jmonth.setColumns(2);
		jday.setColumns(2);
		jyear.setColumns(5);
		west.add(jmonth);
		west.add(div);
		west.add(jday);
		west.add(div2);
		west.add(jyear);
		
		
		JLabel jstart = new JLabel("Start: ");
		JTextField jshour = new JTextField(Integer.toString(start.getHours()));
		JLabel colon = new JLabel(":");
		JTextField jsmin = new JTextField(Integer.toString(start.getMinutes()));
		jshour.setColumns(2);
		jsmin.setColumns(2);
		cent.add(jstart);
		cent.add(jshour);
		cent.add(colon);
		cent.add(jsmin);
		
		JLabel jend = new JLabel("End: ");
		JTextField jehour = new JTextField(Integer.toString(end.getHours()));
		JLabel colon2 = new JLabel(":");
		JTextField jemin = new JTextField(Integer.toString(end.getMinutes()));
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
		
		JButton JEdit = new JButton("Edit");
		JButton JDel = new JButton("Delete");
		JEdit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MySQLAccess msa = new MySQLAccess();
				try {
					msa.updateEvent(eventID, jtitle.getText(), Integer.parseInt(jroom.getText()),
							new Date(Integer.parseInt(jyear.getText()), Integer.parseInt(jmonth.getText()), Integer.parseInt(jday.getText())),
									new Time(Integer.parseInt(jshour.getText()), Integer.parseInt(jsmin.getText()), 0),
									new Time(Integer.parseInt(jehour.getText()), Integer.parseInt(jemin.getText()), 0), jdesc.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MySQLAccess msa = new MySQLAccess();
				try {
					msa.deleteEvent(eventID);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buttons.add(JEdit);
		buttons.add(JDel);
		south.add(buttons);
		south.add(sep);
		
		p.add(north, BorderLayout.NORTH);
		p.add(east, BorderLayout.EAST);
		p.add(cent, BorderLayout.CENTER);
		p.add(west, BorderLayout.WEST);
		p.add(south, BorderLayout.SOUTH);
		
		return p;
	}
	
}
