/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.eserciziguerrini;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Esercizio1 {

    //calcolo green pass 
    
    public static void main(String[] args) {
    
        int myvoto;
        // per essere ammesso almeno 5
        
        String vototx = JOptionPane.showInputDialog("inserisci la media dei voti");
        // converto in intero la stringa vototx
        boolean lode = 
                
                 vototx.equalsIgnoreCase("10 e lode") //lode diventa true se è vero
                || 
                   vototx.equalsIgnoreCase("10 con lode")
                || 
                   vototx.equalsIgnoreCase("10 lode")
        
        ;
        
        if(!lode)
            myvoto = Integer.parseInt(vototx);//analizzattore sintattico parseInt, converte la frase in intero
        else
            myvoto=10;
        
        boolean  outofrange= (myvoto< 0 || myvoto>10);//outofrange è o true o false
        
        if (outofrange){ // if (!(myvoto >= 0 && myvoto <= 10));
            
        
             System.out.println("NUMERO NON COMPRESO NEL RANGE");
             return;
             
        }
        
        
        else {

           if (myvoto >= 5 && !outofrange) {

            System.out.println("AMMESSO");

            //fascia pericolante 5-6
            if (myvoto >= 5 && myvoto <= 6) //no graffe un solo comando
            {
                System.out.println("SEI PERICOLANTE!!");
            } else {
                if (myvoto >= 7 && myvoto <= 8) {
                    System.out.println("DISCRETO!!");
                } else {
                    
                
                    System.out.println("OTTIMO!!!");
                    if(lode) System.out.println("CON LODE");
                }
            }
            
           
            

        }else{

            System.out.println("NON AMMESSO");
        }

    
    }


        
        