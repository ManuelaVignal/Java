package it.tss.jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        //istruzioni di connessione al data base e crea oggetto em per connettersi al data base dbscuola
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbscuola");
        EntityManager em = emf.createEntityManager();

        em.createNamedQuery("select e from Corso e ", Corso.class)
                .getResultList()
                .forEach(System.out::println);

        Corso tosave = new Corso();
        tosave.setTitolo("jakarta EE");
        tosave.setInizio(LocalDate.now());
        tosave.setCosto(BigDecimal.valueOf(120, 50));
        tosave.setDurata(120);
        tosave.setDescrizione("applicazioni web con jakarta EE");
        tosave.setCreatoil(LocalDate.now());

        em.getTransaction().begin();
        em.persist(tosave);
        em.getTransaction().commit();
    }

}
