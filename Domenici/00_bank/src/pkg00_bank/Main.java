/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg00_bank;

/**
 * Programma per modellare un tipo di conto corrente
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    ContoCorrenteConEstrattoConto cc=new ContoCorrenteConEstrattoConto("alfonso");
        cc.deposito(100);
        cc.prelievo(20); 
        System.out.println("intestatario: " +  cc.getIntestatario() + "saldo: " + cc.getSaldo());
        System.out.println("cc.getMovimenti" + cc.getMovimenti());
    }
    
}
