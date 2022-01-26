/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.array;

/**
 *
 * @author tss
 */
//Main principale
public class ArraysTools {

    public static void stampa(int[] numeri) {
        for (int i = 0; i < numeri.length; i++) {
            System.out.print(numeri[i] + ",");
        }
        System.out.println("");
    }

    public static boolean ricerca(int[] numeri, int n) {

        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array vuoto");
        }

        boolean trovato = false;
        int i = 0;

        while (numeri[i] < numeri.length && !trovato) {

            if (numeri[i] == n) {
                trovato = true;
                i++;

            }
        }
        System.out.println(trovato);
        return trovato;

    }

    public static int max(int[] numeri) {
        int max = 0;

        for (int i = 0; i < numeri.length; i++) {
            if (numeri[i] > max) {
                max = numeri[i];
            }
        }

        return max;
        
    }

    public static int min(int[] numeri) {

        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array vuoto");
        }

        int min = numeri[0];
        int indice = 1;

        while (indice < numeri.length) {

            if (numeri[indice] < min) {
                min = numeri[indice];

            }
            indice = indice + 1;

        }
        return min;

    }

    public static int somma(int[] numeri) {

        int ris = 0;
        for (int i = 0; i < numeri.length; i++) {

            ris = numeri[i] + ris;

        }
        return ris;
    }

    public static int media(int[] numeri) {

        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array vuoto");

        }
        return (double) somma(numeri) / numeri.length;
    

        
    }
    
}

public static ordina(int [] numeri){

   //ordina bubble sort

boolean ordinato =true;
int z=0;

do {

     
      int indice = 0;

        while (indice < numeri.legth -1){

          if (numeri[indice]> numeri[indice +1]) {
   
            z = numeri[indice];
             numeri [indice]=numeri [indice+1];
             numeri[indice+1]=z;
    
             ordinato = false;

}
indice = indice +1;

}
while (!ordinato);


}

