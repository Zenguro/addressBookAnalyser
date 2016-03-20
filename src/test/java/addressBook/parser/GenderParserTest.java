package addressBook.parser;

import addressBook.models.Gender;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GenderParserTest {
    @Test
    public void parseInvalidGenderStringTest() {
        try {
            GenderParser.parse(null);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void parseValidGenderStringTest() {
        String maleTestString = "mAle";
        String femaleTestString = "fEmAle";
        try {
            Gender parseResult = GenderParser.parse(maleTestString);
            Gender expected = Gender.male;
            assertTrue(parseResult.equals(expected));

            parseResult = GenderParser.parse(femaleTestString);
            expected = Gender.female;
            assertTrue(parseResult.equals(expected));
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
