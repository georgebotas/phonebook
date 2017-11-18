package phonebook;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	static Logger log = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) throws IOException {
		
		Phonebook phonebook = new Phonebook();
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        
		Menu menu = (Menu)context.getBean("menu");;
        menu.showMainMenu(); 
        Integer userInt = Menu.SCAN.nextInt();
        menu.select(userInt, phonebook);
        
        
		//DBOperations.ENTITY_MANAGER_FACTORY.close();

	}
}
