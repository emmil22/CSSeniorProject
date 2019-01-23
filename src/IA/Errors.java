package IA;

import java.util.Date;

public class Errors {
	private String bMic;
	private String rMic;
	private String error;
	private String time ;
	

	
	public Errors() {
		
		this.bMic = "";
		this.rMic = "";
		this.error = "";
		this.time = "";
	
	}
	
	public Errors(String bMic, String rMic, 
			String error, String time) {
		
		this.bMic = bMic;
		this.rMic = rMic;
		this.error = error;
		this.time = time;
		
		
	}
	
	public Errors(String bMic, String rMic, 
			String error, String time) {
		
		this.bMic = bMic;
		this.rMic = rMic;
		this.error = error;
		this.time = time;
		
	}
	
	public void setbMic(String bMic) {
		
		this.bMic = bMic;
	}
	
	public String getbMic() {
		
		return this.bMic;
	}
	
	public void setrMic(String rMic) {
		
		this.rMic = rMic;
	}
	
	public String getrMic() {
		
		return this.rMic;
	}
	
	public void seterror(String error) {
		
		this.error = error;
	}
	
	public String geterror() {
		
		return this.error;
	}
	
	public void settime(String time) {
		
		this.time = time;
	}
	
	public String gettime() {
		
		return this.time;
	}
	
	
}

