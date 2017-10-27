package phonebook;

import java.io.BufferedReader;
//Methods and generaly code that works with data (we will work with an arraylist consisting of "contact" objects.) 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Phonebook {

	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	public void createContact(Contact contact) throws IOException {
		contacts.add(contact);
		saveData();
	}

	public boolean findContact(String userName) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(userName)) {
				return true;
			}
		}

		return false;
	}

	public void showContacts() throws IOException {
		int count = 0;

		if (contacts.isEmpty()) {
			System.out.println("THERE ARE NO CONTACTS IN THE PHONEBOOK.\n");
			Menu.showMainMenu();
		}
		System.out.printf("%-23s %-21s %-21s \n", "   NAME:", "PHONE NUMBER:", "E-MAIL:");

		for (Contact contact : contacts) {
			System.out.printf("%d. %-20s %-21s %s \n", count + 1, contact.getName(), contact.getNumber(),
					contact.getEmail());
			count++;
		}
		System.out.println();
	}

	public void deleteContact(String userName) throws IOException {
		for (Contact contact : contacts) {
			if (contact.getName().equals(userName)) {
				contacts.remove(contact);
			}
		}

		saveData();
	}

	public void editName(String userName) throws IOException {
		for (Contact c : contacts) {
			if (c.getName().equals(userName)) {
				c.setName(userName);
			}
		}

		saveData();
	}

	public void editNumber(String userNumber) throws IOException {
		for (Contact contact : contacts) {
			if (contact.getNumber().equals(userNumber)) {
				contact.setNumber(userNumber);
			}
		}

		saveData();
	}

	public void editEmail(String userEmail) throws IOException {
		for (Contact contact : contacts) {
			if (contact.getEmail().equals(userEmail)) {
				contact.setEmail(userEmail);
			}
		}

		saveData();
	}

	public void sortContacts() throws IOException {

		Collections.sort(contacts, new Comparator<Contact>() {
			public int compare(Contact c1, Contact c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
		saveData();
	}

	public void saveData() throws IOException {

		Writer writer = new FileWriter("phonebook.json");
		Gson gson = new GsonBuilder().create();
		gson.toJson(contacts, writer);
		writer.close();

	}

	public void loadData() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("phonebook.json"));
		Gson gson = new Gson();
		contacts = gson.fromJson(br, new TypeToken<ArrayList<Contact>>() {
		}.getType());
	}
}
