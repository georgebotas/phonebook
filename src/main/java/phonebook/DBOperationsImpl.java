package phonebook;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.*;

@Default
@ApplicationScoped
public class DBOperationsImpl implements DBOperations {
	private EntityManager manager;
	private EntityTransaction transaction;
	
	public DBOperationsImpl() {
		super();
		manager = ENTITY_MANAGER_FACTORY.createEntityManager();
	}
	/* (non-Javadoc)
	 * @see phonebook.DbOperations#create(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see phonebook.DbOperations#readAll()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see phonebook.DbOperations#validate(java.lang.Long)
	 */
	@Override
	public void validate(Long contact_id) {
			transaction = manager.getTransaction();
			transaction.begin();
			Contact contact = manager.find(Contact.class, contact_id);
			if (contact == null) {
				System.out.println("COULDN'T FIND THE CONTACT WITH THIS ID: " + contact_id);
				System.exit(0);
			}
	}
	
	/* (non-Javadoc)
	 * @see phonebook.DbOperations#contInfo(java.lang.Long)
	 */
	@Override
	public void contInfo(Long contact_id) {
		Contact contact = manager.find(Contact.class, contact_id);
		System.out.println("SELECTED CONTACT INFORMATION:\n");
		System.out.printf("%-21s %-21s %-21s \n", "NAME:", "PHONE NUMBER:", "E-MAIL:");
		System.out.printf("%-21s %-21s %s \n",  contact.getName(), contact.getNumber(), contact.getEmail());
		System.out.println();
	}

	/* (non-Javadoc)
	 * @see phonebook.DbOperations#updateName(java.lang.Long, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see phonebook.DbOperations#updateNumber(java.lang.Long, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see phonebook.DbOperations#updateEmail(java.lang.Long, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see phonebook.DbOperations#delete(java.lang.Long)
	 */
	@Override
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
