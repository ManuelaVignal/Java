/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.tss.esercizio1_8;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("inserisci il numero da analizzare");
        int x = sc.nextInt();

        int n = 1;
        int sommaDivisori = 0;

        while (n < x) {

            if (x % n == 0) {
                sommaDivisori += n;
            }

            n++;
        }
        if (sommaDivisori == x) {

            System.out.println(x + " il numero è perfetto");
        } else if (sommaDivisori > x) {
            System.out.println(x+ " il numero è abbondante");
        } else {
            System.out.println(x + " il numero è difettivo");
        }

    }

}
