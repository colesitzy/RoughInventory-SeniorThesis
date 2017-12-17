 import java.sql.*;
 
public class DbConnector {
	
	
	notaccess na;
	DbConnector()
	{
		
	};
	void intCon (){
	
	
	
	 Connection con = null;
	 
	 //Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
     		+ "databaseName=roughdb;"+ "user=csitzberger; password=Glurak20XX;";
     //test the connection
     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(60)==true)
	 		{
	 				System.out.println("Connection working");
	 		}
	 		con.close();
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	
	}
	void queryConNonID (){
		
		 Connection con = null;
		 
		 //Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	     		+ "databaseName=roughdb;"+ "user=csitzberger; password=Glurak20XX;";
	     //test the connection
	     try
	     	 {
		 		con = DriverManager.getConnection(conUrl);
		 		if(con.isValid(60)==true)
		 		{
		 				System.out.println("Connection working");
		 		}
		 		
	     	 } 
	     //print stack if error occurs
	 	 catch (Exception e) { e.printStackTrace(); }
	 
	     finally{
	         if (con != null) try { con.close(); } catch(Exception e) {}
	     }
		
		}
	boolean checkExistingUsername(String username)
	{
		Connection con = null;
		
		boolean retval = (false);
				
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	     		+ "databaseName=roughdb;"+ "user=csitzberger; password=Glurak20XX;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 	 
	 	            rs = stmt.executeQuery("SELECT * FROM Users WHERE Username = "+username+"");
	 	            if(rs.next() != false)
	 	            {
	 	            	retval = true;
	 	            }
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	
		
		return retval;
	}
}


	