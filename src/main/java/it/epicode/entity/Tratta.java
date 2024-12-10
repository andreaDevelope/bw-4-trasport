package it.epicode.entity;

import it.epicode.entity.single_table_classes.Mezzo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tratte")
public class Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "zona_partenza")
    private String zonaPartenza;

    @Column(name = "zona_arrivo")
    private String zonaArrivo;

    @Column(name = "tempo_previsto")
    private int tempoPrevisto; // Tempo di percorrenza previsto

    @Column(name = "tempo_previsto")
    private int tempoEffettivo;

    @ManyToMany
    @JoinTable(
            name = "tratte_mezzi",
            joinColumns = @JoinColumn(name = "tratta_id"),
            inverseJoinColumns = @JoinColumn(name = "mezzo_id")
    )
    private List<Mezzo> mezzi = new ArrayList<>();


}
