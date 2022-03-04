/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionearticolo;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        Mobile m1 = new Mobile(20, 40, 10, 50, "Mobile1");
        Mobile m2 = new Mobile(30, 10, 10, 60, "Mobile2");
        Mobile m3 = new Mobile(20, 40, 10, 50, "Mobile3");

        Catalogo<Mobile> c = new Catalogo();
        
        c.aggiungiArticolo(m1);
        c.aggiungiArticolo(m2);
        c.aggiungiArticolo(m3);
        c.getArticoliSottoPrezzo(10);
        c.getArticoliSottoPrezzo(20);

        System.out.println(c.toString());

    }
}
