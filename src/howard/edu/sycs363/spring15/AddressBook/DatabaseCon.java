package howard.edu.sycs363.spring15.AddressBook;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseCon {
	
	
	
	static Connection connection = null;
	
	String driverName = "org.postgresql.Driver";
	String serverAddress = "127.0.0.1";
	String portNumber = "5432";
	String dbName = "contactdb";
	String username = "errol";
	String password = "123456";
	
	String url = "jdbc:postgresql://" + serverAddress + ":" + portNumber + "/" + dbName;

	
	public DatabaseCon(){
		
	}

	public void retrieveAllContacts(){
		
		try {
			
			Statement stmt = connection.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM address_book");
			
		
			while (rs.next()) {
				System.out.println("city: " + rs.getString(1) + "," + 
						"state: " + rs.getString(2) + "," + 
						"zip: " + rs.getString(3) + "," +
						"street: "+ rs.getString(4) + "," +
						"first name: " + rs.getString(5) + "," +
						"last name: "+ rs.getString(6) + "," +
						"phone number: " + rs.getString(7) + "," +
						"primary key: " + rs.getString(8));
			}
			stmt.close();
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public void makeConnection(){
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName(driverName);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		try {
 
			connection = DriverManager.getConnection(url,username,password);
			
			
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			

			
		} else {
			System.out.println("Failed to make connection!");
		}
		
	}
	
	
	
	
	
	
	public static void updateContactDB(Person contact, String newCity, String newState, String newZip, String newStreet)
	{
		try {
			Statement stmt = connection.createStatement();
			String sql = "UPDATE address_book "
					+ " SET city ='"+newCity+"'"
					+ ", state ='"+newState+"'"
					+ ", zip ='"+newZip+"'"
					+ ", street ='"+newStreet+"'"
					+" WHERE first_name='"+contact.getFirstName() +"'";
			
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
			
			System.out.println("Update Complete");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void insertToDB(String key, Person contact){
		try {
	
		Statement stmt = connection.createStatement();
				
		
		String sql = "INSERT INTO address_book "
				+ " (city, state, zip, street, first_name, last_name, phone_num, uid)"
				+ " VALUES " + "(" + "'" + contact.getAddressCity() + "'" + "," + "'" + contact.getAddressState() + "'" + "," + "'" + contact.getAddressZip() + "'" + ',' + "'" + contact.getAddressStreet() + "'" + ',' + "'" + contact.getFirstName() + "'" + ',' + "'" + contact.getLastName() + "'" + ',' + "'" + contact.getNumber() + "'" + ',' + "'" + key + "'" + ")";
		
		stmt.executeUpdate(sql);
		
		System.out.println("Insert complete");
		
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public void retrieveContactByName(Person contact){
		
		try {
			
			Statement stmt = connection.createStatement();
			
			
			String sql = "SELECT * FROM address_book WHERE first_name='"+contact.getFirstName()+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next()) {
				System.out.println("city: " + rs.getString(1) + "," + 
						"state: " + rs.getString(2) + "," + 
						"zip: " + rs.getString(3) + "," +
						"street: "+ rs.getString(4) + "," +
						"first name: " + rs.getString(5) + "," +
						"last name: "+ rs.getString(6) + "," +
						"phone number: " + rs.getString(7) + "," +
						"primary key: " + rs.getString(8));
			}
			stmt.close();
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	

	public static void main(String[] args) {
		DatabaseCon con = new DatabaseCon();
		con.makeConnection();

		
	}

}
