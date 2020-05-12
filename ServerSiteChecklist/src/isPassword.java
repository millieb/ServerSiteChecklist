/**
* Validates Password. 
*
* @author Mildred Brito
*/

public class isPassword {
	public boolean isValid(String password) {
		String pw = password;
		switch(pw){
		case "Dataxp0rtMB27+":
			System.out.println("Correct password");
			return true;
		case "Dataxp0rtDS28+":
			System.out.println("Correct password");
			return true;
		case "Dataxp0rtCE29+":
			System.out.println("Correct password");
			return true;
		case "Dataxp0rtVV30+":
			System.out.println("Correct password");
			return true;
		default:
			System.out.println("Incorrect password");
			return false;
		}
	}
}
