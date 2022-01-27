/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.array_guerrini;

/**
 *
 * @author tss
 */
public class Array1 {
    
    public static void main(String[] args) {
        
        
        float x,y,z;
        
        x= Tool.insNumero("dimmi x:");
        y= Tool.insNumero("dimmi y:");
        z= Tool.insNumero("dimmi z:");
        
        float distanza = Tool.dist3D(x, y, z);
        
        System.out.println("x:   :"  +x);
        System.out.println("y:   :"  +y);
        System.out.println("z:   :"  +z);
        System.out.println("distanza:"  + distanza);
        
        //chiedo la dimensione degli array
        
        int dim1= (int)Tool.insNumero("dimmi dim1:");
        int dim2= (int)Tool.insNumero("dimmi dim2:");
        
        //creo gli array con cui lavorare
        
        int ar1[]=new int[2000];//creo nuovo array
        int ar2[]=new int[dim2];
        int ar3[]=new int[dim1 + dim2];
        ar1=Tool.loadDataInt(ar1, 500);
        ar2=Tool.loadDataInt(ar2, 5);
        ar3=Tool.concatArrays(ar1,ar2);
        
        System.out.println("primo elemento" + ar1[0]);
        int[]file ={123,234,354,456,354,234,123,234};
        file = Tool.concatArrays(ar1,file);
        int [] virus ={3,3,3};
        
        int posvirus=Tool.cercaVirus(file, virus);
    
}
    
}