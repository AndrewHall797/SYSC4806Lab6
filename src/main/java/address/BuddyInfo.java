package address;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable{

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	private AddressBook address_book;

	private String phone_number;

	private String address;

	public BuddyInfo(){
		this.phone_number = "1";
		this.address = "Random";
	}

	public BuddyInfo(String name, String phone_number, String address){
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressBook(AddressBook address_book){
		this.address_book = address_book;
	}

	public long getId(){
		return this.id;
	}

	public void setId(long id){
		this.id = id;
	}

	//@ManyToOne(cascade = CascadeType.ALL)
	public AddressBook getAddressBook(){
		return this.address_book;
	}
}
