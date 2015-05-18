package howard.edu.sycs363.spring15.AddressBook;

public class AddressBookMain {

	public static void main(String[] args) {
		DatabaseCon con = new DatabaseCon();
		con.makeConnection();
		
		AddressBook SampleBook = new AddressBook();
		
		Person SamplePerson = new Person("clark","sam",testAddress,"6412954375");

		Address SampleAddress = new Address("St. Paul","Minnesota","10500","3032 Great Oak");
	
	    
	    
	    
	    con.insertToDB("test", SamplePerson);
	    
	   
	    con.retrieveContactByName(SamplePerson);
	    System.out.println("\n");
	    
		
		
		SampleBook.write();
		
	
		Address testAddress = new Address("new york","new york","79657","24 12th street");
		Person testPerson = new Person("sloveal","time",testAddress,"6412954375");
		
		con.insertToDB("sample", testPerson);
		
		System.out.println("Contact in DB before Edit:");
		con.retrieveContactByName(testPerson);
		
		testPerson.editAddress("westfield","alabama","36743","24 Lazy Lake");
		con.updateContactDB(testPerson,"lake view", "minnesota", "78550", "10101 flower");
		
		System.out.println("Contact in DB after Update Operation is performed:");
		con.retrieveContactByName(testPerson);
		
		
		
		
		
		System.out.print("\n\n\n\n");
		System.out.println("All the Records within our Database:");
		con.retrieveAllContacts();
	    
	}

}
