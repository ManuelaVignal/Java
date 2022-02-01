/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola;

/**
 *
 * @author tss
 */

//classe Tool che controlal il numero di telefono
public class Tool {
    String checkTel(String ntelefono){
    String ris = "";
    //tolgo gli spazi
    ntelefono=ntelefono.replace(" ", "");
    //tolto trattini punti
    ntelefono=ntelefono.replace("-", "");
    ntelefono=ntelefono.replace("(", "");
    ntelefono=ntelefono.replace(".", "");
    ntelefono=ntelefono.replace(")", "");
    try{
        //controlla che sia un numero
    long ltel= Long.parseLong(ntelefono);
    String tre = ntelefono.substring(0,3);//controllo i primi tre caratteri del telefono 
    //controllo che sono uguali a +39
     if (tre.equals("+39")){
      ris = ntelefono;
     }else {
     //se il +39 non c'è, lo inserisco.
     ris= "+39"+ntelefono;
     }
    
    
    }
    // se c'è un imput errato, esco con ris
    catch (Exception e){
    ris="";
    }
    
        return ris;
    }


    

 String checkTel(String ntelefono,String prefix){
    String ris = "";
    //tolgo gli spazi
    ntelefono=ntelefono.replace(" ", "");
    //tolto trattini punti
    ntelefono=ntelefono.replace("-", "");
    ntelefono=ntelefono.replace("(", "");
    ntelefono=ntelefono.replace(".", "");
    ntelefono=ntelefono.replace(")", "");
    try{
        //controlla che sia un numero
    long ltel= Long.parseLong(ntelefono);
    String tre = ntelefono.substring(0,3);//controllo i primi tre caratteri del telefono 
    //controllo che sono uguali a +39
     if (tre.equals(prefix)){
      ris = ntelefono;
     }else {
     //se il +39 non c'è, lo inserisco.
     ris= prefix+ntelefono;
     }
    
    
    }
    // se c'è un imput errato, esco con ris
    catch (Exception e){
    ris="";
    }
    
        return ris;
    }
} 