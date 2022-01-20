/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodi;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        pTx("ciao");
        pTx("tutto bene...");
        String nome = "Luca";
        String msg = "eccoci arrivati" + nome;
        pTx(msg);
        Persona myperson =new Persona ();// creo persona come lo Scanner
        myperson.saluta();// da definire

        int quanti = (int) chiediNumero("inserisci numero di righe dell'elenco");//versione intera della chiediNumero che restituisce un float

        stampaNumeri(quanti);
        

        float prezzoiva = chiediNumero("inserisci il prezzo");
        float iva = chiediNumero("inserisci iva");
        

        float valore = scorporoIva(prezzoiva, iva);
        String ris = "prezzo scorporato =" + valore;
        pTx(ris);
        
        
        float prezzo = chiediNumero("inserisci il prezzo");
        float sconto = chiediNumero("inserisci lo sconto del prodotto");

        float scontato = scontaPrezzo(prezzo, sconto);
        System.out.println("solo €" + scontato);

        int somma = fareSomma(5, 10);
        System.out.println(somma);

        float risultato_div = fareDivisione(5, 0);
        System.out.println(risultato_div);

    }   // fine del metodo main

    static void pTx(String testo) {

        System.out.println();
        System.out.println(testo);

    }

    static float scorporoIva(float prezzo, float iva) {

        float risultato = 0;

        risultato = (prezzo * 100) / (100 + iva);

        return risultato;
    }

    static float chiediNumero(String testodomanda) {

        float ris = 0;
        String txnumero = JOptionPane.showInputDialog(testodomanda);

        ris = Float.parseFloat(txnumero);// converte una stringa con un numero float "100" in numero intero, int 100

        return ris;
    }

    static float scontaPrezzo(float prezzo, float sconto) {

        float ris = 0;

        /*
                100 e 20
                100 * 20/100--> 20 da togliere
                100 -20 ---> 80 è il prezzo finale
                togliere = prezzo+sconto/100
                finale = prezzo - togliere
        
         */
        ris = prezzo - (prezzo * sconto / 100);

        return ris;

    }

    static int fareSomma(int x, int y) {

        int ris = 0;
        ris = x + y;

        return ris;

    }

    static float fareDivisione(float x, float y) {

        float divisione;

        if (y == 0) {
            divisione = -1999;
        } else {

            divisione = x / y;

        }

        return divisione;

    }

    static void stampaNumeri(int quanti) {

        for (int i = 1; i <= quanti; i++) {

            String inizio = "";

            if (i < 10) {

                inizio = "  ";

            } else if (i < 100) {
                inizio = " ";

            }
            String barra = ")__________________";

            String rigafinale = inizio + i + barra;
            System.out.println(rigafinale);

        }

    }

}
