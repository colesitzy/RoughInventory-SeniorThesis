import java.util.ArrayList;

import javax.swing.JCheckBox;

public class currentUser {
	private static currentUser instance = null;
	
	private String username;
	
	private int user_id;
	
	private int company_id;
	
	private String role;
	
	 InventoryItem currentInv;
	 
	 inventoryPanel currentlycheckedinv;
	 
	 String nextedit = new String("none");
	 
	 employee currentEmp;
	 
	 employeePanel currentlycheckedemp;
	
	ArrayList <InventoryItem> itemlist = new ArrayList<InventoryItem>();
		
	ArrayList <employee> employeelist = new ArrayList<employee>();
	
	ArrayList <inventoryPanel> invpanellist = new ArrayList <inventoryPanel>();
	
	ArrayList <employeePanel> emppanellist = new ArrayList <employeePanel>();
	
	
	currentUser(){
		
	}
	
	public static currentUser getInstance()
	{
		//if not created
		if (instance == null)
		{
			instance = new currentUser();
			
		}
		//if created already
		else
		{
			
		}
		
		return instance;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void addInventoryItem(InventoryItem ii){
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void clearLists(){
		this.itemlist = new ArrayList<InventoryItem>();
		
		this.employeelist = new ArrayList<employee>();
		
	}

	public employee getCurrentEmp() {
		return currentEmp;
	}

	public void setCurrentEmp(employee currentEmp) {
		this.currentEmp = currentEmp;
	}

	public InventoryItem getCurrentInv() {
		return currentInv;
	}

	public void setCurrentInv(InventoryItem currentInv) {
		this.currentInv = currentInv;
	}
	
}
