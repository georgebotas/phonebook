package main.java.com.georgebotas.phonebook.UI;

import java.util.Scanner;

import main.java.com.georgebotas.phonebook.Middleware.IPhonebook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu implements IMenu {

    @Autowired
    IPhonebook iphonebook;

    private final Logger logger = LogManager.getLogger();
    private static final Scanner SCAN = new Scanner(System.in);
    private int userSelect;
    private Long contactID;

    public Menu() {
    }

    @Override
    public void select() {

        Print.mainMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();

        switch (userSelect) {
            case 1:
                showPhonebook();
                break;
            case 2:
                create();
                break;
            case 3:
                editContact();
                break;
            case 4:
                delete();
                break;
            case 5:
                sort();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                Print.invalidNumber();
                select();
                break;
        }
    }

    private void validate_name(String contactName) {
        while (!UserInputValidator.validateContactName(contactName)) {
            Print.invalidString();
            contactName = SCAN.nextLine();
        }
    }

    private void validate_number(String contactNumber) {
        while (!UserInputValidator.validateContactNumber(contactNumber)) {
            Print.invalidString();
            contactNumber = SCAN.nextLine();
        }
    }

    private void validate_email(String contactEmail) {
        while (!UserInputValidator.validateContactName(contactEmail)) {
            Print.invalidString();
            contactEmail = SCAN.nextLine();
        }
    }

    private void contInfo(Long contact_id) {
        System.out.println("SELECTED CONTACT INFORMATION:\n");
        System.out.printf("%-21s %-21s %-21s \n", "NAME:", "PHONE NUMBER:", "E-MAIL:");
        System.out.printf("%-21s %-21s %s \n", iphonebook.infoName(contact_id), iphonebook.infoNumber(contact_id), iphonebook.infoEmail(contact_id));
        System.out.println();
    }

    private void showPhonebook() {
        logger.info("ATTEMPTING TO LIST THE PHONEBOOK.");
        iphonebook.showContacts();
        logger.info("OPERATION SUCCESSFUL.");
        select();
    }

    private void create() {
        String contactName;
        String contactNumber;
        String contactEmail;
        logger.info("ATTEMPTING CONTACT CREATION. USER INPUT EXPECTED.");
        Print.createName();
        contactName = SCAN.nextLine();
        while (!UserInputValidator.validateContactName(contactName)) {
            Print.invalidString();
            contactName = SCAN.nextLine();
        }
        Print.createNumber();
        contactNumber = SCAN.nextLine();
        SCAN.nextLine();
        while (!UserInputValidator.validateContactNumber(contactNumber)) {
            Print.invalidNumber();
            contactNumber = SCAN.nextLine();
            SCAN.nextLine();
        }
        Print.createEmail();
        contactEmail = SCAN.nextLine();

        while (!UserInputValidator.validateContactEmail(contactEmail)) {
            Print.invalidEmail();
            contactEmail = SCAN.nextLine();
        }

        iphonebook.createContact(contactName, contactNumber, contactEmail);
        select();
    }

    private void editContact() {
        Print.contactSelect();
        contactID = SCAN.nextLong();
        SCAN.nextLine();
        while (!iphonebook.validateID(contactID)) {
            Print.invalidID();
            contactID = SCAN.nextLong();
            SCAN.nextLine();
        }
        logger.info("THE CONTACT WITH THE ID '" + contactID + "' HAS BEEN SELECTED FOR EDITING.");
        contInfo(contactID);
        edit(contactID);
        select();
    }

    private void edit(Long contactID) {
        String userString;
        Print.editMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();
        switch (userSelect) {
            case 1:
                Print.editName();
                userString = SCAN.nextLine();
                while (!UserInputValidator.validateContactName(userString)) {
                    Print.invalidString();
                    userString = SCAN.nextLine();
                }
                iphonebook.editName(contactID, userString);
                logger.info("THE CONTACT'S NAME WITH THE ID '" + contactID + "' HAS CHANGED TO '" + userString + "'.");
                break;
            case 2:
                Print.editNumber();
                userString = SCAN.nextLine();
                while (!UserInputValidator.validateContactNumber(userString)) {
                    Print.invalidNumber();
                    userString = SCAN.nextLine();
                }
                iphonebook.editNumber(contactID, userString);
                logger.info("THE CONTACT'S NUMBER WITH THE ID '" + contactID + "' HAS CHANGED TO '" + userString + "'.");
                break;
            case 3:
                Print.editEmail();
                userString = SCAN.nextLine();
                while (!UserInputValidator.validateContactEmail(userString)) {
                    Print.invalidEmail();
                    userString = SCAN.nextLine();
                }
                iphonebook.editEmail(contactID, userString);
                logger.info("THE CONTACT'S E-MAIL WITH THE ID '" + contactID + "' HAS CHANGED TO '" + userString + "'.");
                break;
            default:
                Print.invalidNumber();
                edit(contactID);
                break;
        }
    }

    private void delete(){
        Print.contactDelete();
        contactID = SCAN.nextLong();
        SCAN.nextLine();
        while (!iphonebook.validateID(contactID)) {
            Print.invalidID();
            contactID = SCAN.nextLong();
            SCAN.nextLine();
        }
        contInfo(contactID);
        logger.info("THE CONTACT WITH THE ID '" + contactID + "' HAS BEEN SELECTED FOR REMOVAL.");
        iphonebook.deleteContact(contactID);
        logger.info("THE CONTACT WITH THE ID '" + contactID + "' HAS BEEN SUCCESSFULLY REMOVED.");
        select();
    }

    public void sort() {
        Print.sortMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();
        switch (userSelect) {
            case 1:
                Print.sortName();
                logger.info("ATTEMPTING TO SORT AND LIST THE PHONEBOOK BY THE CONTACTS' NAMES.");
                iphonebook.sortContactsName();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            case 2:
                Print.sortNumber();
                logger.info("ATTEMPTING TO SORT AND LIST THE PHONEBOOK BY THE CONTACTS' PHONE-NUMBERS.");
                iphonebook.sortContactsNumber();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            case 3:
                Print.sortEmail();
                logger.info("ATTEMPTING TO SORT AND LIST THE PHONEBOOK BY THE CONTACTS' EMAILS.");
                iphonebook.sortContactsEmail();
                logger.info("SORTING SUCCESSFUL");
                select();
                break;
            default:
                Print.invalidNumber();
                sort();
                break;
        }
    }
}
