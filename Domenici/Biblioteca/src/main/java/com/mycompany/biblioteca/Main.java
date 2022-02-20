/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        //creiamo le istanze di una classe, creiamo gli oggetti stampini 
        // arrivano dalla stessa madre Book ma sono oggetti diversi
        //metto il titolo che è diverso, ho inserito 3 libri diversi della stessa classe
        Book libro1 = new Book("Carlo");
        Book libro2 = new Book("Sandra");
        Book libro3 = new Book("Bettina");

        Library biblioteca = new Library();

        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println(libro3.toString());

        biblioteca.addBook(libro1);
        biblioteca.addBook(libro2);
        biblioteca.addBook(libro3);
       

        biblioteca.loanBook(libro3);
        TimeUnit.MINUTES.sleep(1);
        biblioteca.loanBook(libro1);
        biblioteca.printLoan();
        biblioteca.returnBook(libro2);
        biblioteca.printLoan();

    }

}
