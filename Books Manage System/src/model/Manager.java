package model;

public class Manager {
	private String userString;
	private String pswString;
	public String getUserString() {
		return userString;
	}
	public void setUserString(String userString) {
		this.userString = userString;
	}
	public String getPswString() {
		return pswString;
	}
	public void setPswString(String pswString) {
		this.pswString = pswString;
	}
	public Manager(String userString, String pswString) {
		super();
		this.userString = userString;
		this.pswString = pswString;
	}
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Manager [userString=" + userString + ", pswString=" + pswString + "]";
	}
	
	
	
	

}
