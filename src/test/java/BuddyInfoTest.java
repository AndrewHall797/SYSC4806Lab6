import org.junit.Test;
import address.BuddyInfo;
import address.AddressBook;

import javax.persistence.*;

import java.util.List;

public class BuddyInfoTest {

    @Test
    public void getPhone_number() {
        BuddyInfo buddy = new BuddyInfo("Buddy","555555","89 whatever lane");
        assert "555555" == buddy.getPhone_number();
    }

    @Test
    public void setPhone_number() {
        BuddyInfo buddy = new BuddyInfo("Buddy","555555","89 whatever lane");
        buddy.setPhone_number("44444");
        assert "44444" == buddy.getPhone_number();
    }

    @Test
    public void getName() {
        BuddyInfo buddy = new BuddyInfo("Buddy","555555","89 whatever lane");
        assert "Buddy".equals(buddy.getName());
    }

    @Test
    public void setName() {
        BuddyInfo buddy = new BuddyInfo("Buddy","555555","89 whatever lane");
        buddy.setName("Joe");
        assert "Joe".equals(buddy.getName());
    }

    @Test
    public void getAddress() {
        BuddyInfo buddy = new BuddyInfo("Buddy","555555","89 whatever lane");
        assert "89 whatever lane".equals(buddy.getAddress());
    }

    @Test
    public void setAddress() {
        BuddyInfo buddy = new BuddyInfo("Buddy","555555","89 whatever lane");
        buddy.setAddress("78 something");
        assert "78 something".equals(buddy.getAddress());
    }

}