import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Investor {

	static class Inv{
		
		 double initialInvestment;
		 double percentage;
		 double individualEarnings;
		 static double totalEarningsPer;
		 static double totalEarnings;
		 static double totalInvestment;
			 
			 Inv(double initial){
				 
				 this.initialInvestment = initial;
				 
			 }
			
			public static void setTotalInvestment(double total) {
				
				totalInvestment = total;
			}
			
			public static double getTotalInvestment() {
				
				return totalInvestment;
			}
			
			public void setPercentage(double initialInvestment) {
				
				this.percentage = (initialInvestment/totalInvestment) * 100;
				this.percentage = (double) Math.round(this.percentage * (double) 100) / (double) 100; 
				
			}
			
			public double getPercentage() {
				
				return this.percentage;
				
			}
			
			public static void setTotalEarningsPer(double currentInvestment) {
				
				totalEarningsPer = ((currentInvestment/getTotalInvestment()) -1) * 100;
				totalEarningsPer = (double) Math.round(totalEarningsPer * (double) 100) / (double) 100; 

				
			}
			
			public static double getTotalEarningsPer() {
				
				return totalEarningsPer;
				
			}
			
			public static void totalEarnings(double currentInvestment) {
				
				totalEarnings = currentInvestment - totalInvestment;
				totalEarnings = (double) Math.round(totalEarnings * (double) 100) / (double) 100; 
			
			}
			
			public void setIndividualEarnings(Inv name) {
				
				name.individualEarnings = totalEarnings * (name.getPercentage()/100);	
				name.individualEarnings = (double) Math.round(name.individualEarnings * (double) 100) / (double) 100; 
			}
			
			public double getIndividualEarnings() {
				
				return individualEarnings;
			}
	}
	

	private JFrame frame;
	private JTextField tfAdd;
	private JTextField textField_2;
	private JTextField tfAbdallahInvest;
	private JTextField tfAbdallahPer;
	private JTextField tfAndresPer;
	private JTextField tfAbdallahEarnings;
	private JTextField tfAndresEarnings;
	private JTextField tfAndresInvest;
	private JTextField tfTotalInvestment;
	private JTextField tfTotalEarnings;
	private JTextField tfTotalEarningPer;
	private JTextField tfCurrentInvest;
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Investor window = new Investor();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	
	}
	
	public Investor() {
		
		
		initialize();
	}

	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDate = new JLabel("");
		lblDate.setBounds(226, 71, 132, 16);
		frame.getContentPane().add(lblDate);
		
		
		//////////////////////////////////////////
		
		Inv Abdallah = new Inv(6215);
		Inv Andres = new Inv(1756);
		
		lblDate.setText("As of 03/13/2019");
		
		//////////////////////////////////////////
		
		JLabel lblAdd = new JLabel("Add ");
		lblAdd.setBounds(6, 11, 29, 16);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblAbdallah_1 = new JLabel("Abdallah:");
		lblAbdallah_1.setBounds(6,211,65,20);
		frame.getContentPane().add(lblAbdallah_1);
		
		JButton btnGetData = new JButton("Get data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Total Initial Investment
				
				double total = Abdallah.initialInvestment + Andres.initialInvestment;
				Inv.setTotalInvestment(total);
				tfTotalInvestment.setText(Double.toString(Inv.getTotalInvestment()));
				
				//Individual Investments and Percentages
				
				tfAndresInvest.setText(Double.toString(Andres.initialInvestment));
				tfAbdallahInvest.setText(Double.toString(Abdallah.initialInvestment));
				
				Andres.setPercentage(Andres.initialInvestment);
				Abdallah.setPercentage(Abdallah.initialInvestment);
				
				tfAndresPer.setText(Double.toString(Andres.getPercentage()));
				System.out.println(Andres.getPercentage());
				tfAbdallahPer.setText(Double.toString(Abdallah.getPercentage()));
				System.out.println(Abdallah.getPercentage());
				
				//Total Earnings
				
				Inv.setTotalEarningsPer(Double.parseDouble(tfCurrentInvest.getText()));
				tfTotalEarningPer.setText(Double.toString(Inv.getTotalEarningsPer()));
				
				Inv.totalEarnings(Double.parseDouble(tfCurrentInvest.getText()));
				tfTotalEarnings.setText(Double.toString(Inv.totalEarnings));
				
				// Individual Earnings
				
				Andres.setIndividualEarnings(Andres);
				tfAndresEarnings.setText(Double.toString(Andres.getIndividualEarnings()));
				
				Abdallah.setIndividualEarnings(Abdallah);
				tfAbdallahEarnings.setText(Double.toString(Abdallah.getIndividualEarnings()));
			
				
			}
		});
		
		btnGetData.setBounds(329,199,106,66);
		frame.getContentPane().add(btnGetData);
		
		tfAdd = new JTextField();
		tfAdd.setBounds(41,9,132,20);
		frame.getContentPane().add(tfAdd);
		
		JLabel lblInitialInvestment = new JLabel("Investment");
		frame.getContentPane().add(lblInitialInvestment);
		
		JLabel lblTo = new JLabel("$  to");
		lblTo.setBounds(185, 11, 29, 16);
		frame.getContentPane().add(lblTo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(50,50,50,50);
		
		JLabel lblEarnings = new JLabel("Investment");
		frame.getContentPane().add(lblEarnings);
		lblEarnings.setBounds(78,182,75,26);
		
		tfAbdallahInvest = new JTextField();
		tfAbdallahInvest.setBounds(76,212,75,18);
		frame.getContentPane().add(tfAbdallahInvest);
		
		JLabel label = new JLabel("%");
		frame.getContentPane().add(label);
		label.setBounds(170,185,9,20);
		
		
		JLabel lblAndres = new JLabel("Andres:");
		frame.getContentPane().add(lblAndres);
		lblAndres.setBounds(6,243,58,22);
		
		tfAbdallahPer = new JTextField();
		tfAbdallahPer.setBounds(150, 212, 50, 18);
		frame.getContentPane().add(tfAbdallahPer);
		
		tfAndresPer = new JTextField();
		tfAndresPer.setBounds(150, 243, 50, 18);
		frame.getContentPane().add(tfAndresPer);
		
		JLabel lblEarnings_1 = new JLabel("Earnings");
		lblEarnings_1.setBounds(245, 182, 58, 26);
		frame.getContentPane().add(lblEarnings_1);
		
		tfAbdallahEarnings = new JTextField();
		tfAbdallahEarnings.setBounds(237, 212, 75, 18);
		frame.getContentPane().add(tfAbdallahEarnings);
		
		tfAndresEarnings = new JTextField();
		tfAndresEarnings.setBounds(237, 245, 75, 18);
		frame.getContentPane().add(tfAndresEarnings);
		
		tfAndresInvest = new JTextField();
		tfAndresInvest.setBounds(76, 243, 75, 18);
		frame.getContentPane().add(tfAndresInvest);
		
		
		JLabel lblTotalInvestment = new JLabel("Initial Investment");
		lblTotalInvestment.setBounds(6, 71, 121, 16);
		frame.getContentPane().add(lblTotalInvestment);
		
		tfTotalInvestment = new JTextField();
		tfTotalInvestment.setBounds(127, 69, 87, 20);
		frame.getContentPane().add(tfTotalInvestment);

		
		JLabel lblTotalEarnings = new JLabel("Total Earnings");
		lblTotalEarnings.setBounds(229, 121, 106, 16);
		frame.getContentPane().add(lblTotalEarnings);
		
		tfTotalEarnings = new JTextField();
		tfTotalEarnings.setBounds(338, 119, 97, 20);
		frame.getContentPane().add(tfTotalEarnings);
		
		JLabel lblTotalEarningsPer = new JLabel("Total Earnings %");
		lblTotalEarningsPer.setBounds(229, 152, 106, 16);
		frame.getContentPane().add(lblTotalEarningsPer);
		
		tfTotalEarningPer = new JTextField();
		tfTotalEarningPer.setBounds(338, 150, 97, 20);
		frame.getContentPane().add(tfTotalEarningPer);
		
		JButton btnAbdallah = new JButton("Abdallah");
		btnAbdallah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = tfAdd.getText();
				
				if (!"".equals(a)) {
		
					Abdallah.initialInvestment += Double.parseDouble(tfAdd.getText());
				
				}

				
			}
		});
		btnAbdallah.setBounds(218, 6, 117, 29);
		frame.getContentPane().add(btnAbdallah);
		
		JButton btnAndres = new JButton("Andres");
		btnAndres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = tfAdd.getText();
				
				if (!"".equals(a)) {
					
					Andres.initialInvestment += Double.parseDouble(tfAdd.getText());
				
				}
				
			}
		});
		
		btnAndres.setBounds(326, 6, 117, 29);
		frame.getContentPane().add(btnAndres);
		
		JLabel lblCurrentInvestment = new JLabel("Current Investment");
		lblCurrentInvestment.setBounds(41, 121, 132, 16);
		frame.getContentPane().add(lblCurrentInvestment);
		
		tfCurrentInvest = new JTextField();
		tfCurrentInvest.setBounds(51, 137, 102, 20);
		frame.getContentPane().add(tfCurrentInvest);
		
	
		
		
		
		
	}
}
