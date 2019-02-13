package IA;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
//import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

//import javax.imageio.ImageIO;




import javax.swing.*;
//import java.io.File;
//import java.io.IOException;

//import Reference.CustomerOrder;


public class LogIn implements ActionListener {
	
	//Log In Screen Variable
	private JFrame logInScreen;
	private JTextField username;
	private TextField PasswordText;
	private User LogInUser;
	private Error er;
	private List<User> AllUsers;
	private List<User> AdminUser;

	private List<Musical> MusicalList;
	private ImageIcon ragtimeImage;

	Admin a;


	
	//Create Account Screen Variables
	private String AdminCode = "s738*!dp";
	private JFrame createAccountScreen;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField InitialUsername;
	private JTextField InitialPassword;
	private JTextField SecurityAnswer;
	private JTextField Hint;
	private JTextField aCode;
	private JButton CreateAccount;
	private JButton DisplayTable;
	private JComboBox<String> securityQuestions;
	String[] questions = {"What is the name of your favorite childhood friend?", "What is your favorite Disney movie?",
			"What school did you attend for sixth grade?", "What was the make and model of your first car?",
			"What is the last name of the teacher who gave you your first failing grade?"};
	
	//Forgot Password Screen Variables
	private JFrame forgotPasswordScreen;
	private JTextField ResetAnswer;
	
	//Password Recovery Screen Variables
	private JFrame passwordRecoveryScreen;
	private JTextField NewPasswordText;
	private JTextField rNewPasswordTextText;
	
	//Admin Log In Screen Variables
	private JFrame adminLogInScreen;
	private JTextField aunt;
	private JTextField apt;
	private JTextField act;
	
	//Server Screen Variables
	private JFrame ServerScreen;
	private JButton SOS;
	private JButton CreateMusical;
	private JFrame ErrorMessage;
	private JTextField BrokenMic;
	private JTextField error;
	private JButton confirmError;
	private JFrame MusicalFrame;
	private JTextField mName;
	private JTextField actor;
	private JTextField role;
	private JTextField songsin;
	private JButton confirmMusical;

	//Database Variables
	DBConnectionManagerSingleton dbc;
	static Connection conn;
	static Statement stmt;
	private User u;
	private Error err;
	ArrayList<User> users = new ArrayList<User>();

	ArrayList<Error> errors = new ArrayList<Error>();
	
	private JFrame UserFrame;

	private JFrame frame1;
	private JFrame frame2;

	private JScrollPane jscrlp;

	private boolean userTableCreated = false;
	private Object[][] userObj;
	private JTable userTable;
	String [] userHeadings = {"First Name", "Last Name", "Username", "Password", 
			"Security Question", "Security Answer", "Hint"};
	

	private boolean tableCreated = false;
	private boolean tableCreated1 = false;
	private Object[][] obj;
	private Object[][] obj1;
	private JTable table;
	private JTable table1;
	String [] headings = {"First Name", "Last Name", "Username", "Password", 
			"Security Question","Security Answer", "Hint"};
	
	private JFrame errorFrame;
	private boolean errorTableCreated = false;
	private Object[][] errorObj;
	private JTable errorTable;
	String [] errorHeadings = {"Broken Mic", "Replaced Mic", "Error", "Time Logged"};
	
	
	/*******************************************************************************************************************************/
	//Log In Screen
	LogIn() {
		
		//Create connection with database
	/*	try {
			dbc = DBConnectionManagerSingleton.getInstance();
		} catch (Exception e) {
		}
		
		
		conn = dbc.getConnection();
		statement = dbc.getStatement();
			
			String viewRec = "SELECT * from USER_INFO";
			ResultSet rs;
			try {
				rs = statement.executeQuery(viewRec);
			
			

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
			}catch (SQLException ex) {
	
				ex.printStackTrace();
			}
		*/
		//Create LogIn Screen Frame
		logInScreen = new JFrame("Log In");
		logInScreen.setLayout(null);
		logInScreen.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		logInScreen.setSize(screen);
		logInScreen.setBackground(Color.white);
		logInScreen.setForeground(Color.white);
		logInScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create List of Users to login
		AllUsers = new ArrayList<>();
		AdminUser = new ArrayList<>();
		MusicalList = new ArrayList<>();
		LogInUser = null;
		
		//Create and edit labels
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel label3 = new JLabel("Ragtime Tech");
		JLabel label4 = new JLabel("Log In");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 75));
		label4.setFont(new Font("Times New Roman", Font.BOLD, 75));
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		//Create Textfields for input from user
		username = new JTextField("", 30);
		PasswordText = new TextField("");
		PasswordText.setEchoChar('*');     //Mask password
		
		//Create and label each button
		JButton LogInButton = new JButton("Log In");
		JButton HintButton = new JButton("Hint");
		JButton fPassButton = new JButton("Forgot Password");
		JButton CreateAccountButton = new JButton("Create Account");
		JButton AdminLogInButton = new JButton("Admin Log In");
		JCheckBox ShowPassword = new JCheckBox("Show Password");
		ragtimeImage = new ImageIcon("/Users/emily/eclipse-workspace/RAGTIME.png");
		Image image = ragtimeImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(575, 700,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		ragtimeImage = new ImageIcon(newimg);  // transform it back
		JLabel ragtimeLabel = new JLabel(ragtimeImage);
		
		//Add labels and textfields to the frame
        logInScreen.add(ragtimeLabel);
		logInScreen.add(label3);
		logInScreen.add(label4);
		logInScreen.add(usernameLabel);
		logInScreen.add(username);
		logInScreen.add(passwordLabel);
		logInScreen.add(PasswordText);
		logInScreen.add(LogInButton);
		logInScreen.add(HintButton);
		logInScreen.add(fPassButton);
		logInScreen.add(CreateAccountButton);
		logInScreen.add(AdminLogInButton);
		logInScreen.add(ShowPassword);
				
		//Format frame
		ragtimeLabel.setBounds(0, 0, 575, 700);
		usernameLabel.setBounds(675,300,100,50);
		username.setBounds(770, 310, 400, 30);
		passwordLabel.setBounds(675, 347, 90, 50);
		PasswordText.setBounds(772, 360, 395, 24);
		label4.setBounds(810, 125,400,110);
		label3.setBounds(700,50, 700, 110);
		ShowPassword.setBounds(770,400,150, 30);
		LogInButton.setBounds(675,450, 485, 45);
		HintButton.setBounds(595,600, 150, 70);
		fPassButton.setBounds(770,600, 150, 70);
		CreateAccountButton.setBounds(945,600, 150, 70);
		AdminLogInButton.setBounds(1120,600, 150, 70);
		
		//Evoke action listener
		LogInButton.addActionListener(this);
		HintButton.addActionListener(this);
		fPassButton.addActionListener(this);
		CreateAccountButton.addActionListener(this);
		AdminLogInButton.addActionListener(this);
		
		HintButton.setBackground(Color.pink);
		HintButton.setForeground(Color.black);
	/*********************************************************************************************************************/
		//Create Account Screen
		
		createAccountScreen = new JFrame("Create Account Screen");
		createAccountScreen.setLayout(null);
		createAccountScreen.setSize(screen);
		createAccountScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		

		UserFrame = new JFrame("User Data");
		UserFrame.getContentPane().setLayout(new FlowLayout());
		UserFrame.setSize(1000, 500);
		UserFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//updateTable();

		frame1 = new JFrame("User Data");
		frame1.getContentPane().setLayout(new FlowLayout());
		frame1.setSize(1000, 500);
		frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		updateTable();
		
		frame2 = new JFrame("User Data");
		frame2.getContentPane().setLayout(new FlowLayout());
		frame2.setSize(1000, 500);
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		updateTable();

		//createAcoountScreen.setLayout(new Layout());
		//createAccountScreen.setBounds(0,0,0,0); 
		
		
		JTextArea star = new JTextArea("*");
		star.setForeground(Color.RED);
		JLabel heading = new JLabel("New User");
		JLabel rFields = new JLabel("required fields");
		rFields.setForeground(Color.RED);
		heading.setForeground(Color.PINK);
		JLabel fName = new JLabel("First Name" + star +" : ");
		JLabel lName = new JLabel("Last Name"  + star.getText() +" : ");
		JLabel uName = new JLabel("Username"  + star.getText() +" : ");
		JLabel password = new JLabel("Password"  + star.getText() +" : ");
		JLabel sq = new JLabel("Security Question"  + star.getText() +" : ");
		JLabel sa = new JLabel("Security Answer"  + star.getText() +" : ");
		JLabel hint = new JLabel("Hint"  + star.getText() +" : ");
		JLabel ACode = new JLabel("Admin Code");
	
		
		
		heading.setFont(new Font("Times New Roman", Font.BOLD, 110));
		fName.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lName.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		uName.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		password.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		sq.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		sa.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		hint.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		ACode.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		
		
		
		securityQuestions = new JComboBox<String>(questions);
		securityQuestions.addActionListener(this);
		//securityQuestions.setEditable(true);
		
		FirstName = new JTextField("", 50);
		LastName = new JTextField("", 50);
		InitialUsername = new JTextField("", 50);
		InitialPassword = new JTextField("", 50);
		SecurityAnswer = new JTextField("", 50);
		Hint =new JTextField("", 50);
		aCode = new JTextField("", 50);
		CreateAccount = new JButton("Create User");
		DisplayTable = new JButton("Display Table");
	  
		createAccountScreen.add(star);
		createAccountScreen.add(rFields);
		createAccountScreen.add(heading);
		createAccountScreen.add(fName);
		createAccountScreen.add(FirstName);
		createAccountScreen.add(lName);
		createAccountScreen.add(LastName);
		createAccountScreen.add(uName);
		createAccountScreen.add(InitialUsername);
		createAccountScreen.add(password);
		createAccountScreen.add(InitialPassword);
		createAccountScreen.add(sq);
		createAccountScreen.add(securityQuestions);
		createAccountScreen.add(sa);
		createAccountScreen.add(SecurityAnswer);
		createAccountScreen.add(hint);
		createAccountScreen.add(Hint);
		createAccountScreen.add(ACode);
		createAccountScreen.add(aCode);
		
		heading.setBounds(450,50, 600, 110);
		fName.setBounds(325,200,275,75);
		FirstName.setBounds(575, 225, 360, 45);
		lName.setBounds(325, 250, 275, 75);
		LastName.setBounds(575, 275, 360, 45);
		uName.setBounds(325,320, 275, 45);
		InitialUsername.setBounds(575,325,360, 45);
		password.setBounds(325,370, 275, 45);
		InitialPassword.setBounds(575,375,360, 45);
		sq.setBounds(325,420, 350, 45);
		securityQuestions.setBounds(625,425, 360, 45);
		sa.setBounds(325,470, 350, 45);
		SecurityAnswer.setBounds(575,475, 360, 45);
		hint.setBounds(325,520, 275, 45);
		Hint.setBounds(575,525, 360, 45);
		ACode.setBounds(325,570, 450, 45);
		aCode.setBounds(575,575, 360, 45);
		star.setBounds(575,600, 20, 20);
		rFields.setBounds(600,600, 100, 45);
		CreateAccount.setBounds(325,650, 175, 75);
		DisplayTable.setBounds(575,650, 175, 75);

		
		createAccountScreen.add(CreateAccount);
		createAccountScreen.add(DisplayTable);
		CreateAccount.addActionListener(this);
		DisplayTable.addActionListener(this);

		//HintButton.addActionListener(this);
		
	/**************************************************************************************************************************/
		//Forgot Password Screen
		
		forgotPasswordScreen = new JFrame("Forgot Password");
		forgotPasswordScreen.setLayout(new FlowLayout());
		forgotPasswordScreen.setSize(500, 500);
		forgotPasswordScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel fpsq = new JLabel((String)securityQuestions.getSelectedItem());
		JLabel fpsa = new JLabel("Answer: ");
		ResetAnswer = new JTextField("", 50);

		JButton fpb = new JButton("Enter");
		
		forgotPasswordScreen.add(fpsq);
		forgotPasswordScreen.add(fpsa);
		forgotPasswordScreen.add(ResetAnswer);
		forgotPasswordScreen.add(fpb);

		fpb.addActionListener(this);
	/**************************************************************************************************************************/
		//Password Recovery Screen
		
		passwordRecoveryScreen = new JFrame("Password Recovery");
		passwordRecoveryScreen.setLayout(new GridLayout(3,2));
		passwordRecoveryScreen.setSize(500, 500);
		passwordRecoveryScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel NewPassword = new JLabel("Enter New Password:");
		JLabel rNewPassword = new JLabel("Re-enter New Password: ");
		NewPasswordText = new JTextField("", 50);
		rNewPasswordTextText = new JTextField("", 50);
		
		JButton prb = new JButton("Enter");
		
		passwordRecoveryScreen.add(NewPassword);
		passwordRecoveryScreen.add(NewPasswordText);
		passwordRecoveryScreen.add(rNewPassword);
		passwordRecoveryScreen.add(rNewPasswordTextText);

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
	
	/**************************************************************************************************************************/
		//Server Screen
		
		ServerScreen = new JFrame("Makeshift Servver");
		ServerScreen.setLayout(null);
		ServerScreen.setSize(screen);
		ServerScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		SOS = new JButton("SOS");
		CreateMusical = new JButton("Create Musical");
		
		ServerScreen.add(SOS);
		ServerScreen.add(CreateMusical);
		
		CreateMusical.setBounds(325,400, 175, 75);
		SOS.setBounds(575,400, 175, 75);
		
		CreateMusical.addActionListener(this);
		SOS.addActionListener(this);
		
		/////////////////////////////////////////
		
		ErrorMessage = new JFrame("Makeshift Servver");
		ErrorMessage.setLayout(null);
		ErrorMessage.setSize(screen);
		ErrorMessage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel brokenMic = new JLabel("Please enter the number of the broken mic.");
		JLabel Error = new JLabel("Please state what error occured.");
		JTextField bm = new JTextField("",50);
		JTextField errorText = new JTextField("",50);
		confirmError = new JButton("Confirm Error");
		
		ErrorMessage.add(brokenMic);
		ErrorMessage.add(Error);
		ErrorMessage.add(bm);
		ErrorMessage.add(errorText);
		ErrorMessage.add(confirmError);
		
		brokenMic.setBounds(50,200, 400,50 );
		Error.setBounds(125,300, 400,50 );

		errorText.setBounds(125,270, 400,50 );
		confirmError.setBounds(50,350, 400,50 );

		bm.setBounds(125,350, 400,50 );
		confirmError.setBounds(50,425, 400,50 );

		
		/////////////////////////////////////////
		
		MusicalFrame = new JFrame("Musical");
		MusicalFrame.setLayout(null);
		MusicalFrame.setSize(screen);
		MusicalFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		confirmMusical = new JButton("Confirm Musical");
		JLabel MName = new JLabel("Please enter musical name:");
		JLabel Actor = new JLabel("Please enter actor's name:");
		JLabel Roles = new JLabel("Please enter the role(s) the actor has: ");
		JLabel Songsin = new JLabel("Please list all the songs the actor is in seperated by a '''");
		
		mName = new JTextField("",50);
		actor = new JTextField("",50);
		role = new JTextField("",50);
		songsin = new JTextField("",50);
		
		MusicalFrame.add(confirmMusical);
		MusicalFrame.add(MName);
		MusicalFrame.add(Actor);
		MusicalFrame.add(Roles);
		MusicalFrame.add(Songsin);
		MusicalFrame.add(mName);
		MusicalFrame.add(actor);
		MusicalFrame.add(role);
		MusicalFrame.add(songsin);
		
		
		MName.setBounds(50,200, 400,50 );
		mName.setBounds(300,220, 400,50 );
		Actor.setBounds(50,250, 400,50 );
		actor.setBounds(300,270, 400,50 );
		Roles.setBounds(50,300, 400,50 );
		role.setBounds(300,320, 400,50 );
		Songsin.setBounds(50,350, 400,50 );
		songsin.setBounds(300,370, 400,50 );
		confirmMusical.setBounds(325,500, 100,50 );
		
		confirmMusical.addActionListener(this);
		
		
		

		
		
	/**************************************************************************************************************************/
	//Make Buttons Work Time!!!
	ShowPassword.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
		
	        JCheckBox cb = (JCheckBox) ae.getSource();
	        if (cb.isSelected()) {
	        	 PasswordText.setEchoChar((char)0);
	         
	        } else {
	            PasswordText.setEchoChar('*');
	        }

		
	}
});
}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Log In")) {
			
			if(AllUsers.size() != 0) {
			for (User user : AllUsers) {
				
	            if (user.getuName().equals(username.getText())) {
	                if (user.getPassword().equals(PasswordText.getText())) {
	                    LogInUser = user;
	                }
	                    if (LogInUser != null) {
	    				 logInScreen.dispose();
	    		        	ServerScreen.setVisible(true);
	    		        }
	    		        else
	    		        {
	    		        	JOptionPane.showMessageDialog(logInScreen,"Invalid username/password combination");
	    		        }

	                    // when a user is found, "break" stops iterating through the list
	                    break;
	                
	            }
	            else {
	            	JOptionPane.showMessageDialog(logInScreen,"User does not exist");
	            	
	            }
	        }
			}
			else {
				JOptionPane.showMessageDialog(logInScreen,"No user accounts have been created");
			}
			
		}
		if(e.getActionCommand().equals("Admin Log In")) {
	            for (User aUser : AdminUser)
		        {
		            if (aUser.getuName().equals(username.getText()))
		            {
		                if (aUser.getPassword().equals(PasswordText.getText()))
		                {
		                    LogInUser = aUser;

		                    // when a user is found, "break" stops iterating through the list
		                    break;
		                }
		            }
	        }

	        // if loggedInUser was changed from null, it was successful
	            if (LogInUser != null)
		        {
	            	logInScreen.dispose();
		        	ServerScreen.setVisible(true);
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(logInScreen,"Invalid username/password combination");
		        }
	    }
		
		if(e.getActionCommand().equals("Create Musical")) {
			MusicalFrame.setVisible(true);
			//createMusical();
			
			
		}
		
		if(e.getActionCommand().equals("Create Account")) {
			createAccountScreen.setVisible(true);
			logInScreen.dispose();
		}
		if(e.getActionCommand().equals("Create User")) {
			if(AllUsers.size() == 0) {
			if(FirstName.getText().length() == 0 || LastName.getText().length() == 0||InitialUsername.getText().length() == 0 ||InitialPassword.getText()
					.length() == 0 ||SecurityAnswer.getText().length() == 0 ||Hint.getText().length() == 0 ) {
				JOptionPane.showMessageDialog(createAccountScreen, 
						  "Please answer all required fields.", "Failure", 
						  JOptionPane.ERROR_MESSAGE);
			}
			else if(FirstName.getText().length() > 0 && LastName.getText().length() > 0&&
					InitialUsername.getText().length() > 0 &&InitialPassword.getText()
					.length() > 0 &&SecurityAnswer.getText().length() > 0 &&
					Hint.getText().length() > 0 && aCode.getText().length() == 0) {
				if(InitialPassword.getText().length()>30||InitialUsername.getText().length()>30||
						FirstName.getText().length()>30||LastName.getText()
						.length()>30||SecurityAnswer.getText().length()>30||Hint
						.getText().length() > 30) {
					JOptionPane.showMessageDialog(createAccountScreen,"Please make sure the"
							+ " amount of characters in each field is less than 30.");
				}
				else {
			AllUsers.add(new User(FirstName.getText(), LastName.getText(),InitialUsername.
				   getText(), InitialPassword.getText(), (String) securityQuestions
				  .getSelectedItem(), SecurityAnswer.getText(), Hint.getText()));
			createAccountScreen.dispose();
			logInScreen.setVisible(true);
			JOptionPane.showMessageDialog(createAccountScreen,"User "
					+ "successfuly created.");
				}
			}
			
			else if(FirstName.getText().length() > 0 && LastName.getText().length() > 0 &&
					InitialUsername.getText().length() > 0 &&InitialPassword.getText()
					.length() > 0 &&SecurityAnswer.getText().length() > 0 &&
					Hint.getText().length() > 0 && aCode.getText().length() > 0) {
				if(aCode.getText().equals(AdminCode)) {
					if(InitialPassword.getText().length()>30||InitialUsername.getText().length()>30||
							FirstName.getText().length()>30||LastName.getText()
							.length()>30||SecurityAnswer.getText().length()>30||Hint
							.getText().length() > 30) {
						JOptionPane.showMessageDialog(createAccountScreen,"Please make sure the"
								+ " amount of characters in each field is less than 30.");
					}
					else {
						if(InitialPassword.getText().length()>30||InitialUsername.getText().length()>30||
								FirstName.getText().length()>30||LastName.getText()
								.length()>30||SecurityAnswer.getText().length()>30||Hint
								.getText().length() > 30) {
							JOptionPane.showMessageDialog(createAccountScreen,"Please make sure the"
									+ " amount of characters in each field is less than 30.");
						}
						else {
				AdminUser.add(new User(FirstName.getText(), LastName.getText(),InitialUsername.
						   getText(), InitialPassword.getText(), (String) securityQuestions
						  .getSelectedItem(), SecurityAnswer.getText(), Hint.getText()));
					createAccountScreen.dispose();
					logInScreen.setVisible(true);
					JOptionPane.showMessageDialog(createAccountScreen,"Admin user "
							+ "successfuly created.");
						}
				}
			}
				else{
					JOptionPane.showMessageDialog(createAccountScreen, 
							  "Invalid admin code.", "Failure", 
							  JOptionPane.ERROR_MESSAGE);
				}
			}
			
					u = new User(FirstName.getText(), LastName.getText(),InitialUsername.
				   getText(), InitialPassword.getText(), (String) securityQuestions
				  .getSelectedItem(), SecurityAnswer.getText(), Hint.getText());
					try {
						stmt.executeUpdate("Insert into USER_INFO values("+"'" + FirstName.getText() + "',' "
					+ LastName.getText() + "','" + InitialUsername.getText() + "','"+ InitialPassword.getText() + "','"+ (String) securityQuestions
					.getSelectedItem() + "','" + SecurityAnswer.getText() + "','"+ Hint.getText() +"')");

					}  catch (SQLException ex) {

						ex.printStackTrace();
					}
				
				
				

				this.users.add(u);

				updateUserTable();
				
				
				updateTable();

				username.setText("");
				PasswordText.setText("");
			
			FirstName.setText("");
			LastName.setText("");
			InitialUsername.setText("");
			InitialPassword.setText("");
			SecurityAnswer.setText("");
			Hint.setText("");
			aCode.setText("");
			}
			
			else {
				for(User u: AllUsers) {
					if(u.getuName().equals(InitialUsername.getText())) {
						JOptionPane.showMessageDialog(createAccountScreen, 
								  "Username already exists. Choose a new username.");
						
						username.setText("");
						PasswordText.setText("");
						FirstName.setText("");
						LastName.setText("");
						InitialUsername.setText("");
						InitialPassword.setText("");
						SecurityAnswer.setText("");
						Hint.setText("");
						aCode.setText("");
						
					}
					else {
						if(FirstName.getText().length() == 0 || LastName.getText().length() == 0||InitialUsername.getText().length() == 0 ||InitialPassword.getText()
								.length() == 0 ||SecurityAnswer.getText().length() == 0 ||Hint.getText().length() == 0 ) {
							JOptionPane.showMessageDialog(createAccountScreen, 
									  "Please answer all required fields.", "Failure", 
									  JOptionPane.ERROR_MESSAGE);
						}
						else if(FirstName.getText().length() > 0 && LastName.getText().length() > 0&&
								InitialUsername.getText().length() > 0 &&InitialPassword.getText()
								.length() > 0 &&SecurityAnswer.getText().length() > 0 &&
								Hint.getText().length() > 0 && aCode.getText().length() == 0) {
						AllUsers.add(new User(FirstName.getText(), LastName.getText(),InitialUsername.
							   getText(), InitialPassword.getText(), (String) securityQuestions
							  .getSelectedItem(), SecurityAnswer.getText(), Hint.getText()));
						createAccountScreen.dispose();
						logInScreen.setVisible(true);
						JOptionPane.showMessageDialog(createAccountScreen,"User "
								+ "successfuly created.");
						}
						
						else if(FirstName.getText().length() > 0 && LastName.getText().length() > 0 &&
								InitialUsername.getText().length() > 0 &&InitialPassword.getText()
								.length() > 0 &&SecurityAnswer.getText().length() > 0 &&
								Hint.getText().length() > 0 && aCode.getText().length() > 0) {
							if(aCode.getText().equals(AdminCode)) {
							AdminUser.add(new User(FirstName.getText(), LastName.getText(),InitialUsername.
									   getText(), InitialPassword.getText(), (String) securityQuestions
									  .getSelectedItem(), SecurityAnswer.getText(), Hint.getText()));
								createAccountScreen.dispose();
								logInScreen.setVisible(true);
								JOptionPane.showMessageDialog(createAccountScreen,"Admin user "
										+ "successfuly created.");
							}
							else{
								JOptionPane.showMessageDialog(createAccountScreen, 
										  "Invalid admin code.", "Failure", 
										  JOptionPane.ERROR_MESSAGE);
							}
						}
						
							/*	u = new User(FirstName.getText(), LastName.getText(),InitialUsername.
							   getText(), InitialPassword.getText(), (String) securityQuestions
							  .getSelectedItem(), SecurityAnswer.getText(), Hint.getText());
								try {
									stmt.executeUpdate("Insert into USER_INFO values("+"'" + FirstName.getText() + "',' "
								+ LastName.getText() + "','" + InitialUsername.getText() + "','"+ InitialPassword.getText() + "','"+ (String) securityQuestions
								.getSelectedItem() + "','" + SecurityAnswer.getText() + "','"+ Hint.getText() +"')");
								} catch (SQLException e) {
									ex.printStackTrace();
								}
							
							
							

							this.users.add(u);
							updateUserTable();
							*/
							
						username.setText("");
						PasswordText.setText("");
						FirstName.setText("");
						LastName.setText("");
						InitialUsername.setText("");
						InitialPassword.setText("");
						SecurityAnswer.setText("");
						Hint.setText("");
						aCode.setText("");
						
					}
					
				}
			}

		}
		if(e.getActionCommand().equals("SOS")) {
			ErrorMessage.setVisible(true);
			
		}
		
		if(e.getActionCommand().equals("Display Table")) {

			UserFrame.setVisible(true);

			frame1.setVisible(true);

		}
		if(e.getActionCommand().equals("Forgot Password")) {
			forgotPasswordScreen.setVisible(true);
		}
		if(e.getActionCommand().equals("Confirm Musical")) {
			if(mName.getText().length() == 0 || actor.getText().length() == 0|| 
					role.getText().length() == 0 ||songsin.getText().length() == 0) {
				JOptionPane.showMessageDialog(createAccountScreen, 
						  "Please answer all required fields.", "Failure", 
						  JOptionPane.ERROR_MESSAGE);
			}
			else {
			MusicalList.add(new Musical(mName.getText(), actor.getText(),role.
				   getText(), songsin.getText()));
			a.createMusical(MusicalList);
			}
			
		}
		
		if(e.getActionCommand().equals("Display Musical Table")) {
			
		}
		if(e.getActionCommand().equals("Enter")) {
			//passwordRecoveryScreen.setVisible(true);
			if(ResetAnswer.getText().equals(u.getsAnswer())){
				passwordRecoveryScreen.setVisible(true);
				if(NewPasswordText.getText().equals(rNewPasswordTextText.getText())) {
				u.setPassword(NewPasswordText.getText());
				JOptionPane.showMessageDialog(forgotPasswordScreen,"Password "
							+ "successfuly reset.");
				}
				else{
					JOptionPane.showMessageDialog(passwordRecoveryScreen,"Passwords do "
							+ "not match.");
				}
					
			}
		}
			//else{
					//JOptionPane.showMessageDialog(forgotPasswordScreen,"Incorrect answer,"
						//	+ " try again.");
				//}
			
		
		//if(e.getActionCommand().equals("Admin Log In")) {
		//	adminLogInScreen.setVisible(true);
			
	//	}
		if(e.getActionCommand().equals("Hint")) {
			for (User user : AllUsers)
	        {
	            if (user.getuName().equals(username.getText()))
	            {
	                if (user.getPassword().equals(PasswordText.getText()))
	                {
	                	JOptionPane.showMessageDialog(logInScreen,"Your hint is: " +
	                			user.getHint());

	                    // when a user is found, "break" stops iterating through the list
	                    break;
	                }
	            }
		}
		}
		
		if(e.getActionCommand().equals("Confirm Error")) {
			er = new Error(FirstName.getText(), LastName.getText(),InitialUsername.
					   getText(), InitialPassword.getText());
						try {
							stmt.executeUpdate("Insert into ERROR_LOG values("+"'" + mName.getText() + "',' "
						+ actor.getText() + "','" + role.getText() + "','"+ songsin.getText() + "')");
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					
					
					

					//this.e.add(er);
					updateTable();
			
			err = new Error(FirstName.getText(), LastName.getText(),InitialUsername.
					   getText(), InitialPassword.getText());
						try {
							stmt.executeUpdate("Insert into USER_INFO values("+"'" + FirstName.getText() + "',' "
						+ LastName.getText() + "','" + InitialUsername.getText() + "','"+ InitialPassword.getText() + "','"+ (String) securityQuestions
						.getSelectedItem() + "','" + SecurityAnswer.getText() + "','"+ Hint.getText() +"')");
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
			
		}
		
		
	}
		public void updateUserTable() {
			
			
		if (userTableCreated) {
			UserFrame.remove(jscrlp);
		}
		}

	public void updateTable() {
		
		
		if (tableCreated) {
			frame1.remove(jscrlp);

		}
		
		userTableCreated = true;
			
		userObj = new Object[users.size()][20];
		for(int i = 0; i < users.size(); i++) {
			userObj[i][0] = this.users.get(i).getfName();
			userObj[i][1] = this.users.get(i).getlName();
			userObj[i][2] = this.users.get(i).getuName();
			userObj[i][3] = this.users.get(i).getPassword();
			userObj[i][4] = this.users.get(i).getsQuestion();
			userObj[i][5] = this.users.get(i).getsAnswer();
			userObj[i][6] = this.users.get(i).getHint();
		}
			
		userTable = new JTable(userObj, userHeadings)
		{
		    public boolean isCellEditable(int row, int column) {                
		        return false;               
		    };
		};
		jscrlp = new JScrollPane(userTable);
		userTable.getTableHeader().setReorderingAllowed(false);
	
		userTable.setPreferredScrollableViewportSize(new Dimension(980, 500));
			
		UserFrame.add(jscrlp);

		if (UserFrame.isVisible()) {
			UserFrame.setVisible(true);
		}
			
	}
	
	public void updateErrorTable() {

		
		if (errorTableCreated) {
			errorFrame.remove(jscrlp);
			frame1.add(jscrlp);

		if (frame1.isVisible()) {
			frame1.setVisible(true);

		}
		
		errorTableCreated = true;
			
		errorObj = new Object[errors.size()][4];
		for(int i = 0; i < errors.size(); i++) {
			errorObj[i][0] = this.errors.get(i).getbMic();
			errorObj[i][1] = this.errors.get(i).getrMic();
			errorObj[i][2] = this.errors.get(i).getError();
			errorObj[i][3] = this.errors.get(i).getTime();

		}
			
		errorTable = new JTable(userObj, userHeadings)
		{
		    public boolean isCellEditable(int row, int column) {                
		        return false;               
		    };
		};
		jscrlp = new JScrollPane(errorTable);
		errorTable.getTableHeader().setReorderingAllowed(false);
	
		errorTable.setPreferredScrollableViewportSize(new Dimension(980, 500));
			
		errorFrame.add(jscrlp);

		if (errorFrame.isVisible()) {
			errorFrame.setVisible(true);
		}
	}
			
	}
	
	public static void main(String[] args) throws IOException {
		
		   // Construct JFrame for entire program
        JFrame jfm = new JFrame("Literature Application");

        // EDIT APPLICATION JFRAME
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setBackground(Color.BLACK);
        jfm.setForeground(Color.BLACK);
        jfm.setPreferredSize(new Dimension(1500, 1000));

        // Construct Intro GUI
       // introScreen g = new introScreen(jfm);

        try {

                String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;";
                String user = "sa";
                String pass = "Suncoast$1";

          
                conn = DriverManager.getConnection(dbURL, user, pass);
                if (conn != null) {
                        DatabaseMetaData dm = conn.getMetaData();
                        System.out.println("Driver name: " + dm.getDriverName());
                        System.out.println("Driver version: " + dm.getDriverVersion());
                        System.out.println("Product name: " + dm.getDatabaseProductName());
                        System.out.println("Product version: " + dm.getDatabaseProductVersion());
                }

        }

        catch (SQLException ex) {

                System.out.println(ex);

        }

        try {

                stmt = conn.createStatement();

                String update = "CREATE DATABASE SuncoastTheatre";
                 stmt.executeUpdate(update);

                String user = "USE SuncoastTheatre";
                stmt.executeUpdate(user);

                String updateTable = "Create table USER_INFO (FIRST_NAME varchar (30), LAST_NAME "
        				+ "varchar (35), USERNAME varchar (30) primary key, PASSWORD varchar (30), "
        				+ "SECURITY_QUESTION varchar (100), SECURITY_ANSWER varchar(30), HINT varchar(30))";
                 stmt.executeUpdate(updateTable);
                
                String updateTable1 = "CREATE TABLE literatureInfo(Question varchar(100), typeOfQuestion varchar(25), questionAnswer varchar(100))";
                // statement.executeUpdate(updateTable1);

        }

        catch (SQLException ex) {

                System.out.println(ex);

        }


		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LogIn();
			}
		});
	}

}


