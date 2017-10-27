package phonebook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// This class is responsible for printing the menu and taking in user input.
public class Main {
	private static final Scanner SCAN = new Scanner(System.in);

	public void select(Integer userSelect, Phonebook phoneBook) throws IOException {
		String userName;
		String userNumber;
		String userEmail;

		switch (userSelect) {
			case 1:
				phoneBook.showContacts();
				Menu.showMainMenu();
			case 2:
				System.out.println("ENTER THE CONTACT'S NAME:");
				SCAN.nextLine();
				userName = SCAN.nextLine();
	
				while (!UserInputValidator.validateUserName(userName)) {
					System.out.println("PLEASE ENTER A VALID NAME.");
					userName = SCAN.nextLine();
				}
	
				System.out.println("ENTER THE CONTACT'S NUMBER:");
	
				userNumber = SCAN.nextLine();
	
				while (!UserInputValidator.validateUserNumber(userNumber)) {
					System.out.println("PLEASE ENTER A VALID NUMBER.");
					userNumber = SCAN.nextLine();
				}
	
				System.out.println("ENTER THE CONTACT'S E-MAIL:");
	
				userEmail = SCAN.nextLine();
	
				while (!UserInputValidator.validateUserEmail(userEmail)) {
					System.out.println("PLEASE ENTER A VALID E-MAIL.");
					userEmail = SCAN.nextLine();
				}
	
				phoneBook.createContact(new Contact(userName, userNumber, userEmail));
			case 3:
				System.out.println("ENTER THE FULL NAME OF THE CONTACT YOU WISH TO EDIT:");
				SCAN.nextLine();
				String userEdit = SCAN.nextLine();
	
				if (!phoneBook.findContact(userEdit)) {
					System.out.println("THE CONTACT " + userEdit + " WAS NOT FOUND IN THE PHONEBOOK.\n");
				}
	
				Menu.showEditMenu();
	
				Integer userInt = SCAN.nextInt();
				switch (userInt) {
					case 1:
						System.out.println("ENTER THE NEW NAME FOR THE SELECTED CONTACT:");
						SCAN.nextLine();
						userName = SCAN.nextLine();
		
						while (!UserInputValidator.validateUserName(userName)) {
							System.out.println("PLEASE ENTER A VALID NAME.");
							userName = SCAN.nextLine();
						}
		
						phoneBook.editName(userName);
		
						System.out.println("THE NAME WAS SUCCESFULLY MODIFIED.\n");
						Menu.showMainMenu();
					case 2:
						System.out.println("ENTER THE NUMBER FOR THE SELECTED CONTACT:");
						SCAN.nextLine();
						userNumber = SCAN.nextLine();
		
						while (!UserInputValidator.validateUserNumber(userNumber)) {
							System.out.println("PLEASE ENTER A VALID NUMBER.");
							userNumber = SCAN.nextLine();
						}
		
						phoneBook.editNumber(userNumber);
		
						System.out.println("THE NUMBER WAS SUCCESFULLY MODIFIED.\n");
						Menu.showMainMenu();
					case 3:
						System.out.println("ENTER THE E-MAIL FOR THE SELECTED CONTACT:");
						SCAN.nextLine();
						userEmail = SCAN.nextLine();
						while (!UserInputValidator.validateUserEmail(userEmail)) {
							System.out.println("PLEASE ENTER A VALID E-MAIL.");
							userEmail = SCAN.nextLine();
						}
		
						phoneBook.editEmail(userEmail);
		
						System.out.println("THE E-MAIL WAS SUCCESFULLY MODIFIED.\n");
						Menu.showMainMenu();
					default:
						System.out.println("PLEASE ENTER A VALID NUMBER.");
						userInt = SCAN.nextInt();
				}
			case 4:
				System.out.println("ENTER THE FULL NAME OF THE CONTACT YOU WISH TO DELETE:");
				SCAN.nextLine();
				userName = SCAN.nextLine();
	
				if (phoneBook.findContact(userName)) {
					System.out.println("THE CONTACT " + userName + " WAS NOT FOUND IN THE PHONEBOOK.\n");
					Menu.showMainMenu();
	
				}
	
				phoneBook.deleteContact(userName);
				System.out.println("THE CONTACT" + userName + "WAS SUCCESFULLY DELETED.\n");
				Menu.showMainMenu();
			case 5:
				phoneBook.sortContacts();
				System.out.println("THE CONTACTS HAVE BEEN SORTED ALPHABETICALY.\n");
				Menu.showMainMenu();
			case 6:
				System.exit(0);
			default:
				System.out.println("PLEASE ENTER A VALID NUMBER.");
				Menu.showMainMenu();
			}
	}

	public static void main(String[] args) throws IOException {
		Phonebook phoneBook = new Phonebook();
		Main main = new Main();
		try {
			phoneBook.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Menu.showMainMenu();

		Integer userInt = SCAN.nextInt();
		main.select(userInt, phoneBook);
	}
}
