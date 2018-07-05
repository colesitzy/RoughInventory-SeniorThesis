import javax.swing.JPanel;
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

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class employeePanel extends JPanel {




// The inventory items grabbed from the database will be stored in these objects and then put in a Jscrollpane

	
	Font  headerFont = new Font("Calibri", Font.BOLD, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 28);
	
	String itemName;
	int employeeId;
	int inventoryCount;
	String itemDescription;
	int companyID;
	
	employeePanel ep = this;
	
	JPanel firstnamepanel;
	
	JLabel firstnameLabel;
	
	JPanel lastnamepanel;
	
	JLabel lastnameLabel;
	
	JPanel emailpanel;
	
	JLabel emailLabel;
	
	JPanel rolepanel;
	
	JLabel roleLabel;
	
	JPanel panel;
	private final Action action = new SwingAction();
	private JCheckBox selectedCheck;
	
	employee storedemp;
	
	void setemployeeId(int in)
	{
		employeeId = in;
		
	}
 
	public employeePanel( ) {
		setMinimumSize(new Dimension(1100, 70));
		setMaximumSize(new Dimension(32767, 70));
		setBounds(new Rectangle(0, 0, 900, 7));
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new GridLayout(1,7));
		
		//storedemp = emp;
		
		//employeeId = employeeI;
		
		
		firstnamepanel = new JPanel();
		firstnamepanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(firstnamepanel);
		
		firstnameLabel = new JLabel("First Name");
		 changeFont(firstnameLabel, headerFont);
		 firstnamepanel.add(firstnameLabel);
		
		lastnamepanel = new JPanel();
		lastnamepanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(lastnamepanel);
		
		lastnameLabel = new JLabel("Last Name");
		 changeFont(lastnameLabel, headerFont);
		 lastnamepanel.add(lastnameLabel);
		 

		emailpanel = new JPanel();
		emailpanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(emailpanel);
			
		emailLabel = new JLabel("Email");
		changeFont(emailLabel, headerFont);
		emailpanel.add(emailLabel);
		
		
		rolepanel = new JPanel();
		rolepanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(rolepanel);
			
		roleLabel = new JLabel("Role");
		changeFont(roleLabel, headerFont);
		rolepanel.add(roleLabel);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(panel);
		
		selectedCheck = new JCheckBox("");
		selectedCheck.setPreferredSize(new Dimension(50, 50));
		selectedCheck.setMinimumSize(new Dimension(50, 50));
		selectedCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentUser.getInstance().currentlycheckedinv != null){
					//uncheck other
					currentUser.getInstance().currentlycheckedemp.selectedCheck.setSelected(false);
					//set new
					currentUser.getInstance().currentlycheckedemp= ep;
					
					currentUser.getInstance().currentEmp = storedemp;
					
					currentUser.getInstance().nextedit = "emp";
					
					System.out.println(currentUser.getInstance().currentEmp.getFirstName());
								
				}
				else{
					currentUser.getInstance().currentlycheckedemp = ep;
					
					currentUser.getInstance().nextedit = "emp";
					
					currentUser.getInstance().currentEmp = storedemp;
					
					System.out.println(currentUser.getInstance().currentEmp.getFirstName());
				}
			}
		});
		//panel.add(selectedCheck);
		
		
	}
	
	
	public employeePanel(employee emp, int employeeI, String firstname, String lastname, String email, String role ) {
		setMinimumSize(new Dimension(1100, 70));
		setMaximumSize(new Dimension(32767, 70));
		setBounds(new Rectangle(0, 0, 900, 7));
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new GridLayout(1,7));
		
		storedemp = emp;
		
		employeeId = employeeI;
		
		
		firstnamepanel = new JPanel();
		firstnamepanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(firstnamepanel);
		
		firstnameLabel = new JLabel(firstname);
		 changeFont(firstnameLabel, baseFont);
		 firstnamepanel.add(firstnameLabel);
		
		lastnamepanel = new JPanel();
		lastnamepanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(lastnamepanel);
		
		lastnameLabel = new JLabel(lastname);
		 changeFont(lastnameLabel, baseFont);
		 lastnamepanel.add(lastnameLabel);
		 

		emailpanel = new JPanel();
		emailpanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(emailpanel);
			
		emailLabel = new JLabel(email);
		changeFont(emailLabel, baseFont);
		emailpanel.add(emailLabel);
		
		
		rolepanel = new JPanel();
		rolepanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(rolepanel);
			
		roleLabel = new JLabel(role);
		changeFont(roleLabel, baseFont);
		rolepanel.add(roleLabel);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(panel);
		
		selectedCheck = new JCheckBox("");
		selectedCheck.setPreferredSize(new Dimension(50, 50));
		selectedCheck.setMinimumSize(new Dimension(50, 50));
		selectedCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentUser.getInstance().currentlycheckedinv != null){
					//uncheck other
					currentUser.getInstance().currentlycheckedemp.selectedCheck.setSelected(false);
					//set new
					currentUser.getInstance().currentlycheckedemp= ep;
					
					currentUser.getInstance().currentEmp = storedemp;
					
					currentUser.getInstance().nextedit = "emp";
					
					System.out.println(currentUser.getInstance().currentEmp.getFirstName());
								
				}
				else{
					currentUser.getInstance().currentlycheckedemp = ep;
					
					currentUser.getInstance().nextedit = "emp";
					
					currentUser.getInstance().currentEmp = storedemp;
					
					System.out.println(currentUser.getInstance().currentEmp.getFirstName());
				}
			}
		});
		panel.add(selectedCheck);
		
		
	}

	void setProperties(String item_name, int employeeId, int inventoryCount, String itemDescription)
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