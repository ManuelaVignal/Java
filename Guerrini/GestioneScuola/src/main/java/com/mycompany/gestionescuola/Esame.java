/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

import java.time.LocalDate;



/**
 *
 * Dichiarazione classe Esame
 */
public class Esame {

    //attributi
    
    private String docente;
    private LocalDate data;
    private int voto;
    private String materia;
    private String note;

    
    // dichiarazione costruttore
    
    public Esame(String docente, int voto, String materia) {
        
        this.docente = docente;
        this.voto = voto;
        this.materia = materia;
        data = LocalDate.now();//data ufficiale di registrazione esame
    }

    public String getDocente() {
        return docente;
    }

    public LocalDate getData() {
        return data;
    }

    public int getVoto() {
        return voto;
    }

    public String getMateria() {
        return materia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    

}
