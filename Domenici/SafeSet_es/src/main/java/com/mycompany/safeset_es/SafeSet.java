/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.safeset_es;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class SafeSet {

    private  List<Oggetto> oggetti = new ArrayList<>();

    // il metodo add aggiunge un oggetto nell'insieme e 
    // restituendo true se l'elemnto è stato inserito
    public boolean add_Ogg(Oggetto obj) {

        if (oggetti.contains(obj)) {
            return false;

        } else {

            oggetti.add(obj);
            return true;
        }
    }// rimuove un elemento dall'insieme, rimozione definitiva 
    //rimozione definitiva solo dopo seconda chiamatata

    public boolean remove_Ogg(Oggetto obj) {

        if (oggetti.contains(obj)) {
            return false;

        } else {

            oggetti.remove(obj);
            return true;
        }
    }

    //il metodo contains verifica se oggetto è inserito nell'insieme
    public boolean contains_Ogg(Oggetto obj) {

        if (!oggetti.contains(obj)) {
            throw new IllegalArgumentException("l'oggetto non esiste nell'insieme");

        }

        int indice = oggetti.indexOf(obj);
        Oggetto index = oggetti.get(indice);
        index.setStato(true);
        return true;

    }
}