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

	
	static ArrayList<Contact>contacts = new ArrayList<Contact>();
	
	public static void createContact() throws IOException {
		
		Contact contact = new Contact(Menu.userName, Menu.userNumber, Menu.userEmail);
		
		contacts.add(contact);
		
		saveData();
	}

	public static void showContacts() throws IOException {
		int count = 0;
			if (contacts.isEmpty()) {
				System.out.println("THERE ARE NO CONTACTS IN THE PHONEBOOK.\n");
				Menu.select();
			}
			System.out.printf("%-23s %-21s %-21s \n", "   NAME:", "PHONE NUMBER:", "E-MAIL:");
			for (Contact i: contacts) {
				
				System.out.printf("%d. %-20s %-21s %s \n", count + 1, i.getName(), i.getNumber(), i.getEmail());
				count++;
			}
			System.out.println();
		
	}

	public static void deleteContact() throws IOException {

		contacts.remove(Menu.userDelete);
		saveData();
	}

	public static void editName() throws IOException {
		for (Contact c : Phonebook.contacts) {

			if (c.getName() != null && c.getName().contains(Menu.userName)) {

				c.setName(Menu.userName2);
			}
		}
		saveData();
	}
	public static void editNumber() throws IOException {
		for (Contact c : Phonebook.contacts) {

			if (c.getNumber() != null && c.getNumber().contains(Menu.userNumber)) {

				c.setNumber(Menu.userNumber2);
			}
		}
		saveData();
	}
	public static void editEmail() throws IOException {
		for (Contact c : Phonebook.contacts) {

			if (c.getEmail() != null && c.getEmail().contains(Menu.userEmail)) {

				c.setEmail(Menu.userEmail2);
			}
		}
		saveData();
}
	
	public static void sortContact() throws IOException{
		
		Collections.sort(contacts, new Comparator<Contact>(){
			public int compare(Contact c1, Contact c2) {
				return c1.getName().compareTo(c2.getName());	
			}
		});
		saveData();
	}
	
	public static void saveData() throws IOException {

		Writer writer = new FileWriter("phonebook.json");
		Gson gson = new GsonBuilder().create();
		gson.toJson(contacts, writer);
		writer.close();

	}

	public static void loadData() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("phonebook.json"));
		Gson gson = new Gson();
		contacts = gson.fromJson(br, new TypeToken<ArrayList<Contact>>() {
		}.getType());
	}
	
	public static void main(String[] args) throws IOException {
		
		try {
			
		loadData();
		}
		catch (FileNotFoundException e){
		}
		Menu.select();
	}
}
