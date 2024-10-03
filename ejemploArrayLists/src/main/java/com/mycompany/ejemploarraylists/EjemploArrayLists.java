/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemploarraylists;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class EjemploArrayLists {

    public static void main(String[] args) {
        
        List<Persona> lista = new ArrayList<Persona> ();
        lista.add(new Persona("Eduardo",30,1));
        lista.add(new Persona("Bianca",30,2));
        lista.add(new Persona("Arthur",1,3));
        lista.add(new Persona("Aurora",3,4));
        
        System.out.println("-----------------FOR----------------------");
        // recorrer por indice
        for (int i=0; i<lista.size(); i++) {
            System.out.println("Prueba: " + "Indice = " + lista.get(i).getIndice() + " Nombre = " + lista.get(i).getNombre() + " Edad = " + lista.get(i).getEdad());
        }
        
        System.out.println("-----------------FOREACH----------------------");
        //recorrido foreach
        for (Persona perso:lista) {
            System.out.println("Indice: " + perso.getIndice() + " Prueba: " + perso.getNombre()+ " Edad: " + perso.getEdad());
        }
        
        // ahora agregando tu mismo lo que quiera en la ArrayList
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);
        int opcion;
        
        String agregarNombre;
        int agregarEdad, agregarIndice;
        boolean salir = false;
        
        while (!salir) {
            System.out.println("-----------------Agregar Persona----------------------");
            System.out.println("-----------------MENU----------------------");
            System.out.println("1. Agregar a la lista.");
            System.out.println("2. Enseñar la lista");
            System.out.println("3. Salir.");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Pon el Nombre:");
                    agregarNombre = sn.next();
                    System.out.println("Pon el Edad:");
                    agregarEdad = sn.nextInt();
                    System.out.println("Pon el Indice:");
                    agregarIndice = sn.nextInt();
                    lista.add(new Persona(agregarNombre, agregarEdad, agregarIndice));
                    System.out.println("Persona agregada a la lista.");
                    break;
                case 2:
                    //recorrido foreach
                    for (Persona perso : lista) {
                        System.out.println("Indice: " + perso.getIndice() + " Prueba: " + perso.getNombre() + " Edad: " + perso.getEdad());
                    }
                    break;

                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Error, elige una opcion de 1 a 6.");
                    break;
            }
        }

    }
}
