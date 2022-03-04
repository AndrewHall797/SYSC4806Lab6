package address;

import address.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.List;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository addressRepository;

    @Autowired
    BuddyInfoRepository buddyRepository;

    @GetMapping("/createBuddy")
    public String addBuddyForm(Model model){
        model.addAttribute("buddy", new BuddyInfo());
        return "createBuddy";
    }

    @PostMapping("/createBuddy")
    public String createBuddy(@ModelAttribute BuddyInfo buddy, Model model){
        buddyRepository.save(buddy);
        model.addAttribute("buddy", buddy);
        return "resultCreateBuddy";
    }

    @GetMapping("/createAddress")
    public String addAddressForm(Model model){
        model.addAttribute("address", new AddressBook());
        return "createAddress";
    }

    @PostMapping("/createAddress")
    public String createAddress(@ModelAttribute AddressBook addressBook, Model model){
        addressRepository.save(addressBook);
        model.addAttribute("address", addressBook);
        return "resultCreateAddress";
    }

    @GetMapping("/addBuddy")
    public String viewBuddies(Model model){
        model.addAttribute("buddy", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/viewBuddies")
    public String viewBuddies(@RequestParam String addressName,@ModelAttribute BuddyInfo buddy, Model model) {

        List<AddressBook> correct_address = addressRepository.findByName(addressName);
        AddressBook addressBook = correct_address.get(0);
        addressBook.addBuddy(buddy);

        String[] buddy_names = new String[addressBook.getBuddyInfos().size()];

        int i = 0;
        for(BuddyInfo buddyInfo : addressBook.getBuddyInfos()){
            buddy_names[i] = buddyInfo.getName();
            i++;
        }

        model.addAttribute("buddy_names", buddy_names);
        return "viewBuddies";


    }

}
