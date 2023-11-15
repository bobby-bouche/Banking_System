package GUI_classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import data_classes.Bank;
import data_classes.BankAccount;
import keyboard_class.Keyboard;

@SuppressWarnings("serial")
public class BankFrame extends JFrame {

	private JPanel contentPane;
	private JFrame myframe;
	
	private static Bank bank;
	private static Keyboard kb;
	private BankAccount account;
	
	
	/**
	 * Create the frame.
	 */
	public BankFrame(int accNo) {
		
		bank 	= new Bank();
		kb   	= new Keyboard();
		MainFrame.createDbConnection(bank);
		account = bank.getAccount(accNo);
		
		
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
				if(JOptionPane.showConfirmDialog(myframe, validName(account.getFName()) + ", are you sure you want to return to the main menu?", "Bouche's Bank Management System",
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
		panel_1.setBounds(386, 154, 664, 76);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAdministratorMenu = new JLabel("Account Menu");
		lblAdministratorMenu.setBounds(126, 11, 402, 49);
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
		
		JButton btnCheckBalance = new JButton("Check Balance");
		btnCheckBalance.setForeground(new Color(51, 102, 153));
		btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Balance: $ " + account.getBalance());
				
			}
		});
		btnCheckBalance.setBounds(64, 31, 228, 38);
		panel_1_1.add(btnCheckBalance);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int amount = kb.validateDepositAmount();
					account.deposit(amount);
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ronaldo");
					PreparedStatement stat = con.prepareStatement("UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCNO = ?");
					stat.setInt(1, (int) account.getBalance());
					stat.setInt(2,  account.getAccNum());
					stat.executeUpdate();
					stat.close();
					
				} catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDeposit.setForeground(new Color(51, 102, 153));
		btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeposit.setBounds(64, 98, 228, 38);
		panel_1_1.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int amount = kb.validateWithdrawAmount();
				account.withdraw(amount);
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ronaldo");
					PreparedStatement stat = con.prepareStatement("UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCNO = ?");
					stat.setInt(1, (int) account.getBalance());
					stat.setInt(2,  account.getAccNum());
					stat.executeUpdate();
					stat.close();
					
				} catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnWithdraw.setForeground(new Color(51, 102, 153));
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnWithdraw.setBounds(64, 168, 228, 38);
		panel_1_1.add(btnWithdraw);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strAmount = kb.validateTransferAmount();
				String receiver = kb.readReceiverAccountNumber();
				
				if(receiver == null || strAmount == null || (receiver == null && strAmount == null)) {
			
				}
				else if(bank.getAccount(Integer.parseInt(receiver)) != null) {
					int amount = Integer.parseInt(strAmount);
					account.transfer(amount, bank.getAccount(Integer.parseInt(receiver)));	
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "Account does not exist");
				}
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ronaldo");
					
					PreparedStatement stat = con.prepareStatement("UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCNO = ?");
					stat.setInt(1, (int) account.getBalance());
					stat.setInt(2,  account.getAccNum());
					stat.executeUpdate();
					stat.close();
					
					PreparedStatement stat2 = con.prepareStatement("UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCNO = ?");
					stat2.setInt(1, (int) bank.getAccount(Integer.parseInt(receiver)).getBalance());
					stat2.setInt(2,  Integer.parseInt(receiver));
					stat2.executeUpdate();
					stat2.close();
					
				} 
				catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
					JOptionPane.showInternalMessageDialog(null, "Invalid input");
				}
			}
		});
		btnTransfer.setForeground(new Color(51, 102, 153));
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTransfer.setBounds(64, 230, 228, 38);
		panel_1_1.add(btnTransfer);
		
		welcomeMessage();
	}
	
	
	// this method displays a personalized welcome message with the username associated with the inputted valid account number.
	void welcomeMessage() {
		JOptionPane.showInternalMessageDialog(null, "Welcome back " + validName(account.getFName()) + " " + validName(account.getLName()));
	}
	
	
	// this method takes user names in UPPERCASE and pesents them in lowercase with the first letter capitalised.
	public String validName(String name) {
		
		String value = name.toLowerCase();
		String s1 = value.substring(0, 1).toUpperCase();
		String s2 = value.substring(1);
		String result = s1 + s2;
		return result;
	}
	
	
}
