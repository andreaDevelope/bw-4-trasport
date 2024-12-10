package it.epicode.entity;

import it.epicode.entity.single_table_classes.Mezzo;
import it.epicode.entity.single_table_classes.TitoloViaggio;
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

    public boolean validazione(Utente u){
        if (u.getTessera().getAbbonamenti().equals(null) || u.getTitoloViaggio().getBiglietto().equals(null)){
            System.out.println("Devi possedere un titolo di viaggio");
            return false;
        } else{
            System.out.println("Validazione eseguita");
            return true;
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
