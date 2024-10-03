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
public class MyClassDesdeOtraCollection {

    public static void main(String args[]) {
        List<Integer> pares = new ArrayList<>();
        pares.add(2);
        pares.add(4);
        pares.add(6);
        pares.add(8);
        System.out.println("Lista de Array Pares "+ pares);
        List<Integer> impares = new ArrayList<>();
        impares.add(1);
        impares.add(3);
        impares.add(5);
        impares.add(7);
        System.out.println("Lista de Array Impares "+ impares);
        
        /**
         * Crear un ArrayList desde otra Collection
         */
        List<Integer> numeros = new ArrayList<>(impares);
        numeros.addAll(pares);
        System.out.println("Lista de Array creada apartir de Impares y Pares "+ numeros);
    }

}
