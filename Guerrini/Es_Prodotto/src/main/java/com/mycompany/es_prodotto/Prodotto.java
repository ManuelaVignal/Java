/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.es_prodotto;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Prodotto {

    private String nome_prodotto;
    private String id_prodotto;
    private float prezzo;

    public Prodotto(String nome_prodotto, String id_prodotto, float prezzo) {
        this.nome_prodotto = nome_prodotto;
        this.id_prodotto = id_prodotto;
        this.prezzo = prezzo;
    }

    public String getNome_prodotto() {
        return nome_prodotto;
    }

    public void setNome_prodotto(String nome_prodotto) {
        this.nome_prodotto = nome_prodotto;
    }

    public String getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(String id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "nome_prodotto=" + nome_prodotto + ", id_prodotto=" + id_prodotto + ", prezzo=" + prezzo + '}';
    }

    String getInfo() {

        String ris = "";
        ris += "-------Scheda prodotto-------";
        ris += "\nNome del prodotto: " + nome_prodotto;
        ris += "\nPrezzo del prodotto: " + prezzo;
        ris += "\nId del prodotto: " + id_prodotto;

        return ris;

    }

    String getCSVInfo() {

        return nome_prodotto + ";" + id_prodotto + ";" + prezzo + "\n";

    }

    void stampaInfo() {

        System.out.println("\n\n-------Scheda corso-------");
        System.out.println("Nome del prodotto: " + nome_prodotto);
        System.out.println("Prezzo del prodotto: " + prezzo);
        System.out.println("Id del prodotto: " + id_prodotto);

        //stampaRegistro();
        System.out.println("--------------------------\n\n");
    }
}
