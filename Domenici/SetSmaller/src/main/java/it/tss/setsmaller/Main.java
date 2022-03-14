/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.setsmaller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> insieme1 = new ArrayList<>();
        ArrayList<Integer> insieme2 = new ArrayList<>();

        insieme1.add(1);
        insieme1.add(2);
        insieme1.add(7);

        insieme2.add(5);
        insieme2.add(4);
        insieme2.add(6);
        
        System.out.println(isSetSmaller(insieme1,insieme2));
    }

    public static boolean isSetSmaller(ArrayList<Integer> insieme1, ArrayList<Integer> insieme2) {
        Iterator<Integer> it2 = insieme2.iterator();
        int ris = 0;
        for (Integer i : insieme1) {
            while (it2.hasNext()) {
                ris = i.compareTo(it2.next());
            }
        }
        if (ris == 0 || ris == 1) {
            return false;
        } else {
            return true;
        }
    }
}
