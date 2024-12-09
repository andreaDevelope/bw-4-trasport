package it.epicode.entity;

import it.epicode.entity.single_table_classes.Tratta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tratte_autobus")
public class TrattaAutobus extends Tratta {
    @ManyToMany
    @JoinTable(
            name = "tratte_autobus_autobus",
            joinColumns = @JoinColumn(name = "tratta_autobus_id"),
            inverseJoinColumns = @JoinColumn(name = "autobus_id")
    )
    private List<Autobus> listaAutobus = new ArrayList<>();
}
