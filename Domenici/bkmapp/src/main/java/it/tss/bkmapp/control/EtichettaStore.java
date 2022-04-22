/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.control;

import it.tss.bkmapp.entity.Bookmark;
import it.tss.bkmapp.entity.Etichetta;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class EtichettaStore {

    @PersistenceContext
    EntityManager em;

    public List<Etichetta> all() {
        return em.createQuery("select e from Etichetta e order by e.name")
                .getResultList();
    }

    public Etichetta save(Etichetta entity) {
        return em.merge(entity);
    }

    public Etichetta saveIfNotExists(String etichetta) {
        Optional<Etichetta> found = byName(etichetta);
        if (found.isPresent()) {
            return found.get();
        }
        return this.save(new Etichetta(etichetta));
    }

    public Optional<Etichetta> find(Long id) {
        Etichetta found = em.find(Etichetta.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public Optional<Etichetta> byName(String etichetta) {
        try {
            return Optional.of(em.createQuery("select e from Etichetta e where TRIM(LOWER(e.name))= :name", Etichetta.class)
                    .setParameter("name", etichetta.trim().toLowerCase())
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    public Set<Etichetta> byBookmark(Long BookmarkId) {
        return em.createQuery("select e from Bookmark e left join fetch e.etichette where e.id= :id ", Bookmark.class)
                .setParameter("id", BookmarkId)
                .getSingleResult()
                .getEtichette();

    }

}
