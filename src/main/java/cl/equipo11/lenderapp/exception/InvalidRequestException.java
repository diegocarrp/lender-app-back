package cl.equipo11.lenderapp.exception;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException() {
        super("Request was invalid");
    }
}
