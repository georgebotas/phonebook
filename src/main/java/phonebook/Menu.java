package phonebook;

public class Menu {
	@Inject
	Phonebook;
	
	public static void showMainMenu() {
		System.out.println("THE PHONE BOOK MENU: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n");

		System.out.println("1. SHOW ALL CONTACTS");
		System.out.println("2. CREATE A NEW CONTACT");
		System.out.println("3. EDIT A CONTACT");
		System.out.println("4. DELETE A CONTACT");
		System.out.println("5. SORT CONTACTS");
		System.out.println("6. EXIT");
	}
	
	public static void showEditMenu() {
		System.out.println("ENTER THE CORESPONDING NUMBER:");
		System.out.println("1. EDIT NAME\t 2. EDIT PHONE NUMBER \t 3. EDIT E-MAIL");
	}

}
