/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author tss
 */
public class Appuntamento {

    private LocalTime ora_fine;
    private LocalTime ora_inizio;
    private LocalDate data;
    private String nome_persona;
    private String luogo;

    public Appuntamento(LocalTime ora_fine, LocalTime ora_inizio, LocalDate data, String nome_persona, String luogo) {
        this.ora_fine = ora_fine;
        this.ora_inizio = ora_inizio;
        this.data = data;
        this.nome_persona = nome_persona;
        this.luogo = luogo;
    }
//interseziona nel range ed over range 

    public boolean intersect(Appuntamento nuovo) {
        if (!this.data.equals(nuovo.data)) {
            return false;
        }

        if (this.isAllDay() || nuovo.isAllDay()) {

            return true;
        }
        if (this.ora_inizio.isBefore(nuovo.ora_inizio) || this.ora_fine.isAfter(nuovo.ora_inizio)) {
            return true;

        }
        return this.ora_inizio.isBefore(nuovo.ora_fine) || this.ora_fine.isAfter(nuovo.ora_fine);
    }

    public boolean overloap(Appuntamento nuovo) {
        return nuovo.ora_inizio.isBefore(this.ora_inizio) && nuovo.ora_fine.isAfter(this.ora_fine);
    }

    public boolean invalid(Appuntamento a) {
        return intersect(a) || overloap((a));

    }

    public boolean isAllDay() {
        return ora_inizio == LocalTime.MIN && ora_fine == LocalTime.MAX;
    }

    public LocalTime getOra_fine() {
        return ora_fine;
    }

    public LocalTime getOra_inizio() {
        return ora_inizio;
    }

    public LocalDate getData() {
        return data;
    }

    public String getNome_persona() {
        return nome_persona;
    }

    public String getLuogo() {
        return luogo;
    }

    @Override
    public String toString() {
        return "Appuntamento{" + "ora_fine=" + ora_fine + ", ora_inizio=" + ora_inizio + ", data=" + data + ", nome_persona=" + nome_persona + ", luogo=" + luogo + '}';
    }

}
