/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it.tss.oo_dado;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        //CREO OGGETTO GIOCATORE E DADO NEL MAIN
        
        Giocatore g = new Giocatore(10,15,5);
        Dado dadoG = new Dado(6);
        Dado dadoB = new Dado(6);
        int conta = 1;
        do {
            dadoG.lancia();
            dadoB.lancia();
            stampaMano(conta, dadoG.getUltimoLancio(), dadoB.getUltimoLancio());
            if (dadoG.getUltimoLancio() > dadoB.getUltimoLancio()) {
                g.incrementaSoldi();
                stampaGiocatore(g.getSoldi());

            } else {
                g.decrementaSoldi();
                stampaGiocatore(g.getSoldi());
            }
            conta ++;
        } while (g.isContinua());
    
   
    }

    private static void stampaMano(int conta, int lancioG, int lancioB) {
        String msg = String.format("mano numero %s banco=%s giocatore=%s", conta,lancioG,lancioB);
        System.out.println(msg);
    }

    private static void stampaGiocatore(int soldi) {
        System.out.println("soldi giocatoere:" + soldi);
    }


    
}
