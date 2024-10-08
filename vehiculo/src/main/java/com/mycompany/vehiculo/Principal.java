package com.mycompany.vehiculo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class Principal {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);
        
        boolean salir = false;
        int opcion;
        Vehiculo v = null;
        
        String marca, matricula, descripcion, nombreProp, DNIProp;
        int km, dia, mes, anio;
        double precio;
        LocalDate fechaMatriculacion;
        
        while (!salir) {

            try {

                System.out.println("\n1.Nuevo Vehiculo.");
                System.out.println("2.Ver Matrícula.");
                System.out.println("3.Ver Número de Kilómetros.");
                System.out.println("4.Actualizar Kilómetros.");
                System.out.println("5.Ver años de antigüedad.");
                System.out.println("6.Mostrar propietario.");
                System.out.println("7.Mostrar descripción.");
                System.out.println("8.Mostrar Precio.");
                System.out.println("9.Salir.");
                System.out.println("Elige una Opcion.\n");
                opcion = sn.nextInt();
                sn.nextLine();

                switch (opcion) {
                    case 1:

                        System.out.println("Introduce la Marca");
                        marca = sn.next();

                        System.out.println("Introduce la Matricula");
                        matricula = sn.next();

                        System.out.println("Introduce el número de KM");
                        km = sn.nextInt();

                        if (!Validacion.esPositivo(km)) {
                            throw new Exception("Km no es positivo");
                        }

                        System.out.println("Introduce el dia de la fecha de matriculacion");
                        dia = sn.nextInt();

                        System.out.println("Introduce el mes de la fecha de matriculacion");
                        mes = sn.nextInt();

                        System.out.println("Introduce el año de la fecha de matriculacion");
                        anio = sn.nextInt();

                        fechaMatriculacion = LocalDate.of(anio, mes, dia);

                        if (Validacion.fechaMayorHoy(fechaMatriculacion)) {
                            throw new Exception("Fecha matriculacion es mayor que hoy");
                        }

                        System.out.println("Introduce la descripcion");
                        descripcion = sn.next();

                        System.out.println("Introduce el nombre del propietario");
                        nombreProp = sn.next();

                        System.out.println("Introduce el dni del proprietario");
                        DNIProp = sn.next();

                        if (!Validacion.validarDNI(DNIProp)) {
                            throw new Exception("DNI no valido");
                        }

                        System.out.println("Introduce el precio");
                        precio = sn.nextDouble();

                        v = new Vehiculo(marca, matricula, km, fechaMatriculacion, descripcion, precio, nombreProp, DNIProp);
                        System.out.println("Vehiculo creado");

                        break;

                    case 2:
                        if (v != null) {
                            System.out.println("Matricula:" + v.getMatricula());
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        break;

                    case 3:
                        if (v != null) {
                            System.out.println("Kilometros:" + v.getNumKM());
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        break;

                    case 4:

                        if (v != null) {
                            System.out.println("Introduce el número de KM");
                            km = sn.nextInt();

                            if (!Validacion.esPositivo(km)) {
                                throw new Exception("Km no es positivo");
                            }

                            v.setNumKM(km);
                            System.out.println("Kilometros actualizados.");
                            
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        

                        break;

                    case 5:
                        
                        if (v != null) {
                            System.out.println("Antiguedad: " + v.get_Anios() + " años ");   
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        
                        break;

                    case 6:
                        if (v != null) {
                            System.out.println("Propietario:" + v.getDniPropietario() + " " + v.getNombreProprietario());
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        break;

                    case 7:
                        
                        if (v != null) {
                            System.out.println("Descripcion: " + v.getDescripcion());   
                            System.out.println("Matricula: " + v.getMatricula());  
                            System.out.println("KM: " + v.getNumKM());  
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        
                        break;

                    case 8:
                        if (v != null) {
                            System.out.println("Precio:" + v.getPrecio());
                        } else {
                            System.out.println("Debes crear un vehiculo.");
                        }
                        break;

                    case 9:
                        salir = true;
                        break;

                    default:
                        System.out.println("Elige una opcion entre 1 y 9");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } 
        }
        
        
    }
    
}
