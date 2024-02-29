package ironhack.com;
import java.util.Scanner;
import java.util.UUID;

public class Utils {

    public static String generateSerialId () {

        return UUID.randomUUID().toString();
    }

    public static int validate_number_of(Scanner scanner){
        boolean is_finish= false;

        do{
            String number_string=scanner.nextLine();
            try{
                int number= Integer.parseInt(number_string);
                return number;
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number");
            }
            is_finish=true;
        }while(is_finish);
        return 0;
    }
}
