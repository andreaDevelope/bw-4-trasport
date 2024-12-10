package it.epicode.entity;

import it.epicode.entity.single_table_classes.Mezzo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity

public class Tram extends Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    private List<Tratta> listaTratte=new ArrayList<>();


}
