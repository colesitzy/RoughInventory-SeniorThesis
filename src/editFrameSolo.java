import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;

public class editFrameSolo extends JFrame {

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
	public editFrameSolo() {
		
		
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
	
	public editFrameSolo(inventoryFrame iF) {
		
		
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
					iF.update();
					terminate();
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
