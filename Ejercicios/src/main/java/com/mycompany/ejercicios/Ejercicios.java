/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicios;

/**
 *
 * @author pereiras-house
 */
import java.util.Scanner;
public class Ejercicios {

        public static void main(String[] args) {
            int var1, var2;
            Scanner teclado = new Scanner(System.in);
            
            System.out.print("Introduce var1: ");
            var1 = teclado.nextInt();
            System.out.print("Introduce var2: ");
            var2 = teclado.nextInt();
            var1 = var2;
            System.out.println("Ahora var1 es igual a var1");
            System.out.println("Ahora var2 es igual a var2");
    }
}