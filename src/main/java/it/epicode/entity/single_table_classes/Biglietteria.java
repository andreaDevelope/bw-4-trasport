package it.epicode.entity.single_table_classes;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(mappedBy = "biglietteria", cascade = CascadeType.ALL)
    private List<TitoloViaggio> titoliViaggio = new ArrayList<>();
}
