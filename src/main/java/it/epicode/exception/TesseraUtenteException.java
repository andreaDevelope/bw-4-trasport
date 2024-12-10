package it.epicode.exception;

public class TesseraUtenteException extends RuntimeException {
    public TesseraUtenteException(String message) {
        super("Non possiedi ancora una tessera");
    }
}
