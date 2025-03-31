package Ex8;
public class InvalidPhoneNumberLengthException extends Exception {

    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Invalid length: " + phone);
        }
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberLengthException("Contains invalid characters: " + phone);
        }
    }
}