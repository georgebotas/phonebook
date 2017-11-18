package phonebook;

//Methods and generaly code that works with data (we will work with an arraylist consisting of "contact" objects.) 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Phonebook {
	
	@Autowired(required=false)
	DBOperations dboperations;
	
	public Phonebook() {
		super();
	}

	public void createContact(String userName, String userNumber, String userEmail) {
		dboperations.create(userName, userNumber, userEmail);
	}

	public void showContacts() {

		ArrayList<Contact> contacts = dboperations.readAll();
		int count = 0;
		System.out.printf("%-10s %-21s %-21s %-21s \n", "   ID:", "NAME:", "PHONE NUMBER:", "E-MAIL:");
		try {
			for (Contact contact : contacts) {
				
				System.out.printf("%d. %-7s %-21s %-21s %s \n", count+1, contact.getContact_Id() , contact.getName(), contact.getNumber(),
						contact.getEmail());
				count++;
			}
			System.out.println();
		} catch (NullPointerException ne) {
			System.out.println("THERE ARE NO CONTACTS IN THE PHONEBOOK. CREATE NEW ENTRIES AND TRY AGAIN.");
		}
	}
	
	public void validateID(Long contact_id) {
		dboperations.validate(contact_id);
	}
	
	public void currentID (Long contact_id) {
		dboperations.contInfo(contact_id);
	}
	public void deleteContact(Long contact_id) {
		dboperations.delete(contact_id);
	}

	public void editName(Long contact_id, String newName) {
		dboperations.updateName(contact_id, newName);
	}

	public void editNumber(Long contact_id, String newNumber) {
		dboperations.updateNumber(contact_id, newNumber);
	}

	public void editEmail(Long contact_id, String newEmail) {
		dboperations.updateEmail(contact_id, newEmail);
	}

	public void sortContacts() {
		ArrayList<Contact> contacts = dboperations.readAll();
		int count = 0;
		Collections.sort(contacts, new Comparator<Contact>() {
			public int compare(Contact c1, Contact c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
		System.out.printf("%-10s %-21s %-21s %-21s \n", "   ID:", "NAME:", "PHONE NUMBER:", "E-MAIL:");
		for (Contact contact : contacts) {
			System.out.printf("%d. %-7s %-21s %-21s %s \n", count+1, contact.getContact_Id() , contact.getName(), contact.getNumber(),
					contact.getEmail());
			count++;
		}
		System.out.println();
	}

}
