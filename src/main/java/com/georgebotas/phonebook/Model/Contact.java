package main.java.com.georgebotas.phonebook.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;
	
	private String name;
	private String number;
	private String email;
	

	public Contact(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}
	
	public Contact() {

	}
	
	public Long getContact_Id() {
		return contact_id;
	}
	public void setContact_Id(Long contact_id) {
		this.contact_id = contact_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
