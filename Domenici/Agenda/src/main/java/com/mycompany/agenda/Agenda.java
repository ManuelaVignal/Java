/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Agenda {

    private ArrayList<Appuntamento> app = new ArrayList<Appuntamento>();

    public Appuntamento addApp(LocalTime ora_fine, LocalTime ora_inizio, LocalDate data, String nome_persona, String luogo) {
        
        
        
        Objects.requireNonNull(data);
        ora_inizio =Objects.requireNonNullElse(ora_inizio,LocalTime.MIN);
        ora_fine = Objects.requireNonNullElse(ora_fine,LocalTime.MAX);
        
        if (data.isBefore(LocalDate.now())) {
            throw new RuntimeException("data non valida");
        }

        Appuntamento result = new Appuntamento(ora_fine, ora_inizio, data, nome_persona, luogo);
        boolean isInvalid = app.stream().anyMatch(v -> v.invalid(result));
        if (isInvalid) {
            throw new RuntimeException("appuntamento non valido");
        }
        app.add(result);
        return result;
    }

    public void removeApp(Appuntamento a) {
        app.remove(a);

    }

    public void removeC(LocalDate data, String luogo, String persona) {
        app.removeAll(cercaApp(data, luogo, persona));
    }

    public void removeApp(LocalDate data) {

        //interfaccia funzionale, sostituita da una landa e ritorna un boolena
        app.removeIf(v -> v.getData().equals(data));

    }

    public List<Appuntamento> cercaApp(LocalDate data, String luogo, String nome_persona) {
        Predicate<Appuntamento> byDate = v -> data == null || v.getData().equals(data);
        Predicate<Appuntamento> byLuogo = v -> luogo == null || luogo.isBlank() || v.getLuogo().trim().toLowerCase().equals(luogo.trim().toLowerCase());
        Predicate<Appuntamento> byPersona = v -> nome_persona == null || nome_persona.isBlank() || v.getNome_persona().equals(nome_persona);

        //filter filtra se è vero
        return app.stream().filter((byDate).and(byLuogo).and(byPersona)).collect(Collectors.toList());
    }

    public void stampa() {
        System.out.println("----------Agenda-----------");
        //accetta un paramentro e non ritorna niente
        //app.forEach(v -> System.out.println(v));
        //gli passo il puntatore all'elemento e non ritorna nulla e deve accettare un appuntamento
        app.forEach(System.out::println);
        app.forEach(this::stampaAppuntamento);

    }

    //metodo visto come consumeri ad appuntamento
    private void stampaAppuntamento(Appuntamento a) {
        String.format(toString());

    }
}
