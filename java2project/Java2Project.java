
package java2project;
import java.sql.*;
public class Java2Project {

    public static void main(String[] args) {
      MainFrame frame=new MainFrame();
      frame.setVisible(true);
      try
      {
      Connection connection= DbConnector.connectToDatabase();
      System.out.println("Connection successful");
      }
      catch(Exception e)
      {
          System.out.println(e.toString());
          System.out.println("D");
      }
      
    }
    
}
