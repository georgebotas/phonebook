package main.java.com.georgebotas.phonebook.UI;

public class UserInputValidator {
	public static boolean validateContactName(String userName) {
		return !userName.trim().isEmpty();
	}
	public static boolean validateContactNumber(String userNumber) { return userNumber.chars().allMatch(Character::isDigit); }
	public static boolean validateContactEmail(String userEmail) { return (!userEmail.trim().isEmpty() && userEmail.contains("@") && userEmail.contains(".")); }
}
