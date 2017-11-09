package phonebook;

public class UserInputValidator {
	
	public static boolean validateUserName(String userName) {
		return !userName.trim().isEmpty();
	}
	
	public static boolean validateUserNumber(String userNumber) {
		return userNumber.chars().allMatch(Character::isDigit);
	}
	
	public static boolean validateUserEmail(String userEmail) {
		return (!userEmail.trim().isEmpty() || userEmail.contains("@") || userEmail.contains("."));
	}
}
