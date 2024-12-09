package it.epicode.entity.single_table_classes;

import it.epicode.entity.Validazione;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TitoloViaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Validazione validazione;

    @ManyToOne
    private Biglietteria biglietteria;



}
