package phonebook;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) throws IOException {
		
		Phonebook phonebook = new Phonebook();
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        
		Menu menu = (Menu)context.getBean("menu");;
        menu.showMainMenu(); 
        Integer userInt = Menu.SCAN.nextInt();
        menu.select(userInt);
        
        
		//DBOperations.ENTITY_MANAGER_FACTORY.close();

	}
}
