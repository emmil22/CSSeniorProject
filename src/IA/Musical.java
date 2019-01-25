package IA;

public class Musical {
	//musical name, rName, role, songs, songs participated in
	private String mName;
	private String actors;
	private String role;
	private String songsin;
	
public Musical() {
		
		this.mName = "";
		this.actors = "";
		this.role = "";
		this.songsin = "";
	
	}
	
	public Musical(String mName, String actors, 
			String role, String songsin) {
		
		this.mName = mName;
		this.actors = actors;
		this.role = role;
		this.songsin = songsin;
		
		
	}
	
	public void setmName(String mName) {
		
		this.mName = mName;
	}
	
	public String getmName() {
		
		return this.mName;
	}
	
	public void setactors(String actors) {
		
		this.actors = actors;
	}
	
	public String getactors() {
		
		return this.actors;
	}
	
	public void setrole(String role) {
		
		this.role = role;
	}
	
	public String getrole() {
		
		return this.role;
	}
	
	public void setsongsin(String songsin) {
		
		this.songsin = songsin;
	}
	
	public String getsongsin() {
		
		return this.songsin;
	}
	
}
