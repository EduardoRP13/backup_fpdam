/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploarraylists;

/**
 *
 * @author eduar
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private int indice;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Persona(String nombre, int edad, int indice) {
        this.nombre = nombre;
        this.edad = edad;
        this.indice = indice;
    }
    
    
}




