package it.epicode;

import com.github.javafaker.Faker;
import it.epicode.dao.BiglietteriaDAO;
import it.epicode.dao.TesseraDAO;
import it.epicode.entity.Tessera;
import it.epicode.entity.single_table_classes.Biglietteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;

public class PopolaDB {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        BiglietteriaDAO biglietteriaDAO = new BiglietteriaDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);

        // Popolazione Biglietterie
        for (int i = 0; i < 10; i++) {
            Biglietteria biglietteria = new Biglietteria();
            biglietteriaDAO.create(biglietteria);
        }

        // Popolazione Tessere
        /*for (int i = 0; i < 10; i++) {
            Tessera tessera = new Tessera();
            tessera.setBiglietteria(biglietteriaDAO.findAll().get(faker.random().nextInt(0, 9)));
            tesseraDAO.create(tessera);
        }*/

        em.close();
        emf.close();
    }
}
