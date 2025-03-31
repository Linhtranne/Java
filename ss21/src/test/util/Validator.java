package test.util;

public class Validator {
    public static boolean isInteger(String str) {
        return str.matches("^-?\\d+$");
    }

    public static boolean isFloat(String str) {
        return str.matches("^-?\\d+\\.\\d+$");
    }

    public static boolean isDouble(String str) {
        return str.matches("^-?\\d+\\.\\d+$");
    }

    public static boolean isBoolean(String str) {
        return str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false");
    }

    public static boolean isString(String str, int min, int max) {
        str = str.trim();
        return !str.isEmpty() && str.length() >= min && str.length() <= max;
    }

    public static boolean isEmail(String str) {
        return str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean isPhone(String str) {
        return str.matches("^0[3|5|7|8|9]\\d{8}$");
    }
}