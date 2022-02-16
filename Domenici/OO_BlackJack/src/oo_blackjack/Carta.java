/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Carta {

    public static enum Seme {
        CUORI, QUADRI, FIORI, PICCHE

    }

    public static enum Nome {
        ASSO, DUE, TRE, QUATTRO, CINQUE, SEI, SETTE, OTTO, NOVE, DIECI, FANTE, REGINA, RE

    }
    private final Seme seme;
    private final ArrayList<Integer> valoriPossibili;
    private int valore;
    private final Nome nome;
    private boolean coperta = true;

    public Carta(Seme seme, int valore, Nome nome) {
        this(seme, valore, nome, new ArrayList());
    }

    public Carta(Seme seme, int valore, Nome nome, ArrayList<Integer> valori) {
        this.seme = seme;
        this.valore = valore;
        this.nome = nome;

        this.valoriPossibili = new ArrayList(valori);
        if (this.valoriPossibili.isEmpty()) {
            this.valoriPossibili.add(valore);

        }
    }

    public int getValore() {
        return valore;
    }

    public Nome getNome() {
        return nome;
    }

    public void setValore(int valore) {
        if (!valoriPossibili.contains(valore)) {
            throw new IllegalArgumentException("Valore non  previsto");

        }

        this.valore = valore;
    }

    public Seme getSeme() {
        return seme;
    }

    public boolean isCoperta() {
        return coperta;
    }

    public void setCoperta(boolean coperta) {
        this.coperta = coperta;
    }

    
    @Override
    public String toString() {

        return this.coperta ? "???????": this.nome.name() + "di" + this.seme.name() + " " + this.valore;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.seme);
        hash = 79 * hash + this.valore;
        hash = 79 * hash + Objects.hashCode(this.nome);
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
        final Carta other = (Carta) obj;
        if (this.valore != other.valore) {
            return false;
        }
        if (this.seme != other.seme) {
            return false;
        }
        return this.nome == other.nome;
    }

}
