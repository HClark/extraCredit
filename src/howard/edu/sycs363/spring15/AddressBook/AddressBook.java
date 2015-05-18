package howard.edu.sycs363.spring15.AddressBook;

import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import java.io.FileWriter;
import java.io.IOException;


public class AddressBook {
	
	private Map<String, Person> ContactMap = new HashMap<String, Person>();
	
	Scanner inFile;
	
	
	public AddressBook(){
		
	    
		try {
		inFile = new Scanner(new FileReader("dbinfile.txt"));

	    while(inFile.hasNextLine())
	    {
	       String data = inFile.nextLine();
	       String[] input = data.split(",");
	       Address newAddress = new Address(input[3],input[4],input[5],input[6].trim());
	       Person newPerson = new Person(input[0],input[1], newAddress,input[2]);
	       DatabaseCon.insertToDB(input[7].trim(), newPerson);
	       ContactMap.put(input[7].trim(), newPerson);
	    }
		} catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	


	public void addEntry(String key, Person newContact){
		ContactMap.put(key, newContact);
	}
	
	 public void write() {
	      
		  try {
			  File file = new File("Outfile.txt");
			  if (!file.exists()){
				  file.createNewFile();
			  }
			  
			  FileWriter fw = new FileWriter(file.getAbsolutePath());
			  BufferedWriter bw = new BufferedWriter(fw);
			  
        for (Map.Entry<String, Person> entry : ContactMap.entrySet()) {
            Person contact = entry.getValue();
            bw.write(entry.getKey() + "," +
                    contact.getFirstName() + "," +
                    contact.getLastName() + "," +
                    contact.getNumber() + "," +
                    contact.getAddressStreet() + "," +
                    contact.getAddressCity() + "," +
                    contact.getAddressState() + "," +
                    contact.getAddressZip() +
                    "\n");
        }
			  
			  bw.close();
			  
		  } catch (IOException e){
			  e.printStackTrace();
		  }
		  
	  }
	
	public Person getContact(String contactName){
		return ContactMap.get(contactName);
	}
	
	public AddressBook(String contactFile) {
		
		try {
		inFile = new Scanner(new FileReader(contactFile));
		
	    while(inFile.hasNextLine())
	    {
	       String data = inFile.nextLine();
	       String[] input = data.split(",");
	       Address newAddress = new Address(input[3],input[4],input[5],input[6].trim());
	       Person newPerson = new Person(input[0],input[1], newAddress,input[2]);
	       ContactMap.put(input[0].trim(), newPerson);
	    }
		} catch(IOException ex){
			System.out.println(ex.getMessage());
		}	
		
}
	
	  
	
	
	public void editEntry(String contactName, String newData, int option){
		Person contact = getContact(contactName);
		if (option < 5){
			contact.editAddress(option, newData);
		}
		else {
			contact.setNumber(newData);
		}
	}
	
	
	
	public void removeEntry(String contactName){
		ContactMap.remove(contactName);
	}
	
	
	
	public void sortByLastName(){
		  LastNameComparator lc = new LastNameComparator(ContactMap);
		  
		  TreeMap<String,Person> tm=new TreeMap<String,Person>(lc);
		  tm.putAll(ContactMap);
		  ContactMap = tm;
	}
		

	
	public void sortByZip(){
		ZipComparator zc =new ZipComparator(ContactMap);
		  
		  TreeMap<String,Person> tm=new TreeMap<String,Person>(zc);
		  tm.putAll(ContactMap);
		  ContactMap = tm;
	}
	
	
	
	public void printEntry(String contactName){
		getContact(contactName).print();
		
	}
	
	  
	 

	

}

	
	
	class LastNameComparator implements Comparator{
		 private Map<String, Person> ContactMap;
		 
		 public LastNameComparator(Map<String, Person> ContactMap) {
		  this.ContactMap = ContactMap;
		 }
		 
		
		 public int compare(Object o1, Object o2) {
		  if(ContactMap.get(o1).getLastName().compareTo(ContactMap.get(o2).getLastName())>0){
		   return 1;  
		  }else {
		  return -1;
		  }
		 }
	}
		 

	
			
	class ZipComparator implements Comparator{
		 private Map<String, Person> ContactMap;
		 
		 public ZipComparator(Map<String, Person> ContactMap) {
		  this.ContactMap = ContactMap;
		 }
		 
		 
		 public int compare(Object o1, Object o2) {
		  if(Integer.parseInt(ContactMap.get(o1).getAddressZip()) > Integer.parseInt(ContactMap.get(o2).getAddressZip())){
		   return 1;  
		  }else {
		  return -1;
		  }
		 }
	}

