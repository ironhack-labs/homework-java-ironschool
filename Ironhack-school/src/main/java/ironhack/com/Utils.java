package ironhack.com;
import java.util.UUID;

public class Utils {

    public String generateSerialId () {
        return UUID.randomUUID().toString();
    }
}
