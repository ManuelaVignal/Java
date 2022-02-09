/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oo_blackjack;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Carta carta1 = new Carta(Carta.Seme.CUORI, 10, Carta.Nome.DIECI);
        //System.out.println(carta.toString());
        Carta carta2 = new Carta(Carta.Seme.CUORI, 10, Carta.Nome.DIECI);

        System.out.println(carta1.equals(carta2));

        Mazzo mazzo = new Mazzo();
        //System.out.println(mazzo.toString());

        for (int i = 0; i < 10; i++) {
            Carta pescata = mazzo.pesca();
            System.out.println(pescata.toString());

        }

    }

}
