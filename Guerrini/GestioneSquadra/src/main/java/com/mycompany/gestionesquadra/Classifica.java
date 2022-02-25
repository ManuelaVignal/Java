/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionesquadra;

/**
 *
 * @author tss
 */
public class Classifica {
    private String nome_squadra;
    private String punti;
    private int fatti;
    private int subiti;

    public Classifica(String nome_squadra, String punti, int fatti, int subiti) {
        this.nome_squadra = nome_squadra;
        this.punti = punti;
        this.fatti = fatti;
        this.subiti = subiti;
    }

    @Override
    public String toString() {
        return "Classifica{" + "nome_squadra=" + nome_squadra + ", punti=" + punti + ", fatti=" + fatti + ", subiti=" + subiti + '}';
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public void setNome_squadra(String nome_squadra) {
        this.nome_squadra = nome_squadra;
    }

    public String getPunti() {
        return punti;
    }

    public void setPunti(String punti) {
        this.punti = punti;
    }

    public int getFatti() {
        return fatti;
    }

    public void setFatti(int fatti) {
        this.fatti = fatti;
    }

    public int getSubiti() {
        return subiti;
    }

    public void setSubiti(int subiti) {
        this.subiti = subiti;
    }
    String getInfoClass() {

        String ris = "";
        ris += "-------Scheda Classifica-------";
        ris += "\nNome della  squadra: " + nome_squadra;
        ris += "\nPunti squadra: " + punti;
        ris += "\nPunti fatti: " + fatti;
        ris += "\nPunti subiti: " + subiti;
       
      
        return ris;

    }

    String getCSVInfoClass() {

        return  nome_squadra + ";" + punti+ ";" +fatti+ ";" +subiti + ";" + "\n";

    }
}
