import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class addInventory extends JFrame {

	DbConnector dbc = new DbConnector();
	
	private JTextField itemnameField;
	private JTextField countField;
	private JTextField descField;
	private JTextField NoteField;
	int currentitemID;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addInventory frame = new addInventory();
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
	public addInventory() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 730, 774);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));
				
				JPanel panel = new JPanel();
				contentPane.add(panel, BorderLayout.NORTH);
				panel.setLayout(new GridLayout(24, 1, 0, 0));
				
				JLabel lblNewLabel = new JLabel("Item Name");
				panel.add(lblNewLabel);
				
				itemnameField = new JTextField();
				panel.add(itemnameField);
				itemnameField.setColumns(10);
				
				Component verticalStrut = Box.createVerticalStrut(20);
				panel.add(verticalStrut);
				
				JLabel lblInventoryCount = new JLabel("Inventory Count");
				panel.add(lblInventoryCount);
				
				countField = new JTextField();
				panel.add(countField);
				countField.setColumns(10);
				
				JLabel count_error_label = new JLabel("");
				panel.add(count_error_label);
				
				JLabel descLabel = new JLabel("Item description");
				panel.add(descLabel);
				
				descField = new JTextField();
				panel.add(descField);
				descField.setColumns(10);
				
				Component verticalStrut_1 = Box.createVerticalStrut(20);
				panel.add(verticalStrut_1);
				
				JLabel noteLabel = new JLabel("Note");
				panel.add(noteLabel);
				
				NoteField = new JTextField();
				panel.add(NoteField);
				NoteField.setColumns(10);
				
				JLabel label = new JLabel(" ");
				panel.add(label);
				
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				
				JButton btnConfirmChanges = new JButton("Confirm Changes");
				 btnConfirmChanges.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					
						
							
						
							try{
							int i = Integer.parseInt(countField.getText());
							dbc.addInv(itemnameField.getText(), i, descField.getText(), 
									NoteField.getText());
								
							}
							catch(NumberFormatException ex)
							{
								
							}
							
									//userSignIn si = new userSignIn();
									
									
							}
						});
				btnConfirmChanges.setHorizontalAlignment(SwingConstants.LEFT);
				panel_1.add(btnConfirmChanges);
			}
	

}
