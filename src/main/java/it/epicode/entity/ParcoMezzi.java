package it.epicode.entity;

import it.epicode.entity.single_table_classes.Mezzo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "parchi_mezzi")
public class ParcoMezzi {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "rimessa", cascade = CascadeType.ALL)
    private List<Mezzo> mezzi = new ArrayList<>();
}
