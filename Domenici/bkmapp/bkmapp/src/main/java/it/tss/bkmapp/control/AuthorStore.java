/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.bkmapp.control;


import it.tss.bkmapp.boundary.Credential;
import it.tss.bkmapp.entity.Author;
import it.tss.bkmapp.entity.SecurityEncoding;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */
@Named("authorstore")
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class AuthorStore {

    @PersistenceContext
    EntityManager em;

    @Inject
    BookmarkStore store;

    /**
     * restituisce tutti gli utenti presenti nel database
     *
     * @return lista oggetti User
     */
    public List<Author> all() {
        return em.createQuery("select e from Author e order by e.lastName", Author.class)
                .getResultList();
    }

    /**
     * restituisce tutti gli utenti presenti nel database in modo paginato
     *
     * @param page numero di pagina
     * @param size dimensioni pagina
     * @return lista oggetti User
     */
    public List<Author> allPaginated(int page, int size) {
        return em.createQuery("select e from Author e order by e.lastName", Author.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public Optional<Author> find(Long id) {
       Author found = em.find(Author.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public Author create(Author entity) {
        entity.setPwd(SecurityEncoding.shaHash(entity.getPwd()));
        return save(entity);
    }

    public Author save(Author entity) {
        Author saved = em.merge(entity);
        return saved;
    }

    public void delete(Author u) {
        store.deletebyAuthor(u);
        em.remove(em.getReference(Author.class, u.getId()));
    }

    public Optional<Author> login(Credential credential) {
        try {
            return Optional.of(em.createQuery("select e from Author e where e.email= :usr and e.pwd= :pwd", Author.class)
                    .setParameter("usr", credential.usr)
                    .setParameter("pwd", SecurityEncoding.shaHash(credential.pwd))
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }   
    }
}
