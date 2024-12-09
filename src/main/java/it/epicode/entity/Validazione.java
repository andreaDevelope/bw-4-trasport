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

    @OneToMany(mappedBy = "validazione", cascade = CascadeType.ALL)
    private List<TitoloViaggio> titoliViagio = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "validazioni_mezzi",
            joinColumns = @JoinColumn(name = "validazione_id"),
            inverseJoinColumns = @JoinColumn(name = "mezzo_id")
    )
    private List<Mezzo> mezzi = new ArrayList<>();
}
