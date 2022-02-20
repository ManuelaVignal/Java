/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.safeset_es;

import java.util.Objects;

/**
 *
 * @author pc
 */
public class Oggetto {

    //Attributi dell'oggetto
    private final String nome;
    private boolean stato;
    private int indice;

// cotruttore della classe Oggetto
    public Oggetto(String nome) {
        this.nome = nome;

    }

    //metodi oggetto-get-set-tostring-hash code ed equals...
    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNome() {
        return nome;
    }

    public boolean isStato() {
        return stato;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return "Oggetto{" + "nome=" + nome + ", stato=" + stato + ", indice=" + indice + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oggetto other = (Oggetto) obj;
        return Objects.equals(this.nome, other.nome);
    }

 
    

}
