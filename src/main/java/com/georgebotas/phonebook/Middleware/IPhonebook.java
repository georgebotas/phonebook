package main.java.com.georgebotas.phonebook.Middleware;

public interface IPhonebook {
    void createContact(String userName, String userNumber, String userEmail);

    void showContacts();

    boolean validateID(Long contact_id);

    String infoName(Long contact_id);

    String infoNumber(Long contact_id);

    String infoEmail(Long contact_id);

    void deleteContact(Long contact_id);

    void editName(Long contact_id, String newName);

    void editNumber(Long contact_id, String newNumber);

    void editEmail(Long contact_id, String newEmail);

    void sortContactsName();

    void sortContactsNumber();

    void sortContactsEmail();
}
