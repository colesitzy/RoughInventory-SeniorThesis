
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

//TODO New user, Forgot Password
public class userSignIn extends JFrame{
	
	DbConnector dbc = new DbConnector();
	
	JPanel blankpanel= new JPanel();
	JLabel blankLabel= new JLabel("            ");
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	
	JTextField usernameSignIn = new JTextField();
	JPasswordField passwordSignIn =  new JPasswordField();
	private final Action action = new SwingAction();
	
	userSignIn()
	{
	super("Rough Inventory - Sign In");
	
	JPanel mPanel= new JPanel();
	mPanel.setLayout(new BorderLayout());
	
	
	
	JPanel topPanel= new JPanel();
	topPanel.setLayout(new GridLayout(4,1));
	
	JLabel lblNewLabel_6 = new JLabel(" ");
	topPanel.add(lblNewLabel_6);
	
	
	
	JLabel topLabelone = new JLabel("     Welcome the Rough Inventory! ");
	topLabelone.setFont(headerFont);
	topPanel.add(topLabelone);
	
	
	JLabel topLabeltwo = new JLabel("     If you already have an account with us "
			+ "please enter your username and password.");
	topLabeltwo.setFont(headerFont);
	topPanel.add(topLabeltwo);
	
	
	JLabel topLabelthree = new JLabel("     If you are a new user click the New User button.");
	topLabelthree.setFont(headerFont);
	topPanel.add(topLabelthree);
	
	mPanel.add(topPanel, BorderLayout.NORTH);
	
	//make a panel to hold  sign in panel 
	JPanel signInContainer = new JPanel();
	signInContainer.setLayout(new BorderLayout());
	
	JPanel signInPanel = new JPanel();
	
	signInPanel.setLayout(new GridLayout(1, 5));
	signInPanel.setSize(200, 300);
	
	JLabel lblNewLabel = new JLabel("     ");
	signInPanel.add(lblNewLabel);
	
	JLabel signUsername = new JLabel("        Username:");
	signUsername.setFont(baseFont);
	signInPanel.add(signUsername);
	usernameSignIn.setFont(baseFont);
	signInPanel.add(usernameSignIn);
	
	JLabel signPassword = new JLabel("   Password:");
	signPassword.setFont(baseFont);
	passwordSignIn.setFont(baseFont);
	signInPanel.add(signPassword);
	
	signInPanel.add(passwordSignIn);
	
	JButton signInButton = new JButton("Sign In");
	JButton newUserButton = new JButton("New User");
	JButton createNewCompany = new JButton("Create New Company");
	
	//signInPanel.add(signInButton);
	
	signInContainer.add(signInPanel, BorderLayout.NORTH);
	
	JLabel lblNewLabel_1 = new JLabel("       ");
	signInPanel.add(lblNewLabel_1);
	mPanel.add(signInContainer, BorderLayout.CENTER);
	
	JPanel bottomPanel = new JPanel();
	bottomPanel.setLayout(new BorderLayout());
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new GridLayout(1, 3));
	buttonPanel.add(newUserButton);
	buttonPanel.add(createNewCompany);
	buttonPanel.add(signInButton);
	bottomPanel.add(buttonPanel, BorderLayout.NORTH);http://download.eclipse.org/windowbuilder/WB/release/4.6/
	
	//mPanel.add(bottomPanel, BorderLayout.SOUTH);
	
	getContentPane().add(mPanel);
	
	JPanel panel = new JPanel();
	mPanel.add(panel, BorderLayout.SOUTH);
	panel.setLayout(new GridLayout(2, 1, 0, 0));
	
	JPanel bottomPanel_1 = new JPanel();
	panel.add(bottomPanel_1);
	bottomPanel_1.setLayout(new GridLayout(1, 8, 0, 0));
	
	JLabel blanklabel = new JLabel("      ");
	bottomPanel_1.add(blanklabel);
	
	JButton newCompanyButton = new JButton("New Company ");
	newCompanyButton.setFont(baseFont);
	bottomPanel_1.add(newCompanyButton);
	
	JLabel label = new JLabel("       ");
	bottomPanel_1.add(label);
	
	
	
	JButton newUserButton_1 = new JButton("New User");
	
	newUserButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			New_User nu = new New_User();
			nu.setVisible(true);
		}
	});
	
	
	newUserButton_1.setAction(action);
	newUserButton_1.setFont(baseFont);
	bottomPanel_1.add(newUserButton_1);
	
	JLabel lblNewLabel_2 = new JLabel("            ");
	bottomPanel_1.add(lblNewLabel_2);
	
	JButton signInButton_1 = new JButton("Sign In");
	signInButton_1.setFont(baseFont);
	bottomPanel_1.add(signInButton_1);
	
	JLabel lblNewLabel_3 = new JLabel("     ");
	bottomPanel_1.add(lblNewLabel_3);
	
	JLabel lblNewLabel_5 = new JLabel("     ");
	panel.add(lblNewLabel_5);
	
	setSize(1475,1000);
	setLocation(1000, 300);
	setVisible(true);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
