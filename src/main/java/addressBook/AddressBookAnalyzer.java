package addressBook;

import addressBook.exceptions.PersonNotFoundException;
import addressBook.models.AddressBook;
import addressBook.models.Gender;
import addressBook.models.Person;
import addressBook.reader.AddressBookReader;
import org.joda.time.Days;

import java.io.*;

public class AddressBookAnalyzer {

    public static void main(String[] args) throws IOException {
        try {
            AddressBook addressBook = AddressBookReader.readAddressBookFromFile("addressbook.txt");
            //1. How many women are in the address book?
            int numberOfFemales = countGender(Gender.female, addressBook);
            System.out.println("1. " + numberOfFemales);

            //2. Who is the oldest person in the address book?
            Person oldestPerson = getOldestPerson(addressBook);
            System.out.println("2. " + oldestPerson.getName());

            //3. How many days older is Bill than Paul?
            int ageDifferenceInDays = ageDifferenceInDaysBetween2Persons("Bill McKnight", "Paul Robinson", addressBook);
            System.out.println("3. " + ageDifferenceInDays);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Person getOldestPerson(AddressBook addressBook) {
        Person oldestPerson = null;

        for (Person person : addressBook.getMapOfPersons().values()) {
            if (oldestPerson == null) {
                oldestPerson = person;
            } else if (person.getBirthDate().isBefore(oldestPerson.getBirthDate())) {
                oldestPerson = person;
            }

        }

        return oldestPerson;
    }

    public static int countGender(Gender gender, AddressBook addressBook) {
        if (addressBook == null || gender == null) {
            return 0;
        } else {
            int count = 0;
            for (Person person : addressBook.getMapOfPersons().values()) {
                if (person.getGender().equals(gender)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static int ageDifferenceInDaysBetween2Persons(String name1, String name2, AddressBook addressBook) throws PersonNotFoundException {
        Person person1 = addressBook.getPersonByName(name1);
        Person person2 = addressBook.getPersonByName(name2);

        return Days.daysBetween(person1.getBirthDate(), person2.getBirthDate()).getDays();
    }
}
