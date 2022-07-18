package it.tss.bkmapp.control;

import it.tss.bkmapp.entity.Author;
import it.tss.bkmapp.entity.Bookmark;
import it.tss.bkmapp.entity.Etichetta;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pc
 */
@Named("bookmarkstore")
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)

public class BookmarkStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    EtichettaStore store;

    public List<Bookmark> all() {
        return em.createQuery("select e from Bookmark e order by e.author",Bookmark.class)
                .getResultList();
    }

    public Optional<Bookmark> find(Long id) {
        Bookmark found = em.find(Bookmark.class, id);
        return found == null ? Optional.empty() : Optional.of(found);

    }

    public List<Bookmark> byAuthor(Author u) {
        return em.createQuery("select e from Bookmark e where e.author=:author", Bookmark.class)
                .setParameter("author", u)
                .getResultList();

    }

    public Bookmark save(Bookmark entity) {
        Bookmark saved = em.merge(entity);
        return saved;
    }
      public Bookmark update(Long id,Bookmark entity) {
          Optional <Bookmark> find_entity=find(id);
          if (find_entity.isPresent()){
              Bookmark bookmark=find_entity.get();
              bookmark.setDescription(entity.getDescription());
              bookmark.setEtichette(entity.getEtichette());
              bookmark.setLink(entity.getLink());
              bookmark.setShared(entity.isShared());
              em.merge(bookmark);
              return bookmark;
              
              
                }else throw new RuntimeException("bookmark non trovato");
          
       
    }

    public void addEtichetta(Bookmark found, String etichetta) {
        Bookmark toupdate = find(found.getId()).get();
        Etichetta saved = store.saveIfNotExists(etichetta);
        toupdate.getEtichette().add(saved);
        save(toupdate);
    }

    public void removeEtichetta(Long id, String etichetta) {
        final Bookmark toupdate = find(id).get();
        Optional<Etichetta> found = store.byName(etichetta);
        if (found.isPresent()) {
            toupdate.getEtichette().remove(found.get());
            save(toupdate);
        }
    }

    public void deletebyAuthor(Author u) {
        byAuthor(u).stream().forEach(this::delete);

    }

    public void delete(Bookmark b) {
        em.remove(em.getReference(Bookmark.class, b.getId()));
    }

}
