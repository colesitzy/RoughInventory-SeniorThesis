import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;

public class NewCompany extends JFrame{
	private DbConnector dbc = new DbConnector();
	private JTextField companynameField;
	private JTextField usernameField;
	private JPanel panel;
	private JButton btnReturnToLogin;
	private JLabel label;
	private JButton btnConfirm;
	private JLabel label_1;
	private JButton btnCreateUser;
	private JLabel lblChooseACompany;
	private JLabel label_2;
	private JLabel label_3;
	private JPasswordField passwordField;
	private Component verticalStrut;
	
	
 	
	
	void terminate(){
		this.dispose();
	}
	
	NewCompany()
	{
		
		super("Rough Inventory");
		getContentPane().setLayout(new GridLayout(11, 1, 0, 0));
		
		Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
		Font baseFont = new Font("Calibri", Font.BOLD, 26);
		
		lblChooseACompany = new JLabel("Choose a company name and an existing account that will serve as admin for the company /n "
				+ "this account will have full access to this company's inventory and employees.");
		lblChooseACompany.setFont(headerFont);
		getContentPane().add(lblChooseACompany);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setFont(headerFont);
		getContentPane().add(lblCompanyName);
		
		companynameField = new JTextField();
		companynameField.setFont(headerFont);
		getContentPane().add(companynameField);
		companynameField.setColumns(10);
		
		
		
		
		
		JLabel lblCreateTheOwner = new JLabel("Owner Username:");
		lblCreateTheOwner.setFont(headerFont);
		getContentPane().add(lblCreateTheOwner);
		
		usernameField = new JTextField();
		usernameField.setFont(baseFont);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
			
		
		JLabel lblOwnerPassword = new JLabel("Owner Password:");
		lblOwnerPassword.setFont(headerFont);
		getContentPane().add(lblOwnerPassword);
		
		passwordField = new JPasswordField();
		getContentPane().add(passwordField);
		
		label_2 = new JLabel(" ");
		getContentPane().add(label_2);
		
		label_3 = new JLabel(" ");
		getContentPane().add(label_3);
		
		
		
		
		
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		btnReturnToLogin = new JButton("Return to Login");
		btnReturnToLogin.setFont(headerFont);
		btnReturnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userSignIn si =new userSignIn();
				
				terminate();
			}
		});
		panel.add(btnReturnToLogin);
		
		label = new JLabel(" ");
		panel.add(label);
		
		btnCreateUser = new JButton("Create User");
		btnCreateUser.setFont(headerFont);
		//change to switch a panel instead of creating a frame
		
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New_User nu = new New_User(false);
				nu.setVisible(true);
				terminate();
			}
		});
		
		
		panel.add(btnCreateUser);
		
		
	
		label_1 = new JLabel(" ");
		panel.add(label_1);
		
		btnConfirm = new JButton("Confirm and Sign In");
	
		btnConfirm.setFont(headerFont);
		btnConfirm.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				boolean plsbbwrk = dbc.confirmUser(usernameField.getText(), passwordField.getText());
				if(plsbbwrk == true){
					dbc.addCompany(companynameField.getText(), usernameField.getText());
					
					dbc.setCompanyID(usernameField.getText(), passwordField.getText(), dbc.getcompanyID(usernameField.getText()));
					dbc.signin(usernameField.getText(), passwordField.getText());
					
				}
				else{
					label_2.setText("Invalid username or password.");
				}
			}
		});
		panel.add(btnConfirm);
		
		verticalStrut = Box.createVerticalStrut(20);
		getContentPane().add(verticalStrut);
		
		
		setSize(1775,1200);
		setLocation(1000, 300);
		setVisible(true);
		
	}

}
