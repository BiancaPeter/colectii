package exercitii.phonebook;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> validContacts = new ArrayList<>();
        validContacts.add("15635");
        System.out.println(validContacts);
        List<String> blackContacts = new ArrayList<>();
        PhoneBook phoneBook = new PhoneBook(validContacts, blackContacts);
        phoneBook.addToBlackList("15635");
        System.out.println(phoneBook.getBlackList());
        System.out.println(phoneBook.getValidContacts());
        PhoneBook.filterContacts(validContacts,blackContacts);
        phoneBook.removeFromBlackList("15635");
    }
}
