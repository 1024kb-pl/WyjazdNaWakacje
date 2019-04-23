package exception;

public class PathNotExistException extends RuntimeException {
    public PathNotExistException() {
    }

    public PathNotExistException(String message) {
        super(message);
    }
}
