/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.help.ayuda;

/**
 *
 * @author pereiras-house
 */
import java.util.Scanner;

public class HelpAyuda {
    
    //Funcion eso es
    private String mostrarAltura(int altura){
        
        String resultado = "";
        
        if(altura >= 180){
            resultado = "Eres una Persona alta, mides "+altura;
        
        }else{
            resultado = "Eres una persona bajita";
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // el principio
        /*
        *esto es un comentario
        *multilinea
        *ves
         */
        // Variables
        int edad = 45;
        String nombre = "Eduardo";
        nombre = "Alessandro"; //aqui cambio la variable nombre
        Boolean verdade = true;

        System.out.println(nombre);
        //Concatenación
        System.out.println("Me llamo " + nombre + " tengo " + edad + " años");
        //otra manera
        //Systen.out.println("Me llamo %s tengo %d años", nombre, edad);
        
        //entrada de datos
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner (System.in); eso guarda lo que fue introducido en la consola
        /*
        aqui por Ejemplo yo tengo que importar la libreria Scanner para que funciones
        
        
        
        System.out.println("Como te Llamas?: ");
        String miNombre = sc.nextLine();
        
        System.out.println("El Usuario se llama "+miNombre);
        
        */
        
        //Condiciones
        /* EJEMPLO de fuera de una funcion
        if(altura >= 180){
            System.out.println("Eres una Persona alta, mides ")+altura;
        
        }else{
            System.out.println("Eres una persona bajita");
        }
        */
        
        System.out.print("¿Cuanto mides?:");
        int altura = sc.nextInt();
        
        
        //Funcion Llamando la Funcion
        // pregunta no me funciona
        /*
        App aplicacion = new App();
        System.out.println(aplicacion.mostrarAltura(altura));
        */
        
        // Array
        String[] personas = {"Victor", "Pedro", "Juan"};
        
        personas[2] = "Fran";
        
        System.out.println(personas[2]);
        
        //bucle for
        
        for(String persona : personas){
            System.out.println("- "+persona);
            
        }
        
        
    }     
}