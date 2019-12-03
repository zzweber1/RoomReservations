import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import javax.swing.*;

public class Membership extends JFrame{
	
	public Membership(int stuID) {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setSize(300, 300);
		
		JPanel north = new JPanel(new FlowLayout());
		JPanel west = new JPanel(new FlowLayout());
		JPanel south = new JPanel();
		
		JTextField jtitle = new JTextField("Join a Student Organization");
		north.add(jtitle);
		
		//this is all of the input, w
		JLabel jorgid = new JLabel("Student Organization ID: ");
		JTextField jorgidinput = new JTextField();
		JLabel jmonth = new JLabel("Month joined: ");
		
		/*JTextField jmonthinput = new JTextField();
		JLabel jday = new JLabel("Day joined: ");
		JTextField jdayinput = new JTextField();
		JLabel jyear = new JLabel("Year joined: ");
		JTextField jyearinput = new JTextField(); */
		
		jorgidinput.setColumns(5);
		jorgidinput.setColumns(5);
		
		
		west.add(jorgid);
		west.add(jorgidinput);
		west.add(jmonth);
		
		/*west.add(jmonthinput);
		west.add(jday);
		west.add(jdayinput);
		west.add(jyear);
		west.add(jyearinput);*/
		
		JButton JSubmit = new JButton("Submit");
		JSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MySQLAccess msa = new MySQLAccess();
				try {
					msa.insertMembership(stuID, Integer.parseInt(jorgidinput.getText()));
					
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
