package phonebook;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Menu {

	@Autowired
	Phonebook phonebook;
	
	public static final Scanner SCAN = new Scanner(System.in);

	public Menu() {

	}

	public void select(Integer userSelect) throws IOException {

		String userName;
		String userNumber;
		String userEmail;
		Long userID;
		switch (userSelect) {
		case 1:
			phonebook.showContacts();
			this.showMainMenu();
			userSelect = SCAN.nextInt();
			this.select(userSelect);
			break;
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

			phonebook.createContact(userName, userNumber, userEmail);
			this.showMainMenu();
			userSelect = SCAN.nextInt();
			this.select(userSelect);
			break;
		case 3:
			System.out.println("ENTER THE ID OF THE CONTACT YOU WISH TO EDIT:");
			SCAN.nextLine();
			userID = SCAN.nextLong();
			phonebook.validateID(userID);
			phonebook.currentID(userID);
			this.showEditMenu();

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

				phonebook.editName(userID, userName);

				System.out.println("THE NAME WAS SUCCESFULLY MODIFIED.\n");
				this.showMainMenu();
				userSelect = SCAN.nextInt();
				this.select(userSelect);
				break;
			case 2:
				System.out.println("ENTER THE NUMBER FOR THE SELECTED CONTACT:");
				SCAN.nextLine();
				userNumber = SCAN.nextLine();

				while (!UserInputValidator.validateUserNumber(userNumber)) {
					System.out.println("PLEASE ENTER A VALID NUMBER.");
					userNumber = SCAN.nextLine();
				}

				phonebook.editNumber(userID, userNumber);

				System.out.println("THE NUMBER WAS SUCCESFULLY MODIFIED.\n");
				this.showMainMenu();
				userSelect = SCAN.nextInt();
				this.select(userSelect);
				break;
			case 3:
				System.out.println("ENTER THE E-MAIL FOR THE SELECTED CONTACT:");
				SCAN.nextLine();
				userEmail = SCAN.nextLine();
				while (!UserInputValidator.validateUserEmail(userEmail)) {
					System.out.println("PLEASE ENTER A VALID E-MAIL.");
					userEmail = SCAN.nextLine();
				}

				phonebook.editEmail(userID, userEmail);

				System.out.println("THE E-MAIL WAS SUCCESFULLY MODIFIED.\n");
				this.showMainMenu();
				userSelect = SCAN.nextInt();
				this.select(userSelect);
				break;
			default:
				System.out.println("PLEASE ENTER A VALID NUMBER.");
				userInt = SCAN.nextInt();
				break;
			}
			break;
		case 4:
			System.out.println("ENTER THE ID OF THE CONTACT YOU WISH TO DELETE:");
			SCAN.nextLine();
			userID = SCAN.nextLong();
			phonebook.deleteContact(userID);
			this.showMainMenu();
			userSelect = SCAN.nextInt();
			this.select(userSelect);
			break;
		case 5:
			System.out.println("THE CONTACTS SORTED ALPHABETICALY:\n");
			phonebook.sortContacts();
			this.showMainMenu();
			userSelect = SCAN.nextInt();
			this.select(userSelect);
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("PLEASE ENTER A VALID NUMBER.");
			this.showMainMenu();
			userSelect = SCAN.nextInt();
			this.select(userSelect);
			break;
		}
	}

	public void showMainMenu() {
		System.out.println("THE PHONE BOOK MENU: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n");

		System.out.println("1. SHOW ALL CONTACTS");
		System.out.println("2. CREATE A NEW CONTACT");
		System.out.println("3. EDIT A CONTACT");
		System.out.println("4. DELETE A CONTACT");
		System.out.println("5. SORT CONTACTS");
		System.out.println("6. EXIT");
	}

	public void showEditMenu() {
		System.out.println("ENTER THE CORESPONDING NUMBER:");
		System.out.println("1. EDIT NAME\t 2. EDIT PHONE NUMBER \t 3. EDIT E-MAIL");
	}

}
