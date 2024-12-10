package it.epicode.entity.single_table_classes;

import it.epicode.entity.ParcoMezzi;
import it.epicode.entity.Tratta;
import it.epicode.entity.Validazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "mezzi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parco_mezzi_id")
    private ParcoMezzi rimessa;

    @ManyToMany(mappedBy = "mezzi")
    private List<Validazione> validazioni = new ArrayList<>();


    @OneToMany(mappedBy = "mezzi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratta> listaTratte;
}
