package addressBook.parser;

import addressBook.exceptions.BirthDateInvalidException;
import addressBook.exceptions.GenderInvalidException;
import addressBook.exceptions.PersonStringIncompleteException;
import addressBook.models.Gender;
import addressBook.models.Person;
import org.joda.time.DateTime;

public class PersonParser {
    public static Person parse(String personAsString) throws GenderInvalidException, PersonStringIncompleteException, BirthDateInvalidException {
        String[] personAsStringComponents = personAsString.split(",");
        if (personAsStringComponents.length < 3) {
            throw new PersonStringIncompleteException("Something is missing: \"Name, Gender, Birth Date\" expected");
        }

        String name = personAsStringComponents[0].trim();
        String genderString = personAsStringComponents[1].trim();
        Gender gender = GenderParser.parse(genderString);
        String birthDateString = personAsStringComponents[2].trim();
        DateTime birthDate = BirthDateParser.parse(birthDateString);
        return new Person(name, gender, birthDate);
    }
}
