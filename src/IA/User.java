package IA;

public class User {

	private String fName;
	private String lName;
	private String uName;
	private String password ;
	private String sQuestion;
	private String sAnswer;
	private String hint;

	
	public User() {
		
		this.fName = "";
		this.lName = "";
		this.uName = "";
		this.password = "";
		this.sQuestion= "";
		this.sAnswer = "";
		this.hint = "";
	}
	
	public User(String fName, String lName, 
			String uName, String password, String sQuestion, String sAnswer, String hint) {
		
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.password = password;
		this.sQuestion = sQuestion;
		this.sAnswer = sAnswer;
		this.hint = hint;
		
	}
	
	public User(String fName, String lName, 
			String uName, String password, String sQuestion, String sAnswer) {
		
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.password = password;
		this.sQuestion = sQuestion;
		this.sAnswer = sAnswer;
		
	}
	
	public User( String uName, String password) {
		
		this.uName = uName;
		this.password = password;
		
	}
	
	public void setfName(String fName) {
		
		this.fName = fName;
	}
	
	public String getfName() {
		
		return this.fName;
	}
	
	public void setlName(String lName) {
		
		this.lName = lName;
	}
	
	public String getlName() {
		
		return this.lName;
	}
	
	public void setuName(String uName) {
		
		this.uName = uName;
	}
	
	public String getuName() {
		
		return this.uName;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	public String getPassword() {
		
		return this.password;
	}
	
	public void setsQuestion(String sQuestion) {
		
		this.sQuestion = sQuestion;
	}
	
	public String getsQuestion() {
		
		return this.sQuestion;
	}
	
	public void setsAnswer(String sAnswer) {
			
		this.sAnswer = sAnswer;
		}
	public String getsAnswer() {
			 
		return this.sAnswer;
	}
	
	public void setHint(String hint) {
		
		this.hint = hint;
		}
	public String getHint() {
			 
		return this.hint;
	}
}