/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.control;

import it.tss.blogapp.entity.Comment;
import it.tss.blogapp.entity.Post;
import it.tss.blogapp.entity.Tag;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tss
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CommentStore {
    
      @PersistenceContext
    EntityManager em;

    //metodo che ritorna tutti gli utenti
    public List<Comment> all() {
        return em.createQuery("select e from Comment e order by e.author").getResultList();

    }

    public Optional<Comment> find(Long id) {
        Comment found = em.find(Comment.class, id);
        return found == null ? Optional.empty() : Optional.of(found);

    }

    public Comment save(Comment entity) {
        return em.merge(entity);

    }

    public void delete(Long id) {
        em.remove(em.getReference(Comment.class, id));
    }
}
