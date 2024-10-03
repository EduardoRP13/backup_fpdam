/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serializacionejemplo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author eduar
 */
public class SerializacionEjemplo {
    // Escribir

    public static void main(String[] args) throws IOException {
        // Creamos el objeto
        Empleado empleado1=new Empleado("Fernando", "Dominique", 23, 1000);
        Empleado empleado2=new Empleado("Vladimir", "Roskov", 29, 1200);
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\eduar\\Documents\\empleados.ddr"))){
            //Escribir en un fichero
            oos.writeObject(empleado1);
            oos.writeObject(empleado2);    
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        // Leer Objecto
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:\\Users\\eduar\\Documents\\empleados.ddr"))){
            // Cuando no haya mas objetos saltara la excepcion EOFException
            while(true){
                // Leer objeto
            Empleado aux=(Empleado)ois.readObject();
            System.out.println(aux.getNombre());
            System.out.println(aux.getApellido());
            System.out.println(aux.getEdad());
            System.out.println(aux.getSalario());
            System.out.println("");
            }
        }catch(ClassNotFoundException e){
        }catch(EOFException e){
        }catch(IOException e){
        }
    }
}
