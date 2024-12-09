package it.epicode.entity;

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
    @JoinColumn(name = "biglietto_id")
    private Biglietto biglietto;

    @OneToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;
}
