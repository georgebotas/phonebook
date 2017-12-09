package main.java.com.georgebotas.phonebook.Middleware;

//Methods and generaly code that works with data (we will work with an arraylist consisting of "contact" objects.) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.java.com.georgebotas.phonebook.Model.Contact;
import main.java.com.georgebotas.phonebook.DB.IDBOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Phonebook implements IPhonebook {

    @Autowired
    IDBOperations idboperations;

    public Phonebook() {
        super();
    }

    @Override
    public void createContact(String userName, String userNumber, String userEmail) {
        idboperations.create(userName, userNumber, userEmail);
    }

    @Override
    public void showContacts() {
        ArrayList<Contact> contacts = idboperations.readAll();
        int count = 0;
        System.out.printf("%-10s %-21s %-21s %-21s \n", "   ID:", "NAME:", "PHONE NUMBER:", "E-MAIL:");
        for (Contact contact : contacts) {

            System.out.printf("%d. %-7s %-21s %-21s %s \n", count + 1, contact.getContact_Id(), contact.getName(), contact.getNumber(),
                    contact.getEmail());
            count++;
        }
        System.out.println();
    }

    @Override
    public boolean validateID(Long contact_id) {
        return idboperations.validateID(contact_id);
    }

    //public boolean emptyPhonebook(){ return idboperations.emptyPhonebook}

    @Override
    public String infoName(Long contact_id) {
        return idboperations.infoName(contact_id);
    }

    @Override
    public String infoNumber(Long contact_id) {
        return idboperations.infoNumber(contact_id);
    }

    @Override
    public String infoEmail(Long contact_id) {
        return idboperations.infoEmail(contact_id);
    }

    @Override
    public void deleteContact(Long contact_id) {
        idboperations.delete(contact_id);
    }

    @Override
    public void editName(Long contact_id, String newName) {
        idboperations.updateName(contact_id, newName);
    }

    @Override
    public void editNumber(Long contact_id, String newNumber) {
        idboperations.updateNumber(contact_id, newNumber);
    }

    @Override
    public void editEmail(Long contact_id, String newEmail) {
        idboperations.updateEmail(contact_id, newEmail);
    }

    @Override
    public void sortContactsName() {
        ArrayList<Contact> contacts = idboperations.readAll();
        int count = 0;
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s \n", "   ID:", "NAME:", "PHONE NUMBER:", "E-MAIL:");
        for (Contact contact : contacts) {
            System.out.printf("%d. %-7s %-21s %-21s %s \n", count + 1, contact.getContact_Id(), contact.getName(), contact.getNumber(),
                    contact.getEmail());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortContactsNumber() {
        ArrayList<Contact> contacts = idboperations.readAll();
        int count = 0;
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.getNumber().compareTo(c2.getNumber());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s \n", "   ID:", "NAME:", "PHONE NUMBER:", "E-MAIL:");
        for (Contact contact : contacts) {
            System.out.printf("%d. %-7s %-21s %-21s %s \n", count + 1, contact.getContact_Id(), contact.getName(), contact.getNumber(),
                    contact.getEmail());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortContactsEmail() {
        ArrayList<Contact> contacts = idboperations.readAll();
        int count = 0;
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.getEmail().compareTo(c2.getEmail());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s \n", "   ID:", "NAME:", "PHONE NUMBER:", "E-MAIL:");
        for (Contact contact : contacts) {
            System.out.printf("%d. %-7s %-21s %-21s %s \n", count + 1, contact.getContact_Id(), contact.getName(), contact.getNumber(),
                    contact.getEmail());
            count++;
        }
        System.out.println();
    }

}
