package ironhack.com;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String generateSerialId () {

        return UUID.randomUUID().toString();
    }

    public static boolean validateName(String name) {
        String regex = "^[A-Za-z\\s]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static class ValidateEmail {

        private static final Pattern EMAIL_PATTERN =
                Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        public static boolean isValidEmail(String email) {
            if (email == null) {
                return false;
            }
            return EMAIL_PATTERN.matcher(email).matches();
        }
    }
}
