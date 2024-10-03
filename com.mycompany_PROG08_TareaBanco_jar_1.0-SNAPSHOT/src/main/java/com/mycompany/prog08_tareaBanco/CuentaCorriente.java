/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog08_tareaBanco;

/**
 *
 * @author eduar
 */
public class CuentaCorriente extends CuentaBancaria {
    
    private String listaEntidades;
    
    public CuentaCorriente(String listaEntidades, Persona titular, double saldo, String IBAN) {
        super(titular, saldo, IBAN);
        this.listaEntidades = listaEntidades;
    }

    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
    
    @Override
    public String devolverInfoString(){
        return super.devolverInfoString() + ",{" + ", listaEntidades=" + listaEntidades;
    }
    
    
    
}
