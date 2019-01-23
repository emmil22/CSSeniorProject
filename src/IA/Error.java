package IA;

import java.util.Date;

public class Error {
	private String bMic;
	private String rMic;
	private String error;
	private String time ;
	

	
	public Error() {
		
		this.bMic = "";
		this.rMic = "";
		this.error = "";
		this.time = "";
	
	}
	
	public Error(String bMic, String rMic, 
			String error, String time) {
		
		this.bMic = bMic;
		this.rMic = rMic;
		this.error = error;
		this.time = time;
		
		
	}
	
	public Error(String bMic, String rMic, 
			String error) {
		
		this.bMic = bMic;
		this.rMic = rMic;
		this.error = error;
		
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
	
	public void setError(String error) {
		
		this.error = error;
	}
	
	public String getError() {
		
		return this.error;
	}
	
	public void setTime(String time) {
		
		this.time = time;
	}
	
	public String getTime() {
		
		return this.time;
	}
	
	
}

