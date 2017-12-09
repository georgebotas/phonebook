package main.java.com.georgebotas.phonebook.DB;

import main.java.com.georgebotas.phonebook.Model.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Component
public class DBOperations implements IDBOperations {

    public DBOperations() {
    }

    private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Phonebook");
    private EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    private EntityTransaction transaction;

    public boolean validateID(Long contact_id) {
        Contact contact = manager.find(Contact.class, contact_id);
        if (contact == null) {
            return false;
        }
        return true;
    }

    //public boolean emptyPhonebook = false;

    public void create(String name, String number, String email) {
        transaction = manager.getTransaction();
        transaction.begin();
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        manager.persist(contact);
        transaction.commit();
    }

    public ArrayList<Contact> readAll() {
        ArrayList<Contact> contacts = null;
        transaction = manager.getTransaction();
        transaction.begin();
        contacts = (ArrayList<Contact>) manager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
        transaction.commit();
        //if (contacts == null) {
        //    emptyPhonebook = true;
        //} else {
        //    emptyPhonebook = false;
        //}
        return contacts;
    }

    public String infoName(Long contact_id) {
        Contact contact = manager.find(Contact.class, contact_id);
        return contact.getName();
    }

    public String infoNumber(Long contact_id) {
        Contact contact = manager.find(Contact.class, contact_id);
        return contact.getNumber();
    }

    public String infoEmail(Long contact_id) {
        Contact contact = manager.find(Contact.class, contact_id);
        return contact.getEmail();
    }

    public void updateName(Long contact_id, String newName) {
        transaction = manager.getTransaction();
        transaction.begin();
        Contact contact = manager.find(Contact.class, contact_id);
        contact.setName(newName);
        manager.persist(contact);
        transaction.commit();
    }

    public void updateNumber(Long contact_id, String newNumber) {
        transaction = manager.getTransaction();
        transaction.begin();
        Contact contact = manager.find(Contact.class, contact_id);
        contact.setNumber(newNumber);
        manager.persist(contact);
        transaction.commit();
    }

    public void updateEmail(Long contact_id, String newEmail) {
        transaction = manager.getTransaction();
        transaction.begin();
        Contact contact = manager.find(Contact.class, contact_id);
        contact.setEmail(newEmail);
        manager.persist(contact);
        transaction.commit();
    }

    public void delete(Long contact_id) {
        transaction = manager.getTransaction();
        transaction.begin();
        Contact contact = manager.find(Contact.class, contact_id);
        manager.remove(contact);
        transaction.commit();
    }
}
