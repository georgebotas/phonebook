package main.java.com.georgebotas.phonebook.UI;

public class Print {

    public static void mainMenu() {
        String mainMenu = "THE PHONE CONTACT MENU: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n\n" +
                "1. SHOW ALL CONTACTS\n2. CREATE A NEW CONTACT\n3. EDIT A CONTACT\n4. DELETE A CONTACT\n5. SORT CONTACTS\n6. EXIT";
        System.out.println(mainMenu);
    }

    public static void createName() {
        String createName = "ENTER THE CONTACT'S NAME:";
        System.out.println(createName);
    }

    public static void createNumber() {
        String createNumber = "ENTER THE CONTACT'S NUMBER:";
        System.out.println(createNumber);
    }

    public static void createEmail() {
        String createEmail = "ENTER THE CONTACTS'S E-MAIL:";
        System.out.println(createEmail);
    }

    public static void editMenu() {
        String editMenu = "CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n 1. EDIT NAME\n 2. EDIT NUMBER\n 3. EDIT E-MAIL";
        System.out.println(editMenu);
    }

    public static void editName() {
        String editName = "ENTER THE NEW NAME FOR THE SELECTED CONTACT:";
        System.out.println(editName);
    }

    public static void editNumber() {
        String editNumber = "ENTER THE NEW NUMBER FOR THE SELECTED CONTACT:";
        System.out.println(editNumber);
    }

    public static void editEmail() {
        String editEmail = "ENTER THE NEW E-MAIL FOR THE SELECTED CONTACT:";
        System.out.println(editEmail);
    }

    public static void contactSelect() {
        String CONTACTSelect = "SELECT A CONTACT BY ENTERING IT'S ID:";
        System.out.println(CONTACTSelect);
    }

    public static void contactDelete() {
        String CONTACTDelete = "SELECT A CONTACT YOU'D LIKE TO DELETE BY ENTERING IT'S ID:";
        System.out.println(CONTACTDelete);
    }

    public static void invalidNumber() {
        String invalidNumber = "PLEASE ENTER A VALID NUMBER:";
        System.out.println(invalidNumber);
    }

    public static void invalidString() {
        String invalidString = "PLEASE ENTER A VALID NAME:";
        System.out.println(invalidString);
    }

    public static void invalidEmail() {
        String invalidEmail = "PLEASE ENTER A VALID E-MAIL:";
        System.out.println(invalidEmail);
    }

    public static void invalidID() {
        String invalidID = "THE ID YOU HAVE ENTERED DOES NOT EXIST IN THE DATABASE. TRY AGAIN:";
        System.out.println(invalidID);
    }

    public static void emptyPhonebook() {
        String emptyPHONEBOOK = "THE PHONEBOOK IS EMPTY. PLEASE ADD SOME CONTACTS AND TRY AGAIN.";
        System.out.println(emptyPHONEBOOK);
    }

    public static void sortMenu() {
        String sortMenu = "CHOOSE THE TYPE OF SORTING:\n 1. SORT BY NAME\n 2. SORT BY NUMBER\n 3. SORT BY E-MAIL";
        System.out.println(sortMenu);
    }

    public static void sortName() {
        String sortedName = "THE PHONEBOOK SORTED BY NAMES:";
        System.out.println(sortedName);
    }

    public static void sortNumber() {
        String sortedNumber = "THE PHONEBOOK SORTED BY PHONE-NUMBERS:";
        System.out.println(sortedNumber);
    }


    public static void sortEmail() {
        String sortedEmail = "THE PHONEBOOK SORTED BY E-MAILS:";
        System.out.println(sortedEmail);
    }

    public static void exception() {
        String exception = "AN EXCEPTION OCCURED. THE PROGRAM WILL NOW EXIT.";
        System.out.println(exception);
    }
}
