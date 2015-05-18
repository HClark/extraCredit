package howard.edu.sycs363.spring15.AddressBook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	
	public void testAddEntry() {
		Address testAddress = new Address("St. Paul","Minnesota","10500","3032 Great Oak"); 
		Person testPerson = new Person("clark","sam",testAddress,"6412954375");
		AddressBook abook = new AddressBook();
			
		abook.addEntry("paul", testPerson);

		
		assertNotNull("make sure that the object is not null", abook.getContact("paul"));
	}

	@Test
	public void testWrite() {
		Address testAddress = new Address("new york","new york","79657","24 12th street");
        Person testPerson = new Person("sloveal","tim",testAddress,"6412954375");
        AddressBook abook = new AddressBook();
        abook.addEntry("check", testPerson);
        
        abook.write();
		
	}

	@Test
	
	public void testGetContact() {
		Address testAddress = new Address("westfield","alabama","36743","24 Lazy Lake"); 
		Person testPerson = new Person("smith","tone",testAddress,"6412954375");
		Address tAddress = new Address("harlingen","texas","78552","mya"); 
		Person tPerson = new Person("michelle","april",testAddress,"5434353546");
		AddressBook abook = new AddressBook();
		
		
		
		abook.addEntry("paul", testPerson);
		abook.addEntry("gretchen", tPerson);
		
	
		assertNotNull("Should check that the object is not null", abook.getContact("gretchen"));
		assertNotNull("Should check that the object is not null", abook.getContact("paul"));
		
	}


	@Test
	
	
	public void testAddressBook() {
		Address testAddress = new Address("huston","texas","78552","3562 carla"); 
		Person testPerson = new Person("michelle","april",testAddress,"5434353546");
		
		
		Map<String, Person> ContactMap = new HashMap<String, Person>();
		ContactMap.put("gretchen", testPerson);
		
	
		assertNotNull("Should check that the object is not null", ContactMap.get("gretchen"));
		
	}


	
	
	@Test
	
	public void testRemoveEntry() {
		Address testAddress = new Address("silver spring","maryland","34552","236 hannah st."); 
		Person testPerson = new Person("smith","tone",testAddress,"6412954375");
		AddressBook abook = new AddressBook();
		
		
		
		abook.addEntry("paul", testPerson);
		
		assertNotNull("Should check that the object is not null", abook.getContact("paul"));
		
		abook.removeEntry("paul");
		
		assertNull("Should check that the object is not null", abook.getContact("paul"));
		
	}

	
	

}
