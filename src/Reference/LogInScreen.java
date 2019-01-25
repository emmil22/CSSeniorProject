package Reference;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LogInScreen implements ActionListener{
	
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
	private JComboBox<String> securityQuestions;
	String[] questions = {"What is the name of your favorite childhood friend?", "What is your favorite Disney movie?",
			"What school did you attend for sixth grade?", "What was the make and model of your first car?",
			"What is the last name of the teacher who gave you your first failing grade?"};
	
	//Forgot Password Screen Variables
	private JFrame forgotPasswordScreen;
	private JTextField sat;

	
	//Create the Log In Screen
	LogInScreen() {
		
		JFrame logInScreen = new JFrame("Log In");
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
//		Font f = label1.getFont();
//		System.out.println(f.getName());
	//	label2.setFont(new Font("Ariel", Font.ITALIC, 50));
		
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
		b1.setBackground(Color.pink);
		b1.setForeground(Color.white);
	/*********************************************************************************************************************/
		createAccountScreen = new JFrame("Create Account Screen");
		createAccountScreen.setLayout(new FlowLayout());
		createAccountScreen.setSize(500, 500);
		createAccountScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel heading = new JLabel("New User");
		heading.setForeground(Color.PINK);
		JLabel fName = new JLabel("First Name: ");
		JLabel lName = new JLabel("Last Name: ");
		JLabel uName = new JLabel("Username: ");
		JLabel password = new JLabel("Password: ");
		JLabel sq = new JLabel("Security Question: ");
		JLabel sa = new JLabel("Security Answer: ");
		
		heading.setFont(new Font("Times New Roman", Font.BOLD, 110));
		
		securityQuestions = new JComboBox<String>(questions);
		securityQuestions.addActionListener(this);
		securityQuestions.setEditable(true);
		
		cast1 = new JTextField("", 50);
		cast2 = new JTextField("", 50);
		cast3 = new JTextField("", 50);
		cast4 = new JTextField("", 50);
		cast5 = new JTextField("", 50);
//		Font f = label1.getFont();
//		System.out.println(f.getName());
//		label2.setFont(new Font(f.getName(), Font.ITALIC, 50));
		
		JButton cab = new JButton("Create User");
		
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
		
		createAccountScreen.add(cab);

		b1.addActionListener(this);
		
	/**************************************************************************************************************************/
		//Forgot Password Screen
		
		forgotPasswordScreen = new JFrame("Forgot Password");
		forgotPasswordScreen.setLayout(new FlowLayout());
		forgotPasswordScreen.setSize(500, 500);
		forgotPasswordScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel fpsq = new JLabel((String)securityQuestions.getSelectedItem());
		JLabel fpsa = new JLabel("Answer: ");
		sat = new JTextField("", 50);

//		Font f = label1.getFont();
//		System.out.println(f.getName());
//		label2.setFont(new Font(f.getName(), Font.ITALIC, 50));
		
		JButton fpb = new JButton("Enter");
		
		forgotPasswordScreen.add(fpsq);
		forgotPasswordScreen.add(fpsa);
		forgotPasswordScreen.add(sat);
	
		
		createAccountScreen.add(cab);

		b1.addActionListener(this);
	/**************************************************************************************************************************/
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Create Account")) {
			createAccountScreen.setVisible(true);
			
		}
		else if(ae.getActionCommand().equals("Forgot Password")) {
			forgotPasswordScreen.setVisible(true);
		}
		/*else if(ae.getActionCommand().equals("Admin Log In")) {
			
		}*/
		
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LogInScreen();
			}
		});
	}

}


