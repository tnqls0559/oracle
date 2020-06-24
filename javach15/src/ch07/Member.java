package ch07;

public class Member {
  private String name;
  private String id;
  private Address address;
  
//생성자
public Member(String name, String id, Address address) {
	this.name = name;
	this.id = id;
	this.address = address;
}

public String getName() {
	return name;
}

public String getId() {
	return id;
}

public Address getAddress() {
	return address;
}
  
}
class Address{
	private String country;
	private String city;
	
	public Address(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}
	
}
