/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.array;

import java.util.Arrays;

/**
 *
 * @author pc
 */
public class ArraysTools {

    public static void stampa(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array nullo o vuoto");
        }
        for (int i = 0; i < numeri.length; i++) {
            String separatore = (i == numeri.length - 1) ? " " : " , ";
            System.out.print(numeri[i] + separatore);
        }
        System.out.println("");
    }

    public static boolean ricerca(int[] numeri, int n) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array nullo o vuoto");
        }
        boolean trovato = false;
        int i = 0;
        while (i < numeri.length && !trovato) {
            if (numeri[i] == n) {
                trovato = true;
            }
            i++;
        }
        System.out.println(trovato);
        return trovato;
    }

    public static int max(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array nullo o vuoto");
        }
        int massimo = 0;
        for (int i = 0; i < numeri.length; i++) {
            if (numeri[i] > massimo) {
                massimo = numeri[i];
            }
        }
        System.out.println("Il massimo è: " + massimo);
        return massimo;
    }

    public static int min(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array nullo o vuoto");
        }
        int minimo;
        int i = 0;
        minimo = numeri[i];
        for (i = 0; i < numeri.length; i++) {
            if (numeri[i] < minimo) {
                minimo = numeri[i];
            }
        }
        System.out.println("Il minimo è: " + minimo);
        return minimo;

    }

    public static double media(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array nullo o vuoto");
        }
        double ris = 0;
        for (int i = 0; i < numeri.length; i++) {
            ris += numeri[i];
        }
        ris = ris / numeri.length;
        System.out.println("La media dei numeri è: " + ris);
        return ris;
    }

    public static void ordinamento(int[] numeri) {

        boolean ordinato = true;
        do {

            ordinato = true;
            int i = 0;
            while (i < numeri.length - 1) {
                if (numeri[i] > numeri[i + 1]) {
                    int tmp = numeri[i];
                    numeri[i] = numeri[i + 1];
                    numeri[i + 1] = tmp;
                    ordinato = false;
                }

                i = i + 1;

            }

        } while (!ordinato);

    }

    public static int[] copia(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException(" array nullo o vuoto");
        }

        int[] array2 = new int[numeri.length];

        for (int i = 0; i < numeri.length; i++) {

            array2[i] = numeri[i];
        }

        return array2;

    }

    /**
     * ritorna un array contenente l'unione di numeri1 e numeri2
     *
     * @param numeri
     * @param numeri2
     * @return
     */
    public static int[] unisci(int[] numeri, int[] numeri2) {

        int dim1 = numeri.length;
        int dim2 = numeri2.length;
        int dim3 = dim1 + dim2;

        int[] ar3 = new int[dim3];

        for (int i = 0; i < dim1; i++) {
            ar3[i] = numeri[i];

        }
        //inserimento secondo array da ultima posizione del primo array
        for (int i = 0; i < dim2; i++) {
            ar3[i + dim1] = numeri2[i];

        }

        for (int i = 0; i < dim3; i++) {
            System.out.print(ar3[i] + ",");

        }
        System.out.println("");
        return ar3;

    }

    public static boolean contieneValori(int[] numeri, int[] numeri2) {

        boolean ris = true;

        for (int n : numeri2) {
            if (ricerca(numeri, n) == false) {
                ris = false;
                break;

            }

        }
        return ris;

    }

    /**
     * ritorna un array con solo i valori contenuti in entrambi gli array
     *
     * @param numeri
     * @param numeri2
     * @return
     */
    public static int[] intersezione(int[] numeri, int[] numeri2) {

        int[] ris = {};
        for (int n : numeri) {
            if (ricerca(ris, n) == false && ricerca(numeri2, n) == true) {
                int[] tmp = new int[1];
                tmp[0] = n;
                ris = unisci(ris, tmp);

            }

        }

        return ris;
    }

    public static int indexOf(int[] numeri, int n) {
        return indexOf(0, numeri, n);
    }

    //ritorna indice dell'elemento trovato altrimenti -1
    public static int indexOf(int start, int[] numeri, int n) {
       
        for (int idx = start; idx < numeri.length; idx++) {

            if (numeri[idx] == n) {
                return idx;
            }

        }
        return -1;
    }

    public static boolean contieneSequenza(int[] numeri, int[] numeri2) {

        if (numeri2.length == 0) {
            return false;
        }

        if (numeri2.length > numeri.length) {
            return false;
        }
        boolean ris= false;
        int n = numeri2[0];
        int start =indexOf(numeri,n);
        while (start != -1 && !ris){
            
            ris = true;
        
        for (int i=0;i<numeri2.length; i++){
            if (numeri[start+i]!= numeri2[i]){
            break;
            
            }
        }
        
        start = indexOf(start +1,numeri,n);
        
        } 
        return true;
    }
}
