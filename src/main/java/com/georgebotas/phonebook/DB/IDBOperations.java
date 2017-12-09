package main.java.com.georgebotas.phonebook.DB;

import main.java.com.georgebotas.phonebook.Model.Contact;

import java.util.ArrayList;

public interface IDBOperations {

	void create(String name, String number, String email);

	ArrayList<Contact> readAll();

	boolean validateID(Long contact_id);

	void updateName(Long contact_id, String newName);

	void updateNumber(Long contact_id, String newNumber);

	void updateEmail(Long contact_id, String newEmail);

	void delete(Long contact_id);

    String infoName(Long contact_id);

    String infoNumber(Long contact_id);

    String infoEmail(Long contact_id);

}