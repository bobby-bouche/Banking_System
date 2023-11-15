package data_classes;

import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;


public class Bank {
	
	// Bank fields
	private Map<Integer, BankAccount> accounts;
	
	
	// constructor
	public Bank() {
		super();
		accounts = new HashMap<>();
	}
	
	
	// method to add account
	public void addAccount(BankAccount acc) {
		
		accounts.put(acc.getAccNum(), acc);
	}
	
	
	// method to retrieve account
	public BankAccount getAccount(int accNum) {
		
		BankAccount account = null;
		
		if(accounts.containsKey(accNum)) {
			account = accounts.get(accNum);
		}
		else {
			
		}
		return account;
	}
	
	
	// method to remove account
	public void deleteAccount(int accNum) {
		
		accounts.remove(accNum);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Ronaldo");
			
			PreparedStatement stat = con.prepareStatement("DELETE FROM ACCOUNTS WHERE ACCNO = ?");
			stat.setInt(1, accNum);
			stat.executeUpdate();
			stat.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// method to return bank HashMap
	public HashMap<Integer, BankAccount> getAccounts(){
		
		return (HashMap<Integer, BankAccount>) accounts;
	}


}
