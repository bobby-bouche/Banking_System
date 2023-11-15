package data_classes;

import javax.swing.JOptionPane;

public class BankAccount extends Bank{
	
	// BankAccount fields
	private int AccNum;
	private String accType;
	private String LName;
	private String FName;
	private int age;
	private String address;
	private long balance;
	
	
	// constructors
	public BankAccount() {
		super();
	}
	
	public BankAccount(int accNo, String accType, String Lname, String Fname, int age, String cutomerAddress, long balance){
		
		super();
		this.AccNum  = accNo;
		this.accType = accType;
		this.LName   = Lname;
		this.FName   = Fname;
		this.age     = age;
		this.address = cutomerAddress;
		this.balance = balance;
	}


	// get and set methods
	public int getAccNum() {
		return AccNum;
	}

	public void setAccNum(int accNum) {
		AccNum = accNum;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String acctype) {
		accType = acctype;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fname) {
		this.FName = fname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long value) {
		this.balance = value;
	}
	
	
	// method to deposit amount
	public void deposit(double depositAmount) {
		
		if(depositAmount < 0) {
			JOptionPane.showInternalMessageDialog(null, "invalid amount: " + depositAmount);
		}
		else {
			balance += depositAmount;
			JOptionPane.showInternalMessageDialog(null, "$" + depositAmount + " has been deposited to your account");
		}
		
	}
	
	
	// method to withdraw amount
	public void withdraw(int withdrawAmount) {
		
		if(balance - withdrawAmount >= 0) {
			balance -= withdrawAmount;
			JOptionPane.showInternalMessageDialog(null, "$" + withdrawAmount + " has been withrawn from your account");
		}
		else {
			JOptionPane.showInternalMessageDialog(null, "Insufficient funds: " + balance);
		}
	}
	
	
	// method to transfer amount
	public void transfer(Integer transferAmount, BankAccount acc) {
		
		if(balance - transferAmount >= 0) {
			balance -= transferAmount;
			int result = (int) (acc.balance += transferAmount);
			acc.setBalance(result);
			JOptionPane.showInternalMessageDialog(null, "transfer succssfull");
		}
		else {
			JOptionPane.showInternalMessageDialog(null, "Insufficient funds: " + balance);
		}
	}

	
}
