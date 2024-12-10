package it.epicode.entity;

import it.epicode.entity.single_table_classes.TitoloViaggio;
import it.epicode.exception.TesseraException;
import it.epicode.exception.TesseraUtenteException;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private boolean isAdmin;

    public Utente(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setTessera(Tessera tessera) throws TesseraUtenteException {
        if (tessera == null) {
            throw new TesseraUtenteException("La tessera non può essere null.");
        }
        this.tessera = tessera;
    }

    public Tessera getTessera() {
        return tessera;
    }

    @OneToOne
    @JoinColumn(name = "titolo_viaggio")
    private TitoloViaggio titoloViaggio;

    @OneToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;


}
