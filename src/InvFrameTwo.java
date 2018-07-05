import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InvFrameTwo extends JFrame {
	DbConnector dbc = new DbConnector();

	ArrayList <InventoryItem> itemlist = new ArrayList<InventoryItem>();
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	
	JPanel inventoryholderpanel = new JPanel(); 
	JPanel tabholderpanel = new JPanel();
	JTabbedPane tabbedPane;
	
	JPanel contentPane;

	dualtabbedpane tabs;
	
	InvFrameTwo frame;
		
	public InvFrameTwo() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 00, 3883, 2907);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabholderpanel = new JPanel();
		
		
		//dbc.getInventory(currentUser.getInstance().getCompany_id(), itemlist);
		frame = this;
		
		JPanel menupanel = new JPanel();
		contentPane.add(menupanel, BorderLayout.NORTH);
		menupanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JToolBar toolBar = new JToolBar();
		menupanel.add(toolBar);
		
		JButton AddButton = new JButton(" Add ");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				editFrameSolo eds = new editFrameSolo();
				eds.setVisible(true);
				
			}
		});
		AddButton.setFont(headerFont);
		toolBar.add(AddButton);
		
		JButton btnRefresh = new JButton("Refresh");
		changeFont(btnRefresh, headerFont);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inventoryholderpanel.removeAll();
				
				currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
				currentUser.getInstance().employeelist = new ArrayList<employee>();
				
				dualtabbedpane newtabs = new dualtabbedpane();
					
				
				inventoryholderpanel.add(newtabs);
				
				inventoryholderpanel.repaint();
				//inventoryholderpanel.revalidate();
				
				repaint();
				revalidate();
				
				//contentPane.add(inventoryholderpanel.add(newtabs), BorderLayout.SOUTH);
				contentPane.repaint();
				//contentPane.revalidate();
			}
		});
		toolBar.add(btnRefresh);
		
		JButton btnSearch = new JButton("Search");
		changeFont(btnSearch, headerFont);
		toolBar.add(btnSearch);
		
		JButton btnLogOut = new JButton("Log Out");
		changeFont(btnLogOut, headerFont);
		toolBar.add(btnLogOut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		
		JScrollPane employeescrollPane = new JScrollPane();
		
		
		//tabholderpanel.setLayout(mgr);
		
		contentPane.add(tabholderpanel, BorderLayout.EAST);
				
				
				//JScrollPane inventoryscrollPane = new JScrollPane();
				
						tabs = new dualtabbedpane();
						tabholderpanel.add(tabs);
						
						Component horizontalStrut_1 = Box.createHorizontalStrut(40);
						tabholderpanel.add(horizontalStrut_1);
			
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
		
		public void update(){
			//tabs = new dualtabbedpane();
			revalidate();
			repaint();
			//this.dispose();
		}
		
		JPanel InventoryList()
		{
			JPanel inventoryholder = new JPanel();
			inventoryholder.setLayout(new BoxLayout(inventoryholderpanel, BoxLayout.PAGE_AXIS));
			
			//JScrollPane inventoryScollPane = new JScrollPane();
			//tabbedpanel.add(tabbedPane_1);
			
			
			dbc.getInventory(currentUser.getInstance().getCompany_id(), currentUser.getInstance().itemlist);
			
			for(int i = 0; i < currentUser.getInstance().itemlist.size(); i++)
			{
			inventoryPanel ip = new inventoryPanel(currentUser.getInstance().itemlist.get(i), currentUser.getInstance().itemlist.get(i).getItem_id(), currentUser.getInstance().itemlist.get(i).getItem_name(),
					currentUser.getInstance().itemlist.get(i).getItem_inventory(), currentUser.getInstance().itemlist.get(i).getCompany_id(), 
					currentUser.getInstance().itemlist.get(i).getItem_descr(), currentUser.getInstance().itemlist.get(i).getItem_note(), 
					currentUser.getInstance().itemlist.get(i).getLast_date());
					
			
				inventoryholderpanel.add(ip);
				currentUser.getInstance().invpanellist.add(ip);
				
			}
			contentPane.add(inventoryholderpanel);
			return contentPane;
			
		}
	}


