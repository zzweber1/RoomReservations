import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setSize(340, 500);
		
		JPanel north = new JPanel(new FlowLayout());
		JPanel west = new JPanel(new FlowLayout());
		JPanel south = new JPanel();
		
		JTextField jtitle = new JTextField("Create a New Event");
		north.add(jtitle);
		
		//this is all of the input, w
		JLabel jeventname = new JLabel("Event name: ");
		JTextField jeventnameinput = new JTextField();
		
		JLabel jdesc = new JLabel("Description: ");
		JTextField jdescinput = new JTextField();
		jdescinput.setBorder(new EmptyBorder(5, 5, 5, 5));
		JSeparator sep = new JSeparator();
		sep.setBorder(new EmptyBorder(1, 1, 1, 1));
		
		JLabel jstuorgID = new JLabel("Student org ID: ");
		JTextField jstuorgIDinput = new JTextField();
		JLabel jroomID = new JLabel("Room ID: ");
		JTextField jroomIDinput = new JTextField();
		JLabel jdate = new JLabel("Date: ");
		JTextField jdateinput = new JTextField();
		JLabel jstarttime = new JLabel("Start time (HH:mm:ss): ");
		JTextField jstarttimeinput = new JTextField();
		JLabel jendtime = new JLabel("End time (HH:mm:ss): ");
		JTextField jendtimeinput = new JTextField();
		
		jeventnameinput.setColumns(10);
		jdescinput.setColumns(20);
		jstuorgIDinput.setColumns(5);
		jroomIDinput.setColumns(5);
		jdateinput.setColumns(5);
		jstarttimeinput.setColumns(5);
		jendtimeinput.setColumns(5);
		
		
		west.add(jeventname);
		west.add(jeventnameinput);
		west.add(jdesc);
		west.add(jdescinput);
		west.add(jstuorgID);
		west.add(jstuorgIDinput);
		west.add(jroomID);
		west.add(jroomIDinput);
		west.add(jdate);
		west.add(jdateinput);
		west.add(jstarttime);
		west.add(jstarttimeinput);
		west.add(jendtime);
		west.add(jendtimeinput);
		
		
		
		//Used to parse jdateinput, sets the format of Date to dd/mm/yyyy (Day/Month/Year)
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//**NOT SURE IF CREATING NEW EVENTS WORKS. PAGE DOESN'T CLOSE AFTER CLICKING SUBMIT
		
		JButton JSubmit = new JButton("Submit");
		JSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MySQLAccess msa = new MySQLAccess();
				try {
					msa.insertEvent(jeventnameinput.getText(), Integer.parseInt(jstuorgIDinput.getText()), Integer.parseInt(jroomIDinput.getText()), sdf.parse(jdateinput.getText()), 
							Time.valueOf(jstarttimeinput.getText()), Time.valueOf(jendtimeinput.getText()), jdescinput.getText());
				} catch (Exception ex) {	
				}
			}
		});
		south.add(JSubmit);
		
		add(north, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
	}

}
	
