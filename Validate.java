  import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String uname1,String pass11) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
         PreparedStatement ps =con.prepareStatement
                             ("select * from user12 where username=? and pass=?");
         ps.setString(1, uname1);
         ps.setString(2, pass11);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}