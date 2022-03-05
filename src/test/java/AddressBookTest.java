import javax.persistence.*;
import java.util.List;
import address.BuddyInfo;
import address.AddressBook;

public class AddressBookTest {

    @org.junit.Test
    public void addBuddy() {
        AddressBook address = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Bob", "61365665", "57 Cecil Carling");
        address.addBuddy(buddy);

        assert address.size() == 1;
    }

    @org.junit.Test
    public void removeBuddy() {
        AddressBook address = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Bob", "61365665", "57 Cecil Carling");
        address.addBuddy(buddy);
        address.removeBuddy(buddy);

        assert address.size() == 0;
    }

}