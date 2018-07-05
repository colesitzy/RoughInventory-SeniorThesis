import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
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

public class editInventoryFrame extends JFrame {

	DbConnector dbc = new DbConnector();
	
	Font  headerFont = new Font("Calibri", Font.PLAIN, 35);
	Font baseFont = new Font("Calibri", Font.BOLD, 26);
	
	private JPanel contentPane;
	private JTextField itemnameField;
	private JTextField countField;
	private JTextField descField;
	private JTextField NoteField;
	int currentitemID;
	

	void terminate(){
		this.dispose();
	}
	/**
	 * Create the frame.
	 */
	public editInventoryFrame(int itemId, String c_name, String c_count) {
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(24, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(1,2));
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Item Name");
		panel_2.add(lblNewLabel);
		changeFont(lblNewLabel,headerFont);
		
		JLabel currentnamelbl = new JLabel(c_name);
		changeFont(currentnamelbl,headerFont);
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
		
		JLabel lblInventoryCount = new JLabel("Inventory Count");
		panel_3.add(lblInventoryCount);
		changeFont(lblInventoryCount,headerFont);
		
		JLabel currentcountLabel = new JLabel(c_count);
		changeFont(currentcountLabel,headerFont);
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
		panel.add(panel_1);
		
		JButton btnConfirmChanges = new JButton("Confirm Changes");
		changeFont(btnConfirmChanges,headerFont);

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
