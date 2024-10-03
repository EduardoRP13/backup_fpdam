/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.indicar_num_par_impar;

import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class Indicar_num_par_impar {

    public static void main(String[] args) {
        
        /*
        ALT + ENTER te abre la venta con posibles soluciones para arreglar un error como por ejemplo cuanto ponemos Scanner
        y no tenemos el import java.util.Scanner
        */
        
        Scanner sn=new Scanner(System.in);
        
        System.out.println("Instroduzca un número");
        int num=sn.nextInt();
        
        if(num%2==0) {
            System.out.println("El numero "+num+" es Par");
        }else{
            System.out.println("El numero "+num+" es Impar");
        }
    }
}
