/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

/**
 *
 * @author tss
 */
public class GestioneScuola {
    
    
    
    
    
    public static void main(String[] args) {
        
        Tool genio = new Tool();
        
        String nome="tss java";
        int durata= 1000;
        Corso c1= new Corso(nome,durata);//per far nascere un nuovo Corso con il costruttore per far nascere gli oggetti
        c1.stampaInfo();
        Corso c2=new Corso();
        c2.stampaInfo();
        Alunno a1 =new Alunno("vignal","manuela");
        String oktel =genio.checkTel("0125---12478 ","+44");
        Alunno a2 =new Alunno(oktel,"tss@libero.it","vignal","manuela");
        a1.stampaInfo();
        a2.stampaInfo();
        c1.insertAlunno(a2,0);
        c1.insertAlunno(a1);
        
    }
    
}
