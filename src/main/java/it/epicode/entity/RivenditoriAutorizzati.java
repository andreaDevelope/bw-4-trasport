package it.epicode.entity;

import it.epicode.entity.single_table_classes.Biglietteria;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rivenditori_autorizzati")
public class RivenditoriAutorizzati extends Biglietteria {
}
