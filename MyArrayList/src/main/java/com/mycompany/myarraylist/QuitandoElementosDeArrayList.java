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
import java.util.function.Predicate;

public class QuitandoElementosDeArrayList {
    
    public static void main(String args[]) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(5);
        numeros.add(8);
        numeros.add(9);
        numeros.add(5);
        
        System.out.println("Estos son los elementos almacenados en el ArrayList "+numeros);
        // Borrar un elemento por su índice: 
        numeros.remove(1);
        System.out.println( "Borramos el elemento que está en la segunda posicion: "+ numeros);
        
        /** Borrar la primera ocurrencia de un elemento: 
         * Convertimos 5 en un objeto Integer utilizando Integer.valueOf() 
         * para garantizar que se borre el elemento Integer y no el elemento en la posición 5.
         */
        numeros.remove(Integer.valueOf(5));
        System.out.println("Borramos la primera ocurrencia de 5: "+ numeros);
        
        // Borrar varios elementos a la vez:
        List<Integer> numerosABorrar = new ArrayList<>();
        numerosABorrar.add(3);
        numerosABorrar.add(6);
        numerosABorrar.add(5);
        numeros.removeAll(numerosABorrar);
        System.out.println( "Después de borrar una lista de elementos :"+ numeros);

        /**
         * Utilizamos el método removeIf() para eliminar elementos de la lista numeros que cumplan con cierta condición.
        Creamos una instancia de Predicate anónima que comprueba si un elemento es igual a 9 y devuelve true si lo es.
        La condición se evalúa para cada elemento de numeros, y si devuelve true, ese elemento se elimina de la lista.
        Como se indica en el comentario, esta lógica también se puede expresar de forma más concisa utilizando una expresión lambda:
         */
        numeros.removeIf(new Predicate<Integer>() {
            public boolean test(Integer i) {
                return i.equals(Integer.valueOf(9));
            }
        });
        /**
         * aqui tambien se podria usar esta expresion lambda
         * numeros.removeIf(i -> i.equals(9));
         */
        System.out.println( "Después de borrar siguiendo una condición:"+ numeros);
    }
    
}
