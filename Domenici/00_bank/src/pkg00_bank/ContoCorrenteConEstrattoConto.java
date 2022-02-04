/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg00_bank;

import java.util.ArrayList;

/**
 *si usa quando 
 * con extends vuol dire che ha lo stato di conto corrente ed ha tutte le variabili di esso
 */
public class ContoCorrenteConEstrattoConto extends ContoCorrente {
    
    private ArrayList<Integer> movimenti = new ArrayList<>();

    public ContoCorrenteConEstrattoConto(String intestatario) {
        super(intestatario);
    }
    
    //per avre una lista di tutti i movuimenti che io faccio
    
  public ArrayList<Integer> getMovimenti(){
  return new ArrayList(this.movimenti);
  
  }

    @Override
    public void deposito(int somma) {
        super.deposito(somma); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        movimenti.add(somma);
        
    }

    @Override
    public void prelievo(int somma) {
        super.prelievo(somma); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        movimenti.add(-somma);
    }

}
