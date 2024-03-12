package utils;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isAddressValid(String address) {
        return patternMatches(address, "^(?![0-9])[\\p{L}0-9 .,'-]+$");
    }

    public static boolean isNameValid(String name) {
        return validate(name, "^(?!-)[\\p{L} .'-]+$", String.format("Invalid name: %s", name));
    }

    public static boolean isPositiveNumberValid(String number, int maxNumber) {
        return maxNumber == 0 ?
                validate(number, "^[1-9]\\d*$", String.format("The value %s is not valid", number)) :
                validate(number, "^(?:[1-9]|" + maxNumber + ")$", String.format("The valid range is from 1 to %s", maxNumber));
    }

    public static boolean isPositiveDecimalNumberValid(String decimalNumber) {
        return validate(decimalNumber, "^(?:0*[1-9]\\d*(?:\\.\\d+)?|0*0\\.\\d*[1-9]\\d*)$", String.format("The value %s is not valid", decimalNumber));
    }

    public static boolean isEmailValid(String email) {
        return validate(email, "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", String.format("Invalid email: %s", email));
    }

    private static boolean validate(String name, String pattern, String errorMessage) {
        boolean isValidName = patternMatches(name, pattern);
        if (!isValidName) {
            System.err.println(errorMessage);
        }
        return isValidName;
    }

    private static boolean patternMatches(String inputString, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(inputString)
                .matches();
    }
}
