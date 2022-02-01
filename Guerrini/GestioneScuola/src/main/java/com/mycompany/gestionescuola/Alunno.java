/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

/**
 *
 * @author tss
 */
public class Alunno {
    
    //area attributi o proprietà
    String ntelefono;
    String email;
    String cognome;
    String nome;
    

    public Alunno(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
       
    }

    public Alunno(String ntelefono, String email, String cognome, String nome) {
        this.ntelefono = ntelefono;
        this.email = email;
        this.cognome = cognome;
        this.nome = nome;
        this.ntelefono= ntelefono;
    }
    

    
 //area metodi o capacità, abilità
    void stampaInfo() {
        
        System.out.println("\n\n---------------Scheda corso-----");
        
        System.out.println("Nome:" + nome);
        System.out.println("Cognome:" + cognome);
        System.out.println("email:" + email);
        System.out.println("numerotelefono:" + ntelefono);
        System.out.println("--------------------------------\n\n");
    }  
}