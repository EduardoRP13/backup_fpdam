/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;

/**
 *
 * @author eduar
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Rectangulo r1 = new Rectangulo();
        Rectangulo r2 = new Rectangulo(5, 5);
        
        System.out.println("Base rl: " + r1.getBase());
        
        r1.setBase(20);
        r1.setAltura(10);
        
        System.out.println("Base rl: " + r1.getBase());
        System.out.println("rl toString: " + r1.toString());
        
        System.out.println("¿r2 es cuadrado?" + r2.isCuadrado());
        System.out.println("r2 toString" + r2.toString());
        
    }
    
}
