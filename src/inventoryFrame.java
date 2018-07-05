import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JSeparator;
import java.awt.Dimension;

public  class inventoryFrame extends JFrame {
	
	DbConnector dbc = new DbConnector();
	
	ArrayList <InventoryItem> itemlist = new ArrayList<InventoryItem>();
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font  headerFontb = new Font("Calibri", Font.BOLD, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	Font errorFont = new Font("Calibri", Font.ITALIC, 18);
	
	JPanel inventoryholderpanel; 
	JPanel tabholderpanel = new JPanel();
	JTabbedPane tabbedPane;
	JPanel viewpanel;
	
	
	
	JPanel contentPane;

	dualtabbedpane tabs;
	
	inventoryFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	
	public inventoryFrame() {
		super("- Rough Inventory - "+ currentUser.getInstance().getUsername()+"");
		viewpanel = new JPanel();
		
		inventoryholderpanel=new JPanel();
		
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
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(135, 206, 235));
		menupanel.add(toolBar);
		
		JButton AddButton = new JButton(" Add ");
		AddButton.setBackground(new Color(135, 206, 235));
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewpanel.removeAll();
				viewpanel.add(addPanel());
				viewpanel.repaint();
				viewpanel.revalidate();
				//editFrameSolo eds = new editFrameSolo();
				//ds.setVisible(true);
				
			}
		});
		AddButton.setFont(headerFont);
		toolBar.add(AddButton);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(135, 206, 235));
		changeFont(btnRefresh, headerFont);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tabholderpanel.removeAll();
				
				currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
				currentUser.getInstance().employeelist = new ArrayList<employee>();
				currentUser.getInstance().invpanellist = new ArrayList <inventoryPanel>();
				currentUser.getInstance().emppanellist = new ArrayList <employeePanel>();
				
				dualtabbedpane newtabs = new dualtabbedpane();
					
				
				tabholderpanel.add(newtabs);
				Component horizontalStrut_1 = Box.createHorizontalStrut(40);
				tabholderpanel.add(horizontalStrut_1);
				
				tabholderpanel.repaint();
				tabholderpanel.revalidate();
				
				//repaint();
				//revalidate();
				
				//contentPane.add(inventoryholderpanel.add(newtabs), BorderLayout.SOUTH);
				//contentPane.repaint();
				//contentPane.revalidate();
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(135, 206, 235));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewpanel.removeAll();
				
				if(currentUser.getInstance().nextedit.equals("none")){
					
					
				}
				else if(currentUser.getInstance().nextedit.equals("inv")){
					viewpanel.add(InventoryEdit());
					viewpanel.repaint();
					viewpanel.revalidate();
					
					
				}
				else if(currentUser.getInstance().nextedit.equals("emp")){
					viewpanel.add(editEmployee());
					viewpanel.repaint();
					viewpanel.revalidate();
				}
			
			}
		});
		changeFont(btnEdit, headerFont);
		toolBar.add(btnEdit);
		toolBar.add(btnRefresh);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(135, 206, 235));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logoutdialog ld = new logoutdialog(frame);
				
			}
		});
		changeFont(btnLogOut, headerFont);
		toolBar.add(btnLogOut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		
		
		
		
		//tabholderpanel.setLayout(mgr);
		
		contentPane.add(tabholderpanel, BorderLayout.WEST);
				
				
				//JScrollPane inventoryscrollPane = new JScrollPane();
				
		tabs = new dualtabbedpane();
		tabholderpanel.add(tabs);
						
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		tabholderpanel.add(horizontalStrut_1);
						
		//viewpanel = addPanel();
		
		contentPane.add(viewpanel, BorderLayout.EAST);
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
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
	JPanel addPanel(){
		JPanel Returnpanel =new JPanel(); 
		JTextField itemnameField;
		JTextField countField;
		 JTextField descField;
		 JTextField NoteField;
		int currentitemID;
		

		
		/**
		 * Create the frame.
		 */
		
			
			
		
			Returnpanel.setLayout(new BorderLayout(0, 0));
			JPanel toppanel = new JPanel();
			toppanel.setLayout(new BorderLayout());
			Returnpanel.add(toppanel, BorderLayout.NORTH);
			
			JLabel titlepanel = new JLabel(" Add an Inventory Item ");
			changeFont(titlepanel, headerFont);
			toppanel.add(titlepanel, BorderLayout.WEST);
			JPanel panel = new JPanel();
			Returnpanel.add(panel, BorderLayout.WEST);
			Component horizontalStrut = Box.createHorizontalStrut(40);
			Returnpanel.add(horizontalStrut, BorderLayout.EAST);
			
			
			
			panel.setLayout(new GridLayout(26, 1, 0, 0));
			
			
			JLabel lblNewLabel = new JLabel("Item Name");
			changeFont(lblNewLabel,headerFont);
			panel.add(lblNewLabel);
			
			itemnameField = new JTextField();
			changeFont(itemnameField,baseFont);	
			panel.add(itemnameField);
			itemnameField.setColumns(10);
			
			Component verticalStrut = Box.createVerticalStrut(20);
			panel.add(verticalStrut);
			
			JLabel lblInventoryCount = new JLabel("Inventory Count");
			changeFont(lblInventoryCount,headerFont);
			panel.add(lblInventoryCount);
			
			countField = new JTextField();
			changeFont(countField,baseFont);		

			panel.add(countField);
			countField.setColumns(20);
			
			JLabel count_error_label = new JLabel("");
			changeFont(count_error_label, errorFont);
			count_error_label.setForeground(Color.RED);
			panel.add(count_error_label);
			
			JLabel descLabel = new JLabel("Item description");
			changeFont(descLabel,headerFont);
			panel.add(descLabel);
			
			descField = new JTextField();
			changeFont(descField,baseFont);		

			panel.add(descField);
			descField.setColumns(10);
			
			Component verticalStrut_1 = Box.createVerticalStrut(20);
			panel.add(verticalStrut_1);
			
			JLabel noteLabel = new JLabel("Note");
			changeFont(noteLabel,headerFont);
			panel.add(noteLabel);
			
			NoteField = new JTextField();
			changeFont(NoteField,baseFont);		
			panel.add(NoteField);
			NoteField.setColumns(10);
			
			JLabel label = new JLabel(" ");
			panel.add(label);
			
			JPanel panel_1 = new JPanel();
			panel.add(panel_1);
			
			JButton btnConfirmChanges = new JButton("Add Item");
			changeFont(btnConfirmChanges,headerFont);

			 btnConfirmChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				
					
						
					
						try{
						int i = Integer.parseInt(countField.getText());
						dbc.addInv(itemnameField.getText(), i, descField.getText(), 
								NoteField.getText());
						tabholderpanel.removeAll();
						
						currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
						currentUser.getInstance().employeelist = new ArrayList<employee>();
						currentUser.getInstance().invpanellist = new ArrayList <inventoryPanel>();
						currentUser.getInstance().emppanellist = new ArrayList <employeePanel>();
						
						dualtabbedpane newtabs = new dualtabbedpane();
							
						
						tabholderpanel.add(newtabs);
						Component horizontalStrut_1 = Box.createHorizontalStrut(40);
						tabholderpanel.add(horizontalStrut_1);
						
						tabholderpanel.repaint();
						tabholderpanel.revalidate();
						itemnameField.setText("");
						countField.setText("");
						descField.setText("");
						NoteField.setText("");
						}
						catch(NumberFormatException ex)
						{
							count_error_label.setText("Inventory must be a number. ");
							
						}
						
								//userSignIn si = new userSignIn();
								
								
						}
					});
			btnConfirmChanges.setHorizontalAlignment(SwingConstants.LEFT);
			panel_1.add(btnConfirmChanges);
		return Returnpanel;
	}
	
////////////////////////////////////////////////////	
	JPanel InventoryEdit(){
		JPanel Returnpanel = new JPanel();
		JPanel contentPane;
		JTextField itemnameField;
		JTextField countField;
		JTextField descField;
		JTextField NoteField;
		
		
		
		Returnpanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		Returnpanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(26, 1, 0, 0));
		
	
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JLabel title = new JLabel("Editing Selected Inventory");
		changeFont(title, headerFont);
		p1.add(title, BorderLayout.WEST);
		Component verticalStrut4 = Box.createVerticalStrut(20);
		//p1.add(verticalStrut4);
		
		panel.add(p1);
		panel.add(verticalStrut4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(1,2));
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Item Name: ");
		panel_2.add(lblNewLabel);
		changeFont(lblNewLabel,headerFont);
		System.out.println(currentUser.getInstance().currentInv.getItem_name());
		JLabel currentnamelbl = new JLabel(currentUser.getInstance().currentInv.getItem_name());
		changeFont(currentnamelbl,headerFontb);
		panel_2.add(currentnamelbl);
		
		itemnameField = new JTextField();
		changeFont(itemnameField,baseFont);	
		panel.add(itemnameField);
		itemnameField.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(1,2));
		panel.add(panel_3);
		
		JLabel lblInventoryCount = new JLabel("Inventory Count: ");
		panel_3.add(lblInventoryCount);
		changeFont(lblInventoryCount,headerFont);
		
		
		
		Integer i = currentUser.getInstance().currentInv.getItem_inventory();
		String s = i.toString();
		JLabel currentcountLabel = new JLabel(s);
		changeFont(currentcountLabel,headerFontb);
		panel_3.add(currentcountLabel);
		
		countField = new JTextField();
		changeFont(countField,baseFont);		

		panel.add(countField);
		countField.setColumns(10);
		
		JLabel count_error_label = new JLabel("");
		panel.add(count_error_label);
		
		JLabel descLabel = new JLabel("Item description");
		changeFont(descLabel,headerFont);
		panel.add(descLabel);
		
		descField = new JTextField();
		changeFont(descField,baseFont);		

		panel.add(descField);
		descField.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		
		JLabel noteLabel = new JLabel("Note");
		changeFont(noteLabel,headerFont);
		panel.add(noteLabel);
		
		NoteField = new JTextField();
		changeFont(NoteField,baseFont);		
		panel.add(NoteField);
		NoteField.setColumns(10);
		
		JLabel label = new JLabel(" ");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(1,2));
		panel.add(panel_1);
		
		JButton btnConfirmChanges = new JButton("Confirm Changes");
		changeFont(btnConfirmChanges,headerFontb);

		 btnConfirmChanges.addActionListener(new ActionListener() {
			 String itemname;
			public void actionPerformed(ActionEvent arg0) {
			if(itemnameField.getText().isEmpty() == true){
				 itemname = currentUser.getInstance().currentInv.getItem_name();
			}
			else{
				itemname = itemnameField.getText();
			}
			int count = 0;
			if(countField.getText().isEmpty() == true){
				count = currentUser.getInstance().currentInv.getItem_inventory();
			}
			else{
				try{
					count = Integer.parseInt(countField.getText());
				}
				catch(NumberFormatException ex)
				{
					count_error_label.setText("Inventory must be a number. ");
					
				}
			}
				String itemdesc; 
				if(descField.getText().isEmpty() == true){
					itemdesc = currentUser.getInstance().currentInv.getItem_descr();
				}
				else{
					itemdesc = descField.getText();
				}
				String itemnote; 
				if(NoteField.getText().isEmpty() == true){
					itemnote = currentUser.getInstance().currentInv.getItem_note();
				}
				else{
					itemnote = NoteField.getText();
				}
				
				String date = new SimpleDateFormat("mm-dd-yy").format(new Date());
			
			InventoryItem ii = new InventoryItem(currentUser.getInstance().currentInv.getItem_id(), itemname, count, itemdesc, itemnote, date, currentUser.getInstance().currentInv.getCompany_id());
				
					
				
					try{
					//int i = Integer.parseInt(countField.getText());
					dbc.updateInventory(currentUser.getInstance().getCompany_id(), ii);
					tabholderpanel.removeAll();
					
					currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
					currentUser.getInstance().employeelist = new ArrayList<employee>();
					currentUser.getInstance().invpanellist = new ArrayList <inventoryPanel>();
					currentUser.getInstance().emppanellist = new ArrayList <employeePanel>();
					
					dualtabbedpane newtabs = new dualtabbedpane();
						
					
					tabholderpanel.add(newtabs);
					Component horizontalStrut_1 = Box.createHorizontalStrut(40);
					tabholderpanel.add(horizontalStrut_1);
					
					tabholderpanel.repaint();
					tabholderpanel.revalidate();
					itemnameField.setText("");
					countField.setText("");
					descField.setText("");
					NoteField.setText("");
					viewpanel.removeAll();
					
					}
					catch(NumberFormatException ex)
					{
						
					}
					
							//userSignIn si = new userSignIn();
							
							
					}
				});
		btnConfirmChanges.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnConfirmChanges);
		JLabel n = new JLabel("");
		//panel_1.add(n);
		JButton removeInv = new JButton("Remove Item");
		changeFont(removeInv,headerFontb);
		removeInv.setBackground(Color.red);
		

		removeInv.addActionListener(new ActionListener() {
			 String itemname;
			public void actionPerformed(ActionEvent arg0) {
				dbc.deleteInv();
				tabholderpanel.removeAll();
				
				currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
				currentUser.getInstance().employeelist = new ArrayList<employee>();
				currentUser.getInstance().invpanellist = new ArrayList <inventoryPanel>();
				currentUser.getInstance().emppanellist = new ArrayList <employeePanel>();
				
				dualtabbedpane newtabs = new dualtabbedpane();
					
				
				tabholderpanel.add(newtabs);
				Component horizontalStrut_1 = Box.createHorizontalStrut(40);
				tabholderpanel.add(horizontalStrut_1);
				
				tabholderpanel.repaint();
				tabholderpanel.revalidate();
				itemnameField.setText("");
				countField.setText("");
				descField.setText("");
				NoteField.setText("");
				viewpanel.removeAll();
				}
			});
		 panel_1.add(removeInv);
		
		return Returnpanel;
	}
	
	JPanel editEmployee(){
		JPanel returnplane = new JPanel();
		returnplane.setLayout(new BoxLayout(returnplane, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JLabel title = new JLabel("Editing Selected Employee");
		changeFont(title, headerFontb);
		p1.add(title, BorderLayout.WEST);
		Component verticalStrut4 = Box.createVerticalStrut(50);
		returnplane.add(title);
		returnplane.add(verticalStrut4);
		
		JLabel nametitle = new JLabel("Employee name:");
		changeFont(nametitle, headerFont);
		nametitle.setAlignmentX(LEFT_ALIGNMENT);
		returnplane.add(nametitle);
		String employeeName = new String(currentUser.getInstance().getCurrentEmp().getFirstName() + " " + currentUser.getInstance().getCurrentEmp().getLastName());
		JLabel nameLabel = new JLabel(employeeName);
		
		changeFont(nameLabel, headerFontb);
		nameLabel.setAlignmentX(LEFT_ALIGNMENT);
		returnplane.add(nameLabel);
		Component verticalStrut = Box.createVerticalStrut(50);
		returnplane.add(verticalStrut);
		
		JLabel emailtitle = new JLabel("Employee email:");
		emailtitle.setAlignmentX(LEFT_ALIGNMENT);
		changeFont(emailtitle, headerFont);
		returnplane.add(emailtitle);
		//String employeeName = new String(currentUser.getInstance().getCurrentEmp().getFirstName() + " " + currentUser.getInstance().getCurrentEmp().getLastName());
		JLabel emailLabel = new JLabel(currentUser.getInstance().getCurrentEmp().getEmail());
		changeFont(emailLabel, headerFontb);
		emailLabel.setAlignmentX(LEFT_ALIGNMENT);
		returnplane.add(emailLabel);
		Component verticalStrut1 = Box.createVerticalStrut(50);
		returnplane.add(verticalStrut1);
		
		JLabel ranktitle = new JLabel("Employee rank:");
		changeFont(ranktitle, headerFont);
		ranktitle.setAlignmentX(LEFT_ALIGNMENT);
		returnplane.add(ranktitle);
		//String employeeName = new String(currentUser.getInstance().getCurrentEmp().getFirstName() + " " + currentUser.getInstance().getCurrentEmp().getLastName());
		JLabel rankLabel = new JLabel(currentUser.getInstance().getCurrentEmp().getRole());
		changeFont(rankLabel, headerFontb);
		rankLabel.setAlignmentX(LEFT_ALIGNMENT);
		returnplane.add(rankLabel);
		Component verticalStrut2 = Box.createVerticalStrut(50);
		returnplane.add(verticalStrut2);
		
		JLabel listtitle = new JLabel("Change employee access:");
		changeFont(listtitle, headerFont);
		returnplane.add(listtitle);
		
	
        
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Has full access.");  
        l1.addElement("Can edit inventory");  
        l1.addElement("Can veiw but can't edit.");  
        JList<String> list = new JList<>(l1);  
        list.setBounds(100,100, 75,75);  
        changeFont(list,headerFontb);
        list.setAlignmentX(LEFT_ALIGNMENT);
        returnplane.add(list);
        
    	JButton btnConfirmChanges = new JButton("Confirm Changes");
		changeFont(btnConfirmChanges,headerFont);

		 btnConfirmChanges.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
					
					//int i = Integer.parseInt(countField.getText());
					dbc.updateEmployee(currentUser.getInstance().currentEmp.getEmployeeID(), list.getSelectedValue());
					tabholderpanel.removeAll();
					
					currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
					currentUser.getInstance().employeelist = new ArrayList<employee>();
					currentUser.getInstance().invpanellist = new ArrayList <inventoryPanel>();
					currentUser.getInstance().emppanellist = new ArrayList <employeePanel>();
					
					dualtabbedpane newtabs = new dualtabbedpane();
						
					
					tabholderpanel.add(newtabs);
					Component horizontalStrut_1 = Box.createHorizontalStrut(40);
					tabholderpanel.add(horizontalStrut_1);
					
					tabholderpanel.repaint();
					tabholderpanel.revalidate();
					
					viewpanel.removeAll();
					
					
					
							//userSignIn si = new userSignIn();
							
							
		 }
				});
		btnConfirmChanges.setHorizontalAlignment(SwingConstants.LEFT);
        returnplane.add(btnConfirmChanges);
        
		return returnplane;
		
		
	}
	
	
	JPanel searchPanel(){
		JPanel returnplane = new JPanel();
		returnplane.setLayout(new BoxLayout(returnplane, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JLabel title = new JLabel("Select a catagory to search. ");
		changeFont(title, headerFontb);
		p1.add(title, BorderLayout.WEST);
		p1.setAlignmentX(LEFT_ALIGNMENT);
		Component verticalStrut4 = Box.createVerticalStrut(50);
		returnplane.add(title);
		returnplane.add(verticalStrut4);
		
	
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Inventory");  
        l1.addElement("Users");  
          
        JList<String> list = new JList<>(l1);  
        list.setBounds(100,100, 75,75);  
        changeFont(list,headerFontb);
        list.setAlignmentX(LEFT_ALIGNMENT);
        returnplane.add(list);
        
    	JButton btnConfirmChanges = new JButton("Confirm selection");
		changeFont(btnConfirmChanges,headerFont);
		btnConfirmChanges.setAlignmentX(LEFT_ALIGNMENT);
		returnplane.add(btnConfirmChanges);
		
		Component verticalStrut1 = Box.createVerticalStrut(50);
		returnplane.add(verticalStrut1);

		 
					
					
						JPanel p2 = new JPanel();
						p2.setLayout(new BorderLayout());
						JLabel titlei = new JLabel("Select a column to search. ");
						changeFont(titlei, headerFontb);
						p2.add(titlei, BorderLayout.WEST);
						returnplane.add(p2);
						
						DefaultListModel<String> l2 = new DefaultListModel<>();  
				        l2.addElement("Item Name");  
				        l2.addElement("Item Description");  
				        l2.addElement("Item Note");  
				          
				        JList<String> listi = new JList<>(l2);  
				        listi.setBounds(100,100, 75,75);  
				        changeFont(listi,headerFontb);
				        listi.setAlignmentX(LEFT_ALIGNMENT);
				        returnplane.add(listi);
				        
				      
				
		 btnConfirmChanges.setHorizontalAlignment(SwingConstants.LEFT);
	        //returnplane.add(btnConfirmChanges); 
		 JPanel p3 = new JPanel();
			p3.setLayout(new BorderLayout());
			JLabel titlet = new JLabel("Input a word to search. ");
			changeFont(titlet, headerFontb);
			p3.add(titlet, BorderLayout.WEST);
			p3.setAlignmentX(LEFT_ALIGNMENT);
			returnplane.add(p3);
	        
			JTextField infi = new JTextField();
			changeFont(infi, headerFontb);
			infi.setAlignmentX(LEFT_ALIGNMENT);
			returnplane.add(infi);
			
			JButton btnConfirmChanges2 = new JButton("Confirm selection");
			changeFont(btnConfirmChanges,headerFont);
			btnConfirmChanges2.setAlignmentX(LEFT_ALIGNMENT);
			Component verticalStrut3 = Box.createVerticalStrut(50);
			returnplane.add(verticalStrut3);

			 btnConfirmChanges2.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent arg0) {
					 	//dbc.search("Inventory", CurrentStock, infi.getText(), itemList)
					 	tabholderpanel.removeAll();
						
						currentUser.getInstance().itemlist = new ArrayList<InventoryItem>();
						currentUser.getInstance().employeelist = new ArrayList<employee>();
						currentUser.getInstance().invpanellist = new ArrayList <inventoryPanel>();
						currentUser.getInstance().emppanellist = new ArrayList <employeePanel>();
						
						dualtabbedpane newtabs = new dualtabbedpane("Inventory", "CurrentStock", infi.getText());
							
						
						tabholderpanel.add(newtabs);
						Component horizontalStrut_1 = Box.createHorizontalStrut(40);
						tabholderpanel.add(horizontalStrut_1);
						
						tabholderpanel.repaint();
						tabholderpanel.revalidate();
						
						viewpanel.removeAll();
				 }
			 });
			 btnConfirmChanges2.setHorizontalAlignment(SwingConstants.LEFT);
		        returnplane.add(btnConfirmChanges2);
        
		return returnplane;
		
		
	}
}


