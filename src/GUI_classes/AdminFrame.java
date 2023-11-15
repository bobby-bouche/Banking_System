package GUI_classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import data_classes.Bank;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JFrame myframe;
	
	private static Bank bank;
	Connection con;
	
	
	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		
		bank = new Bank();
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1450, 800);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1450, 800);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panel.setBounds(177, 21, 1086, 91);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Bouche's Bank Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		panel.add(lblNewLabel);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				myframe = new JFrame();
				if(JOptionPane.showConfirmDialog(myframe, "Are you sure you want to return to the main menu?", "Bouche's Bank Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					
					dispose();	
				}	
			}
		});
		
		btnExit.setForeground(new Color(51, 102, 153));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(1252, 713, 113, 37);
		contentPane.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBounds(350, 154, 747, 76);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdministratorMenu = new JLabel("Administrator Menu");
		lblAdministratorMenu.setBounds(164, 11, 402, 49);
		lblAdministratorMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministratorMenu.setForeground(Color.WHITE);
		lblAdministratorMenu.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_1.add(lblAdministratorMenu);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panel_1_1.setBackground(new Color(51, 102, 153));
		panel_1_1.setBounds(538, 298, 355, 298);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					OpenAccountDialog dialog = new OpenAccountDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} 
				catch (Exception ed) {
					ed.printStackTrace();
				}	
			}
		});
		
		btnAddAccount.setForeground(new Color(51, 102, 153));
		btnAddAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddAccount.setBounds(70, 35, 228, 38);
		panel_1_1.add(btnAddAccount);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					MainFrame.createDbConnection(bank);
					String deleteAccNum = JOptionPane.showInputDialog("please enter account number: ");
					
					if(deleteAccNum == null) {
					
					}
					else if(bank.getAccount(Integer.parseInt(deleteAccNum)) == null) {
						JOptionPane.showInternalMessageDialog(null, "Account number does not exist");
					}
					else {
						bank.deleteAccount(Integer.parseInt(deleteAccNum));
						JOptionPane.showInternalMessageDialog(null, "Account successfully removed from database");
					}
				} 
				catch (Exception ed) {
					JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
							JOptionPane.OK_OPTION);
				}
			}
		});
		
		btnDeleteAccount.setForeground(new Color(51, 102, 153));
		btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteAccount.setBounds(70, 101, 228, 38);
		panel_1_1.add(btnDeleteAccount);
		
		JButton btnSearchAccounts = new JButton("Search Account");
		btnSearchAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					MainFrame.createDbConnection(bank);
					String deleteAccNum = JOptionPane.showInputDialog("please enter account number: ");
					
					if(deleteAccNum == null) {
					
					}
					else if(bank.getAccount(Integer.parseInt(deleteAccNum)) == null) {
						JOptionPane.showInternalMessageDialog(null, "Account number does not exist");
					}
					else {
						DisplayAccountInfoDialog dialog = new DisplayAccountInfoDialog(bank.getAccount(Integer.parseInt(deleteAccNum)));
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
				} 
				catch (Exception ed) {
					JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
							JOptionPane.OK_OPTION);
				}
			}
		});
		
		btnSearchAccounts.setForeground(new Color(51, 102, 153));
		btnSearchAccounts.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearchAccounts.setBounds(70, 167, 228, 38);
		panel_1_1.add(btnSearchAccounts);
		
		JButton btnDisplayAccounts = new JButton("Display Accounts");
		btnDisplayAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			
					displayAllAccountsDialog dialog = new displayAllAccountsDialog(bank);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} 
				catch (Exception ed) {
					ed.printStackTrace();
				}	
			}
		});
		btnDisplayAccounts.setForeground(new Color(51, 102, 153));
		btnDisplayAccounts.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayAccounts.setBounds(70, 229, 228, 38);
		panel_1_1.add(btnDisplayAccounts);
	}
	
}
