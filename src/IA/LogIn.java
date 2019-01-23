package IA;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import Reference.CustomerOrder;


public class LogIn implements ActionListener{
	
	//Log In Screen Variable
	private JFrame logInScreen;
	private JTextField t1;
	private JTextField t2;
	
	//Create Account Screen Variables
	private JFrame createAccountScreen;
	private JTextField cast1;
	private JTextField cast2;
	private JTextField cast3;
	private JTextField cast4;
	private JTextField cast5;
	private JTextField cast6;
	private JButton cab;
	private JButton dt;
	private JComboBox<String> securityQuestions;
	String[] questions = {"What is the name of your favorite childhood friend?", "What is your favorite Disney movie?",
			"What school did you attend for sixth grade?", "What was the make and model of your first car?",
			"What is the last name of the teacher who gave you your first failing grade?"};
	
	//Forgot Password Screen Variables
	private JFrame forgotPasswordScreen;
	private JTextField sat;
	
	//Password Recovery Screen Variables
	private JFrame passwordRecoveryScreen;
	private JTextField npt;
	private JTextField rnpt;
	
	//Admin Log In Screen Variables
	private JFrame adminLogInScreen;
	private JTextField aunt;
	private JTextField apt;
	private JTextField act;
	

	//Database Variables
	DBConnectionManagerSingleton dbc;
	Connection conn;
	Statement stmt;
	private User u;
	ArrayList<User> users = new ArrayList<User>();
	private JFrame frame2;
	private JScrollPane jscrlp;
	private boolean tableCreated = false;
	private Object[][] obj;
	private JTable table;
	String [] headings = {"First Name", "Last Name", "Username", "Password", 
			"Security Question","Security Answer", "Hint"};
	/*******************************************************************************************************************************/
	//Log In Screen
	LogIn() {
		
		try {
			dbc = DBConnectionManagerSingleton.getInstance();
		} catch (Exception e) {
		}
		
		conn = dbc.getConnection();
		stmt = dbc.getStatement();
			
			String viewRec = "SELECT * from USER_INFO";
			ResultSet rs;
			try {
				rs = stmt.executeQuery(viewRec);
			
			

				while (rs.next()) {
					String fn = rs.getString("FIRST_NAME");
					String ln = rs.getString("LAST_NAME");
					String us = rs.getString("USERNAME");
					String p = rs.getString("PASSWORD");
					String sq = rs.getString("SECURITY_QUESTION");
					String sa = rs.getString("SECURITY_ANSWER");
					String h = rs.getString("HINT");
					User u = new User(fn, ln, us, p, sq, sa, h);
					users.add(u);
					System.out.println(fn);
				}
			}catch (SQLException e) {
	
				e.printStackTrace();
			}
		
		logInScreen = new JFrame("Log In");
		logInScreen.setLayout(new FlowLayout());
		logInScreen.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		logInScreen.setSize(screen);
		logInScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label1 = new JLabel("Username: ");
		JLabel label2 = new JLabel("Password: ");
		JLabel label3 = new JLabel("Musical Name");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 300));
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 180));
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 180));
		label3.setForeground(Color.pink);
		t1 = new JTextField("", 50);
		t2 = new JTextField("", 50);
		
		JButton b1 = new JButton("Hint");
		JButton b2 = new JButton("Forgot Password");
		JButton b3 = new JButton("Create Account");
		JButton b4 = new JButton("Admin Log In");
		
		 b1.setPreferredSize(new Dimension(550, 100));
		 b2.setPreferredSize(new Dimension(550, 100));
		 b3.setPreferredSize(new Dimension(550, 100));
		 b4.setPreferredSize(new Dimension(550, 100));
		
		label1.setVerticalAlignment(SwingConstants.CENTER);
		label2.setVerticalAlignment(SwingConstants.CENTER);
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setVerticalAlignment(SwingConstants.NORTH);
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		
		logInScreen.add(label3);
		logInScreen.add(label1);
		logInScreen.add(t1);
		logInScreen.add(label2);
		logInScreen.add(t2);
		logInScreen.add(b1);
		logInScreen.add(b2);
		logInScreen.add(b3);
		logInScreen.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b1.setBackground(Color.pink);
		b1.setForeground(Color.white);
	/*********************************************************************************************************************/
		//Create Account Screen
		
		createAccountScreen = new JFrame("Create Account Screen");
		createAccountScreen.setLayout(new FlowLayout());
		createAccountScreen.setSize(screen);
		createAccountScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		frame2 = new JFrame("Customer Order Data");
		frame2.getContentPane().setLayout(new FlowLayout());
		frame2.setSize(1000, 500);
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		updateTable();
		//createAcoountScreen.setLayout(new Layout());
		//createAccountScreen.setBounds(0,0,0,0); 
		JLabel heading = new JLabel("New User");
		heading.setForeground(Color.PINK);
		JLabel fName = new JLabel("First Name: ");
		JLabel lName = new JLabel("Last Name: ");
		JLabel uName = new JLabel("Username: ");
		JLabel password = new JLabel("Password: ");
		JLabel sq = new JLabel("Security Question: ");
		JLabel sa = new JLabel("Security Answer: ");
		JLabel hint = new JLabel("Hint: ");
		
		heading.setFont(new Font("Times New Roman", Font.BOLD, 110));
		
		securityQuestions = new JComboBox<String>(questions);
		securityQuestions.addActionListener(this);
		securityQuestions.setEditable(true);
		
		cast1 = new JTextField("", 50);
		cast2 = new JTextField("", 50);
		cast3 = new JTextField("", 50);
		cast4 = new JTextField("", 50);
		cast5 = new JTextField("", 50);
		cast6 =new JTextField("", 50);

		cab = new JButton("Create User");
		dt = new JButton("Display Table");
	   // cast5.setEchoChar('*');
		createAccountScreen.add(heading);
		createAccountScreen.add(fName);
		createAccountScreen.add(cast1);
		createAccountScreen.add(lName);
		createAccountScreen.add(cast2);
		createAccountScreen.add(uName);
		createAccountScreen.add(cast3);
		createAccountScreen.add(password);
		createAccountScreen.add(cast4);
		createAccountScreen.add(sq);
		createAccountScreen.add(securityQuestions);
		createAccountScreen.add(sa);
		createAccountScreen.add(cast5);
		createAccountScreen.add(hint);
		createAccountScreen.add(cast6);
		
		
		createAccountScreen.add(cab);
		createAccountScreen.add(dt);
		cab.addActionListener(this);
		dt.addActionListener(this);

		//b1.addActionListener(this);
		
	/**************************************************************************************************************************/
		//Forgot Password Screen
		
		forgotPasswordScreen = new JFrame("Forgot Password");
		forgotPasswordScreen.setLayout(new FlowLayout());
		forgotPasswordScreen.setSize(500, 500);
		forgotPasswordScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel fpsq = new JLabel((String)securityQuestions.getSelectedItem());
		JLabel fpsa = new JLabel("Answer: ");
		sat = new JTextField("", 50);

		JButton fpb = new JButton("Enter");
		
		forgotPasswordScreen.add(fpsq);
		forgotPasswordScreen.add(fpsa);
		forgotPasswordScreen.add(sat);
		forgotPasswordScreen.add(fpb);

		fpb.addActionListener(this);
	/**************************************************************************************************************************/
		//Password Recovery Screen
		
		passwordRecoveryScreen = new JFrame("Password Recovery");
		passwordRecoveryScreen.setLayout(new GridLayout(3,2));
		passwordRecoveryScreen.setSize(500, 500);
		passwordRecoveryScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel np = new JLabel("Enter New Password:");
		JLabel rnp = new JLabel("Re-enter New Password: ");
		npt = new JTextField("", 50);
		rnpt = new JTextField("", 50);
		
		JButton prb = new JButton("Enter");
		
		passwordRecoveryScreen.add(np);
		passwordRecoveryScreen.add(npt);
		passwordRecoveryScreen.add(rnp);
		passwordRecoveryScreen.add(rnpt);

		prb.addActionListener(this);
		
	
		
		
		/*******************************************************************************************************************/
		//Admin Log In Screen
		
		adminLogInScreen = new JFrame("Admin Log In");
		adminLogInScreen.setLayout(new GridLayout(4,2));
		adminLogInScreen.setSize(500, 500);
		adminLogInScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel aun = new JLabel("Username: ");
		JLabel ap = new JLabel("Password: ");
		JLabel ac = new JLabel("Admin Code: ");
		aunt = new JTextField("", 50);
		apt = new JTextField("", 50);
		act = new JTextField("", 10);

		JButton aub = new JButton("Enter");
		
		adminLogInScreen.add(aun);
		adminLogInScreen.add(aunt);
		adminLogInScreen.add(ap);
		adminLogInScreen.add(apt);
		adminLogInScreen.add(ac);
		adminLogInScreen.add(act);
		adminLogInScreen.add(aub);

		aub.addActionListener(this);
	}
	
	/**************************************************************************************************************************/
	//Make Buttons Work Time!!!
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Create Account")) {
			createAccountScreen.setVisible(true);
		}
		if(ae.getActionCommand().equals("Create User")) {
			if(cast1.getText().length() == 0 || cast2.getText().length() == 0||cast3.getText().length() == 0 ||cast4.getText()
					.length() == 0 ||cast5.getText().length() == 0 ||cast6.getText().length() == 0 ) {
				JOptionPane.showMessageDialog(null, "Please enter values in all fields");
			}
					
					u = new User(cast1.getText(), cast2.getText(),cast3.getText(), cast4.getText(), (String) securityQuestions
							.getSelectedItem(), cast5.getText(), cast6.getText());
					try {
						stmt.executeUpdate("Insert into USER_INFO values("+"'" + cast1.getText() + "',' "
					+ cast2.getText() + "','" + cast3.getText() + "','"+ cast4.getText() + "','"+ (String) securityQuestions
					.getSelectedItem() + "','" + cast5.getText() + "','"+ cast6.getText() +"')");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				
				

				this.users.add(u);
				updateTable();
				
				t1.setText("");
				t2.setText("");
			
			cast1.setText("");
			cast2.setText("");
			cast3.setText("");
			cast4.setText("");
			cast5.setText("");
			cast6.setText("");
		}
		
		if(ae.getActionCommand().equals("Display Table")) {
			frame2.setVisible(true);
		}
		if(ae.getActionCommand().equals("Forgot Password")) {
			forgotPasswordScreen.setVisible(true);
			
			if(ae.getActionCommand().equals("Enter")) {
				passwordRecoveryScreen.setVisible(true);
				if(sat.getText().equals(u.getsAnswer())){
					passwordRecoveryScreen.setVisible(true);
					if(npt.getText().equals(rnpt.getText())) {
					u.setPassword(npt.getText());
						JOptionPane.showMessageDialog(forgotPasswordScreen,"Password "
								+ "successfuly reset.");
					}
					else{
						JOptionPane.showMessageDialog(passwordRecoveryScreen,"Passwords do "
								+ "not match.");
					}
					
				}
			}
				else{
					JOptionPane.showMessageDialog(forgotPasswordScreen,"Incorrect answer,"
							+ " try again.");
				}
			
		}
		if(ae.getActionCommand().equals("Admin Log In")) {
			adminLogInScreen.setVisible(true);
			
		}
		if(ae.getActionCommand().equals("Hint")) {
			JOptionPane.showMessageDialog(logInScreen,"Your hint is: " );
		}
		
	}
	
	public void updateTable() {
		
		
		if (tableCreated) {
			frame2.remove(jscrlp);
		}
	
		tableCreated = true;
		
		 obj = new Object[users.size()][20];
		for(int i = 0; i < users.size(); i++) {
			obj[i][0] = this.users.get(i).getfName();
			obj[i][1] = this.users.get(i).getlName();
			obj[i][2] = this.users.get(i).getuName();
			obj[i][3] = this.users.get(i).getPassword();
			obj[i][4] = this.users.get(i).getsQuestion();
			obj[i][5] = this.users.get(i).getsAnswer();
			obj[i][6] = this.users.get(i).getHint();
		}
		
		table = new JTable(obj, headings)
		{
		    public boolean isCellEditable(int row, int column) {                
		        return false;               
		    };
		};
		jscrlp = new JScrollPane(table);
		table.getTableHeader().setReorderingAllowed(false);

		table.setPreferredScrollableViewportSize(new Dimension(980, 500));
		
		frame2.add(jscrlp);

		if (frame2.isVisible()) {
			frame2.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LogIn();
			}
		});
	}

}


