import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws Exception {
    MySQLAccess dao = new MySQLAccess();
   ResultSet rs = dao.select("students", "STUDENT_GPA", "STUDENT_FNAME='George'");
   rs.next();
    System.out.println(rs.getDouble("student_gpa"));
  }

}