package addressBook.exceptions;

public class AddressBookFileDoesNotExistException extends Exception {
    public AddressBookFileDoesNotExistException(String message) {
        super(message);
    }
}
