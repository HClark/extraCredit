package howard.edu.sycs363.spring15.AddressBook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	
	public void testAddressStringStringStringString() {
		Address testAddress = new Address("harlingen","texas","78552","1918 adrian"); 
		
		
		
		
		assertEquals("Should return harlingen", "harlingen", testAddress.getCity());
		assertEquals("Should return texas", "texas", testAddress.getState());
		assertEquals("Should return 78552", "78552", testAddress.getZip());
		assertEquals("Should return 1918 adrian", "1918 adrian", testAddress.getStreet());
	}


		@Test
	
	public void testEditZip() {
		Address testAddress = new Address();
		testAddress.editZip("23124");
		
		
		assertEquals("Should return 23124", "23124", testAddress.getZip());
	}
	@Test
	
	public void testAddress() {
		Address testAddress = new Address();
		
		
		assertEquals("Should return a blank string", "", testAddress.getCity());
		assertEquals("Should return a blank string", "", testAddress.getState());
		assertEquals("Should return a blank string", "", testAddress.getZip());
		assertEquals("Should return a blank string", "", testAddress.getStreet());
		
	}



	@Test
	
	public void testEditStreet() {
		Address testAddress = new Address();
		testAddress.editStreet("27691 Bass Blvd");
		
	
		assertEquals("Should return 27691 Bass Blvd", "27691 Bass Blvd", testAddress.getStreet());
		
	}


	@Test
	
	public void testEditCity() {
		Address testAddress = new Address();
		testAddress.editCity("testVille");
		
		
		assertEquals("Should return testVille", "testVille", testAddress.getCity());
		
	}

	@Test
	
	public void testEditState() {
		Address testAddress = new Address();
		testAddress.editState("testafornia");
		
		
		assertEquals("Should return testafornia", "testafornia", testAddress.getState());
	}



}
