package com.mycompany.centrodeestudios;

import java.util.Scanner;

/**
 *
 * @author pereiras-house
 */
public class CentrodeEstudios {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        
        Alumnos alumno = null;
        Profesores profesor = null;
        
        String nombre, primerApellido, dni, fechaNasc, direccion, telefono, materias = null;
        String ddni;
        String buscaMateria;
        
        while (!salir) {
            // presentamos lo que el jugador puede hacer
            System.out.println("1. Matricular alumnos");
            System.out.println("2. Dar de baja alumnos");
            System.out.println("3. Lista de alumnos");
            System.out.println("4. Lista de profesores");
            System.out.println("5. Busca de alumnos por materia");
            System.out.println("6. Busca de alumnos por dni");
            System.out.println("7. Busca de alumnos por profesor");
            System.out.println("8. Salir");
            String input = sn.nextLine();

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        
                        System.out.println("Introduce el nombre");
                        nombre = sn.next();
                        
                        System.out.println("Introduce el primer apellido");
                        primerApellido = sn.next();

                        System.out.println("Introduce el dni");
                        dni = sn.next();

                        System.out.println("Introduce la fecha de nascimiento por ejemplo 01/01/1990");
                        fechaNasc = sn.next();

                        System.out.println("Introduce la dirección");
                        direccion = sn.next();

                        System.out.println("Introduce el telefono");
                        telefono = sn.next();

                        System.out.println("Introduce la materia");
                        materias = sn.next();

                        alumno = new Alumnos(nombre, primerApellido, dni, fechaNasc, direccion, telefono, materias);
                        System.out.println("Matricula Hecha.");
                        break;
                    case 2:
                        
                        break;
                    case 3:

                        if (alumno != null) {
                            System.out.println("Alumnos:" + alumno.toString());
                        } else {
                            System.out.println("Ninguna matricula disponible.");
                        }
                        break;
                    case 4:

                        System.out.println("Introduce el nombre");
                        nombre = sn.next();
                        
                        System.out.println("Introduce el primer apellido");
                        primerApellido = sn.next();

                        System.out.println("Introduce el dni");
                        dni = sn.next();

                        System.out.println("Introduce la fecha de nascimiento por ejemplo 01/01/1990");
                        fechaNasc = sn.next();

                        System.out.println("Introduce la dirección");
                        direccion = sn.next();

                        System.out.println("Introduce el telefono");
                        telefono = sn.next();

                        System.out.println("Introduce la materia");
                        materias = sn.next();

                        profesor = new Profesores(nombre, primerApellido, dni, fechaNasc, direccion, telefono, materias);
                        System.out.println("Profesor cadastrado.");
                        
                        System.out.println("Profesores:" + profesor.toString());
                        
                        break;

                    case 5:
                        
                        System.out.println("Inserta la materia.");
                        buscaMateria = sn.next();
                        
                        if (buscaMateria.equals(materias)) {
                            System.out.println(alumno.toString());
                        } else {
                            System.out.println("Alumno no encontrado()");
                        }
                        
                        
                        break;
                    case 6:

                        System.out.println("Inserta el DNI");
                        ddni = sn.next();

                        if (ddni == alumno.getDni()) {
                            System.out.println("Alumnos:" + alumno.toString());
                        } else {
                            System.out.println("No existe matricula con el dni introducido");
                        }
                        break;
                    case 7:

                        break;
                    case 8:
                        salir = true; // Salimos del bucle
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elige entre 1 hasta 8.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número.");
                System.out.println(e.getMessage());
                
            }
    }
}

    private static void Profesores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
