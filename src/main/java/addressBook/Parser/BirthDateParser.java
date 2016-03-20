package addressBook.parser;

import addressBook.exceptions.BirthDateInvalidException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthDateParser {

    private static final String  patternRegex = "\\d{2}/\\d{2}/\\d{2}";

    public static DateTime parse(String birthDateString) throws BirthDateInvalidException {
        String pattern = "dd/MM/yy";
        try {
            if (!birthDateMatchesPattern(birthDateString)) {
                throw new Exception();
            }
            DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
            return formatter.parseDateTime(birthDateString);
        } catch (Exception e) {
            throw new BirthDateInvalidException("\"" + birthDateString + "\" is no valid birth date. Expected format is \""+pattern+"\"");
        }
    }

    public static boolean birthDateMatchesPattern(String birthDate) {
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(birthDate);

        return matcher.matches();
    }
}
