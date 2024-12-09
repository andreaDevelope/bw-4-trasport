package it.epicode.entity;

import it.epicode.entity.single_table_classes.Biglietteria;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RivenditoriAutorizzati extends Biglietteria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


}
