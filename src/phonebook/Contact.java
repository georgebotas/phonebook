package phonebook;

//The main class that contains the data types we are working with (name, number, e-mail, etc.). 
public class Contact{

	private String name;
	private String number;
	private String email;
	
	public Contact(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}
	
	public String getName() {
		return this.name;
	}

	public String setName(String name) {
		this.name = name;
		return name;
	}

	public String getNumber() {
		return this.number;
	}

	public String setNumber(String number) {
		this.number = number;
		return number;
	}

	public String getEmail() {
		return this.email;
	}

	public String setEmail(String email) {
		this.email = email;
		return email;
	}

}
