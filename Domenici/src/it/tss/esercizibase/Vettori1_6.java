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
public class Vettori1_6 {
    
    public static void main(String[] args) {
        
        
        int somma =0;
        int i = 0;
        int v[]= new int[10];
        int num =1;
        
        
        while (num!=0){
        
          Scanner LettoreS = new Scanner(System.in);
          System.out.println("inserisci il numero:  ");
          num= LettoreS.nextInt();  
           
           v[i]= num;
           somma = somma + num;
           i = i+1;
        
        
        }
        
        System.out.println ("la somma è : " + somma);
    }
    
   
}
