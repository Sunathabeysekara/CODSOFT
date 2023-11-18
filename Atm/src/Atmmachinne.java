import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.util.Scanner;

public class Atmmachinne extends JFrame{
	Scanner sc=new Scanner(System.in);
	
	private int cashdeposit;//for cash deposit variable
	private int total;//for full amount in account
	private int cashwithdraw;//for cash withdraw

	////////////////////////////////////////////////////
	Atmmachinne(){
	
	JFrame frame=new JFrame();//create jframe for display frame
	JButton btnw=new JButton();//for withdraw button
	btnw.setBounds(50,130,120,60);//button sizes
	btnw.setFocusable(false);
	btnw.setText("Widthdraw");
	btnw.addActionListener(e ->{String ccwithdraw = JOptionPane.showInputDialog(frame,"Enter the amount: ");//// for get button action
	int cwithdraw=Integer.parseInt(ccwithdraw);
	withdraw(cwithdraw);
	});
	
	JButton btnd=new JButton();//for deposit button
	btnd.setBounds(200,130,120,60);//button sizes
	btnd.setFocusable(false);
	btnd.setText("Deposit");
	btnd.addActionListener(e ->{String ccdeposit = JOptionPane.showInputDialog(frame,"Enter the amount: ");//// for get button action
	int cdeposit=Integer.parseInt(ccdeposit);
	settotal(cdeposit);
	});
	
	JButton btnb=new JButton();//for checkbalance button
	btnb.setBounds(350,130,120,60);//button sizes
	btnb.setFocusable(false);
	btnb.setText("Check balance");
	btnb.addActionListener(e ->	JOptionPane.showMessageDialog(null,"Your Account Balance is: "+gettotal()+".",null,1));
	
	///////////////////creating frame 
	
	frame.setTitle(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	setLocationRelativeTo(null);
	frame.setSize(550,250);
	frame.setLayout(null);
	frame.setVisible(true);
	
	//adding buttons to frame 
	frame.add(btnw);//withdraw button in frame
	frame.add(btnd);//deposit button in frame
	frame.add(btnb);//check balance button in frame
	
	}
	
	
	Atmmachinne(int cdeposit,int cwithdraw,int ctotal){
	//methos for options withdraw,deposit,check balance
	this.cashdeposit=cdeposit;
	this.cashwithdraw=cwithdraw;
	this.total=ctotal;
	
	}
	
	//for get account value
	public int gettotal() {
		return total;
	}
	
	//for update & deposit acount
	public void settotal(int cashdeposit) {
		total=total+cashdeposit;
		JOptionPane.showMessageDialog(null,"Success",null,1);
	}
	
	//for update & withdraw account 
	public void withdraw(int amount) {
		if (amount<=total) {
			total=total-amount;
			JOptionPane.showMessageDialog(null,"Success",null,1);
		}else {
			JOptionPane.showMessageDialog(null,"Not sufficient balance to withdraw!.",null,2);
		}
	}
	


}


//sunath abeyekara