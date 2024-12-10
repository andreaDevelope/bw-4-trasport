package it.epicode;

import it.epicode.entity.Utente;
import it.epicode.entity.Validazione;

import java.util.Scanner;

public class AcquistoViaggio {
        static Scanner scanner = new Scanner(System.in);
        static Utente utente = new Utente();

    public static void main(String[] args) {
        System.out.println("Scegli il tuo livello\n1 Amministratore\n2 Utente\n0 Esci");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta){
            case 0:
                System.out.println("Applicazione chiusa");
                break;
            case 1:
                menuAmministratore();
                break;
            case 2:
                menuUtente();
                break;
            default:
                System.out.println("Numero non valido");
        }
    }

    public static void menuAmministratore(){
        Validazione validazione = new Validazione();
        System.out.println("Scegli un operazione:\n1 Valida biglietto");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta){
            case 0:
                System.out.println("Applicazione chiusa");
                break;
            case 1:
                System.out.println(validazione.validazione(utente));
                break;
            default:
                System.out.println("Numero non valido");
        }

    }

    public static void menuUtente(){
        System.out.println("hai scelto il menu utente");
    }
}
