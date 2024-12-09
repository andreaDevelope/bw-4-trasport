package it.epicode.entity;

import it.epicode.entity.single_table_classes.Mezzo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NamedQuery(name = "Trova_tutto_Treno", query = "SELECT a FROM Treno a")
public class Tram extends Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    private List<TrattaTram> listaTratteTreno=new ArrayList<>();


}
