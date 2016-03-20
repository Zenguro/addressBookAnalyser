package addressBook.parser;

import addressBook.exceptions.GenderInvalidException;
import addressBook.models.Gender;

public class GenderParser {
    public static Gender parse(String genderString) throws GenderInvalidException {
        if (genderString.toLowerCase().equals(Gender.female.name())) {
            return Gender.female;
        } else if (genderString.toLowerCase().equals(Gender.male.name())) {
            return Gender.male;
        } else {
            throw new GenderInvalidException("'"+genderString+"' is no valid gender.");
        }
    }
}
