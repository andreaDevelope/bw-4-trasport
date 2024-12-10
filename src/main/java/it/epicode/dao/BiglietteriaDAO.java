package it.epicode.dao;


import it.epicode.entity.single_table_classes.Biglietteria;
import it.epicode.interfaces.IBaseDAO;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BiglietteriaDAO implements IBaseDAO<Biglietteria> {
    private final EntityManager em;

    public BiglietteriaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Biglietteria entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public Biglietteria read(Long id) {
        return em.find(Biglietteria.class, id);
    }

    @Override
    public void update(Biglietteria entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Biglietteria entity = read(id);
        if (entity != null) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Biglietteria> findAll() {
        return em.createQuery("SELECT b FROM Biglietteria b", Biglietteria.class).getResultList();
    }
}
