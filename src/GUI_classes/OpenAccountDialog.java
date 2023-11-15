package GUI_classes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OpenAccountDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldLastName;
	private JTextField textFieldFirstName;
	private JTextField textFieldAge;
	private JTextField textFieldAddress;
	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public OpenAccountDialog() {
		setBounds(100, 100, 625, 678);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(51, 102, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelHeading = new JPanel();
		panelHeading.setBackground(new Color(51, 102, 153));
		panelHeading.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panelHeading.setBounds(35, 31, 542, 70);
		contentPanel.add(panelHeading);
		panelHeading.setLayout(null);
		
		JLabel lblHeading = new JLabel("Open New Account");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHeading.setBounds(71, 11, 408, 48);
		panelHeading.add(lblHeading);
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panelMain.setBackground(new Color(51, 102, 153));
		panelMain.setBounds(67, 157, 478, 392);
		contentPanel.add(panelMain);
		
		JLabel lblAccType = new JLabel("Account Type:");
		lblAccType.setBounds(10, 39, 172, 29);
		panelMain.add(lblAccType);
		lblAccType.setForeground(new Color(255, 255, 255));
		lblAccType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAccType.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JComboBox comboBoxAccType = new JComboBox();
		comboBoxAccType.setBounds(207, 39, 222, 29);
		panelMain.add(comboBoxAccType);
		comboBoxAccType.setForeground(new Color(51, 102, 153));
		comboBoxAccType.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxAccType.setModel(new DefaultComboBoxModel(new String[] {"", "Checking", "Savings"}));
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 79, 172, 29);
		panelMain.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(207, 79, 222, 29);
		panelMain.add(textFieldLastName);
		textFieldLastName.setForeground(new Color(51, 102, 153));
		textFieldLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldLastName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 124, 172, 29);
		panelMain.add(lblFirstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(207, 124, 222, 28);
		panelMain.add(textFieldFirstName);
		textFieldFirstName.setForeground(new Color(51, 102, 153));
		textFieldFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldFirstName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 164, 172, 29);
		panelMain.add(lblAge);
		lblAge.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(207, 164, 222, 29);
		panelMain.add(textFieldAge);
		textFieldAge.setForeground(new Color(51, 102, 153));
		textFieldAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAge.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 204, 172, 29);
		panelMain.add(lblAddress);
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(207, 204, 222, 28);
		panelMain.add(textFieldAddress);
		textFieldAddress.setForeground(new Color(51, 102, 153));
		textFieldAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAddress.setColumns(10);
		
		JButton btnOpenAccount = new JButton("Open Account");
		btnOpenAccount.setBounds(168, 297, 144, 29);
		panelMain.add(btnOpenAccount);
		btnOpenAccount.setForeground(new Color(51, 102, 153));
		btnOpenAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpenAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ronaldo");
					
					PreparedStatement ps = con.prepareStatement("INSERT INTO ACCOUNTS (AccType, LName, FName, age, address, balance) VALUES(?,?,?,?,?,?)");
					ps.setString(1, (String) comboBoxAccType.getSelectedItem().toString().toUpperCase());
					ps.setString(2, textFieldLastName.getText().toUpperCase());
					ps.setString(3, textFieldFirstName.getText().toUpperCase());
					ps.setInt(4, Integer.parseInt(textFieldAge.getText()));
					ps.setString(5, textFieldAddress.getText().toUpperCase());
					ps.setInt(6, 0);
					
					ps.executeUpdate();
					ps.close();
					
					JOptionPane.showInternalMessageDialog(null, "Account added to database");	
					
				} catch (SQLException | ClassNotFoundException | NumberFormatException ec) {	
					JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
							JOptionPane.OK_OPTION);
				}
				
				comboBoxAccType.setSelectedItem("");
				textFieldLastName.setText("");
				textFieldFirstName.setText("");
				textFieldAge.setText("");
				textFieldAddress.setText("");
			}
		});
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton exitButton = new JButton("Exit");
				exitButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();		
					}
				});	
				exitButton.setForeground(new Color(51, 102, 153));
				exitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				exitButton.setActionCommand("Exit");
				buttonPane.add(exitButton);
			}
		}
	}
	
}
