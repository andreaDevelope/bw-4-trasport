package it.epicode.entity;

import it.epicode.entity.single_table_classes.Biglietteria;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "biglietteria_id")
    private Biglietteria biglietteria;

    @OneToMany(mappedBy = "tessera", cascade = CascadeType.ALL)
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    @OneToOne(mappedBy = "tessera")
    private Utente titolareTessera;
}
