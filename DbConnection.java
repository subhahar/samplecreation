import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) {
		  try
		    {
			  Class.forName("com.edb.Driver");
			  Connection con = DriverManager.getConnection("jdbc:edb://serverid:port/schemaname","username","password");	
			  Statement statement = con.createStatement();
			  ResultSet rs = statement.executeQuery("SELECT * FROM tablename");

			  while(rs.next()) {
		             System.out.println(rs.getString(1));
			  }	   

			  rs.close();
			  statement.close();
			  con.close();
			  System.out.println("Command successfully executed");
		     }

		     catch(ClassNotFoundException | SQLException e)
		     {
			   System.out.println("Class Not Found : " + e.getMessage()); 
		     }


	}

}
