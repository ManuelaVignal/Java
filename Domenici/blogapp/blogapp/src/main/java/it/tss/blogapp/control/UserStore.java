/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.blogapp.control;

import it.tss.blogapp.entity.User;
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
public class UserStore {

    //metodi che interagiscono con il data base e ci vuole EntityManager
    //connessione data base gestita da wildfly, basta scrivere una annotazione per connettersi al data base
    @PersistenceContext
    EntityManager em;

    //metodo che ritorna tutti gli utenti
    public List<User> all() {
        return em.createQuery("select e from User e order by e.lastName").getResultList();

    }

    public Optional<User> find(Long id) {
        User found = em.find(User.class, id);
        return found == null ? Optional.empty() : Optional.of(found);

    }

    public User save(User entity) {
        return em.merge(entity);

    }

}
