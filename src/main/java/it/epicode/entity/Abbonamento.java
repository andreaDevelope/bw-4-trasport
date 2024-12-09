package it.epicode.entity;

import it.epicode.entity.single_table_classes.TitoloViaggio;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends TitoloViaggio {
}
