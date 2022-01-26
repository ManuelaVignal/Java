/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.array;

import java.util.Random;

/**
 *
 * @author tss
 */

//cercare un numero dentrun array
public class Ricerca_array {
    

        
        public static void main(String[] args) {

        //int[] input = {12,34,56,3,57,3,5,6,67,45};
        int[]input = generaArrayCasuale(10,10);
        ArraysTools.stampa(input);
        System.out.println (ArraysTools.max(input));
        
        ArraysTools.min(input);
        ArraysTools.ricerca(input,0);
        ArraysTools.somma(input);
        

    }
//n celle -->numero celle array e max è il massimo intero contenuto nell'array

    private static int[] generaArrayCasuale(int ncelle, int max) {

        int[] ris = new int[ncelle];
        for (int i = 0; i < ris.length; i++) {
        ris[i] = generaNumeroCasuale(max);

        }
        return ris;
    }
 //procedura per generare numero casuale
    
    private static int generaNumeroCasuale(int max) {
        Random random = new Random();
      return random.nextInt(max);
    }
    
    
    
    
}
