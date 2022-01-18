/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.tss.esercizibase;


import.java.util.Scanner;


 public class Esercizio1 {
     
    public static void main(String[] args) {
    
    String nome;
        
    System.out.println("inserisci nome [" + (i+1) + "/" + nomi.length+"] ");
    nome =  lettoreS.nextLine();
    nomi[i]=nome;
    
    String cognome;
    System.out.println("inserisci cognome [" + (i+1) + "/" + nomi.length+"] ");
    cognome= lettoreS.nextLine();
    cognomi[i]=cognome;
    //gestione acconti
    int acconto;
    System.out.println("inserisci acconto [" + (i+1) + "/" + nomi.length+"] ");
    acconto= lettoreI.nextInt();
    acconti[i]=acconto;

for (int i=0;i<nomi.length;i++) {
    System.out.println((i+1) + ") "+ nomi[i] +  cognomi[i] + " - acconto = " + acconti [i]);
}
//cjhiedo nome da cercare
System.out.println("scrivi il nome da cercare : ");
String cerca = lettoreS.nextLine();
​
boolean trovato=false; 
for (int i = 0; i < nomi.length; i++) {
    if (cerca.equalsIgnoreCase (nomi[i])) {
        trovato = true;
        //break;
    }
    else trovato = false;
}
if (trovato) {
    System.out.println(" TROVATO!!! " + cerca);
}
else {
    System.out.println(cerca + " non presente... ");
}
int totale= 0;
for (int i = 0; i < nomi.length; i++) {
    totale = totale + acconti [i];
}
​
    


