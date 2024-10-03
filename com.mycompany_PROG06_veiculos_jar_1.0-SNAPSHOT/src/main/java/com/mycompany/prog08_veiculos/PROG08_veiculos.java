package com.mycompany.prog08_veiculos;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class PROG08_veiculos {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);
                
        boolean salir = false;
        boolean correcto = false;
        int opcion;
        
        Concesionario concesionario = new Concesionario();
        Vehiculo v;
        String marca, matricula, descripcion, nombreProp, DNIProp;
        int kms=0, dia, mes, anio;
        double precio = 0;
        LocalDate fechaMatriculacion = null;
        
        
        while(!salir){
            
            System.out.println("1. Nuevo vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("3. Buscar vehiculo");
            System.out.println("4. Modificar Kms vehiculo");
            System.out.println("5. Eliminar vehiculo");
            System.out.println("6. Salir");
            System.out.println("Elige una opcion");
            opcion = sn.nextInt();
            
            switch (opcion) {

                case 1:
                    System.out.println("Introduce la Marca");
                    marca = sn.next();

                    do{
                        
                        System.out.println("Introduce la Matricula");
                        matricula = sn.next();
                    }while(!Validacion.validarMatricula(matricula));
                    
                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el número de KM");
                            kms = sn.nextInt();
                        } catch  (InputMismatchException e) { //Si el usuario ingresa un valor no entero (por ejemplo, letras o caracteres especiales), se lanza una excepción InputMismatchException.
                            correcto = false; 
                            System.out.println("Error tienes que poner los numeros de Kilometros del coche ejemplo (50000).)");
                            sn.next(); // IMPORTANTE PONER ESTO PARA QUE NO DE ERROR AL PONER LETRAS INVES DE INT COMO PIDE
                        }
                    }while(!correcto); //El bucle se repetirá mientras correcto sea false, es decir, mientras la entrada del usuario no sea válida.
                    
                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el dia de la fecha de matriculacion");
                            dia = sn.nextInt();

                            System.out.println("Introduce el mes de la fecha de matriculacion");
                            mes = sn.nextInt();

                            System.out.println("Introduce el año de la fecha de matriculacion");
                            anio = sn.nextInt();

                            fechaMatriculacion = LocalDate.of(anio, mes, dia);

                            
                        } catch  (InputMismatchException e) { //Si el usuario ingresa un valor no entero (por ejemplo, letras o caracteres especiales), se lanza una excepción InputMismatchException.
                            correcto = false;
                            System.out.println("ERROR Tienes que poner una fecha en numeros ejemplo (dia 1 - mes 2 - año 1996) vuelve a insertar desde el principio.");
                            sn.next(); // IMPORTANTE PONER ESTO PARA QUE NO DE ERROR AL PONER LETRAS INVES DE INT COMO PIDE
                        } catch (DateTimeException e) {
                            correcto = false;
                            System.out.println("Error tienes que poner una fecha anterior al dia de mañana.)");
                        }
                    }while(!correcto); //El bucle se repetirá mientras correcto sea false, es decir, mientras la entrada del usuario no sea válida.
                    

                    System.out.println("Introduce la descripcion");
                    descripcion = sn.next();
                    
                    do {
                        System.out.println("Introduce el nombre del propietario");
                        nombreProp = sn.next();
                        /**
                         * La condición !Validacion.validarNombre(nombreProp) verifica si el nombre ingresado no es válido.
                         * Si el nombre no es válido, el bucle se repite y se solicita al usuario que vuelva a ingresar el nombre 
                         * hasta que proporcione un nombre válido.
                         */
                    }while(!Validacion.validarNombre(nombreProp));

                    do {
                        System.out.println("Introduce el dni del proprietario");
                        DNIProp = sn.next();
                    }while(!Validacion.validarDNI(DNIProp));

                    
                    do {
                        correcto = true;

                        try {
                            System.out.println("Introduce el precio");
                            precio = sn.nextDouble();
                            
                            
                        } catch  (InputMismatchException e) {
                        correcto = false;
                        System.out.println("Tienes que poner un precio en numeros ejemplo (10000)");
                        sn.next(); // IMPORTANTE PONER ESTO PARA QUE NO DE ERROR AL PONER LETRAS INVES DE DOUBLE COMO PIDE
                        }
                       
                    }while(!correcto);

                    v = new Vehiculo(marca, matricula, kms, fechaMatriculacion, descripcion, precio, nombreProp, DNIProp);
                    
                    /**
                     * Este switch Verifica cual case se cumple en cada caso con el metodo concesionario.insertarVehiculo
                     */
                    switch(concesionario.insertarVehiculo(v)){
                        case -2:
                            System.out.println("El vehiculo existe");
                            break;
                        case -1:
                            System.out.println("El concesionario esta lleno");
                            break;
                        case 0:
                            System.out.println("Vehiculo creado correctamente");
                            break;
                    }
                    
                    break;
                case 2:
                    concesionario.listarVehiculos();
                    break;
                case 3:
                    System.out.println("Inserta la matricula");
                    matricula = sn.next();
                    
                    v = concesionario.buscaVehiculo(matricula);
                    
                    if(v != null){
                        System.out.println(v.getMarca());
                        System.out.println(v.getMatricula());
                        System.out.println(v.getPrecio()); 
                    } else {
                        System.out.println("No existe el vehiculo con la matricula introducida");
                    }
                    
                    break;
                case 4:
                    System.out.println("Inserta la matricula");
                    matricula = sn.next();
                    
                    System.out.println("Inserta los Kilometros");
                    kms = sn.nextInt();
                    
                    if(concesionario.actualizaKm(matricula, kms)){
                        System.out.println("Los kms se han actualizados");
                    } else {
                        System.out.println("No existe el vehiculo con la matricula introducida");
                    }
                    
                    break;
                case 5:
                    System.out.println("Inserta la matricula");
                    matricula = sn.next();
                    
                    if(concesionario.eliminarVehiculo(matricula)){
                        System.out.println("El vehiculo con la matricula introducida se ha Eliminado");
                    } else {
                        System.out.println("El vehiculo con la matricula introducida no existe");
                    }
                    break;
                case 6:
                    salir = true;
                    break; 

                
            }
            
            
        }
        
    }
}
