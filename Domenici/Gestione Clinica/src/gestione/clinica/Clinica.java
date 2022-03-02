/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestione.clinica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Clinica {

    private static List<Prenotazione> prenotazioni = new ArrayList<>();
    

    public void prenota(Specialista specialista, String nomepaziente) {
        //creo l'oggetto pòaziente da inserire, che gli passo come paramentro
        Prenotazione p = new Prenotazione(specialista, nomepaziente);
        
        
        //controllo ch e il mio oggetto non sia dentro la lista
        
        for (Prenotazione pr : prenotazioni) {

            if (pr.getPaziente().equals(p.getPaziente())) {
                return;
            }

        }
        prenotazioni.add(p);
    }

    public void cancellaPrenotazioni(Specialista specialista, String paziente) {

        prenotazioni.removeIf(v -> v.getSpecialista().equals(specialista) && v.getPaziente().equals(paziente));

    }

    /* public void cancellaPrenotazione(Specialista specialista, String paziente) {
        
        Prenotazione p = new Prenotazione(specialista, paziente);
        prenotazioni.removeIf(v -> v.equals(p));
    }*/

    public Collection<String> getPrenotati(Specialista specialista) {
        List<Prenotazione> tmp = prenotazioni.stream().filter(v -> v.getSpecialista() == specialista).collect(Collectors.toList());
        Collection<String> ris = tmp.stream().map(v -> v.getPaziente()).collect(Collectors.toList());
        return ris;

    }

}
