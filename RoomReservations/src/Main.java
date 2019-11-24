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
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
       JButton button1 = new JButton("Button 1");
       JButton button2 = new JButton("Button 2");
       frame.getContentPane().add(button1);
       frame.getContentPane().add(button2);
       frame.setVisible(true);
  }

}