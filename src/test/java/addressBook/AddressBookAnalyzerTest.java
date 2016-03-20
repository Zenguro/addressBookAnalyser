package addressBook;

import addressBook.models.AddressBook;
import addressBook.models.Gender;
import addressBook.models.Person;
import addressBook.parser.PersonParser;
import addressBook.reader.AddressBookReader;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressBookAnalyzerTest {
    @Test
    public void countingGenderTest() {
        try {
            AddressBook addressBook = AddressBookReader.readAddressBookFromFile("addressbookCountGenderTEST.txt");
            assertTrue(AddressBookAnalyzer.countGender(Gender.male, addressBook) == 3);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void findingOldestPersonTest() {
        try {
            AddressBook addressBook = AddressBookReader.readAddressBookFromFile("addressbookValidTEST.txt");
            Person oldestPerson = AddressBookAnalyzer.getOldestPerson(addressBook);
            assertTrue(oldestPerson.getName().equals("Wes Jackson"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void getAgeDifferenceInDaysTest() {
        try {
            AddressBook addressBook = AddressBookReader.readAddressBookFromFile("addressbookAgeDifferenceTEST.txt");
            int differenceInDays = AddressBookAnalyzer.ageDifferenceInDaysBetween2Persons("Sarah Stone", "Wes Jackson", addressBook);
            assertTrue(differenceInDays == -37);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
