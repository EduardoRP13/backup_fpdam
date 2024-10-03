/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lecturatablaascii;

import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class LecturaTablaASCII {

    public static void main(String[] args) {
        
        /*
        ALT + ENTER te abre la venta con posibles soluciones para arreglar un error como por ejemplo cuanto ponemos Scanner
        y no tenemos el import java.util.Scanner
        */
        
        Scanner sn=new Scanner(System.in);
        
        System.out.println("Instroduzca un número");
        int num=sn.nextInt();
        
        char caracter=(char)num;
        char a='a';
        
        System.out.println("El número "+num+" corresponde al caracter '"+caracter+"'");
        /*
        '"+caracter+"'" Ponemos asi para que salga por ejemplo 'B'
        */
    }
}
