/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myarraylist;

/**
 *
 * @author eduar
 */

import java.util.ArrayList;
import java.util.List;

public class AccediendoAelementosDeArrayList {
    
    public static void main(String args[]) {
        List<Integer> numeros=new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        System.out.println("Estos son los elementos almacenados en el ArrayList"+numeros);
        System.out.println("El elemento que está en la primera posición (posicion 0) es: "+ numeros.get(0));
        System.out.println("El elemento que está en la última posición es: "+ numeros.get(numeros.size()-1));
        }

}
