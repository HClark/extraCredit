package howard.edu.sycs363.spring15.AddressBook;

public class Person {
	

	private final String first_name, last_name;
	public String phone_num;
	public Address address;
	
	

	public Person (String new_fname, String new_lname, Address new_address, String new_phone_num)
	{
		first_name = new_fname;
		last_name = new_lname;
		address = new_address;
		phone_num = new_phone_num;
	}

	

	public String getLastName(){
		return this.last_name;
	}

	public String getFirstName(){
		return this.first_name;
	}
	
	public String getAddressCity()
	{
		return address.getCity();
	}
	public String getAddressState()
	{
		return address.getState();
	}
	public String getAddressZip()
	{
		return address.getZip();
	}
	public String getAddressStreet()
	{
		return address.getStreet();
	}
	
	public String getNumber()
	{
		return phone_num;

	}

	public void setNumber(String newNum)
	{
		phone_num = newNum;
	}
	
	
	


	public void editAddress(String newCity, String newState, String newZip, String newStreet)
	{
		address.editCity(newCity);
		address.editState(newState);
		address.editZip(newZip);
		address.editStreet(newStreet);	
	}

	public void editAddress(int option, String newValue)
	{
	switch(option) {	
		case 1: address.editCity(newValue);
		case 2: address.editState(newValue);
		case 3: address.editZip(newValue);
		case 4: address.editStreet(newValue);
		default:
			address.editCity(newValue);
		}
	}
	

	public void print()
	{
		System.out.print("First Name " + this.first_name);
		System.out.print("Last Name " + this.last_name);
		System.out.print("Phone Number " + this.phone_num);
		this.address.print();
		System.out.print("\n");
	}
	
	
	
	
}
