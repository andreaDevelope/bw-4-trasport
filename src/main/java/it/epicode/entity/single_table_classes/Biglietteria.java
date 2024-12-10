package it.epicode.entity.single_table_classes;

import it.epicode.entity.Tessera;
import it.epicode.entity.Utente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "biglietterie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Biglietteria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public void acquistaTessera(Utente u, Biglietteria b){
        LocalDate dataEmissione = LocalDate.now();
        LocalDate dataScadenza = dataEmissione.plusYears(1);

        Tessera tessera = new Tessera(null, dataEmissione, dataScadenza, b, u.getTessera().getAbbonamenti(), u);
    }

    @OneToMany(mappedBy = "biglietteria", cascade = CascadeType.ALL)
    private List<TitoloViaggio> titoliViaggio = new ArrayList<>();
}
