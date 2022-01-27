/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.array;

import java.util.Random;

/**
 *
 * @author pc
 */
public class MainRicerca {
    
    public static void main(String[] args) {
        
        int[] input = generaArrayCasuale(10,30);
        ArraysTools.stampa(input);
        System.out.println("ricerca 9: " + ArraysTools.ricerca(input, 9));
        System.out.println("MAX: " + ArraysTools.max(input));
        System.out.println("MIN: " + ArraysTools.min(input));
        System.out.println("MEDIA: " + ArraysTools.media(input));
        ArraysTools.ordinamento(input);
        ArraysTools.stampa(input);
        ArraysTools.copia(input);
        ArraysTools.unisci(input,input);
        
    }

    /**
     * 
     * @param ncelle numero di celle dell'array
     * @param max massimo intero contenuto nell'array
     * @return 
     */
    private static int[] generaArrayCasuale(int ncelle, int max) {
        int[] ris = new int[ncelle];
        for (int i = 0; i < ris.length; i++) {
            ris[i] = generaNumeroCasuale(max);
            
            
        }
        return ris;
    }

    private static int generaNumeroCasuale(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
    

}
