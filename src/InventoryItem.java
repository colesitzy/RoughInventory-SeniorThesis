
public class InventoryItem {
	
	private int item_id;
	
	private String item_name;
	
	private int item_inventory;
	
	private String item_descr;
	
	private String item_note;
	
	private String last_date;
	
	private int company_id;

	InventoryItem(){
		
	}
	
	InventoryItem(int iId, String in, int iInv, String iDes, String iNote, String iDate, int companyid)
	{
		setLast_date(iDate);
		
		setItem_note(iNote);
		
		setItem_descr(iDes);
		
		setItem_inventory(iInv);
		
		setItem_name(in);
		
		setItem_id(iId);
		
		setCompany_id(companyid);
	}
	
	public String getLast_date() {
		return last_date;
	}

	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}

	public String getItem_note() {
		return item_note;
	}

	public void setItem_note(String item_note) {
		this.item_note = item_note;
	}

	public String getItem_descr() {
		return item_descr;
	}

	public void setItem_descr(String item_descr) {
		this.item_descr = item_descr;
	}

	public int getItem_inventory() {
		return item_inventory;
	}

	public void setItem_inventory(int item_inventory) {
		this.item_inventory = item_inventory;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	
	

}
