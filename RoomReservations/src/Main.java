import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Main {
  public static void main(String[] args) throws Exception {
    MySQLAccess dao = new MySQLAccess();
    dao.insertEvent("Test", 1, 5, new Date(1997, 9, 8), new Time(12, 0, 0), new Time(14, 0, 0), "Test event description");
  }

}