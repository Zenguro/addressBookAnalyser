package addressBook.models;

import addressBook.exceptions.PersonNotFoundException;

import java.util.Map;

public class AddressBook {
    private Map<String, Person> mapOfPersons;

    public AddressBook() {
    }

    public AddressBook(Map<String, Person> mapOfPersons) {
        this.mapOfPersons = mapOfPersons;
    }

    public Person getPersonByName(String name) throws PersonNotFoundException {
        Person person = mapOfPersons.get(name);
        if (person == null) {
            throw new PersonNotFoundException("Person with name \""+name+"\" was not in the address book.");
        } else {
            return person;
        }
    }

    public Map<String, Person> getMapOfPersons() {
        return mapOfPersons;
    }
}
