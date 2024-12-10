package it.epicode.entity;

import it.epicode.entity.single_table_classes.TitoloViaggio;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "titolo_viaggio")
    private TitoloViaggio titoloViaggio;

    @OneToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;


}
