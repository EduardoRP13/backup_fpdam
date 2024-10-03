/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog08_tareaBanco;

import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Banco {
    /**
    ISSO E UMA ARRAY DINAMICA AHORA VAMOS EMPEZAR COM ARRAYLIST INFINITAS 
    private CuentaBancaria[] cuentas;
    private final int MAX_CUENTAS = 100;
    private int numeroCuentas; 
    */
    
    private ArrayList<CuentaBancaria> cuentas;
    
    public Banco() {
        
         /**
        ISSO E UMA ARRAY DINAMICA AHORA VAMOS EMPEZAR COM ARRAYLIST INFINITAS 
        this.cuentas = new CuentaBancaria[this.MAX_CUENTAS];
        this.numeroCuentas = 0;
        */
        this.cuentas = new ArrayList<>();
        
    }
    
     public boolean abrirCuenta(CuentaBancaria c) {

        CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
        if (existe != null) {
            System.out.println("Ya existe la cuenta bancaria");
            return false;
        }

        this.cuentas.add(c);
        return true;

    }

    public String[] listadoCuentas() {
        String[] infoCuentas = new String[this.cuentas.size()];
        for (int i = 0; i < infoCuentas.length; i++) {
            infoCuentas[i] = this.cuentas.get(i).devolverInfoString();
        } //this.cuentas.size() devuelve el número de elementos en la lista cuentas 
        return infoCuentas;
    }

    public String informacionCuenta(String IBAN) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.devolverInfoString();
        }
        return null;
    }

    public boolean ingresoCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {

            boolean sePuedeRetirar = false;
            
            if (c.getSaldo() - cantidad >= 0) {
                sePuedeRetirar = true;
            }else if(c instanceof CuentaCorrienteEmpresa){
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)c;
                if(Math.abs(c.getSaldo() - cantidad) <= aux.getMaximoDescubierto()){
                    sePuedeRetirar = true;
                }
            }
            
            if(sePuedeRetirar){
                c.setSaldo(c.getSaldo() - cantidad);
            }
            
            return sePuedeRetirar;

        }
        return false;
    }

    public double obtenerSaldo(String IBAN) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.getSaldo();
        }
        return -1;
    }

    public boolean eliminarCuenta(String IBAN){
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if(c != null){
            for (CuentaBancaria cEliminar: this.cuentas){
                if(cEliminar.getIBAN().equals(IBAN) && cEliminar.getSaldo() == 0){ //
                    this.cuentas.remove(cEliminar);
                    return true;
                }
            }
        }
        return false;
    }
    
    private CuentaBancaria buscarCuenta(String IBAN) {
        for (CuentaBancaria c: this.cuentas) { //FORIT
            if (c.getIBAN().equals(IBAN)) {
                return c;
            }
        }
        return null;
    }
    
    protected static void ingresarCuentasYa(Banco banco) {
        // Crea las cuentas predefinidas aquí
        Persona titular1 = new Persona("Juan", "García", "12345678A");
        CuentaBancaria cuenta1 = new CuentaAhorro(5.0, titular1, 1000.0, "ES12345678901234567890");
        banco.abrirCuenta(cuenta1);

        Persona titular2 = new Persona("María", "López", "87654321B");
        CuentaBancaria cuenta2 = new CuentaCorrientePersonal(0.0, "BBVA", titular2, 500.0, "ES09876543210987654321");
        banco.abrirCuenta(cuenta2);

        Persona titular3 = new Persona("Pedro", "Martínez", "56789012C");
        String listaAutorizadasEmpresa = "BBVA, Santander, CaixaBank, Banco Sabadell";
        CuentaBancaria cuentaCorrienteEmpresa = new CuentaCorrienteEmpresa(500.0, 0.1, 20.0, listaAutorizadasEmpresa, titular3, 5000.0, "ES34567890123456789012");
        banco.abrirCuenta(cuentaCorrienteEmpresa);

    }

    
}
    

