package phonebook;

public class Person 
{
	
	private String firstName;
	private String lastName;
	private String phone;
	private	String street;
	private	String city;
	private	String state;
	private	String zip;
	
	
public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getZip() {
		return zip;
	}




	public void setZip(String zip) {
		this.zip = zip;
	}









public Person(String firstName, String lastName, String street, String city, String state,
		String zip, String phone) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
	this.street = street;
	this.city = city;
	this.state = state;
	this.zip = zip;
}



public Person() {
	// TODO Auto-generated constructor stub
}






public String getPhone() {
	return phone;
	
}

public void setPhone(String phone) {
	this.phone = phone;

	
}



@Override
public String toString() {
	return "First: " + firstName + "\nLast: " + lastName + "\nCity: " + city +  "\nState: " + state + "\nZip: " + zip +  "\nPhone: " + 	phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") + "\n";
}














}





