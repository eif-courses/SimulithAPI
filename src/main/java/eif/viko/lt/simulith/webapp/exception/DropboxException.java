package eif.viko.lt.simulith.webapp.exception;

public class DropboxException extends RuntimeException {

    public DropboxException(String message) {
        super(message);
    }

    public DropboxException(String message, Exception cause) {
        super(message, cause);
    }

}