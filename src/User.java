
public class User {
	private String id;
	private String password;
	private String phoneNumber;
	public void setPhoneNumber(String phoneNumber){
		if (phoneNumber.length()!=10) {
			System.out.println(phoneNumber +" doesn't have 10 digits. I will not change the phone number");
			return;
		}
		this.phoneNumber = phoneNumber;
	}
	public User(String id, String password){
		this.id = id;
		this.password = password;
	}
	public String toString(){
		return "User Id -> "+id+" : Phone -> "+phoneNumber;
	}
	public String getUserId(){
		return id;
	}
	
}
