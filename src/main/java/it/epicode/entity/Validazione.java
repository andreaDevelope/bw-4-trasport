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

    public void validazione(Utente u, Tessera t) throws TesseraException {
        if (t.getAbbonamenti().isEmpty()){
            System.out.println("Devi possedere un titolo di viaggio");
            validato = false;
            System.out.println(validato);
            throw new TesseraException("");
        } else{
            System.out.println("Validazione eseguita");
            validato = true;
            System.out.println(validato);
        }
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
