/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matrice;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Ex_collection {
    public static void main(String[] args) {
        int [][] matrice=new int[2][3];
        matrice[0][2]=10;
        System.out.println("rigal colonna3:"  +matrice[0][2]);
        ArrayList<Integer> dinamico = new ArrayList<>();//collezioni di oggetti e non variabili primitive
        dinamico.add(10);
        dinamico.add(20);
        System.out.println(dinamico);
        dinamico.get(0);
    }
    
}
