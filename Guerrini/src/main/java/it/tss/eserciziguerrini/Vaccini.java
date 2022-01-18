/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.eserciziguerrini;

/**
 *
 * @author tss
 */
public class Vaccini {
    
    public static void main(String[] args) {
        
        //data oggi
        int oggi= 790;
        //dati ministero di validità
        int duratav1=30;
        int duratav2=120;
        int duratav3=120;
        int durata_tampone = 2;
        int durata_covid = 180;
        
        int v1 =0;
        int v2 =0;
        int v3 =0;
        int covid =0;
        int tampone =0;
            
        
        v1 = 500;
        int dv1= oggi -v1;//749-700= 49 giorni
        boolean okv1 = dv1 <= duratav1;// ritorna falso 49 non è <=30
        
        v2 = 550;
        int dv2= oggi -v2;
        boolean okv2 = dv2 <= duratav2;//true 49 <= 120
        
        v3 = 0;
        int dv3= oggi -v3;
        boolean okv3 = dv3 <= duratav3;// true
        
        covid = 600;
        int dcovid = oggi - covid;
        boolean okcovid = dcovid <= durata_covid;
        
        tampone = 0;
        int dtampone = oggi - tampone;
        boolean oktampone = dtampone <= durata_tampone;
        
        //fammi la somma che è l'or logico
        
        boolean greenpass = oktampone|| okcovid ||okv3||okv2||okv1;
        
        if (greenpass)
            System.out.println("GREEN PASS OK VALIDO");
        
        else
            
            System.out.println("GREEN PASS NON VALIDO");
        
    }
        
        
        
        
        
        
        
        
        
        
                
        
        
        
        
        
        
    }
    
}
