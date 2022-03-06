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
 * @param <E>
 */
public class Catalogo< E extends Articolo> implements Iterable {

    private final List<E> articoli = new ArrayList<>();

    public void aggiungiArticolo(E art) {

        articoli.add(art);

    }

    public List<E> getArticoliSottoPrezzo(double prezzo) {

        return articoli.stream()
                .filter(v -> v.getPrezzo() < prezzo)
                .collect(Collectors.toList());

    }

    @Override
    public String toString() {

        // return articoli.stream().map(Articolo::toString).collect(Collectors.joining("/n"));
        StringBuilder risultato = new StringBuilder();
        for (E t : articoli) {
            risultato.append("\n").append(t.toString());
        }
        return risultato.toString();
    }

   public List<E> getArticoli() {
        return new ArrayList<>(articoli);
    }

    @Override
    public Iterator iterator() {
        return articoli.iterator();

    }
}
