/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestione.clinica;

import java.util.Collection;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        Clinica c = new Clinica();
        c.prenota(Specialista.OCULISTA, "Manuela");
        c.prenota(Specialista.OCULISTA, "Teresa");
        c.prenota(Specialista.OCULISTA, "Teresa");
        c.prenota(Specialista.PEDIATRA, "Arjent");
        c.prenota(Specialista.PEDIATRA, "Teresa");
        c.cancellaPrenotazioni(Specialista.PEDIATRA, "Arjent");
        Collection<String> ocu = c.getPrenotati(Specialista.OCULISTA);
        System.out.println(ocu);
        System.out.println(c.getPrenotati(Specialista.PEDIATRA));

    }
}


