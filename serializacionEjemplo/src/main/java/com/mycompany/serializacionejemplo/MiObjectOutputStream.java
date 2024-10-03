/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serializacionejemplo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author eduar
 */
// Esto es para quando tengar que poner nuevas cabeceras ao inves de usar ObjectOutputStream usar MiObjectOutputStream para que se inserten los nuevos datos.
public class MiObjectOutputStream extends ObjectOutputStream {
    //Esta clase hereda sus propriedades de ObjectOutputStream 
    protected void writeStreamHeader() throws IOException {
        // No hace nada
    }
    
    //Constructores
    public MiObjectOutputStream() throws IOException {
        super();
    }
    
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
