/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareacomplementariaud2;

/**
 *
 * @author pereiras-house
 */

import java.util.Scanner;
public class TareaComplementariaUD2 {

    public static void main(String[] args) {
         float a, b, c, resultado;
         
         Scanner teclado = new Scanner(System.in);
         
         System.out.println("Introduce un número entero: ");
         a = teclado.nextInt();
         System.out.println("Introduce otro número: ");
         b = teclado.nextInt();
         System.out.println("Introduce otro número: ");
         c = teclado.nextInt();
         resultado = (a/b) * c;
         
         System.out.println("La Suma es= " + resultado);
         
    }
}
