/**
* Validates Username. 
*
* @author Mildred Brito
*/

public class isUsername {
	
	public boolean isValid(String name) {
		String username = name;
		switch(username){
		case "mbrito":
			System.out.println("Correct username");
			return true;
		case "dsaucedo":
			System.out.println("Correct username");
			return true;
		case "cestrada":
			System.out.println("Correct username");
			return true;
		case "vvicario":
			System.out.println("Correct username");
			return true;
		default:
			System.out.println("Incorrect username");
			return false;
		}
	}

}

