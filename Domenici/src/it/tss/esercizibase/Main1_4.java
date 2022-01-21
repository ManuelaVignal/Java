/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizibase;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Main1_4 {

    public static void main(String[] args) {

        int x;
        int y;
        int risultato = 1;
        int conta;

        Scanner sc = new Scanner(System.in);

        System.out.println("inserisci la base del numero numero");
        x = sc.nextInt();

        System.out.println("inserisci l'esponente numero");
        y = sc.nextInt();

        if (y < 0) {

            System.out.println(" stampa esponente negativo, impossibile proseguire");

        } else if (y == 0) {
            System.out.println(" il risultato è uguale ad 1");
        } else {

            conta = 1;

            while (conta <= y) {

                risultato = x * risultato;
                conta = conta + 1;

            }
            System.out.println(" il risultato è:" + risultato);
        }

    }

}
