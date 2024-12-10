package it.epicode.entity.single_table_classes;

import it.epicode.entity.Utente;
import it.epicode.entity.Validazione;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "titoli_viaggio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TitoloViaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "validazione_id")
    private Validazione validazione;

    @ManyToOne
    @JoinColumn(name = "biglietteria_id")
    private Biglietteria biglietteria;

    @OneToOne(mappedBy = "titoloViaggio")
    private Utente titolareBiglietto;


}
