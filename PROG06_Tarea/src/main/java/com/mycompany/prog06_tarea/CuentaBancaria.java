/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog06_tarea;

/**
 *
 * @author eduar
 */
public abstract class CuentaBancaria implements Imprimible {
    
    private Persona titular;
    private double saldo;
    private String IBAN;

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public CuentaBancaria(Persona titular, double saldo, String IBAN) {
        this.titular = titular;
        this.saldo = saldo;
        this.IBAN = IBAN;
    }
    
    @Override
    public String devolverInfoString(){
        return "titular=" + titular.devolverInfoString() + ", saldo=" + this.saldo + ", IBAN=" + this.IBAN;
        // IMPORTANTE titular.devolverInfoString()
    }

}
