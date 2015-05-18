package howard.edu.sycs363.spring15.AddressBook;

public class Address {
	private String city, state, zip, street;
	
	
	
	
	public Address(String newCity, String newState, String  newZip, String newStreet)
	{
		city = newCity;
		state = newState;
		zip = newZip;
		street = newStreet;
	}
	
		public void editCity(String new_city)
	{
		city = new_city;
	}
	
	
	public void editState(String new_state)
	{
		state = new_state;
	}
	
	public Address()
	{
		city = "";
		state = "";
		zip = "";
		street = "";
	}
	

	
	
	public void editZip(String new_zip)
	{
		zip = new_zip;
	}
	
	
	public void editStreet(String new_street)
	{
		street = new_street;
	}
	
	
	
	public String getCity(){
		return city;
	}
	
	public String getState(){
		return state;
	}
	
	public String getZip(){
		return zip;
	}
	
	public String getStreet(){
		return street;
	}
	
	
	public void print(){
		System.out.print("Address: ");
		System.out.print(this.street);
		System.out.print(this.city);
		System.out.print(this.state);
		System.out.print(this.zip);
	}

}
