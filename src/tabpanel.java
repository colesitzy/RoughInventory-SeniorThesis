import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public class tabpanel extends JPanel {
	
	
	
	DbConnector dbc = new DbConnector();

	ArrayList <InventoryItem> itemlist = new ArrayList<InventoryItem>();
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	
	JPanel inventoryholderpanel; 

	JTabbedPane tabbedPane;
	
	private JPanel contentPane;

	public tabpanel() {


		JScrollPane employeescrollPane = new JScrollPane();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		JScrollPane inventoryscrollPane = new JScrollPane();
		
		
		
	
		
		inventoryholderpanel = new JPanel();
		inventoryholderpanel.setBounds(new Rectangle(800, 90, 800, 90));
		inventoryholderpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		inventoryholderpanel.setLayout(new BoxLayout(inventoryholderpanel, BoxLayout.Y_AXIS));
		//addInventoryItems(inventoryholderpanel);
		for(int i = 0; i < itemlist.size(); i++)
		{
		inventoryPanel ip = new inventoryPanel(itemlist.get(i), itemlist.get(i).getItem_id(), itemlist.get(i).getItem_name(),
				itemlist.get(i).getItem_inventory(), itemlist.get(i).getCompany_id(), 
				itemlist.get(i).getItem_descr(), itemlist.get(i).getItem_note(), 
				itemlist.get(i).getLast_date());
		/*inventoryPanel ip = new inventoryPanel(currentUser.getInstance().itemlist.get(i).getItem_id(), currentUser.getInstance().itemlist.get(i).getItem_name(),
				currentUser.getInstance().itemlist.get(i).getItem_inventory(), currentUser.getInstance().itemlist.get(i).getCompany_id(), 
				currentUser.getInstance().itemlist.get(i).getItem_descr(), currentUser.getInstance().itemlist.get(i).getItem_note(), 
				currentUser.getInstance().itemlist.get(i).getLast_date());*/
				
		ip.setAlignmentX(LEFT_ALIGNMENT);
		
		//System.out.println(itemlist.get().getItem_name());
		
		inventoryholderpanel.add(ip);
		}
		
		changeFont(inventoryholderpanel, baseFont);
		//inventoryscrollPane.add(inventoryholderpanel);
		
		
		JPanel employeeholderpanel = new JPanel();
		employeescrollPane.add(employeeholderpanel);
		//contentPane.add(panel, BorderLayout.NORTH);
		tabbedPane.setFont(headerFont);
		
		
		tabbedPane.addTab("Inventory", null, inventoryholderpanel, null);
		tabbedPane.addTab("Employees", null, employeescrollPane, null );
		

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
