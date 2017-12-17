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

public class New_User extends JFrame {

	DbConnector dbc = new DbConnector();
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField confirmPasswordField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField companyField;
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public New_User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel usercreatepanel = new JPanel();
		contentPane.add(usercreatepanel, BorderLayout.NORTH);
		usercreatepanel.setLayout(new GridLayout(23, 1, 0, 0));
		
		JLabel lblEnterUserInformation = new JLabel("Enter user information.");
		lblEnterUserInformation.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblEnterUserInformation);
		
		JLabel spacerLabel = new JLabel("    ");
		spacerLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(spacerLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel badUsernamelabel = new JLabel("    ");
		badUsernamelabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(badUsernamelabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(passwordField);
		
		JLabel label_1 = new JLabel("    ");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(label_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblConfirmPassword);
		
		confirmPasswordField = new JTextField();
		confirmPasswordField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		
		JLabel badPasswordlabel = new JLabel("    ");
		badPasswordlabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(badPasswordlabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel label_3 = new JLabel("    ");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(label_3);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel label = new JLabel("     ");
		label.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(label);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblCompanyName);
		
		companyField = new JTextField();
		companyField.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(companyField);
		companyField.setColumns(10);
		
		JLabel companyErrorLabel = new JLabel("       ");
		companyErrorLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(companyErrorLabel);
		
		JLabel lblNewLabel = new JLabel("     ");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("    ");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 30));
		usercreatepanel.add(label_2);
		
		JPanel createbuttonpanel = new JPanel();
		usercreatepanel.add(createbuttonpanel);
		createbuttonpanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel label_4 = new JLabel("       ");
		createbuttonpanel.add(label_4);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbc.checkExistingUsername(usernameField.getText());
			}
		});
		btnCreateUser.setFont(new Font("Calibri", Font.PLAIN, 30));
		createbuttonpanel.add(btnCreateUser);
		
	}

}
