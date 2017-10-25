package phonebook;

import java.io.IOException;
import java.util.Scanner;

// This class is responsible for printing the menu and taking in user input.
public class Menu {

	static Scanner scan = new Scanner(System.in);

	static int userInt;
	static String userName;
	static String userName2;
	static String userEdit;
	static Contact userDelete;
	static String userNumber;
	static String userNumber2;
	static String userEmail;
	static String userEmail2;

	public static void showMenu() {
		System.out.println("THE PHONE BOOK MENU: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n");

		System.out.println("1. SHOW ALL CONTACTS");
		System.out.println("2. CREATE A NEW CONTACT");
		System.out.println("3. EDIT A CONTACT");
		System.out.println("4. DELETE A CONTACT");
		System.out.println("5. SORT CONTACTS");
		System.out.println("6. EXIT");
	}

	public static void select() throws IOException {

		showMenu();

		userInt = scan.nextInt();

		if (userInt < 1 || userInt > 6) {
			System.out.println("PLEASE ENTER A VALID NUMBER.");
			select();
		}

		if (userInt == 1) {
			Phonebook.showContacts();
			select();
		}
		if (userInt == 2) {
			System.out.println("ENTER THE CONTACT'S NAME:");

			scan.nextLine();
			userName = scan.nextLine();

			while (userName.trim().isEmpty()) {
				System.out.println("PLEASE ENTER A VALID NAME.");
				userName = scan.nextLine();
			}

			System.out.println("ENTER THE CONTACT'S NUMBER:");

			userNumber = scan.nextLine();

			boolean allNumbers = userNumber.chars().allMatch(Character::isDigit);
			while (userNumber.isEmpty() || allNumbers == false) {
				System.out.println("PLEASE ENTER A VALID NUMBER.");
				userNumber = scan.nextLine();
				allNumbers = userNumber.chars().allMatch(Character::isDigit);
			}

			System.out.println("ENTER THE CONTACT'S E-MAIL:");

			userEmail = scan.nextLine();

			while (userEmail.trim().isEmpty() || !userEmail.contains("@") || !userEmail.contains(".")) {
				System.out.println("PLEASE ENTER A VALID E-MAIL.");
				userEmail = scan.nextLine();
			}
			Phonebook.createContact();
			select();
		}

		if (userInt == 3) {

			Phonebook.showContacts();
			System.out.println("ENTER THE FULL NAME OF THE CONTACT YOU WISH TO EDIT:");
			scan.nextLine();
			userEdit = scan.nextLine();

			for (Contact c : Phonebook.contacts) {

				if (c.getName() != null && c.getName().contains(userEdit)) {
				 
					userName = c.getName();
					userNumber = c.getNumber();
					userEmail = c.getEmail();
				} 
			}
			if (userName == null) {
				System.out.println("THE CONTACT " + userEdit + " WAS NOT FOUND IN THE PHONEBOOK.\n");
				select();
			}
			else if (!userName.equals(userEdit)) {
				System.out.println("THE CONTACT " + userEdit + " WAS NOT FOUND IN THE PHONEBOOK.\n");
				select();
			}
			
				System.out.println("ENTER THE CORESPONDING NUMBER:");
				System.out.println("1. EDIT NAME\t 2. EDIT PHONE NUMBER \t 3. EDIT E-MAIL");

				userInt = scan.nextInt();

				while (userInt < 1 || userInt > 3) {
					System.out.println("PLEASE ENTER A VALID NUMBER.");
					userInt = scan.nextInt();
				}

				if (userInt == 1) {

					System.out.println("ENTER THE NEW NAME FOR THE SELECTED CONTACT:");
					scan.nextLine();
					userName2 = scan.nextLine();

					while (userName2.trim().isEmpty()) {
						System.out.println("PLEASE ENTER A VALID NAME.");
						userName2 = scan.nextLine();
					}

					Phonebook.editName();

					System.out.println("THE NAME WAS SUCCESFULLY MODIFIED.\n");
					select();
				}

				if (userInt == 2) {

					System.out.println("ENTER THE NUMBER FOR THE SELECTED CONTACT:");
					scan.nextLine();
					userNumber2 = scan.nextLine();

					boolean allNumbers = userNumber2.chars().allMatch(Character::isDigit);
					while (userNumber2.isEmpty() || allNumbers == false) {
						System.out.println("PLEASE ENTER A VALID NUMBER.");
						userNumber2 = scan.nextLine();
						allNumbers = userNumber2.chars().allMatch(Character::isDigit);
					}

					Phonebook.editNumber();

					System.out.println("THE NUMBER WAS SUCCESFULLY MODIFIED.\n");
					select();
				}

				if (userInt == 3) {

					System.out.println("ENTER THE E-MAIL FOR THE SELECTED CONTACT:");
					scan.nextLine();
					userEmail2 = scan.nextLine();
					while (userEmail2.trim().isEmpty() || !userEmail2.contains("@") || !userEmail2.contains(".")) {
						System.out.println("PLEASE ENTER A VALID E-MAIL.");
						userEmail2 = scan.nextLine();
					}

					Phonebook.editEmail();

					System.out.println("THE E-MAIL WAS SUCCESFULLY MODIFIED.\n");
					select();
				}
			}

		if (userInt == 4) {
			Phonebook.showContacts();

			System.out.println("ENTER THE FULL NAME OF THE CONTACT YOU WISH TO DELETE:");
			scan.nextLine();
			String userInput = scan.nextLine();

			for (Contact c : Phonebook.contacts) {

				if (c.getName() != null && c.getName().contains(userInput)) {
				 
					userName = c.getName();
					userNumber = c.getNumber();
					userEmail = c.getEmail();
					userDelete = c;
				} 
			}
			if (userName == null) {
				System.out.println("THE CONTACT " + userInput + " WAS NOT FOUND IN THE PHONEBOOK.\n");
				select();
			}
			else if (!userName.equals(userInput)) {
				System.out.println("THE CONTACT " + userInput + " WAS NOT FOUND IN THE PHONEBOOK.\n");
				select();
			}
			
			Phonebook.deleteContact();
			System.out.println("THE CONTACT" + userName + "WAS SUCCESFULLY DELETED.\n");
			
			select();
		}

		if (userInt == 5) {

			Phonebook.sortContact();
			System.out.println("THE CONTACTS HAVE BEEN SORTED ALPHABETICALY.\n");
			select();
		}

		if (userInt == 6) {
			System.exit(0);
		}

	}
}
