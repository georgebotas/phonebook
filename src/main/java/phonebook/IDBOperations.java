package phonebook;

import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface IDBOperations {

	void create(String name, String number, String email);

	ArrayList<Contact> readAll();

	void validate(Long contact_id);

	void contInfo(Long contact_id);

	void updateName(Long contact_id, String newName);

	void updateNumber(Long contact_id, String newNumber);

	void updateEmail(Long contact_id, String newEmail);

	void delete(Long contact_id);

}