/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it.tss.oo_dado;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class MainDadiSoldi {
    
   static int soldi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci i soldi");
         int contaMani = 1;
        soldi = sc.nextInt();
        while (soldi > 0) {

            gioca(contaMani);
            contaMani++;
        }

    }

    private static void gioca(int numMano ) {
        int dg = lanciaDado();
        int db = lanciaDado();
        System.out.println(String.format("mano numero %s banco=%s giocatore=%s", numMano,db,dg));
        if(dg>db){
          soldi++;
          System.out.println("mano vinta dal giocatore" + soldi);
        }else {
        
        soldi--;
        System.out.println("mano vinta dal banco");
        }
    
    }
    
  private static int lanciaDado() {
         Random rnd = new Random();
         return rnd.nextInt(5)+1;
         
}

}
