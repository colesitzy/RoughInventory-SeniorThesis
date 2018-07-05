import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class New_User extends JFrame {

	DbConnector dbc = new DbConnector();
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField confirmPasswordField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField companyField;
	private JLabel badUsernamelabel;
	private JLabel badPasswordlabel;
	
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	private JTextField emailField;
	JLabel companyErrorLabel;
	
	/**
	 * Launch the application.
	 * @return 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_User frame = new New_User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void terminate()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 */
	public New_User(boolean p) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 1400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel createbuttonpanel = new JPanel();
		contentPane.add(createbuttonpanel, BorderLayout.SOUTH);
		
		createbuttonpanel.setLayout(new GridLayout(1, 5, 0, 0));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		createbuttonpanel.add(horizontalStrut_1);
		
		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("Calibri", Font.BOLD, 30));
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(p == true){
					userSignIn us = new userSignIn();
					terminate();
				}
				else{
					NewCompany nc = new NewCompany();
					terminate();
				}
				
			}
		});
		
		createbuttonpanel.add(returnButton);
		
		JLabel label_4 = new JLabel("       ");
		createbuttonpanel.add(label_4);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(dbc.checkExistingUsername(usernameField.getText()) == true){
					badUsernamelabel.setText("Username already taken.");
				}
				else{
				if(p == true){
					int companyId;
				try{   companyId = Integer.parseInt(companyField.getText());
				if(dbc.checkExistingUsername(usernameField.getText()) == false){
					
						dbc.addUser(usernameField.getText(), passwordField.getText(), firstNameField.getText(), 
								lastNameField.getText(), emailField.getText(), companyId, 
								"Employee");	
								userSignIn us = new userSignIn();
								terminate();
					}
				}
					
				catch(NumberFormatException ex){
					companyErrorLabel.setText("Incorrect company ID.");
					}
				}
					else{
						dbc.addUser(usernameField.getText(), passwordField.getText(), firstNameField.getText(), 
							lastNameField.getText(), emailField.getText(), 4, 
							"Admin");
							userSignIn si = new userSignIn();
							terminate();
							
					}
				}
			}
				
		});
		
		
		
		
		btnCreateUser.setFont(new Font("Calibri", Font.BOLD, 30));
		createbuttonpanel.add(btnCreateUser);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		createbuttonpanel.add(horizontalStrut);
		
		JPanel usercreatepanel = new JPanel();
		contentPane.add(usercreatepanel, BorderLayout.NORTH);
		usercreatepanel.setLayout(new GridLayout(26, 1, 0, 0));
		
		JLabel lblEnterUserInformation = new JLabel("Enter user information.");
		lblEnterUserInformation.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblEnterUserInformation);
		
		JLabel spacerLabel = new JLabel("    ");
		spacerLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(spacerLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(usernameField);
		usernameField.setColumns(10);
		
		badUsernamelabel = new JLabel("    ");
		badUsernamelabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(badUsernamelabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(passwordField);
		
		JLabel passwordsDontMatchlabel = new JLabel("    ");
		passwordsDontMatchlabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(passwordsDontMatchlabel);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblConfirmPassword);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		
		JLabel badPasswordlabel = new JLabel("    ");
		badPasswordlabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(badPasswordlabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel label_3 = new JLabel("    ");
		label_3.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(label_3);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel label = new JLabel("     ");
		label.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(label);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblEmailAddress);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Calibri", Font.PLAIN, 30));

		usercreatepanel.add(emailField);
		emailField.setColumns(10);
		
		JLabel label_5 = new JLabel("     ");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(label_5);
		
	if(p == true){
		JLabel lblCompanyName = new JLabel("Company ID:");
		lblCompanyName.setFont(new Font("Calibri", Font.BOLD, 30));
		usercreatepanel.add(lblCompanyName);
		
		
		companyField = new JTextField();
		companyField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(companyField);
		companyField.setColumns(10);
		
		companyErrorLabel = new JLabel("       ");
		companyErrorLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(companyErrorLabel);
		}
		JLabel lblNewLabel = new JLabel("     ");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("    ");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(label_2);
		
	}
	
}



