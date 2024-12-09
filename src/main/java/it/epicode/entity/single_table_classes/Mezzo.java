package it.epicode.entity.single_table_classes;

import it.epicode.entity.ParcoMezzi;
import it.epicode.entity.Validazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mezzo {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private ParcoMezzi rimessa;

    @ManyToMany
    private List<Validazione> validazioni = new ArrayList<>();
}
