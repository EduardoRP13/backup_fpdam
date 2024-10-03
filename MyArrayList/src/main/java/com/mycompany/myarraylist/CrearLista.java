/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myarraylist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class CrearLista {
    public static void main(String[] args) {
        /**
         * Crear un ArrayList y añadir elementos.
         */
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(4);
        numeros.add(5);
        System.out.println(numeros);
        
        numeros.add(6);
        numeros.add(3);
        System.out.println(numeros);
    }
}
