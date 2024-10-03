/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.centrodeestudios;

/**
 *
 * @author pereiras-house
 */
public class Profesores {
    
    private String nombre;
    private String primerApellido;
    private String dni;
    private String fechaNasc;
    private String direccion;
    private String telefono;
    private String materias;

    public Profesores(String nombre, String primerApellido, String dni, String fechaNasc, String direccion, String telefono, String materias) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.dni = dni;
        this.fechaNasc = fechaNasc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.materias = materias;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNasc() {
        return fechaNasc;
    }

    public void setFechaNasc(String fechaNasc) {
        this.fechaNasc = fechaNasc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Profesores{" + "nombre=" + nombre + ", primerApellido=" + primerApellido + ", dni=" + dni + ", fechaNasc=" + fechaNasc + ", direccion=" + direccion + ", telefono=" + telefono + ", materias=" + materias + '}';
    }
    
    
}
