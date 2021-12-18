package cl.equipo11.lenderapp.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String id) {
        super("User with id <" + id + "> wasn't found in DB.");
    }
}
