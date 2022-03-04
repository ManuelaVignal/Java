/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionearticolo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Catalogo< E extends Articolo> implements Iterable {

    public List<E> articoli = new ArrayList<>();

    public void aggiungiArticolo(E art) {

        articoli.add(art);

    }

    public List<E> getArticoliSottoPrezzo(double prezzo) {
        return articoli.stream().filter(v -> v.getPrezzo() < prezzo).collect(Collectors.toList());

    }

    public String toString() {

        String ris = "";
        ris += "---------Scheda Catalogo-------\n";
        for (E art : articoli) {
            ris += art.toString();
        }
        ris += "---------Fine scheda Catalogo------\n";

        return ris;

    }

    @Override
    public Iterator iterator() {
        return articoli.iterator();

    }
}
