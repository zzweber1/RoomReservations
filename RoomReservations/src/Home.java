import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			editEventButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MySQLAccess msa = new MySQLAccess();
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
