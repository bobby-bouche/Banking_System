package GUI_classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import data_classes.BankAccount;

@SuppressWarnings("serial")
public class DisplayAccountInfoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAccNo;
	private JTextField textFieldAccType;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldAddress;
	private JTextField textFieldBalance;
	
	
	/**
	 * Create the dialog.
	 */
	public DisplayAccountInfoDialog(BankAccount acc) {
		
		
		setBounds(100, 100, 659, 617);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(51, 102, 153));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panel.setBounds(45, 23, 547, 72);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panelHeading = new JPanel();
		panelHeading.setBounds(236, 15, 1, 1);
		panelHeading.setLayout(null);
		panelHeading.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panelHeading.setBackground(new Color(51, 102, 153));
		panel.add(panelHeading);
		
		JLabel lblHeading = new JLabel("Open New Account");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHeading.setBounds(71, 11, 408, 48);
		panelHeading.add(lblHeading);
		{
			JLabel lblAccInfo = new JLabel("Account Information");
			lblAccInfo.setForeground(new Color(255, 255, 255));
			lblAccInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccInfo.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblAccInfo.setBounds(57, 22, 436, 28);
			panel.add(lblAccInfo);
		}
		
		JPanel panelAccNo = new JPanel();
		panelAccNo.setForeground(Color.BLACK);
		panelAccNo.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panelAccNo.setBackground(new Color(51, 102, 153));
		panelAccNo.setBounds(117, 132, 399, 351);
		contentPanel.add(panelAccNo);
		panelAccNo.setLayout(null);
		
		JPanel panelHeading_1 = new JPanel();
		panelHeading_1.setBounds(236, 15, 1, 1);
		panelHeading_1.setLayout(null);
		panelHeading_1.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(51, 153, 204)));
		panelHeading_1.setBackground(new Color(51, 102, 153));
		panelAccNo.add(panelHeading_1);
		
		JLabel lblHeading_1 = new JLabel("Open New Account");
		lblHeading_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading_1.setForeground(Color.WHITE);
		lblHeading_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHeading_1.setBounds(71, 11, 408, 48);
		panelHeading_1.add(lblHeading_1);
		{
			JLabel lblBalance = new JLabel("Balance:");
			lblBalance.setBounds(42, 284, 94, 25);
			panelAccNo.add(lblBalance);
			lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
			lblBalance.setForeground(Color.WHITE);
			lblBalance.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		{
			textFieldBalance = new JTextField();
			textFieldBalance.setForeground(new Color(51, 102, 153));
			textFieldBalance.setBounds(156, 287, 175, 20);
			panelAccNo.add(textFieldBalance);
			textFieldBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
			textFieldBalance.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address:");
			lblAddress.setBounds(42, 235, 94, 25);
			panelAccNo.add(lblAddress);
			lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAddress.setForeground(Color.WHITE);
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		{
			textFieldAddress = new JTextField();
			textFieldAddress.setForeground(new Color(51, 102, 153));
			textFieldAddress.setBounds(156, 238, 175, 20);
			panelAccNo.add(textFieldAddress);
			textFieldAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
			textFieldAddress.setColumns(10);
		}
		{
			JLabel lblAge = new JLabel("Age:");
			lblAge.setBounds(42, 184, 94, 25);
			panelAccNo.add(lblAge);
			lblAge.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAge.setForeground(Color.WHITE);
			lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		{
			textFieldAge = new JTextField();
			textFieldAge.setForeground(new Color(51, 102, 153));
			textFieldAge.setBounds(156, 187, 175, 20);
			panelAccNo.add(textFieldAge);
			textFieldAge.setFont(new Font("Tahoma", Font.BOLD, 15));
			textFieldAge.setColumns(10);
		}
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(42, 135, 94, 25);
			panelAccNo.add(lblName);
			lblName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblName.setForeground(Color.WHITE);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		{
			textFieldName = new JTextField();
			textFieldName.setForeground(new Color(51, 102, 153));
			textFieldName.setBounds(156, 138, 175, 20);
			panelAccNo.add(textFieldName);
			textFieldName.setFont(new Font("Tahoma", Font.BOLD, 15));
			textFieldName.setColumns(10);
		}
		{
			JLabel lblAccType = new JLabel("Acc Type:");
			lblAccType.setBounds(42, 87, 94, 25);
			panelAccNo.add(lblAccType);
			lblAccType.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAccType.setForeground(Color.WHITE);
			lblAccType.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		{
			textFieldAccType = new JTextField();
			textFieldAccType.setForeground(new Color(51, 102, 153));
			textFieldAccType.setBounds(156, 90, 175, 20);
			panelAccNo.add(textFieldAccType);
			textFieldAccType.setFont(new Font("Tahoma", Font.BOLD, 15));
			textFieldAccType.setColumns(10);
		}
		{
			JLabel lblAccNum = new JLabel("Acc No:");
			lblAccNum.setBounds(42, 40, 94, 25);
			panelAccNo.add(lblAccNum);
			lblAccNum.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAccNum.setForeground(new Color(255, 255, 255));
			lblAccNum.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		{
			textFieldAccNo = new JTextField();
			textFieldAccNo.setForeground(new Color(51, 102, 153));
			textFieldAccNo.setBounds(156, 43, 175, 20);
			panelAccNo.add(textFieldAccNo);
			textFieldAccNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			textFieldAccNo.setColumns(10);
		}

		
		textFieldAccNo.setText(String.valueOf(acc.getAccNum()));
		textFieldAccType.setText(acc.getAccType());
		textFieldName.setText(acc.getFName() + " " + acc.getLName());
		textFieldAge.setText(String.valueOf(acc.getAge()));
		textFieldAddress.setText(acc.getAddress());
		textFieldBalance.setText(String.valueOf(acc.getBalance()));
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}
}
