package it.epicode.entity;

import it.epicode.entity.single_table_classes.TitoloViaggio;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "biglietti")
public class Biglietto extends TitoloViaggio {
    @OneToOne(mappedBy = "biglietto")
    private Utente titolareBiglietto;
}
