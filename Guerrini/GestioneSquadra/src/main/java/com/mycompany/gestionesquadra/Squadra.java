/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionesquadra;

/**
 *
 * @author tss
 */
public class Squadra {

    private String nome_squadra;
    private String sede;
    private Integer punteggio;

    public Squadra(String nome_squadra, String sede) {
        this.nome_squadra = nome_squadra;
        this.sede = sede;
    }

    public Squadra(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public int getPunteggio() {
        int punteggio = 0;
        for (int i = 0; i < WinCalcio.Elencopa.size(); i++) {
            Partita p = WinCalcio.Elencopa.get(i);
            if (p.getSquadra1().equalsIgnoreCase(nome_squadra)) {//caso in cui gioco in casa 
                    if(p.getGol1()>p.getGol2()){ //caso vittoria in casa
                    punteggio=punteggio+3;
                    }
                    if(p.getGol1()==p.getGol2()){
                    punteggio=punteggio+1;
                    }
                          
            }
            if (p.getSquadra2().equalsIgnoreCase(nome_squadra)) {//caso in cui gioco in trasferta 
                    if(p.getGol2()>p.getGol1()){ //caso vittoria in trasferta
                    punteggio=punteggio+3;
                    }
                    if(p.getGol1()==p.getGol2()){ 
                    punteggio=punteggio+1;
                    }
                          
            }

        }
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public void setNome_squadra(String nome_squadra) {
        this.nome_squadra = nome_squadra;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Squadra{" + "nome_squadra=" + nome_squadra + ", sede=" + sede + '}';
    }

    String getInfo() {

        String ris = "";
        ris += "-------Scheda Squadra-------";
        ris += "\nNome della squadra: " + nome_squadra;
        ris += "\nSede della squadra: " + sede;

        return ris;

    }

    String getCSVInfo() {

        return nome_squadra + ";" + sede + "\n";

    }

    void stampaInfo() {

        System.out.println("\n\n-------Scheda Squadra-------");
        System.out.println("Nome della squadra: " + nome_squadra);
        System.out.println("Sede della squadra: " + sede);

        //stampaRegistro();
        System.out.println("--------------------------\n\n");
    }
}
