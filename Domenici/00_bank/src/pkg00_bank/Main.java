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
        
    ContoCorrenteConEstrattoConto cc=new ContoCorrenteConEstrattoConto("Alfonso");
        cc.deposito(100);
        cc.prelievo(20); 
       
        System.out.println("cc.getMovimenti" + cc.getMovimenti());
        System.out.println("intestatario: " + cc.getIntestatario());
        System.out.println("saldo: " + cc.getSaldo());
        cc.deposito(200);
        cc.prelievo(40); 
       
         System.out.println("cc.getMovimenti" + cc.getMovimenti());
         System.out.println("intestatario: " +  cc.getIntestatario());
         System.out.println("saldo: " + cc.getSaldo());
    }
    
}
