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
public class Main1_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("inserisci il primo numero");
        int x = sc.nextInt();

        System.out.println("inserisci il secondo numero");
        int y = sc.nextInt();

        int risultato = 1;
        int conta;
        int conta1;

        if (y < 0) {

            System.out.println(" stampa esponente negativo, impossibile proseguire");

        } else if (y == 0) {
            System.out.println(" il risultato è uguale ad 1");
        } else {

            conta = 1;
            
            

            while (conta <= y) {

                conta1 = 1;
                int ris = 0;
  //fare x volte la somma del risultato
                while (conta1 <= x) {

                    ris = ris + risultato;
                    conta1 = conta1 + 1;
                }

                risultato = ris;
                conta = conta + 1;
            }

            System.out.println(" il risultato è :" + risultato);

        }

    }

}
