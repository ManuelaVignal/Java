/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.safeset_es;

import java.util.HashSet;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {

        // nel Main creiamo gli oggetti ed istanze degli oggetti per poterle usare
      
        Oggetto oggetto1 = new Oggetto("a");
        Oggetto oggetto2 = new Oggetto("b");
        Oggetto oggetto3 = new Oggetto("c");
        
        SafeSet lista_oggetti=new SafeSet();
        
        
        System.out.println(oggetto1.toString());
        System.out.println(oggetto2.toString());
        System.out.println(oggetto3.toString());
        

    }
}

        