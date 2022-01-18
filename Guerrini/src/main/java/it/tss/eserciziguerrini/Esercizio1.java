/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.eserciziguerrini;

/**
 *
 * @author tss
 */
public class Esercizio1 {

    public static void main(String[] args) {

        int myvoto = 9;
        // per essere ammesso almeno 5

        if (myvoto >= 5) {

            System.out.println("AMMESSO");

            //fascia pericolante 5-6
            if (myvoto >= 5 && myvoto <= 6) //no graffe un solo comando
            {
                System.out.println("SEI PERICOLANTE!!");
            } else {
                if (myvoto >= 7 && myvoto <= 8) {
                    System.out.println("DISCRETO!!");
                } else {
                    System.out.println("OTTIMO!!!");
                }
            }

        } else {

            System.out.println("NON AMMESSO");
        }

    }

}
