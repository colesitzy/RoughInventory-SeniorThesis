 import java.sql.*;
import java.util.ArrayList;
 
public class DbConnector {
	
	
	notaccess na;
	DbConnector()
	{
		
	};
	void intCon (){
	
	
	
	 Connection con = null;
	 
	 //Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
     		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
     //test the connection
     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(100)==true)
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
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
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
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 	 
	 	             rs = stmt.executeQuery("SELECT * FROM Users WHERE Username = '"+username+"'");
	 	             if(rs.next() != false)
	 	             {
	 	            	System.out.println("Name found");
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
	public boolean addUser(String username, String password, String f_name, String l_name, String email,
		int companyname, String role ) {
		
		boolean retVal = true;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            //ResultSet rs;
	 				try{
	 	            stmt.executeQuery("INSERT INTO users (Username, Password, FirstName, LastName, "
	 	             		+ "EmailAddress, CompanyID, Role) VALUES ('"+username+"', '"+password+"', '"
	 	            		 +f_name+"', '"
	 	            		 +l_name+"', '"+email+"', '"+companyname+"', '"+role+"')");
	 				}
	 				 catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	

	public boolean addCompany(String companyname, String username ) {
			
			boolean retVal = true;
			int placeholder = 0;
			Connection con = null;
											   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
			//Url used for the connection
		     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
		      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
		 	     try
	     	 {
		 		con = DriverManager.getConnection(conUrl);
		 		if(con.isValid(120)==true)
		 		{
		 				
		 				Statement stmt = con.createStatement();
		 	          //  ResultSet rs;
		 				try{
		 	            stmt.executeQuery("INSERT INTO Companies (AdminUsername, CompanyName) VALUES ('"+username+"','"+companyname+"')");
		 				}
		 				 catch (Exception e) { e.printStackTrace();
		 					 System.out.println("Error making company.");
		 				 }
		 	            
		 		}
		 		
	     	 } 
	     //print stack if error occurs
	 	 catch (Exception e) { e.printStackTrace(); }
	 
	     finally{
	         if (con != null) try { con.close(); } catch(Exception e) {}
	     }
		 	     return retVal;
		 	     
		}
	
	
	public int getuserID(String username)
	{
		Integer retVal = null;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 				try{
	 	            rs = stmt.executeQuery("SELECT UserID FROM Users WHERE username ='"+username+"'");
	 	           if(rs.next() != false)
	 	             {
	 	            	
	 	            	retVal = rs.getInt("UserID");
	 	            		 	            	
	 	             }
	 				}
	 				catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	
	
	
	
	
	
	/////////////////////////////////////////
	public boolean checkUserPass(String username, String password)
	{
		boolean retVal = false;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 				try{
	 	            rs = stmt.executeQuery("SELECT UserID FROM Users WHERE username ='"+username+"' AND password ='"+password+"'");
	 	           if(rs.next() != false)
	 	             {
	 	            	
	 	            	retVal = true;
	 	            		 	            	
	 	             }
	 				}
	 				catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	
	
	
	
	
	
	////////////////////////
	public int getcompanyID(String username)
	{
		Integer retVal = null;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 				try{
	 	            rs = stmt.executeQuery("SELECT CompanyID FROM companies WHERE AdminName ='"+username+"'");
	 	           if(rs.next() != false)
	 	             {
	 	            	
	 	            	retVal = rs.getInt("CompanyID");
	 	            		 	            	
	 	             }
	 				}
	 				catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
	 	     
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////
	public void getUser(String username)
	{
		Integer retVal = null;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 				try{
	 	            rs = stmt.executeQuery("SELECT * FROM Users WHERE Username ='"+username+"'");
	 	           if(rs.next() != false)
	 	             {
	 	            	
	 	            	//c = rs.getInt("UserID");
	 	            		 	            	
	 	             }
	 				}
	 				catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
	 	     
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     
	 	     
	}
	////////////////////////////////////////////
	public boolean setCompanyID(String Username, String Password, int CompanyID)
	{
		boolean retVal = false;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs = null;
	 				try{
	 	            stmt.executeQuery("UPDATE users SET CompanyID = '"+CompanyID+"' WHERE Username = '"+Username+"' ");
	 	            if(rs.next() != false)
	 	             {
	 	            	
	 	            	retVal = true;
	 	            		 	            	
	 	             }
	 				}
	 				catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	
		
	public boolean confirmUser(String username, String password)
	{
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
 				
 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{
	 	            rs = stmt.executeQuery("SELECT * FROM Users WHERE Username ='"+username+"' AND Password ='"+password+"'");
	 	           if(rs.next() != false)
	 	             {
	 	            	
	 	            	
	 	             }
	 	           else
	 	           {
	 	        	  retVal = false; 
	 	           }
	 				}
 				catch (Exception e) { }
 	            
 		}
 		
 	 	}
 	    catch (Exception e) { e.printStackTrace(); }
 	    finally{
 	         if (con != null) try { con.close(); } catch(Exception e) {}
 	     }
 		 	     return retVal;
	}

//needs to be finished
	public boolean signin(String username, String password) {
		
		boolean retVal = true;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            ResultSet rs;
	 	           try{
		 	            rs = stmt.executeQuery("SELECT * FROM Users WHERE Username ='"+username+"' AND Password ='"+password+"'");
		 	           if(rs.next() != false)
		 	             {
		 	            	
		 	            	currentUser.getInstance().setUser_id(rs.getInt("UserID"));
		 	            	currentUser.getInstance().setUsername(rs.getString("Username"));
		 	            	currentUser.getInstance().setCompany_id(rs.getInt("CompanyID"));
		 	            	currentUser.getInstance().setRole(rs.getString("Role"));
		 	             }
		 	           else
		 	           {
		 	        	  retVal = false; 
		 	           }
		 				}
	 				catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	
	



public boolean getInventory(int company_id, ArrayList<InventoryItem>itemList) {
	
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
 				
 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{

	 	            rs = stmt.executeQuery("SELECT * FROM Inventory WHERE CompanyID = '"+company_id+"'");
	 	           int i = 0;
	 	            	while(rs.next() != false)
	 	            	{
	 	            		//System.out.println( rs.getString("ItemName"));
	 	            		InventoryItem ii = new InventoryItem(rs.getInt("InventoryEntryID"), rs.getString("ItemName"), 
	 	            				rs.getInt("CurrentStock"), rs.getString("ItemDesciption"), rs.getString("Note"), 
	 	            				rs.getString("DateofLastChange"), rs.getInt("CompanyID"));
	 	            		itemList.add(ii);
	 	            		//System.out.println(itemList.size());
	 	            		itemList.get(i).getItem_name();
	 	            		
	 	            		//System.out.println(itemList.get(i).getItem_name());
	 	            		i++;
	 	            	}
	 	            	
 	           }
 				catch (Exception e) {e.printStackTrace();}
 	            
 		}
 		
 	 } 
 //print stack if error occurs
	 catch (Exception e) { e.printStackTrace(); }

 finally{
     if (con != null) try { con.close(); } catch(Exception e) {}
 }
 	     return retVal;
 	     
}

public boolean addInv(String name, int count, String desc, String Note ) {
		
		boolean retVal = true;
		int placeholder = 0;
		Connection con = null;
										   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
		//Url used for the connection
	     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
	      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
	 	     try
     	 {
	 		con = DriverManager.getConnection(conUrl);
	 		if(con.isValid(120)==true)
	 		{
	 				
	 				Statement stmt = con.createStatement();
	 	            //ResultSet rs;
	 				try{
	 	            stmt.executeQuery("INSERT INTO inventory (ItemName, CurrentStock, ItemDesciption, CompanyID, Note) VALUES ('"+name+"', '"+count+"', '"
	 	            		 +desc+"', '"
	 	            		 +currentUser.getInstance().getCompany_id()+"', '"+Note+"')");
	 				}
	 				 catch (Exception e) { }
	 	            
	 		}
	 		
     	 } 
     //print stack if error occurs
 	 catch (Exception e) { e.printStackTrace(); }
 
     finally{
         if (con != null) try { con.close(); } catch(Exception e) {}
     }
	 	     return retVal;
	 	     
	}
	


public boolean getEmployees(int company_id, ArrayList<employee>empList) {
	
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
     		//System.out.println("current company id "+ company_id);		

 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{
	 	           rs = stmt.executeQuery("SELECT * FROM Users WHERE CompanyID = '"+currentUser.getInstance().getCompany_id()+"'");
	 	           int i = 0;
	 	                while(rs.next() != false)
	 	            	{
	 	            		//System.out.println( "check 1");		
	 	            		//System.out.println( rs.getString("UserName"));
	 	            		employee ii = new employee(rs.getInt("UserID"), rs.getString("Username"), 
	 	            				rs.getString("FirstName"), rs.getString("LastName"), rs.getString("EmailAddress"), 
	 	            				rs.getString("Role"));
	 	            		empList.add(ii);
	 	            		//System.out.println(empList.size());
	 	            		empList.get(i).getFirstName();
	 	            		
	 	            		//System.out.println(empList.get(i).getLastName());
	 	            		//i++;
	 	            	}
	 	            	
 	           }
 				catch (Exception e) {e.printStackTrace();}
 	            
 		}
 		
 	 } 
 //print stack if error occurs
	 catch (Exception e) { e.printStackTrace(); }

 finally{
     if (con != null) try { con.close(); } catch(Exception e) {}
 }
 	     return retVal;
 	     
}


public boolean updateInventory(int company_id, InventoryItem ii) {
	
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
     		//System.out.println("current company id "+ company_id);		

 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{
	 	           rs = stmt.executeQuery("UPDATE Inventory SET ItemName ='"+ii.getItem_name()+"',"
	 	           		+ " CurrentStock ='"+ii.getItem_inventory()+ "', ItemDesciption ='" + ii.getItem_descr() + "', Note ='"+ ii.getItem_note() +"',"
	 	           		+ " DateofLastChange = '"+ ii.getLast_date() +"' "
	 	        		+  " WHERE InventoryEntryID = '"+ii.getItem_id()+"'");
	 	           
	 	           int i = 0;
	 	                while(rs.next() != false)
	 	            	{
	 	            		
	 	            	}
	 	            	
 	           }
 				catch (Exception e) {e.printStackTrace();}
 	            
 		}
 		
 	 } 
 //print stack if error occurs
	 catch (Exception e) { e.printStackTrace(); }

 finally{
     if (con != null) try { con.close(); } catch(Exception e) {}
 }
 	     return retVal;
 	     
}

public boolean updateEmployee(int user_id, String rolechange) {
	
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
	String replacement = new String();
	
	String emp = "Can edit inventory.";
	String adm = "Has full access.";
	String no = "Can veiw but can't edit.";
	
	if(rolechange.equals(emp)){
		replacement = "Employee";
	}
	else if(rolechange.equals(adm)){
		replacement = "Admin";
	}
	else if(rolechange.equals(no)){
		replacement = "Can not edit";
	}
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
     		//System.out.println("current company id "+ company_id);		

 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{
	 	           rs = stmt.executeQuery("UPDATE Users SET Role ='"+replacement+"'"
	 	           	+ " WHERE UserID = '"+ user_id +"'");
	 	           
	 	           int i = 0;
	 	                while(rs.next() != false)
	 	            	{
	 	            		
	 	            	}
	 	            	
 	           }
 				catch (Exception e) {e.printStackTrace();}
 	            
 		}
 		
 	 } 
 //print stack if error occurs
	 catch (Exception e) { e.printStackTrace(); }

 finally{
     if (con != null) try { con.close(); } catch(Exception e) {}
 }
 	     return retVal;
 	     
}

public boolean deleteInv() {
	
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
	String replacement = new String();
	
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
     		//System.out.println("current company id "+ company_id);		

 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{
	 	           rs = stmt.executeQuery("DELETE FROM Inventory WHERE InventoryEntryID ='"+ currentUser.getInstance().currentInv.getItem_id() +"'");
	 	           
	 	           int i = 0;
	 	                while(rs.next() != false)
	 	            	{
	 	            		
	 	            	}
	 	            	
 	           }
 				catch (Exception e) {e.printStackTrace();}
 	            
 		}
 		
 	 } 
 //print stack if error occurs
	 catch (Exception e) { e.printStackTrace(); }

 finally{
     if (con != null) try { con.close(); } catch(Exception e) {}
 }
 	     return retVal;
 	     
}

public boolean search(String table, String col, String word, ArrayList<InventoryItem>itemList) {
	
	boolean retVal = true;
	int placeholder = 0;
	Connection con = null;
	String replacement = new String();
	
									   //roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com,1433
	//Url used for the connection
     String conUrl = "jdbc:sqlserver://roughinventory0.cq07vr5zp0wr.us-east-2.rds.amazonaws.com;"
      		+ "databaseName=roughdb;"+ "user=Csitzberger; password=transam02;";
 	     try
 	 {
 		con = DriverManager.getConnection(conUrl);
 		if(con.isValid(120)==true)
 		{
     		//System.out.println("current company id "+ company_id);		

 				Statement stmt = con.createStatement();
 	            ResultSet rs;
 	           try{
	 	           rs = stmt.executeQuery("SELECT * FROM '"+ table +"'WHERE CompanyID ='"+ currentUser.getInstance().getCompany_id()+"'"
	 	           		+ "WHERE CustomerName LIKE   ' %'"+ word +"'% ");
	 	           
	 	          int i = 0;
	            	while(rs.next() != false)
	            	{
	            		//System.out.println( rs.getString("ItemName"));
	            		InventoryItem ii = new InventoryItem(rs.getInt("InventoryEntryID"), rs.getString("ItemName"), 
	            				rs.getInt("CurrentStock"), rs.getString("ItemDesciption"), rs.getString("Note"), 
	            				rs.getString("DateofLastChange"), rs.getInt("CompanyID"));
	            		itemList.add(ii);
	            		//System.out.println(itemList.size());
	            		itemList.get(i).getItem_name();
	            		
	            		//System.out.println(itemList.get(i).getItem_name());
	            		i++;
	            	}
	 	           
	 	         
	 	            	
 	           }
 				catch (Exception e) {e.printStackTrace();}
 	            
 		}
 		
 	 } 
 //print stack if error occurs
	 catch (Exception e) { e.printStackTrace(); }

 finally{
     if (con != null) try { con.close(); } catch(Exception e) {}
 }
 	     return retVal;
 	     
}
}



	