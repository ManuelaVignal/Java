/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionearticolo;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Mobile implements Articolo {

    private double prezzo;
    private String nome;
    private int larghezza;
    private int altezza;
    private int profondita;

    public Mobile(int larghezza, int altezza, int profondita, double prezzo, String nome) {
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.profondita = profondita;
        this.prezzo = prezzo;
        this.nome = nome;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getProfondita() {
        return profondita;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;

    }

    @Override
    public String toString() {
        return "Mobile{" + "prezzo=" + prezzo + ", nome=" + nome + ", larghezza=" + larghezza + ", altezza=" + altezza + ", profondita=" + profondita + '}';
    }

}
