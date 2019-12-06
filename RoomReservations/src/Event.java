import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Event {
	public int eventID, orgID, roomID;
	public String name, desc;
	public Date date;
	public Time start, end;
	
	/**
	 * Constructor for Event
	 * Enter in all the values for an event in the order of the ERD
	 * 
	 * @param eventID
	 * @param name
	 * @param orgID
	 * @param roomID
	 * @param date
	 * @param start
	 * @param end
	 * @param desc
	 */
	public Event(int eventID, String name, int orgID, int roomID, Date date, Time start, Time end, String desc) {
		this.eventID = eventID;
		this.name = name;
		this.orgID = orgID;
		this.roomID = roomID;
		this.date = date;
		this.start = start;
		this.end = end;
		this.desc = desc;
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
		
		JTextField jtitle = new JTextField(name);
		JTextField jroom = new JTextField(Integer.toString(roomID));
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
	
	public JPanel getUpcoming(int stuNum) throws ClassNotFoundException, SQLException {
		MySQLAccess msa = new MySQLAccess();
		
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
		
		JLabel jtitle = new JLabel(name);
		JLabel jroom = new JLabel(Integer.toString(roomID));
		north.add(jtitle);
		north.add(jroom);
		
		JLabel jdate = new JLabel("Date : " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
		west.add(jdate);
		
		JLabel jstart = new JLabel("Starts: " + start.getHours() + ":" + start.getMinutes());
		cent.add(jstart);
		
		JLabel jend = new JLabel("End: " + end.getHours() + ":" + end.getMinutes());
		east.add(jend);
		
		JTextArea jdesc = new JTextArea(desc);
		jdesc.disable();
		jdesc.setBorder(new EmptyBorder(5, 5, 5, 5));
		JSeparator sep = new JSeparator();
		sep.setBorder(new EmptyBorder(1, 1, 1, 1));
		south.add(jdesc);
		
		final JButton RSVP = new JButton(msa.getRSVP(stuNum, eventID));

		RSVP.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					msa.toggleRSVP(stuNum, eventID);
					RSVP.setText(msa.getRSVP(stuNum, eventID));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttons.add(RSVP);
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
