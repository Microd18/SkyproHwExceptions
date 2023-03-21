public class WrongPasswordException extends RuntimeException{

    WrongPasswordException(String message) {
        super(message);
    }
}
