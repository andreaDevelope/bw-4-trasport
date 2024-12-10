package it.epicode;

import it.epicode.entity.*;
import it.epicode.entity.single_table_classes.Biglietteria;
import it.epicode.exception.TesseraException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AcquistoViaggio {
    static Scanner scanner = new Scanner(System.in);
    static Utente utente = new Utente(false);
    static Biglietteria biglietteria = new Biglietteria();

    public static void main(String[] args) throws TesseraException {
        System.out.println("Scegli il tuo livello\n1 Amministratore\n2 Utente\n3 Acquista tessera\n0 Esci");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 0:
                System.out.println("Applicazione chiusa");
                break;
            case 1:
                menuAmministratore();
                break;
            case 2:
                menuUtente();
                break;
            case 3:
                acquistoTessera();
                break;
            default:
                System.out.println("Numero non valido");
        }
    }

    public static void menuAmministratore() throws TesseraException {
        // Inizializza l'utente con una tessera e un abbonamento
        LocalDate dataEmissione = LocalDate.now();
        LocalDate dataScadenza = dataEmissione.plusYears(1);
        Tessera tessera = new Tessera(null, dataEmissione, dataScadenza, biglietteria, utente.getTessera().getAbbonamenti(), utente);
        tessera.setAbbonamenti(List.of(new Abbonamento())); // Aggiungi un abbonamento
        utente.setAdmin(true);
        tessera.setTitolareTessera(utente);

        Validazione validazione = new Validazione();
        System.out.println("Scegli un operazione:\n1 Valida biglietto");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        try {
            switch (scelta) {
                case 0:
                    System.out.println("Applicazione chiusa");
                    break;
                case 1:
                    validazione.validazione(utente);
                    break;
                default:
                    System.out.println("Numero non valido");
            }
        } catch (TesseraException e) {
            System.out.println(e);
        }
    }


    public static void menuUtente() {
        System.out.println("hai scelto il menu utente");
        utente.setAdmin(false);
    }

    public static void acquistoTessera() throws TesseraException {
        try {
            Biglietteria biglietteria = new Biglietteria();
            biglietteria.acquistaTessera(utente, biglietteria); // Questo potrebbe lanciare una TesseraException
        } catch (TesseraException e) {
            System.out.println("Errore nell'acquisto della tessera: " + e.getMessage());
        }
    }
}
