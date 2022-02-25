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
public class Main {

    public static void main(String[] args) {
        //creo oggetto di tipo Agenda, creo la mia istanza per usare i metodi

        Agenda ag = new Agenda();

        Appuntamento ap1 = ag.addApp(LocalTime.of(14, 30), LocalTime.of(15, 00), LocalDate.now(), "manuela", "ivrea");
        Appuntamento ap2 = ag.addApp(LocalTime.of(15, 30), LocalTime.of(15, 00), LocalDate.now(), "alfonso", "torino");
        Appuntamento ap3 = ag.addApp(LocalTime.of(15, 30), LocalTime.of(15, 00), LocalDate.now().plusDays(10), "alfonso", "torino");

        ag.cercaApp(null, "ivrea", "manuela").forEach(System.out::println);

    }

}
