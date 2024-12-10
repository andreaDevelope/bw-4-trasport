package it.epicode.entity;

import it.epicode.entity.single_table_classes.Mezzo;
import it.epicode.entity.single_table_classes.TitoloViaggio;
import it.epicode.exception.TesseraException;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "validazioni")
public class Validazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private boolean validato;

    public boolean validazione(Utente u) {
        if (u.getTessera() == null) {
            System.out.println("L'utente non possiede una tessera.");
            return false;
        }

        Tessera tessera = u.getTessera();

        // Verifica se l'utente ha abbonamenti
        if (tessera.getAbbonamenti() == null || tessera.getAbbonamenti().isEmpty()) {
            System.out.println("La tessera non contiene abbonamenti validi.");
            return false;
        }

        // Se il titolo di viaggio non è valido
        if (u.getTitoloViaggio() == null || u.getTitoloViaggio().getBiglietto() == null) {
            System.out.println("Devi possedere un titolo di viaggio.");
            return false;
        }

        System.out.println("Validazione eseguita.");
        return true;
    }

    @OneToMany(mappedBy = "validazione", cascade = CascadeType.ALL)
    private List<TitoloViaggio> titoliViaggio = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "validazioni_mezzi",
            joinColumns = @JoinColumn(name = "validazione_id"),
            inverseJoinColumns = @JoinColumn(name = "mezzo_id")
    )
    private List<Mezzo> mezzi = new ArrayList<>();
}
