/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionelibreria;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        Book a = new Book("Manuela");
        Book s = new Book("Sandra");
        Book m = new Book("Bettina");
        Book c = new Book("Carlo");

        Biblioteca b = new Biblioteca();

        b.addBook(a);
        b.addBook(s);
        b.addBook(m);
        b.addBook(c);

        b.addBook(a);
      
     
    }

}
