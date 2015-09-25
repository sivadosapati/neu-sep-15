
public class FaceBookServer {
	InternetUser[] activeUsers;
	FaceBookRegistry registry;
	boolean validateUser(InternetUser user){
		String un = user.userName;
		String pw = user.password;
		boolean b = registry.isUserValid(un, pw);
		if( b == true){
			return true;
		}
		else{
			return false;
		}
	}
}


