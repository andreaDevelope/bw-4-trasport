package it.epicode.entity;

import it.epicode.entity.single_table_classes.TitoloViaggio;
import it.epicode.enums.TipoAbbonamento;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends TitoloViaggio {
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipoAbbonamento;

    @ManyToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;
}
