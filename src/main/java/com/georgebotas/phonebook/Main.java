package main.java.com.georgebotas.phonebook;

import main.java.com.georgebotas.phonebook.UI.IMenu;
import main.java.com.georgebotas.phonebook.UI.Menu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		IMenu imenu = (Menu)context.getBean("imenu");
        imenu.select();
	}
}
