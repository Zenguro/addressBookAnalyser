package addressBook.reader;

import addressBook.exceptions.AddressBookFileDoesNotExistException;
import addressBook.models.AddressBook;
import addressBook.models.Person;
import addressBook.parser.PersonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AddressBookReader {

    public static AddressBook readAddressBookFromFile(String addressBookFileName) throws Exception {
        Map<String, Person> mapOfPersons = new HashMap<>();
        InputStream in = getAddressBookFileAsInputStream(addressBookFileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;

        while ((line = reader.readLine()) != null) {
            Person person = PersonParser.parse(line);
            mapOfPersons.put(person.getName(), person);
        }
        reader.close();

        return new AddressBook(mapOfPersons);
    }

    public static InputStream getAddressBookFileAsInputStream(String addressBookFileName) throws AddressBookFileDoesNotExistException {
        InputStream inputStream = null;
        if (addressBookFileName != null && !addressBookFileName.isEmpty()) {
            inputStream = AddressBookReader.class.getClassLoader().getResourceAsStream(addressBookFileName);
        }

        if (inputStream == null) {
            throw new AddressBookFileDoesNotExistException("Could not find address book file with name '" + addressBookFileName + "'");
        }
        return AddressBookReader.class.getClassLoader().getResourceAsStream(addressBookFileName);
    }
}
