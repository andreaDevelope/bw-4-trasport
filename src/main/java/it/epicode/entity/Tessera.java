package it.epicode.entity;

import it.epicode.entity.single_table_classes.Biglietteria;
import it.epicode.exception.TesseraException;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn
    private LocalDate dataEmissione;

    @JoinColumn
    private LocalDate dataScadenza;

    public List<Abbonamento> getAbbonamenti() throws TesseraException {
        if (abbonamenti.equals(null)) throw new TesseraException("");
            return abbonamenti;
    }

    @ManyToOne
    @JoinColumn(name = "biglietteria_id")
    private Biglietteria biglietteria;

    @OneToMany(mappedBy = "tessera", cascade = CascadeType.ALL)
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    @OneToOne(mappedBy = "tessera")
    private Utente titolareTessera;
}
