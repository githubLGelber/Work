
package java2project;
import java.sql.*;


public class DbConnector {
   public static Connection connectToDatabase() throws SQLException
   {    
   String url="jdbc:mysql://localhost:3306/ufly?useSSL=false";
   
   String userName="root";
   String password="password";
   return DriverManager.getConnection(url,userName,password);
   }
   public static void closeConnection(Connection con) throws SQLException
   {
       con.close();
   }
           
           
}
