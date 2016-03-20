package addressBook.parser;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class BirthDateParserTest {
    int currentYear;
    //joda time has a threshold for ambivalent short year notation
    //example: if current year is 2016, than a string with
    // a year notation of
    // 35 will parsed to 2035 but
    // 36 will be parsed to 1936
    int threshold = 20;

    @Before
    public void init() {
        currentYear = DateTime.now().getYear();
    }

    @Test
    public void parseValidBirthDateStringTest() {
        try {
            int testYear = currentYear+threshold;
            int testYearShort = testYear%100;
            String testString = "23/11/"+testYearShort;

            DateTime birthdayParseResult = BirthDateParser.parse(testString);
            DateTime expected = new DateTime(testYear-100, 11, 23, 0, 0);
            assertTrue(expected.equals(birthdayParseResult));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void parseValidAmbivalentBirthDateStringTest() {
        try {
            int testYear = currentYear+threshold-1;
            int testYearShort = testYear%100;
            String testString = "23/11/"+testYearShort;

            DateTime birthdayParseResult = BirthDateParser.parse(testString);
            DateTime expected = new DateTime(testYear, 11, 23, 0, 0);
            assertTrue(expected.equals(birthdayParseResult));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void birthDatePatternStrictnessTest() {
        //Pure joda time parsing of the pattern "dd/MM/yy" is not strict enough.
        //example: the year 7 will get parsed to a DateTime object with year "0007".
        String testString = "23/12/7";

        try {
            BirthDateParser.parse(testString);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}
