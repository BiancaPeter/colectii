import exercitii.phonebook.PhoneBook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    @Test
    void testFilterContacts_ShouldReturnValidContacts() {
        //given
        List<String> validContacts = new ArrayList<>();
        validContacts.add("12");
        validContacts.add("34");
        validContacts.add("56");
        validContacts.add("78");

        List<String> blackContacts = new ArrayList<>();
        blackContacts.add("12");
        blackContacts.add("78");
        //when
        List<String> result = PhoneBook.filterContacts(validContacts, blackContacts);
        //then
        assertEquals(2, result.size());
    }
}
