package address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AddressBook implements Serializable{

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "address_book", cascade = CascadeType.ALL)
	private Collection<BuddyInfo> buddyList;

	private String name;

	public AddressBook(){
		buddyList = new ArrayList<BuddyInfo>();
	}

	public AddressBook(int id, String name){
		buddyList = new ArrayList<BuddyInfo>();
		this.id = id;
		this.name = name;
	}

	public long getId(){
		return this.id;
	}

	public void setId(long id){
		this.id = id;
	}

	public void addBuddy(BuddyInfo buddy){
		buddyList.add(buddy);
	}

	public void removeBuddy(BuddyInfo buddy_remove){
		String name = buddy_remove.getName();
		for(BuddyInfo buddy : this.buddyList){
			if (buddy.getName().equals(name)){
				buddyList.remove(buddy);
				break;
			}
		}
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public int size(){
		return this.buddyList.size();
	}

	public void removeAllElements(){
		buddyList.clear();
	}

//	public void printAddressBook(){
//		for (address.BuddyInfo buddy : this.buddyList){
//			System.out.println("Buddy name:" + buddy.getName() + " address: " + buddy.getAddress() + " phone number : " + buddy.getPhone_number());
//		}
//	}

	//@OneToMany(mappedBy = "address_book", cascade = CascadeType.ALL)
	public Collection<BuddyInfo> getBuddyInfos(){
		return this.buddyList;
	}
}