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
public class Main1_6 {
    
    public static void main(String[] args) {
        
        
        
        int somma = 0;
        int num;
        
        
 
    boolean ciclo = true;    
        
   while (ciclo){
      
        Scanner LettoreS = new Scanner(System.in); 
        System.out.println("inserisci il numero:  ");
        num = LettoreS.nextInt();
        
        if (num!=0){
        
             somma = somma + num;
             
             
        } else {
            
            ciclo = false;
            
        }
        
    }
    System.out.println ("la somma è : " + somma);
    
    
    }
    
    
}
