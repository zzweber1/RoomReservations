import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Date;
import java.sql.Time;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		eventID = this.eventID;
		name = this.name;
		orgID = this.orgID;
		roomID = this.roomID;
		date = this.date;
		start = this.start;
		end = this.end;
		desc = this.desc;
	}
	
	public JPanel getJPanel() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel north= new JPanel();
		north.setLayout(new BoxLayout(north.getRootPane(), BoxLayout.Y_AXIS));
		JPanel west = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cent = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel east = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel south = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JTextField jtitle = new JTextField(name);
		JTextField jroom = new JTextField(roomID);
		north.add(jtitle);
		north.add(jroom);
		
		JTextField jdate = new JTextField(date.getMonth() + " / " + date.getDay() + " / " + date.getYear());
		west.add(jdate);
		
		JTextField jstart = new JTextField(start.getHours() + ":" + start.getMinutes());
		cent.add(jstart);
		
		JTextField jend = new JTextField(end.getHours() + ":" + end.getMinutes());
		east.add(jend);
		
		JTextArea jdesc = new JTextArea(desc);
		south.add(jdesc);
		
		p.add(north, BorderLayout.NORTH);
		p.add(east, BorderLayout.EAST);
		p.add(cent, BorderLayout.CENTER);
		p.add(west, BorderLayout.WEST);
		p.add(south, BorderLayout.SOUTH);
		
		return p;
	}
}
