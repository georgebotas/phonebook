package phonebook;

import java.util.ArrayList;
import javax.persistence.*;

public class DBOperations {

	public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("Phonebook");

	EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
	EntityTransaction transaction = null;

	public void create(String name, String number, String email) {
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			Contact contact = new Contact();
			contact.setName(name);
			contact.setNumber(number);
			contact.setEmail(email);

			manager.persist(contact);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
	}

	public ArrayList<Contact> readAll() {
		ArrayList<Contact> contacts = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			contacts = (ArrayList<Contact>) manager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} 
		return contacts;
	}

	public void validate(Long contact_id) {
			transaction = manager.getTransaction();
			transaction.begin();
			Contact contact = manager.find(Contact.class, contact_id);
			if (contact == null) {
				System.out.println("COULDN'T FIND THE CONTACT WITH THIS ID: " + contact_id);
				System.exit(0);
			}
	}
	
	public void contInfo(Long contact_id) {
		Contact contact = manager.find(Contact.class, contact_id);
		System.out.println("SELECTED CONTACT INFORMATION:\n");
		System.out.printf("%-21s %-21s %-21s \n", "NAME:", "PHONE NUMBER:", "E-MAIL:");
		System.out.printf("%-21s %-21s %s \n",  contact.getName(), contact.getNumber(), contact.getEmail());
		System.out.println();
	}

	public void updateName(Long contact_id, String newName) {
		try {
			Contact contact = manager.find(Contact.class, contact_id);
			if (contact == null) {
				System.out.println("COULDN'T FIND THE CONTACT WITH THIS ID: " + contact_id);
				System.exit(0);
			}
			contact.setName(newName);
			manager.persist(contact);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} 
	}

	public void updateNumber(Long contact_id, String newNumber) {
		try {
			Contact contact = manager.find(Contact.class, contact_id);
			if (contact == null) {
				System.out.println("COULDN'T FIND THE CONTACT WITH THIS ID: " + contact_id);
				System.exit(0);
			}
			contact.setNumber(newNumber);
			manager.persist(contact);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} 
	}

	public void updateEmail(Long contact_id, String newEmail) {
		try {
			Contact contact = manager.find(Contact.class, contact_id);
			if (contact == null) {
				System.out.println("COULDN'T FIND THE CONTACT WITH THIS ID: " + contact_id);
				System.exit(0);
			}
			contact.setEmail(newEmail);
			manager.persist(contact);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} 
	}

	public void delete(Long contact_id) {
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			Contact contact = manager.find(Contact.class, contact_id);
			if (contact == null) {
				System.out.println("COULDN'T FIND THE CONTACT WITH THIS ID: " + contact_id);
				System.exit(0);
			}
			manager.remove(contact);
			transaction.commit();
			System.out.println(contact.getName() + " WAS SUCCESFULLY DELETED FROM THE PHONEBOOK.");

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} 
	}
}
