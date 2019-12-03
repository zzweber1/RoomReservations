import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Home extends JPanel {
		int stuNum;
	
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel createOrgPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel eventPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel createEventPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel editEventPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JButton joinButton = new JButton("Join a Student Organization");
		JButton createOrgButton = new JButton("Create a Student Organization");
		JButton eventButton = new JButton("Upcoming Events");
		JButton createEventButton = new JButton("Create an Event");
		JButton editEventButton = new JButton("Edit an Event");
		JButton logoutButton = new JButton("Logout and Exit");
		
		public Home(int stuNumber) {
			stuNum = stuNumber;
			
			joinButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Membership memship = new Membership(stuNum);
					memship.setVisible(true);
				}
			});
			
			createOrgButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentOrg stuorg = new StudentOrg();
					stuorg.setVisible(true);
				}
			});
			
			editEventButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MySQLAccess msa = new MySQLAccess();
					int[] orgIDs = null;
					try {
						orgIDs = msa.getOrgsFromOfficer(stuNum);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ArrayList<Event> events = new ArrayList<Event>();
					for(int i = 0; i < orgIDs.length; i++) {
						try {
							events.addAll(msa.getEventFromOrgID(orgIDs[i]));
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
						}
					}
					EditEventFrame eef = new EditEventFrame(events);
					eef.setVisible(true);
				}
			});
			
			createEventButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CreateEventFrame cef = new CreateEventFrame();

					
					
					cef.setVisible(true);
				}
			});
			
			joinPanel.add(joinButton);
			createOrgPanel.add(createOrgButton);
			eventPanel.add(eventButton);
			createEventPanel.add(createEventButton);
			editEventPanel.add(editEventButton);
			logoutPanel.add(logoutButton);
		
			add(joinPanel);
			add(createOrgPanel);
			add(eventPanel);
			add(createEventPanel);
			add(editEventPanel);
			add(logoutPanel);
		}
		
}
