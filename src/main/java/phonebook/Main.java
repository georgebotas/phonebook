package phonebook;

import java.io.IOException;
import java.util.Scanner;
import javax.enterprise.inject.se.*;
import javax.inject.Inject;

// This class is responsible for printing the menu and taking in user input.

public class Main {
	@Inject
    DBOperations ops;
	
	public Main() {
		super();
        SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
        SeContainer container = containerInit.initialize();
		// TODO Auto-generated constructor stub
        ops.readAll();
        container.close();
	}


	
	private static final Scanner SCAN = new Scanner(System.in);
	
	public void select(Integer userSelect, Phonebook phoneBook) throws IOException {
		String userName;
		String userNumber;
		String userEmail;
		Long userID;
		
		switch (userSelect) {
		case 1:
			phoneBook.showContacts();
			Menu.showMainMenu();
			userSelect = SCAN.nextInt();
			select(userSelect, phoneBook);
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

			phoneBook.createContact(userName, userNumber, userEmail);
			Menu.showMainMenu();
			userSelect = SCAN.nextInt();
			select(userSelect, phoneBook);
			break;
		case 3:
			System.out.println("ENTER THE ID OF THE CONTACT YOU WISH TO EDIT:");
			SCAN.nextLine();
			userID = SCAN.nextLong();
			phoneBook.validateID(userID);
			phoneBook.currentID(userID);
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

				phoneBook.editName(userID, userName);

				System.out.println("THE NAME WAS SUCCESFULLY MODIFIED.\n");
				Menu.showMainMenu();
				userSelect = SCAN.nextInt();
				select(userSelect, phoneBook);
				break;
			case 2:
				System.out.println("ENTER THE NUMBER FOR THE SELECTED CONTACT:");
				SCAN.nextLine();
				userNumber = SCAN.nextLine();

				while (!UserInputValidator.validateUserNumber(userNumber)) {
					System.out.println("PLEASE ENTER A VALID NUMBER.");
					userNumber = SCAN.nextLine();
				}

				phoneBook.editNumber(userID, userNumber);

				System.out.println("THE NUMBER WAS SUCCESFULLY MODIFIED.\n");
				Menu.showMainMenu();
				userSelect = SCAN.nextInt();
				select(userSelect, phoneBook);
				break;
			case 3:
				System.out.println("ENTER THE E-MAIL FOR THE SELECTED CONTACT:");
				SCAN.nextLine();
				userEmail = SCAN.nextLine();
				while (!UserInputValidator.validateUserEmail(userEmail)) {
					System.out.println("PLEASE ENTER A VALID E-MAIL.");
					userEmail = SCAN.nextLine();
				}

				phoneBook.editEmail(userID, userEmail);

				System.out.println("THE E-MAIL WAS SUCCESFULLY MODIFIED.\n");
				Menu.showMainMenu();
				userSelect = SCAN.nextInt();
				select(userSelect, phoneBook);
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
			phoneBook.deleteContact(userID);
			Menu.showMainMenu();
			userSelect = SCAN.nextInt();
			select(userSelect, phoneBook);
			break;
		case 5:
			System.out.println("THE CONTACTS SORTED ALPHABETICALY:\n");
			phoneBook.sortContacts();
			Menu.showMainMenu();
			userSelect = SCAN.nextInt();
			select(userSelect, phoneBook);
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("PLEASE ENTER A VALID NUMBER.");
			Menu.showMainMenu();
			userSelect = SCAN.nextInt();
			select(userSelect, phoneBook);
			break;
		}
	}

	public static void main(String[] args) throws IOException {



        
		//Phonebook phoneBook = new Phonebook();
		Main main = new Main();
		//Menu.showMainMenu();
		//Integer userInt = SCAN.nextInt();
		//main.select(userInt, phoneBook);
		//DBOperations.ENTITY_MANAGER_FACTORY.close();

	}
}
