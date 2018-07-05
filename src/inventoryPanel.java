import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;


// The inventory items grabbed from the database will be stored in these objects and then put in a Jscrollpane
public class inventoryPanel extends JPanel {

	
	Font  headerFont = new Font("Calibri", Font.BOLD, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 28);
	
	InventoryItem storedItem;
	String itemName;
	int itemID;
	int inventoryCount;
	String itemDescription;
	int companyID;
	
	JPanel namepanel;
	
	JLabel nameLabel;
	
	
	JPanel inventorycountpanel ;
	
	JLabel countLabel;
	
	JPanel descriptionpanel;
	
	JLabel descLabel;
	
	JPanel notes_panel;
	
	JLabel notesLabel;
	
	JPanel lastupdatedpanel;
	
	JLabel lastupdatedlabel;
	
	JPanel panel;
	
	
	JButton editButton;
	
	JPanel panel_1 ;
	private final Action action = new SwingAction();
	private JCheckBox selectedCheck;
	inventoryPanel ip = this;
	
	void setItemID(int in)
	{
		itemID = in;
		
	}
 
	
	public inventoryPanel( ) {
		setMinimumSize(new Dimension(1000, 70));
		setMaximumSize(new Dimension(32767, 70));
		setBounds(new Rectangle(0, 0, 900, 7));
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new GridLayout(1,6));
		
		//storedItem = inv;
		
		itemID = 0;
		
		companyID = 0;
		
		namepanel = new JPanel();
		namepanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(namepanel);
		
		 nameLabel = new JLabel(" Name ");
		 changeFont(nameLabel, headerFont);
		namepanel.add(nameLabel);
		
		
		inventorycountpanel = new JPanel();
		inventorycountpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(inventorycountpanel);
		//String ic = Integer.toString();
		countLabel = new JLabel(" Current Stock ");
		 changeFont(countLabel, headerFont);
		inventorycountpanel.add(countLabel);
		
		descriptionpanel = new JPanel();
		descriptionpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(descriptionpanel);
		
		descLabel = new JLabel(" Item Description ");
		changeFont(descLabel, headerFont);
		descriptionpanel.add(descLabel);
		
		notes_panel = new JPanel();
		notes_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(notes_panel);
		
		 notesLabel = new JLabel(" Item Notes  ");
			changeFont(notesLabel, headerFont);

		notes_panel.add(notesLabel);
		
		lastupdatedpanel = new JPanel();
		lastupdatedpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		add(lastupdatedpanel);
		
		lastupdatedlabel = new JLabel("   Last Updated   ");
		changeFont(lastupdatedlabel, headerFont);
		lastupdatedpanel.add(lastupdatedlabel);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(panel);
		
		//editButton = new JButton("  Edit  ");
		//editButton.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent arg0) {
				
				//editFrameSolo eds = new editFrameSolo();
			//	eds.setVisible(true);
				
		//	}
	//	});
		//changeFont(editButton, baseFont);
		/*panel.add(new JLabel(" "));
		
		panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 30));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1);
		
		//selectedCheck = new JCheckBox();
		panel_1.add(new JLabel(" "));*/
		
		
	}
	
	public inventoryPanel(InventoryItem inv, int itemid, String itemname, int inventorycount,  int companyid, String itemDesc, String note, String lastupdated ) {
		setMinimumSize(new Dimension(1100, 60));
		setMaximumSize(new Dimension(32767, 60));
		setBounds(new Rectangle(0, 0, 900, 7));
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new GridLayout(1,6));
		
		System.out.println(inv.getItem_name());
		
		storedItem = inv;
		
		itemID = itemid;
		
		companyID = companyid;
		
		namepanel = new JPanel();
		namepanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(namepanel);
		
		 nameLabel = new JLabel(itemname);
		 changeFont(nameLabel, baseFont);
		namepanel.add(nameLabel);
		
		
		inventorycountpanel = new JPanel();
		inventorycountpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(inventorycountpanel);
		String ic = Integer.toString(inventorycount);
		countLabel = new JLabel(ic);
		 changeFont(countLabel, baseFont);
		inventorycountpanel.add(countLabel);
		
		descriptionpanel = new JPanel();
		descriptionpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(descriptionpanel);
		
		descLabel = new JLabel(itemDesc);
		changeFont(descLabel, baseFont);
		descriptionpanel.add(descLabel);
		
		notes_panel = new JPanel();
		notes_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(notes_panel);
		
		 notesLabel = new JLabel(note);
			changeFont(notesLabel, baseFont);

		notes_panel.add(notesLabel);
		
		lastupdatedpanel = new JPanel();
		lastupdatedpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		add(lastupdatedpanel);
		
		lastupdatedlabel = new JLabel(lastupdated);
		changeFont(lastupdatedlabel, baseFont);
		lastupdatedpanel.add(lastupdatedlabel);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel);
		
		selectedCheck = new JCheckBox();
		selectedCheck.setPreferredSize(new Dimension(50, 50));
		selectedCheck.setMinimumSize(new Dimension(50, 50));
		selectedCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentUser.getInstance().currentlycheckedinv != null){
					//uncheck other
					currentUser.getInstance().currentlycheckedinv.selectedCheck.setSelected(false);
					//set new
					currentUser.getInstance().currentlycheckedinv = ip;
					
					currentUser.getInstance().currentInv = storedItem;
					
					currentUser.getInstance().nextedit="inv";			
				}
				else{
					currentUser.getInstance().currentlycheckedinv = ip;
					currentUser.getInstance().nextedit="inv";
					currentUser.getInstance().currentInv = storedItem;
				}
			}
		});
		//changeFont(editButton, baseFont);
		panel.add(selectedCheck);
		
	/*	panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 30));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1);*/
		
		//selectedCheck = new JCheckBox();
		//panel_1.add("");
		
		
	}

	void setProperties(String item_name, int itemID, int inventoryCount, String itemDescription)
	{
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
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