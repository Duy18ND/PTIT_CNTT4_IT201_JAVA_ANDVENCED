package SESSION01.DEMO.Exception;

public class CheckedException extends Exception {
    int code;

    public CheckedException(String message, int code) {
        super(message);
        this.code = code;
    }
}