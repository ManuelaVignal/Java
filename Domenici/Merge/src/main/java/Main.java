
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(5);
        list2.add(4);
        list2.add(6);

        System.out.println(merge(list1, list2));

    }

    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException("Errore: liste di dimensione diversa");
        } else {

            //return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toCollection(LinkedList::new));
            Iterator<Integer> l1 = list1.iterator();
            Iterator<Integer> l2 = list2.iterator();

            LinkedList<Integer> list3 = new LinkedList<>();

            while (l1.hasNext() || l2.hasNext()) {

                if (l1.hasNext()) {
                    list3.add(l1.next());
                }
                if (l2.hasNext()) {
                    list3.add(l2.next());
                }
            }
            return list3;
        }

    }

}
