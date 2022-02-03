/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * dichiarazione classe Alunno
 */
public class Alunno {

    //area attributi o proprietà
    private String ntelefono;
    private String email;
    private String cognome;
    private String nome;
    private LocalDate datainserimento = LocalDate.now();
    private Esame[]libretto=new Esame[50];
    public Alunno(){
    
    
    }

    public Alunno(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
       

    }

    public Alunno(String ntelefono, String email, String cognome, String nome) {
        this.ntelefono = ntelefono;
        this.email = email;
        this.cognome = cognome;
        this.nome = nome;
        this.ntelefono = ntelefono;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean setCognome(String cognome) {
        cognome = cognome.trim();//toglie tutti i caratteri speciali davanti e dopo il cognome
        if (cognome.length() >= 2) {
            this.cognome = cognome;
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatainserimento() {
        return datainserimento;
    }

        public void setLibretto(Esame esame){
         for(int i=0;i<libretto.length;i++){
             if(libretto[i]==null){
             
             libretto[i]=esame;
             break;
             
             }
         
         }
        
        }
    void stampaInfo() {

        System.out.println("\n\n---------------Scheda corso-----");
        System.out.println("Nome:" + nome);
        System.out.println("Cognome:" + cognome);
        System.out.println("email:" + email);
        System.out.println("numerotelefono:" + ntelefono);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("d/M/yyyy");
        String formattedDate = datainserimento.format(myFormatObj);
        System.out.println("Data iscizione:" + formattedDate);
       
        System.out.println("--------------------------------\n\n");
    }
}
