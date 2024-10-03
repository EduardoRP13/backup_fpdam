/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog08_veiculos;

/**
 *
 * @author eduar
 */
public class Validacion {
    
    public static boolean validarDNI(String DNI){
        return DNI.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]");
    }
    
    public static boolean validarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    
    public static boolean validarNombre(String nombre){
        
        if(nombre.length() > 40){
            return false;
        }
        
        char caracter;
        int numEspacios = 0;
        for(int i = 0; i < nombre.length(); i++) {
            caracter = nombre.charAt(i);
            if(caracter == ' '){
                numEspacios++;
            }
            if(Character.isDigit(caracter)){
                return false;
            }
        }
        
        if(numEspacios >= 2){
            return true;
        }
        return false;
        
    }
}
