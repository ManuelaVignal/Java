/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionesquadra;

import java.time.LocalDate;

/**
 *
 * @author tss
 */
public class Partita {

    private String squadra1;
    private String squadra2;
    private int gol1;
    private int gol2;
    private int giornata;

    public Partita(String squadra1, String squadra2, int gol1, int gol2, int giornata) {
        
        
        this.squadra1 = squadra1;
        this.squadra2 = squadra2;
        this.gol1 = gol1;
        this.gol2 = gol2;
        this.giornata = giornata;
    }

    public String getSquadra1() {
        return squadra1;
    }

    public void setSquadra1(String squadra1) {
        this.squadra1 = squadra1;
    }

    public String getSquadra2() {
        return squadra2;
    }

    public void setSquadra2(String squadra2) {
        this.squadra2 = squadra2;
    }

    public int getGol1() {
        return gol1;
    }

    public void setGol1(int gol1) {
        this.gol1 = gol1;
    }

    public int getGol2() {
        return gol2;
    }

    public void setGol2(int gol2) {
        this.gol2 = gol2;
    }

    public int getGiornata() {
        return giornata;
    }

    @Override
    public String toString() {
        return "Partita{" + "squadra1=" + squadra1 + ", squadra2=" + squadra2 + ", gol1=" + gol1 + ", gol2=" + gol2 + ", giornata=" + giornata + '}';
    }

    public void setGiornata(int giornata) {
        this.giornata = giornata;
    }
  String getInfo() {

        String ris = "";
        ris += "-------Scheda Partita-------";
        ris += "\nNome della prima squadra: " + squadra1;
        ris += "\nNome della seconda squadra: " + squadra2;
        ris += "\nGol della prima squadra: " + gol1;
        ris += "\nGol della seconda squadra: " + gol2;
        ris += "\nGiornata della partita: " + giornata;
      
        return ris;

    }

    String getCSVInfo() {

        return  squadra1 + ";" +squadra2 + ";" +gol1 + ";" +gol2 + ";" +giornata + ";"+ "\n";

    }

    void stampaInfo() {

        System.out.println("\n\n-------Scheda Partita-------");
        System.out.println("Nome del prima squadra: " + squadra1);
        System.out.println("Nome della seconda squadra: " + squadra2);
        System.out.println("Gol della prima squadra: " + gol1);
        System.out.println("Gol della seconda squadra: " + gol2);
        System.out.println("Giornata della partita: " + giornata);
      

        //stampaRegistro();
        System.out.println("--------------------------\n\n");
    }
}
