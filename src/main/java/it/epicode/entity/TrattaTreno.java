package it.epicode.entity;

import it.epicode.entity.single_table_classes.Tratta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NamedQuery(name = "Trova_tutto_TrattaTreno", query = "SELECT a FROM TrattaTreno a")
public class TrattaTreno extends Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    private List<Treno> listaTreni=new ArrayList<>();


}
