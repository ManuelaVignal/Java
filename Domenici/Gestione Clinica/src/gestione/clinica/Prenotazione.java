/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestione.clinica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prenotazione {

    private String paziente;
    private Specialista specialista;

    public Prenotazione(Specialista specialista,String paziente) {
        this.paziente = paziente;
        this.specialista = specialista;
    }

    public String getPaziente() {
        return paziente;
    }

    public Specialista getSpecialista() {
        return specialista;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.paziente);
        hash = 97 * hash + Objects.hashCode(this.specialista);
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
        final Prenotazione other = (Prenotazione) obj;
        if (!Objects.equals(this.paziente, other.paziente)) {
            return false;
        }
        return this.specialista == other.specialista;
    }

    @Override
    public String toString() {
        return "Prenotazione{" + "paziente=" + paziente + ", specialista=" + specialista + '}';
    }

}
