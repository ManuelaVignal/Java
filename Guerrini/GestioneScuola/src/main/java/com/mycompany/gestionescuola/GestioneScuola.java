/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

/**
 * Main principale dove si chiamano i metodi
 * 
 */
 
public class GestioneScuola {
    
    public static void main(String[] args) {
        
        Tool genio = new Tool();
        String nome="tss java";
        int durata= 1000;
        //istruzione new per far nascere un nuovo corso legato al costrutture ed i suoi parametri
        Corso c1 = new Corso(nome,durata);
        Corso c2 = new Corso(nome, durata,2022,3,15);
        boolean ok;
        c1.setDatainizio("2022-02-02");
        ok =c1.setDatainizio("2002-02-02");
        ok =c1.setDatainizio("2002/02/31");
        c1.stampaInfo();
        Alunno a1 =new Alunno("vignal","manuela");
        String oktel =genio.checkTel("0125---12478 ","+44");
        Alunno a2 =new Alunno(oktel,"tss@libero.it","vignal","manuela");
        c1.insertAlunno(a1);
        c1.insertAlunno(a2);
        
        c1.stampaRegistro();
        Esame es= new Esame("guerrini",100,"java");
        Alunno esaminando=c1.getRegistro()[0];
        esaminando.setLibretto(es);
    }
    
}
