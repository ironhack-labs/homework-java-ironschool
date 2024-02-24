package ironhack.com;
import java.util.UUID;

public class Utils {

    public static String generateSerialId () {

        return UUID.randomUUID().toString();
    }
}
