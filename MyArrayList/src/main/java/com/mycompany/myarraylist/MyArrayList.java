/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myarraylist;

import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class MyArrayList {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
        
        while(!salir){
            System.out.println("-----------------------------------");
            System.out.println("Ejemplo de ArrayList ");
            System.out.println("Tienes 4 Opciones de ejemplos ");
            System.out.println("1.Crear una ArrayList ");
            System.out.println("2.Acceder a Elementos de ArrayList ");
            System.out.println("3.Crear un ArrayList desde otra Collection ");
            System.out.println("4.Quitar elementos de ArrayList ");
            System.out.println("5.Exit ");
            System.out.println("-----------------------------------\n");
            
            System.out.print("Elige una opción: \n");
            String input = sn.nextLine(); // Leer la entrada como una cadena
            
            try {
                opcion = Integer.parseInt(input);
            
                if (opcion == 1){
                    System.out.println("-----------------------------------");
                    System.out.println("Ejemplo de como crear una ArrayList ");
                    System.out.println("-----------------------------------\n");
                    CrearLista.main(args);
                } else if (opcion == 2){
                    System.out.println("-----------------------------------");
                    System.out.println("Ejemplo de como acceder a Elementos de ArrayList ");
                    System.out.println("-----------------------------------\n");
                    AccediendoAelementosDeArrayList.main(args);
                } else if (opcion == 3){
                    System.out.println("-----------------------------------");
                    System.out.println("Ejemplo de como Crear un ArrayList desde otra Collection ");
                    System.out.println("-----------------------------------\n");
                    MyClassDesdeOtraCollection.main(args);
                } else if (opcion == 4){
                    System.out.println("-----------------------------------");
                    System.out.println("Ejemplo de como Quitar elementos de ArrayList ");
                    System.out.println("-----------------------------------\n");
                    QuitandoElementosDeArrayList.main(args);
                } else if (opcion == 5){
                    salir = true;
                } else {
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 5.\n");
                }
            } catch (NumberFormatException e) { //Para impedir que de error al poner letras
                System.out.println("Error: Debes ingresar un número.\n");
            }
        

        }
        sn.close(); // Cerrar el Scanner al salir del bucle
    
    }
}
