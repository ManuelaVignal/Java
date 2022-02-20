 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.safesetnew;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class SafeSet {

    private List<String> insieme = new ArrayList<>();
    private List<String> cestino = new ArrayList<>();

    public SafeSet() {
    }

    public List<String> getInsieme() {
        return insieme;
    }

    public boolean add(String obj) {
        boolean aggiunto = false;
        if (insieme.contains(obj) == false) {
            insieme.add(obj);
            aggiunto = true;
        }
        return aggiunto;
    }

    public boolean remove(String obj) {
        boolean rimuovi = false;
        if (insieme.contains(obj) && cestino.contains(obj) == false) {
            insieme.remove(obj);
            cestino.add(obj);
            rimuovi = true;
        } else if (cestino.contains(obj) && insieme.contains(obj) == false) {

            cestino.remove(obj);
            rimuovi = true;

        }
        return rimuovi;
    }

    public boolean contains(String obj) {
        boolean trovato = false;
        for (int i = 0; i < insieme.size(); i++) {
            if (insieme.get(i).equals(obj)) {
                trovato = true;
            }
        }
        return trovato;
    }
}
