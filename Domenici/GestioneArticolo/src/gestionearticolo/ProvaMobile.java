/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionearticolo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author tss
 */
public class ProvaMobile {

    double prezzo;
    int altezza;
    int profondit√†;
    int larghezza;

    public static List<Mobile> scegliMobile(Catalogo<Mobile> c, double prezzo, int altezza, int profondit√†, int larghezza) {

        return c.getArticoli().stream().filter(v -> v.getPrezzo() < prezzo && v.getAltezza() < altezza && v.getProfondita() < profondit√† && v.getLarghezza() < larghezza).collect(Collectors.toList());

    }
}
