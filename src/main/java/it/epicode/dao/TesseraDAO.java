package it.epicode.dao;


import it.epicode.entity.Tessera;
import it.epicode.interfaces.IBaseDAO;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TesseraDAO implements IBaseDAO<Tessera> {
    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Tessera entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public Tessera read(Long id) {
        return em.find(Tessera.class, id);
    }

    @Override
    public void update(Tessera entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Tessera entity = read(id);
        if (entity != null) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Tessera> findAll() {
        return em.createQuery("SELECT t FROM Tessera t", Tessera.class).getResultList();
    }
}

