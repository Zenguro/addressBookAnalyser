package addressBook.models;

import addressBook.exceptions.PersonNotFoundException;
import addressBook.reader.AddressBookReader;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressBookTest {

    @Test
    public void findNoneExistingPerson() {
        try {
            AddressBook addressBook = AddressBookReader.readAddressBookFromFile("addressbookValidTEST.txt");
            addressBook.getPersonByName("asdfölj");
            assertTrue(false);
        } catch (PersonNotFoundException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void findExistingPerson() {
        try {
            String testName = "Sarah Stone";
            AddressBook addressBook = AddressBookReader.readAddressBookFromFile("addressbookValidTEST.txt");
            Person person= addressBook.getPersonByName(testName);

            assertTrue(testName.equals(person.getName()));
        } catch (PersonNotFoundException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
