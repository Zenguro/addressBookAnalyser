package addressBook.parser;

import addressBook.models.Gender;
import addressBook.models.Person;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonParserTest {
    @Test
    public void parseValidPersonStringTest() {
        try {
            String testString = "Some Name, male, 23/11/78";
            Person personParseResult = PersonParser.parse(testString);
            DateTime birthDate = new DateTime(1978, 11, 23, 0, 0);
            Person personExpected = new Person("Some Name", Gender.male, birthDate);

            assertTrue(personParseResult.equals(personExpected));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void parseInvalidPersonStringTest() {
        try {
            PersonParser.parse(null);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
