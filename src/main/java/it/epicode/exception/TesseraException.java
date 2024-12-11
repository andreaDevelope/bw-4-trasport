package it.epicode.exception;

public class TesseraException extends RuntimeException {
  public TesseraException(String message) {
    super("Operazione non valida, devi prima acquistare una tessera");

  }
}
