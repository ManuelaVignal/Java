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
public class Main1_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("inserisci il primo numero");
        int x = sc.nextInt();

        System.out.println("inserisci il secondo numero");
        int y = sc.nextInt();

        int calcola = x;

        int quoziente = 0;
        int resto = 0;

        if (y != 0) {

            while (y <= calcola) {

                quoziente = quoziente + 1;
                calcola = calcola - y;
            }

            resto = calcola;

            System.out.println("resto :" + resto);
            System.out.println("quoziente:" + quoziente);

        } else

        System.out.println("stampa impossibile calcolare la divisione x 0");

    }
}
