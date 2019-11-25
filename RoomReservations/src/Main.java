import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static void main(String args[]){
        JFrame frame = new JFrame("Login");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel stuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        
        JLabel email = new JLabel("Email:");
        JTextField emailField = new JTextField();
       	JLabel stuNum = new JLabel("Student Number:");
       	JTextField stuField = new JTextField();
       	JButton submit = new JButton("Submit");
       	
       	emailField.setColumns(10);
       	stuField.setColumns(10);
       	submit.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent e) {
       			MySQLAccess msa = new MySQLAccess();
       			Boolean res = false;
       			try {
					res = msa.login(emailField.getText(), Integer.parseInt(stuField.getText()));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
       		}
       	});
       	
       	emailPanel.add(email);
       	emailPanel.add(emailField);
       	stuPanel.add(stuNum);
       	stuPanel.add(stuField);
       	submitPanel.add(submit);
        
       	frame.add(emailPanel);
       	frame.add(stuPanel);
       	frame.add(submitPanel);
       	frame.setVisible(true);
  }

}