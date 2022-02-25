/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionereservation;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author tss
 */
public class Main {
    
    public static void main(String[] args) {
        
        Room r =new Room();
        r.reserve("Manuela", LocalDate.of(2022,Month.MARCH,15), LocalDate.of(2022, Month.MARCH,30));
        r.reserve("Mario", LocalDate.of(2022,Month.MAY,15), LocalDate.of(2022,Month.MAY,30));
        r.reserve("Pippo", LocalDate.of(2022,Month.FEBRUARY,15), LocalDate.of(2022,Month.FEBRUARY,28));
        
        r.reservations().forEach(v ->System.out.println(v));
        
    }
    
}
