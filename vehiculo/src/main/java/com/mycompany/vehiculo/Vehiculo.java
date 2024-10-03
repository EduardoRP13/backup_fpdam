/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehiculo;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author eduar
 */
public class Vehiculo {

    private String marca;
    private String matricula;
    private int numKM;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombreProprietario;
    private String dniPropietario;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String matricula, int numKM, LocalDate fechaMatriculacion, String descripcion, double precio, String nombreProprietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKM = numKM;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombreProprietario = nombreProprietario;
        this.dniPropietario = dniPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumKM() {
        return numKM;
    }

    public void setNumKM(int numKM) {
        this.numKM = numKM;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreProprietario() {
        return nombreProprietario;
    }

    public void setNombreProprietario(String nombreProprietario) {
        this.nombreProprietario = nombreProprietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    public int get_Anios(){
        
        LocalDate f1 = this.fechaMatriculacion;
        LocalDate f2 = LocalDate.now();
        
        Period p = Period.between(f1,f2);
        
        return p.getYears();  //Diferencias de años.
        
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", numKM=" + numKM + ", fechaMatriculacion=" + fechaMatriculacion + ", descripcion=" + descripcion + ", precio=" + precio + ", nombreProprietario=" + nombreProprietario + ", dniPropietario=" + dniPropietario + '}';
    }
    
}
