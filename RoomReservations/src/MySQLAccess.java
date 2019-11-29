import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.ArrayList;

public class MySQLAccess {
	
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  final private String host = "127.0.0.1:3306";
  final private String user = "root";
  final private String passwd = "oakland";
  
  /**
   * 
   * @param email the email the student entered
   * @param stuNum the student number the student entered
   * @return True if login credentials are correct otherwise false
   * @throws Exception idk
   */
  public boolean login(String email, int stuNum) throws Exception{
      Class.forName("com.mysql.cj.jdbc.Driver"); // This will load the MySQL driver, each DB has its own driver
      
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/mydb?"
              + "user=" + user + "&password=" + passwd );

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
              .executeQuery("select student_email from students where student_id="+stuNum+";");
      resultSet.next(); //This is necessary each time you get a value from the resultSet
      boolean res = (email.contentEquals(resultSet.getString("student_email")));
      close(); //close the conection to the database
      return res;
  }
  
  public int[] getOrgsFromOfficer(int officerID) throws ClassNotFoundException, SQLException {
	  int[] orgIDs;
	  ArrayList<Integer> a = null;
	  
	  Class.forName("com.mysql.cj.jdbc.Driver"); // This will load the MySQL driver, each DB has its own driver
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/mydb?"
              + "user=" + user + "&password=" + passwd );
      statement = connect.createStatement();
      resultSet = statement
              .executeQuery("select org_id from student_orgs where president_id=" + officerID +" or vp_id=" 
      + officerID +" or treasurer_id=" + officerID +" or secretary_id=" + officerID + ";");
      
      //Some spaghetti I had do in order to get the length of the resultset so I could set the length of the array
      resultSet.afterLast();
      resultSet.previous();
      orgIDs = new int[resultSet.getRow()];
      resultSet.beforeFirst();
      for(int i = 0; i < orgIDs.length; i++) {
    	  resultSet.next();
    	  orgIDs[i] = resultSet.getInt("org_id");
      }
     
      close();
      return orgIDs;
  }
  
  /**
   * Gets an array of Event objects for a student org with the org's id
   * 
   * @param orgID
   * @return An array of event objects
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public ArrayList<Event> getEventFromOrgID(int orgID) throws SQLException, ClassNotFoundException {
	  ArrayList<Event> events = new ArrayList<Event>();
	  
	  Class.forName("com.mysql.cj.jdbc.Driver"); // This will load the MySQL driver, each DB has its own driver
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/mydb?"
              + "user=" + user + "&password=" + passwd );
      statement = connect.createStatement();
      resultSet = statement
              .executeQuery("select * from events where org_id=" + orgID + ";");
      while(resultSet.next()) {
    	  
    	  events.add(new Event(resultSet.getInt("event_id"), resultSet.getString("event_name"), resultSet.getInt("org_id"),
    			  resultSet.getInt("room_id"), resultSet.getDate("event_date"), resultSet.getTime("event_start_time"),
    			  resultSet.getTime("evetn_end_time"), resultSet.getString("event_description")));
      }
	  
	  return events;
  }
  
  public void updateEvent(int ID, String name, int roomID, Date date, Time start, Time end, String desc) throws SQLException, ClassNotFoundException {
	  Class.forName("com.mysql.cj.jdbc.Driver"); // This will load the MySQL driver, each DB has its own driver
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/mydb?"
              + "user=" + user + "&password=" + passwd );

      statement = connect.createStatement();
      preparedStatement = connect
    		  .prepareStatement("update EVENTS set event_name=?, room_id=?,  event_date=?, event_start_time=?, evetn_end_time=?,"
    		  		+ " event_description=? where org_id=" + ID + ";");
          // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
          // Parameters start with 1
          preparedStatement.setString(1, name);
          preparedStatement.setInt(2, roomID);
          preparedStatement.setDate(3, (java.sql.Date) date);
          preparedStatement.setTime(4, start);
          preparedStatement.setTime(5, end);
          preparedStatement.setString(6, desc);
          preparedStatement.executeUpdate();
  }
  
  
  public void insertStudent() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/mydb?"
              + "user=" + user + "&password=" + passwd );

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
   // Result set get the result of the SQL query
      resultSet = statement
              .executeQuery("select * from students");
          writeResultSet(resultSet);

          // PreparedStatements can use variables and are more efficient
          preparedStatement = connect
              .prepareStatement("insert into  students values (default, ?, ?, ?, ? , ?, ?, ?)");
          // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
          // Parameters start with 1
          preparedStatement.setString(1, "John");
          preparedStatement.setString(2, "Smith");
          preparedStatement.setInt(3, 5);
          preparedStatement.setString(4, "example@email.com");
          preparedStatement.setInt(5, 4);
          preparedStatement.setDouble(6, 3.5);
          preparedStatement.setString(7, "Computer Science");
          preparedStatement.executeUpdate();

          preparedStatement = connect
              .prepareStatement("SELECT * from EVENTS");
          resultSet = preparedStatement.executeQuery();
          writeResultSet(resultSet);
          
          
        } catch (Exception e) {
          throw e;
        } finally {
          close();
        }

  }
  
  public void insertEvent(String name, int orgID, int roomID, Date date, Time startTime, Time endTime, String desc) throws Exception {
	  try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
	          .getConnection("jdbc:mysql://localhost:3306/mydb?"
	              + "user=" + user + "&password=" + passwd );
	      // Statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // PreparedStatements can use variables and are more efficient
	      preparedStatement = connect
	    		  .prepareStatement("insert into EVENTS values (default, ?, ?, ?, ?, ?, ?, ?)");
	          // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
	          // Parameters start with 1
	          preparedStatement.setString(1, name);
	          preparedStatement.setInt(2, orgID);
	          preparedStatement.setInt(3, roomID);
	          preparedStatement.setDate(4, (java.sql.Date) date);
	          preparedStatement.setTime(5, startTime);
	          preparedStatement.setTime(6, endTime);
	          preparedStatement.setString(7, desc);
	          preparedStatement.executeUpdate();
	          
	          
	        } catch (Exception e) {
	          throw e;
	        } finally {
	          close();
	        }
  }
  
  public ResultSet select(String tableName, String colNames, String condition) throws Exception{
	// This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/mydb?"
              + "user=" + user + "&password=" + passwd );

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      resultSet = statement
              .executeQuery("select " + colNames + " from " + tableName + " where " + condition + ";");
      return resultSet;
  }
  
  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String user = resultSet.getString("student_id");
      String website = resultSet.getString("student_fname");
      String summary = resultSet.getString("student_lname");
      int date = resultSet.getInt("student_phone");
      String comment = resultSet.getString("student_email");
      System.out.println("User: " + user);
      System.out.println("Website: " + website);
      System.out.println("Summary: " + summary);
      System.out.println("Date: " + date);
      System.out.println("Comment: " + comment);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

}