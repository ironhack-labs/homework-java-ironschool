package ironhack.com;


import java.util.Scanner;
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

    public static int validateNumberOf(Scanner scanner){
        boolean is_finish= false;

        do{
            String number_string=scanner.nextLine();
            try{
                int number = Integer.parseInt(number_string);
                if(number >0){
                    return number;
                }
                else{
                    System.out.println("Enter a valid number");
                }
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number");
            }
            is_finish=true;
        }while(is_finish);
        return 0;
    }
    public static double validateDoubleOf(Scanner scanner){
        boolean is_finish= false;

        do{
            String number_string=scanner.nextLine();
            try{
                Double number = Double.parseDouble(number_string);
                if(number >0){
                    return number;
                }
                else{
                    System.out.println("Enter a valid number ex 250.50");
                }
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number");
            }
            is_finish=true;
        }while(is_finish);
        return 0;
    }
    public static String validateEmailOf(Scanner scanner){
        boolean is_finish= false;

        do{
            String email=scanner.nextLine();

                if(!Utils.ValidateEmail.isValidEmail(email)){
                    System.out.println("Enter a valid email@email.com");
                }
                else{
                    return email;
                }

            is_finish=true;
        }while(is_finish);
        return "none";
    }

    public static String validateNameOf(Scanner scanner){
        boolean is_finish= false;

        do{
            String name=scanner.nextLine();

            if(!Utils.validateName(name)){
                System.out.println("Enter a valid name, only Letters allowed");
            }
            else{
                return name;
            }

            is_finish=true;
        }while(is_finish);
        return "none";
    }


}