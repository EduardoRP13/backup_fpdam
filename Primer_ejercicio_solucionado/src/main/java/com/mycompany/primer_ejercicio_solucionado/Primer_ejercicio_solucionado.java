/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primer_ejercicio_solucionado;

import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class Primer_ejercicio_solucionado {

    public static void main(String[] args) {
        //** aqui introduzco los datos de los productos //
        System.out.println("Bienvenido a la Maquina Expendedora");
        double water= 0.87;
        double gaseosa= 2.73;
        double cafe= 1.81;
        double chocolate= 1.28;
        double snack= 2.37;
        //** abro el scanner //
        Scanner scanner = new Scanner(System.in);
        boolean opcion=true;
        double dinero= 0.0; // Iniciar este valor siemple fuera del bucle por que se reinicia si esta dentro del bucle //
                
        while(opcion==true){
            //** abro el el Menu donde hay 4 opciones //
            System.out.println("MenÃº");
            System.out.println("1. insertar Dinero");
            System.out.println("2. Productos Disponibles");
            System.out.println("3. Saldo");
            System.out.println("4. Salir\n");

            int opcionmenu = scanner.nextInt();

            //** aqui para el dinero **//
            if(opcionmenu==1) { 
                System.out.println("Inserta dinero (en monedas o billetes de 5 euros):");
                System.out.println("1. 0.25 Centimos");
                System.out.println("2. 0.50 Centimos");
                System.out.println("3. 1.00 Euro");
                System.out.println("4. 2.00 Euros");
                System.out.println("5. 5.00 Euros\n");
                int opciondinero = scanner.nextInt();

                if (opciondinero >= 1 && opciondinero <= 5) { //Llamo la funcion obtenerCantidad //
                    double cantidad = obtenerCantidad(opciondinero);
                    dinero += cantidad;
                    System.out.println("Dinero agregado: Total " + dinero + " Euros.");
                } else if (opciondinero==6) {
                    System.out.println("Volviendo al Menu Principal...");
                    return;
                } else {
                    System.out.println("OpciÃ³n no vÃ¡lida. IntÃ©ntalo de nuevo.");
                }
            
            } else if (opcionmenu == 2) { // me costo pero la mejor forma me salio asi creando una variable precioProducto para armazenar os valores.
                System.out.println("1. Agua " + water + " $");
                System.out.println("2. Gaseosa " + gaseosa + " $");
                System.out.println("3. CafÃ© " + cafe + " $");
                System.out.println("4. Chocolate " + chocolate + " $");
                System.out.println("5. Snack " + snack + " $");
                System.out.println("6. Volver");
                System.out.println("Elige un producto (1-5) o 6 para volver:\n");
            
                int eleccionProducto = scanner.nextInt();
            
                double precioProducto = 0.0;
                double resultado;

                if (eleccionProducto == 1) {
                    precioProducto = water;
                } else if (eleccionProducto == 2) {
                    precioProducto = gaseosa;
                } else if (eleccionProducto == 3) {
                    precioProducto = cafe;
                } else if (eleccionProducto == 4) {
                    precioProducto = chocolate;
                } else if (eleccionProducto == 5) {
                    precioProducto = snack;
                } else if (eleccionProducto == 6) {
                    System.out.println("Volviendo al menÃº principal.");
                    return;
                } else {
                    System.out.println("OpciÃ³n no vÃ¡lida. IntÃ©ntalo de nuevo.");
                    return;
                }
            
                if (dinero >= precioProducto) {
                    resultado = dinero - precioProducto;
                    System.out.println("Producto Listo. Tu Cambio actual es: $" + resultado);
                    dinero = resultado; // MUY IMPORTANTE PARA GUARDAR EL DINERO ACTUAL Y NO HAGO UN RESET EN EL DINERO.
                } else {
                    System.out.println("Tu Saldo actual es: $" + dinero + ". Por favor, inserta mÃ¡s dinero.");
                }
                
            }else if(opcionmenu==3) { //** aqui para cerrar el bucle //
                System.out.println("Tu Saldo es "+ dinero +" Euros.");
            }else if(opcionmenu==4) { //** aqui para cerrar el bucle //
                System.out.println("Gracias por usar la Maquina");
                opcion = false;
            }else{ //** aqui para que solo se ponga numeros int //
                System.out.println("Por favor Seleciona la opcion Correcta");
            }  
        }   
    } 
    private static double obtenerCantidad(int opciondinero) { //Funciona para sumar al saldo //
        if (opciondinero == 1) return 0.25;
        else if (opciondinero == 2) return 0.50;
        else if (opciondinero == 3) return 1.00;
        else if (opciondinero == 4) return 2.00;
        else if (opciondinero == 5) return 5.00;
        else return 0.0;
    }
}  
