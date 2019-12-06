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
		setSize(500, 500);
		
		JPanel north = new JPanel(new FlowLayout());
		JPanel west = new JPanel(new FlowLayout());
		JPanel south = new JPanel();
		
		JLabel jtitle = new JLabel("Create a New Event");
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
		JTextField jmonth = new JTextField();
		JLabel div = new JLabel(" / ");
		JTextField jday = new JTextField();
		JLabel div2 = new JLabel(" / ");
		JTextField jyear = new JTextField();
		jmonth.setColumns(2);
		jday.setColumns(2);
		jyear.setColumns(5);

		
		
		JLabel jstarttime = new JLabel("Start time:");
		JTextField jshour = new JTextField();
		JLabel colon = new JLabel(":");
		JTextField jsmin = new JTextField();
		jshour.setColumns(2);
		jsmin.setColumns(2);
		
		
		JLabel jendtime = new JLabel("End time: ");
		JTextField jehour = new JTextField();
		JLabel colon2 = new JLabel(":");
		JTextField jemin = new JTextField();
		jehour.setColumns(2);
		jemin.setColumns(2);

		
		jeventnameinput.setColumns(10);
		jdescinput.setColumns(20);
		jstuorgIDinput.setColumns(5);
		jroomIDinput.setColumns(5);

		
		
		west.add(jeventname);
		west.add(jeventnameinput);
		west.add(jdesc);
		west.add(jdescinput);
		west.add(jstuorgID);
		west.add(jstuorgIDinput);
		west.add(jroomID);
		west.add(jroomIDinput);
		west.add(jdate);
		west.add(jmonth);
		west.add(div);
		west.add(jday);
		west.add(div2);
		west.add(jyear);
		west.add(jstarttime);
		west.add(jshour);
		west.add(colon);
		west.add(jsmin);
		west.add(jendtime);
		west.add(jehour);
		west.add(colon2);
		west.add(jemin);
		
		
		
		//Used to parse jdateinput, sets the format of Date to dd/mm/yyyy (Day/Month/Year)
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//**NOT SURE IF CREATING NEW EVENTS WORKS. PAGE DOESN'T CLOSE AFTER CLICKING SUBMIT
		
		JButton JSubmit = new JButton("Submit");
		JSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MySQLAccess msa = new MySQLAccess();
				try {
					msa.insertEvent(jeventnameinput.getText(), Integer.parseInt(jstuorgIDinput.getText()), Integer.parseInt(jroomIDinput.getText()), new Date(Integer.parseInt(jyear.getText()) + 100, Integer.parseInt(jmonth.getText()) -1, Integer.parseInt(jday.getText()) - 1),
									new Time(Integer.parseInt(jshour.getText()), Integer.parseInt(jsmin.getText()), 0),
									new Time(Integer.parseInt(jehour.getText()), Integer.parseInt(jemin.getText()), 0), jdescinput.getText());
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
	
