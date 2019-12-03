import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentOrg extends JFrame {

	public StudentOrg (){
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setSize(340, 500);
		
		JPanel north = new JPanel(new FlowLayout());
		JPanel west = new JPanel(new FlowLayout());
		JPanel south = new JPanel();
		
		JTextField jtitle = new JTextField("Create a Student Organization");
		north.add(jtitle);
		
		//this is all of the input, w
		JLabel jname = new JLabel("Student organization name: ");
		JTextField jnameinput = new JTextField();
		
		JLabel jdesc = new JLabel("Description: ");
		JTextField jdescinput = new JTextField();
		jdescinput.setBorder(new EmptyBorder(5, 5, 5, 5));
		JSeparator sep = new JSeparator();
		sep.setBorder(new EmptyBorder(1, 1, 1, 1));
		
		JLabel jpresID = new JLabel("President's student ID: ");
		JTextField jpresIDinput = new JTextField();
		JLabel jvpID = new JLabel("Vice President's student ID: ");
		JTextField jvpIDinput = new JTextField();
		JLabel jtresID = new JLabel("Treasurer's student ID: ");
		JTextField jtresIDinput = new JTextField();
		JLabel jsecID = new JLabel("Secretary's student ID: ");
		JTextField jsecIDinput = new JTextField();
		
		jnameinput.setColumns(10);
		jdescinput.setColumns(20);
		jpresIDinput.setColumns(5);
		jvpIDinput.setColumns(5);
		jtresIDinput.setColumns(5);
		jsecIDinput.setColumns(5);
		
		
		west.add(jname);
		west.add(jnameinput);
		west.add(jdesc);
		west.add(jdescinput);
		west.add(jpresID);
		west.add(jpresIDinput);
		west.add(jvpID);
		west.add(jvpIDinput);
		west.add(jtresID);
		west.add(jtresIDinput);
		west.add(jsecID);
		west.add(jsecIDinput);
		
		JButton JSubmit = new JButton("Submit");
		JSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MySQLAccess msa = new MySQLAccess();
				try {
					msa.insertOrg(jname.getText(), jdesc.getText(), Integer.parseInt(jpresIDinput.getText()), Integer.parseInt(jvpIDinput.getText()), 
							Integer.parseInt(jtresIDinput.getText()),Integer.parseInt(jsecIDinput.getText()));
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
