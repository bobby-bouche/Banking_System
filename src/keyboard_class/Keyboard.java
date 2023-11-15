package keyboard_class;

import javax.swing.JOptionPane;


public class Keyboard {


	// constructor
	public Keyboard(){
		
		super();
	}

	
	/*
	 *  checks user input for valid administrator password
	 *  Returns true is password entry is valid and false for invalid
	 */
	public boolean validateAdministratorPassword() {
		
		String strInput;
		boolean valid = false;
		
		while(valid == false) {
		
			strInput = JOptionPane.showInputDialog(null, "Enter Password:");
			
			try {
				if(strInput == null) {
					break;
				}
				else if(strInput.equals("Ronaldo")) {
					valid=true;
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "Access Denied");
				}
			}
			catch (Exception ed) {
				JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
						JOptionPane.OK_OPTION);
			}
		}
		return valid;
	}
	
	
	/*
	 *  Method that reads input from a user using JOptionPane and checks input against
	 *  account number paramters. Returns valid input or null for invalid input.
	 *  
	 */
	public String readAccountNumber() {
		
		String input = null;
		boolean validAccNo = false;
		
		while(validAccNo==false) {
			
			input = JOptionPane.showInputDialog("Enter your account number: ");
			
			try {
				if(input==null) {
					break;
				}
			    else if(input.length() == 4) {
					validAccNo=true;
				}	
				else {
					JOptionPane.showInternalMessageDialog(null, "Invalid Input");
				}
				
			}
			catch (Exception ed) {
					JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
							JOptionPane.OK_OPTION);
			}
		}
		return input;
	}
	
	
	public String readReceiverAccountNumber() {
		
		String input = null;
		boolean validAccNo = false;
		
		while(validAccNo==false) {
			
			input = JOptionPane.showInputDialog("Enter receiver's account number: ");
			
			try {
				if(input==null) {
					break;
				}
			    else if(input.length() == 4) {
					validAccNo=true;
				}	
				else {
					JOptionPane.showInternalMessageDialog(null, "Invalid Input");
				}
				
			}
			catch (Exception ed) {
					JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
							JOptionPane.OK_OPTION);
			}
		}
		return input;
	}
	
	public int validateDepositAmount() {
		
		String input = null;
		int amount = 0;
		boolean valid = false;
		
		while(valid==false) {
			
			input = JOptionPane.showInputDialog("Enter amount to deposit: ");
			
			try {
				if(input==null) {
					break;
				}
				else if(Integer.parseInt(input)> 0) {
					valid = true;
					amount = Integer.parseInt(input);
				}
			}
			catch (Exception ed) {
				JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
						JOptionPane.OK_OPTION);
			}
		}
		return amount;
	}
	
	public int validateWithdrawAmount() {
		
		String input = null;
		int amount = 0;
		boolean valid = false;
		
		while(valid==false) {
			
			input = JOptionPane.showInputDialog("Enter amount to Withdraw: ");
			
			try {
				if(input==null) {
					break;
				}
				else if(Integer.parseInt(input)> 0) {
					valid = true;
					amount = Integer.parseInt(input);
				}
			}
			catch (Exception ed) {
				JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
						JOptionPane.OK_OPTION);
			}
		}
		return amount;
	}
	
	public String validateTransferAmount() {
		
		String input = null;
		boolean valid = false;
		
		while(valid==false) {
			
			input = JOptionPane.showInputDialog("Enter amount to transfer: ");
			
			try {
				if(input==null) {
					break;
				}
				else if(Integer.parseInt(input)> 0) {
					valid = true;
					
				}
			}
			catch (Exception ed) {
				JOptionPane.showMessageDialog(null, "Error! Invalid data input.", "Bouche's Bank Management System",
						JOptionPane.OK_OPTION);
			}
		}
		return input;
	}
	
	
}
