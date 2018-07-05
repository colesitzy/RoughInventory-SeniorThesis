import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class dualtabbedpane extends JPanel {

	DbConnector dbc = new DbConnector();

	ArrayList <InventoryItem> itemlist = new ArrayList<InventoryItem>();
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	
	JPanel inventoryholderpanel; 
	private JPanel inventoryholderpanel_1;

	JTabbedPane tabbedPane_1;
	
	private JPanel contentPane;
	
	public dualtabbedpane() {
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel tabbedpanel = new JPanel();
		tabbedpanel.setPreferredSize(new Dimension(3000, 3500));
		
		tabbedpanel.setLayout(new BorderLayout(0, 0));
		
		inventoryholderpanel = new JPanel();
		
		inventoryholderpanel.setLayout(new BoxLayout(inventoryholderpanel, BoxLayout.PAGE_AXIS));
		
		JScrollPane inventoryScollPane = new JScrollPane();
		//tabbedpanel.add(tabbedPane_1);
		JScrollPane inventoryscrollPane = new JScrollPane(inventoryholderpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		inventoryscrollPane.setPreferredSize(new Dimension(4000, 1800));
		inventoryscrollPane.setMaximumSize(new Dimension(4000, 1800));
		inventoryscrollPane.getViewport().setMaximumSize(new Dimension(3500, 1800));
		inventoryscrollPane.getViewport().setPreferredSize(new Dimension(3500, 1800));
		inventoryscrollPane.getViewport().setMinimumSize(new Dimension(3500, 1800));
		inventoryscrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(25, 0));
		
		dbc.getInventory(currentUser.getInstance().getCompany_id(), currentUser.getInstance().itemlist);
		
		inventoryholderpanel.add(new inventoryPanel());
		
		for(int i = 0; i < currentUser.getInstance().itemlist.size(); i++)
		{
		inventoryPanel ip = new inventoryPanel(currentUser.getInstance().itemlist.get(i), currentUser.getInstance().itemlist.get(i).getItem_id(), currentUser.getInstance().itemlist.get(i).getItem_name(),
				currentUser.getInstance().itemlist.get(i).getItem_inventory(), currentUser.getInstance().itemlist.get(i).getCompany_id(), 
				currentUser.getInstance().itemlist.get(i).getItem_descr(), currentUser.getInstance().itemlist.get(i).getItem_note(), 
				currentUser.getInstance().itemlist.get(i).getLast_date());
				/*inventoryPanel ip = new inventoryPanel(currentUser.getInstance().itemlist.get(i).getItem_id(), currentUser.getInstance().itemlist.get(i).getItem_name(),
				currentUser.getInstance().itemlist.get(i).getItem_inventory(), currentUser.getInstance().itemlist.get(i).getCompany_id(), 
				currentUser.getInstance().itemlist.get(i).getItem_descr(), currentUser.getInstance().itemlist.get(i).getItem_note(), 
				currentUser.getInstance().itemlist.get(i).getLast_date());*/
				
			//ip.setAlignmentX(LEFT_ALIGNMENT);
		
			System.out.println(currentUser.getInstance().itemlist.get(i).getLast_date());
		
			inventoryholderpanel.add(ip);
			
		}
		
		
		
		
		//JPanel scrollholder = new JPanel();
		
		//scrollholder.setLayout(new BoxLayout(scrollholder, BoxLayout.PAGE_AXIS));
		
		
		//scrollholder.add(inventoryscrollPane);
		//System.out.println(currentUser.getInstance().getRole());
		
		String check = currentUser.getInstance().getRole();
		
	
		
		add(tabbedpanel, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedpanel.add(tabbedPane_1, BorderLayout.NORTH);
		
		//addInventoryItems(inventoryholderpanel);
		inventoryholderpanel_1 = new JPanel();
		inventoryholderpanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inventoryholderpanel_1.setBounds(new Rectangle(1800, 90, 800, 90));
		inventoryholderpanel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		inventoryholderpanel_1.setLayout(new BoxLayout(inventoryholderpanel_1, BoxLayout.Y_AXIS));
		
		//inventoryholderpanel_1.setLayout(new BorderLayout());
		changeFont(inventoryholderpanel_1, baseFont);
		//add(tabbedpanel);
		
		tabbedPane_1.setFont(headerFont);
		
		//inventoryscrollPane.setLayout(new BorderLayout(0, 0));
		
		//inventoryscrollPane.add(inventoryholderpanel_1);
		
		tabbedPane_1.addTab("Inventory", null, inventoryscrollPane, null);

	if(check.equals("Admin")){
			
			
			
			//System.out.println(currentUser.getInstance().getRole());
			
			JPanel employeeholderpanel = new JPanel();
			
			employeeholderpanel.setLayout(new BoxLayout(employeeholderpanel, BoxLayout.PAGE_AXIS));
			employeePanel e = new employeePanel();
			employeeholderpanel.add(e);
			
			JScrollPane employeescrollPane = new JScrollPane();
			//tabbedpanel.add(tabbedPane_1);
			employeescrollPane = new JScrollPane(employeeholderpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			employeescrollPane.setPreferredSize(new Dimension(4000, 1800));
			employeescrollPane.setMaximumSize(new Dimension(4000, 1800));
			employeescrollPane.getViewport().setMaximumSize(new Dimension(4000, 1800));
			employeescrollPane.getViewport().setPreferredSize(new Dimension(4000, 1800));
			employeescrollPane.getViewport().setMinimumSize(new Dimension(4000, 1800));
			
			dbc.getEmployees(currentUser.getInstance().getUser_id(), currentUser.getInstance().employeelist);
		
			System.out.println(currentUser.getInstance().employeelist.size());
			
			for(int i = 0; i < currentUser.getInstance().employeelist.size(); i++){
				
				employeePanel ep = new employeePanel(currentUser.getInstance().employeelist.get(i), currentUser.getInstance().employeelist.get(i).getEmployeeID(), 
						currentUser.getInstance().employeelist.get(i).getFirstName(), currentUser.getInstance().employeelist.get(i).getLastName(),
						currentUser.getInstance().employeelist.get(i).getEmail(), currentUser.getInstance().employeelist.get(i).getRole());
				
				employeeholderpanel.add(ep);
				
				
			}
				
			
		
			employeescrollPane.add(employeeholderpanel);
			//contentPane.add(panel, BorderLayout.NORTH);
			tabbedPane_1.addTab("Employees", null, employeeholderpanel, null );
		}
	}
	
	
	public dualtabbedpane(String in, String col, String word){

		setLayout(new BorderLayout(0, 0));
		
		
		JPanel tabbedpanel = new JPanel();
		tabbedpanel.setPreferredSize(new Dimension(3000, 3500));
		
		tabbedpanel.setLayout(new BorderLayout(0, 0));
		
		inventoryholderpanel = new JPanel();
		
		inventoryholderpanel.setLayout(new BoxLayout(inventoryholderpanel, BoxLayout.PAGE_AXIS));
		
		JScrollPane inventoryScollPane = new JScrollPane();
		//tabbedpanel.add(tabbedPane_1);
		JScrollPane inventoryscrollPane = new JScrollPane(inventoryholderpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		inventoryscrollPane.setPreferredSize(new Dimension(4000, 1800));
		inventoryscrollPane.setMaximumSize(new Dimension(4000, 1800));
		inventoryscrollPane.getViewport().setMaximumSize(new Dimension(3500, 1800));
		inventoryscrollPane.getViewport().setPreferredSize(new Dimension(3500, 1800));
		inventoryscrollPane.getViewport().setMinimumSize(new Dimension(3500, 1800));
		inventoryscrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(25, 0));
		
		dbc.search(in, col, word, currentUser.getInstance().itemlist);
		
		inventoryholderpanel.add(new inventoryPanel());
		
		for(int i = 0; i < currentUser.getInstance().itemlist.size(); i++)
		{
		inventoryPanel ip = new inventoryPanel(currentUser.getInstance().itemlist.get(i), currentUser.getInstance().itemlist.get(i).getItem_id(), currentUser.getInstance().itemlist.get(i).getItem_name(),
				currentUser.getInstance().itemlist.get(i).getItem_inventory(), currentUser.getInstance().itemlist.get(i).getCompany_id(), 
				currentUser.getInstance().itemlist.get(i).getItem_descr(), currentUser.getInstance().itemlist.get(i).getItem_note(), 
				currentUser.getInstance().itemlist.get(i).getLast_date());
				/*inventoryPanel ip = new inventoryPanel(currentUser.getInstance().itemlist.get(i).getItem_id(), currentUser.getInstance().itemlist.get(i).getItem_name(),
				currentUser.getInstance().itemlist.get(i).getItem_inventory(), currentUser.getInstance().itemlist.get(i).getCompany_id(), 
				currentUser.getInstance().itemlist.get(i).getItem_descr(), currentUser.getInstance().itemlist.get(i).getItem_note(), 
				currentUser.getInstance().itemlist.get(i).getLast_date());*/
				
			//ip.setAlignmentX(LEFT_ALIGNMENT);
		
			System.out.println(currentUser.getInstance().itemlist.get(i).getLast_date());
		
			inventoryholderpanel.add(ip);
			
		}
		
		
		
		
		//JPanel scrollholder = new JPanel();
		
		//scrollholder.setLayout(new BoxLayout(scrollholder, BoxLayout.PAGE_AXIS));
		
		
		//scrollholder.add(inventoryscrollPane);
		//System.out.println(currentUser.getInstance().getRole());
		
		String check = currentUser.getInstance().getRole();
		
	
		
		add(tabbedpanel, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedpanel.add(tabbedPane_1, BorderLayout.NORTH);
		
		//addInventoryItems(inventoryholderpanel);
		inventoryholderpanel_1 = new JPanel();
		inventoryholderpanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inventoryholderpanel_1.setBounds(new Rectangle(1800, 90, 800, 90));
		inventoryholderpanel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		inventoryholderpanel_1.setLayout(new BoxLayout(inventoryholderpanel_1, BoxLayout.Y_AXIS));
		
		//inventoryholderpanel_1.setLayout(new BorderLayout());
		changeFont(inventoryholderpanel_1, baseFont);
		//add(tabbedpanel);
		
		tabbedPane_1.setFont(headerFont);
		
		//inventoryscrollPane.setLayout(new BorderLayout(0, 0));
		
		//inventoryscrollPane.add(inventoryholderpanel_1);
		
		tabbedPane_1.addTab("Inventory", null, inventoryscrollPane, null);

	if(check.equals("Admin")){
			
			
			
			//System.out.println(currentUser.getInstance().getRole());
			
			JPanel employeeholderpanel = new JPanel();
			
			employeeholderpanel.setLayout(new BoxLayout(employeeholderpanel, BoxLayout.PAGE_AXIS));
			
			JScrollPane employeescrollPane = new JScrollPane();
			//tabbedpanel.add(tabbedPane_1);
			employeescrollPane = new JScrollPane(employeeholderpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			employeescrollPane.setPreferredSize(new Dimension(4000, 1800));
			employeescrollPane.setMaximumSize(new Dimension(4000, 1800));
			employeescrollPane.getViewport().setMaximumSize(new Dimension(4000, 1800));
			employeescrollPane.getViewport().setPreferredSize(new Dimension(4000, 1800));
			employeescrollPane.getViewport().setMinimumSize(new Dimension(4000, 1800));
			
			dbc.getEmployees(currentUser.getInstance().getUser_id(), currentUser.getInstance().employeelist);
		
			System.out.println(currentUser.getInstance().employeelist.size());
			
			for(int i = 0; i < currentUser.getInstance().employeelist.size(); i++){
				
				employeePanel ep = new employeePanel(currentUser.getInstance().employeelist.get(i), currentUser.getInstance().employeelist.get(i).getEmployeeID(), 
						currentUser.getInstance().employeelist.get(i).getFirstName(), currentUser.getInstance().employeelist.get(i).getLastName(),
						currentUser.getInstance().employeelist.get(i).getEmail(), currentUser.getInstance().employeelist.get(i).getRole());
				
				employeeholderpanel.add(ep);
				
				
			}
				
			
		
			employeescrollPane.add(employeeholderpanel);
			//contentPane.add(panel, BorderLayout.NORTH);
			tabbedPane_1.addTab("Employees", null, employeeholderpanel, null );
		}
	
	}
		public static void changeFont ( Component component, Font font )
		{
		    component.setFont ( font );
		    if ( component instanceof Container )
		    {
		        for ( Component child : ( ( Container ) component ).getComponents () )
		        {
		            changeFont ( child, font );
		        }
		    }
		}

	
}


	