/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionereservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Room {

    private List<Reservation> list = new ArrayList<>();

    public static class Reservation {

        private final String nome;
        private final LocalDate inizio;
        private final LocalDate fine;

        public Reservation(String nome, LocalDate inizio, LocalDate fine) {

            this.nome = nome;
            this.inizio = inizio;
            this.fine = fine;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.nome);
            hash = 97 * hash + Objects.hashCode(this.inizio);
            hash = 97 * hash + Objects.hashCode(this.fine);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Reservation other = (Reservation) obj;
            if (!Objects.equals(this.nome, other.nome)) {
                return false;
            }
            if (!Objects.equals(this.inizio, other.inizio)) {
                return false;
            }
            return Objects.equals(this.fine, other.fine);
        }

        @Override
        public String toString() {
            return "Reservation{" + "nome=" + nome + ", inizio=" + inizio + ", fine=" + fine + '}';
        }

        public String getNome() {
            return nome;
        }

        public LocalDate getInizio() {
            return inizio;
        }

        public LocalDate getFine() {
            return fine;
        }

    }

    public Reservation reserve(String nome, LocalDate datainizio, LocalDate datafine) {

        Reservation r = new Reservation(nome, datainizio, datafine);

        if (isOccupata(r)) {
            throw new IllegalArgumentException("Periodo e camera occupata");
        }
        list.add(r);
        return r;
    }

    public List<Reservation> reservations() {
        Comparator<Reservation> comp = (r1, r2) -> r1.inizio.compareTo(r2.inizio);
        return list.stream().sorted(comp).collect(Collectors.toList());
    }

    private boolean isOccupata(Reservation nuova) {
        Predicate<Reservation> inizioNonValido = (r)
                -> !nuova.inizio.isBefore(r.inizio) && !nuova.inizio.isAfter(r.fine);
        Predicate<Reservation> fineNonValido = (r)
                -> !nuova.fine.isBefore(r.inizio) && !nuova.fine.isAfter(r.fine);
        Predicate<Reservation> tuttononValido = (r)
                -> nuova.inizio.isBefore(r.inizio) && nuova.inizio.isAfter(r.fine);

        return list.stream().anyMatch(inizioNonValido.or(fineNonValido).or(tuttononValido));
    }

}
