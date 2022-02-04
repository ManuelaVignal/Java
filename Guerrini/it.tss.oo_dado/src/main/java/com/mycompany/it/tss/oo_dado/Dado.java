/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it.tss.oo_dado;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author tss
 */
public class Dado {

    private final int numeroFacce;//un valore non può mai eessere modificato
    private int ultimoLancio;
    private ArrayList<Integer> storia = new ArrayList<>();//array dinamico

    public Dado(int nFacce) {
        this.numeroFacce = nFacce;
    }

    public void lancia() {

        Random rnd = new Random();
        ultimoLancio = rnd.nextInt(numeroFacce - 1) + 1;
        storia.add(ultimoLancio);//tiene traccia/storia in un array di tutti i laci fatti dal dado
    }

    public int getNumeroFacce() {
        return numeroFacce;
    }

    public int getUltimoLancio() {
        return ultimoLancio;
    }

    //questo metodo restituisce un arrai di interi con la storia del lancio del dado
    public ArrayList<Integer> getStoria() {
        return new ArrayList<>(storia);//creo una copia altrimenti cambia valore
    }

}
