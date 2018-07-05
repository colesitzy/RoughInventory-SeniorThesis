
public class main {
	
	
	
	public static void main(String[] args) {
		 
		currentUser.getInstance();
        DbConnector dbc = new DbConnector();
        dbc.intCon();
        userSignIn usersignin = new userSignIn();
        
       // dbc.addUser("test", "test", "test", "test", "test", "test", "test");
       // dbc.checkExistingUsername("test");
	}

}
