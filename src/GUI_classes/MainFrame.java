package GUI_classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import data_classes.Bank;
import data_classes.BankAccount;
import keyboard_class.Keyboard;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private AdminFrame myFrame;
	private JPanel contentPane;
	
	private static Bank bank;
	private static Keyboard kb;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					MainFrame frame = new MainFrame();
					bank  = new Bank();
					kb    = new Keyboard();
					frame.setVisible(true);
					createDbConnection(bank);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 // method to create connection to database and load data to Bank Map. 
	public static void createDbConnection(Bank bank) {
			
			BankAccount account;
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ronaldo");
				Statement stat = con.createStatement();
				ResultSet rs   = stat.executeQuery("SELECT * FROM ACCOUNTS ORDER BY ACCNO ASC");
					
				while(rs.next()) {
					
					int accNum 		= rs.getInt("AccNo");
					String accType 	= rs.getString("accType");
					String LName 	= rs.getString("LName");
					String FName 	= rs.getString("FName");
					int age 		= rs.getInt("age");
					String address 	= rs.getString("address");
					Long balance 	= rs.getLong("balance");
					
					account = new BankAccount(accNum,accType,LName,FName,age,address,balance);
					
					bank.addAccount(account);
				}
				
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1450, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1450, 800);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panel.setBounds(407, 333, 605, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelUserSelect = new JLabel("User:");
		labelUserSelect.setForeground(new Color(255, 255, 255));
		labelUserSelect.setHorizontalAlignment(SwingConstants.CENTER);
		labelUserSelect.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelUserSelect.setBounds(84, 61, 78, 37);
		panel.add(labelUserSelect);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(51, 102, 153));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Administrator", "Account Holder"}));
		comboBox.setBounds(195, 68, 289, 25);
		panel.add(comboBox);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(comboBox.getSelectedItem().equals("Administrator")) {
					
					if(kb.validateAdministratorPassword()) {
						JOptionPane.showInternalMessageDialog(null, "Welcome back sir!");
						AdminFrame frame = new AdminFrame();
						frame.setVisible(true);
					}
				}
				else if(comboBox.getSelectedItem().equals("Account Holder")){
				
					String accNo = kb.readAccountNumber();
					if(accNo == null) {
				
					}
					else if(bank.getAccount(Integer.parseInt(accNo)) != null) {
						BankFrame frame = new BankFrame(Integer.parseInt(accNo));
						frame.setVisible(true);	
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "Account does not exist");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please make a selection");
				};
			}
		});
		btnSelect.setForeground(new Color(51, 102, 153));
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSelect.setBounds(250, 120, 113, 37);
		panel.add(btnSelect);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panel_1.setBounds(177, 21, 1086, 91);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Bouche's Bank Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		panel_1.add(lblNewLabel);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(myFrame, "Are you sure you want to quit?", "Bouche's Bank Management System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnQuit.setForeground(new Color(51, 102, 153));
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuit.setBounds(1252, 713, 113, 37);
		contentPane.add(btnQuit);
	}
	
}
