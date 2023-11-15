package GUI_classes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import data_classes.Bank;
import data_classes.BankAccount;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class displayAllAccountsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;


	/**
	 * Create the dialog.
	 */
	public displayAllAccountsDialog(Bank bank) {
	
		setBounds(100, 100, 756, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 102, 153));
		contentPanel.setForeground(new Color(51, 102, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 720, 340);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setAutoCreateRowSorter(true);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, "", "", null, null, null, null},
					},
					new String[] {
						"AccNo", "AccType", "Last Name", "First Name", "Age", "Address", "Balance"
					}
				));
				scrollPane.setViewportView(table);
			}
			
		}
		
		MainFrame.createDbConnection(bank);
	
		for(BankAccount acc : bank.getAccounts().values()){
			Object data[] = {acc.getAccNum(),acc.getAccType(),acc.getLName(),acc.getFName(),acc.getAge(),acc.getAddress(),acc.getBalance()};
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(data);
			
		}
		
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
