/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.es_prodotto;

/**
 *
 * @author tss
 */
public class Scontrino {

    private String id_prodotto;
    private int quanti;
    private float prezzo_ivato;//prezzo con iva
    private final double ALIQUOTA_IVA = 0.22;

    public Scontrino(String id_prodotto, int quanti, float prezzo_ivato) {
        this.id_prodotto = id_prodotto;
        this.quanti = quanti;
        this.prezzo_ivato = prezzo_ivato;
    }

    public String getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(String id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public int getQuanti() {
        return quanti;
    }

    public void setQuanti(int quanti) {
        this.quanti = quanti;
    }

    public float getPrezzo_ivato() {
        return prezzo_ivato;
    }

    public void setPrezzo_ivato(float prezzo_ivato) {
        this.prezzo_ivato = prezzo_ivato;
    }

    /*public double getPrezzoNetto(double prezzo) {
        return prezzo_ivato / (1 + ALIQUOTA_IVA);
    }*/
    public double getIva(double prezzo) {

        return prezzo * ALIQUOTA_IVA;

    }

    public double getPrezzoLordo(double prezzo) {

        return prezzo + getIva(prezzo);

    }

    String getInfo() {

        String ris = "";
        ris += "-------Scheda scontrino-------";
        ris += "\n Id del prodotto: " + id_prodotto;
        ris += "\nPrezzo Ivato: " + prezzo_ivato;
        ris += "\n quanti: " + quanti;

        return ris;

    }

    String getCSVInfo1() {

        return id_prodotto + ";" + quanti + ";" + prezzo_ivato + "\n";

    }
}
