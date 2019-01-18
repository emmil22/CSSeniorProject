package IA;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingUtilities;

public class logOut implements ActionListener {
	
	// Log Out Screen Variables
	private JFrame logOutScreen;
	
	// Switch User Screen Variables
	private JFrame switchUserScreen;
	
	/***********************************************************************************************************/
	logOut() {
		logOutScreen = new JFrame("Log In");
		logOutScreen.setLayout(new FlowLayout());
		logOutScreen.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		logOutScreen.setSize(screen);
		logOutScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**************************************************************************************************************/
		switchUserScreen = new JFrame("Switch User");
		switchUserScreen.setLayout(new FlowLayout());
		switchUserScreen.setSize(500, 500);
		switchUserScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel fpsq = new JLabel("Select your account: ");
		JLabel fpsa = new JLabel("");
		
		JButton fpb = new JButton("Enter");
		
		switchUserScreen.add(fpsq);
		switchUserScreen.add(fpsa);
		switchUserScreen.add(fpb);
		
		fpb.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Switch User")) {
			switchUserScreen.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new logOut();
			}
		});
	}
	
}
