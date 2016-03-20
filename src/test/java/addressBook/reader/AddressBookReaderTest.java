package addressBook.reader;

import addressBook.exceptions.AddressBookFileDoesNotExistException;
import addressBook.exceptions.BirthDateInvalidException;
import addressBook.exceptions.GenderInvalidException;
import addressBook.exceptions.PersonStringIncompleteException;
import addressBook.models.AddressBook;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressBookReaderTest {

    @Test
    public void jUnitIsReadyTest() {
        assertTrue(true);
    }

    @Test
    public void addressBookFileExistTest() {
        try {
            AddressBookReader.getAddressBookFileAsInputStream("addressbookValidTest.txt");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void readValidAddressBookFileTest() {
        try {
            AddressBookReader.readAddressBookFromFile("addressbookValidTest.txt");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void readAddressBookFileThatDoesNotExistTest() {
        try {
            AddressBookReader.readAddressBookFromFile("jasdljka");
            assertTrue(false);
        } catch (AddressBookFileDoesNotExistException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void readAddressBookFileWithMissingFieldTest() {
        try {
            AddressBookReader.readAddressBookFromFile("addressbookWithMissingFieldTEST.txt");
            assertTrue(false);
        } catch (PersonStringIncompleteException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
      public void readAddressBookFileWithInvalidGenderTest() {
        try {
            AddressBookReader.readAddressBookFromFile("addressbookGenderInvalidTEST.txt");
            assertTrue(false);
        } catch (GenderInvalidException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void readAddressBookFileWithInvalidBirthDateTest() {
        try {
            AddressBookReader.readAddressBookFromFile("addressbookInvalidBirthDateTEST.txt");
            assertTrue(false);
        } catch (BirthDateInvalidException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }


}
