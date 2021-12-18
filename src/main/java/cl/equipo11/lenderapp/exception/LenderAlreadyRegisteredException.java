package cl.equipo11.lenderapp.exception;

public class LenderAlreadyRegisteredException extends RuntimeException{
    public LenderAlreadyRegisteredException(String rut) {
        super("Lender with RUT <" + rut + "> is already registered");
    }
}
