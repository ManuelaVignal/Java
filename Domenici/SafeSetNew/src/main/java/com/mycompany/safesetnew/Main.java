/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.safesetnew;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
//creato istanza classe SafeSet
        SafeSet oggetto = new SafeSet();

        System.out.println(oggetto.add("Ciao"));
        System.out.println(oggetto.add("Mondo"));
        System.out.println(oggetto.remove("Ciao"));
        System.out.println(oggetto.contains("Ciao"));
        System.out.println(oggetto.remove("Ciao"));
        System.out.println(oggetto.contains("Ciao"));
       
        
    }
}
