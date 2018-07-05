
public class employee {
	
	
	private int employeeID;
	
	private String Username;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String role;

	
	
	employee(){
		
	}
	
	
	employee(int employee_id, String uname, String fname, String lname, String email, String role){
		
		setEmployeeID(employee_id);
		setUsername(uname);
		setFirstName(fname);
		setLastName(lname);
		setEmail(email);
		setRole(role);
	}
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}

	
}
