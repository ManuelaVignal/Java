/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it.tss.oo_dado;

import java.util.Random;

/**
 *
 * @author tss
 */
public class Dado {
    private final int numeroFacce;//un valore non può mai eessere modificato
    private int ultimoLancio;

    public Dado(int nFacce) {
        this.numeroFacce = nFacce;
    }
    
    public void lancia(){
    
    Random rnd = new Random();
    ultimoLancio= rnd.nextInt(numeroFacce -1) +1;
    }

    public int getNumeroFacce() {
        return numeroFacce;
    }

    public int getUltimoLancio() {
        return ultimoLancio;
    }
    
    
    
    
    
    
}
