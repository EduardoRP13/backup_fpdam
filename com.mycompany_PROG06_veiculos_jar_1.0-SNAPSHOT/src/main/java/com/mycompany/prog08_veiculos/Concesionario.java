/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog08_veiculos;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ArrayList: ArrayList es una implementación de la interfaz List en Java que
 * proporciona una lista dinámica que puede crecer o disminuir según sea
 * necesario. Los ArrayList se basan en un array subyacente, pero manejan
 * automáticamente el redimensionamiento del array y proporcionan métodos
 * convenientes para agregar, eliminar y acceder a elementos. Por ejemplo:
 *  Primer Importamos:
 * import java.util.ArrayList;
 *
 * ArrayList<String> listaNombres = new ArrayList<>(); 
 * listaNombres.add("Juan");
 * listaNombres.add("María");
 *
 * @author eduar
 */
public class Concesionario {
    
    private ArrayList<Vehiculo> vehiculos; // com eso no tenemos limite 
    
    public Concesionario(){
        this.vehiculos = new ArrayList<>();
    }
    
    public Vehiculo buscaVehiculo(String matricula){
        
        /**
         * Se recorre el array de vehículos (this.vehiculos) utilizando un bucle
         * for. La variable i se utiliza como índice para recorrer cada elemento
         * del array.
         *
         * En cada iteración del bucle, se obtiene el vehículo en la posición i
         * del array y se asigna a la variable v. Esto se hace utilizando la
         * expresión Vehiculo v = this.vehiculos[i];.
         *
         * Se verifica si la matrícula del vehículo v es igual a la matrícula
         * proporcionada como argumento al método. Esto se hace utilizando la
         * condición v.getMatricula().equals(matricula). Si la matrícula del
         * vehículo coincide con la matrícula proporcionada, se devuelve el
         * vehículo v.
         *
         * Si no se encuentra ningún vehículo con la matrícula proporcionada
         * después de recorrer todo el array, el método devuelve null, lo que
         * indica que no se encontró ningún vehículo con esa matrícula.
         */
        for (Vehiculo v:this.vehiculos) {
            if(v.getMatricula().equals(matricula)){
                return v;
            }
            
        }
        return null;
    }
    
    public int insertarVehiculo(Vehiculo v){
        /**
         * El método insertarVehiculo recibe un parámetro v de tipo Vehiculo, que representa el vehículo que se va a insertar en el concesionario.
         */
        
        /**
         * el Primer (if) verifica si el número de vehículos en el concesionario (this.numVehiculos) 
         * es igual a la longitud máxima del array de vehículos (this.vehiculos.length). 
         * Si esto es cierto, significa que el concesionario está lleno y no se puede agregar más vehículos.
         */
        /**
         * ESO NOS SOBRA YA QUE NO TENEMOS LIMITE
         * if(this.numVehiculos == this.vehiculos.length){
            return -1;
        }
        * */
        /**
         * if verifica si ya existe un vehículo con la misma matrícula que el vehículo que se va a insertar. 
         * Esto se realiza llamando al método buscaVehiculo del concesionario y pasando la matrícula del vehículo que se va a insertar 
         * como argumento. Si el método buscaVehiculo devuelve un vehículo (es decir, no es null), 
         * significa que ya existe un vehículo con la misma matrícula en el concesionario.
         */
        if(this.buscaVehiculo(v.getMatricula()) != null){
            return -2;
        } else{
            /**
             * Si el concesionario no está lleno y el vehículo no existe previamente en el concesionario, se procede a insertar el vehículo.
             * El vehículo se agrega al array de vehículos (this.vehiculos) en la posición indicada por this.numVehiculos, 
             * que es el número actual de vehículos en el concesionario. Luego, this.numVehiculos se incrementa para 
             * reflejar que se ha agregado un nuevo vehículo.
             */
            this.vehiculos.add(v); //asi añadimos a la Array
            
            Collections.sort(vehiculos); // esto organiza de coche con matricula de menor a mayor, toda vez que he insertado un coche.
            
            return 0;
        }
    }
    
    public void listarVehiculos(){
        
        /**
         * Se recorre el array de vehículos (this.vehiculos) utilizando un bucle
         * for. La variable i se utiliza como índice para recorrer cada elemento
         * del array.
         *
         * En cada iteración del bucle, se obtiene el vehículo en la posición i
         * del array y se asigna a la variable v. Esto se hace utilizando la
         * expresión Vehiculo v = this.vehiculos[i];.
         *
         * Se imprime la representación en formato de cadena del vehículo v
         * utilizando el método toString(). Esto se hace con la expresión
         * System.out.println(v.toString()).
         *
         * El bucle continúa hasta que se hayan recorrido todos los vehículos en
         * el array.
         */
        
        for (Vehiculo v:this.vehiculos) {
            System.out.println(v.toString());
        }
    }   
    
    public boolean actualizaKm(String matricula, int kms){
        
        /**
         * Se recorre el array de vehículos (this.vehiculos) utilizando un bucle
         * for. La variable i se utiliza como índice para recorrer cada elemento
         * del array.
         *
         * En cada iteración del bucle, se obtiene el vehículo en la posición i
         * del array y se asigna a la variable v. Esto se hace utilizando la
         * expresión Vehiculo v = this.vehiculos[i];.
         *
         * Se compara la matrícula del vehículo v con la matrícula proporcionada
         * como argumento utilizando el método equals(). Si coinciden, significa
         * que se ha encontrado el vehículo que se desea actualizar.
         *
         * Si se encuentra el vehículo, se actualiza el número de kilómetros del
         * vehículo utilizando el método setNumKM() con el valor proporcionado
         * como argumento (kms).
         *
         * Se devuelve true para indicar que se ha encontrado y actualizado
         * exitosamente el vehículo.
         *
         * Si el bucle termina de recorrer todos los vehículos sin encontrar uno
         * con la matrícula proporcionada, se devuelve false para indicar que no
         * se ha encontrado ningún vehículo con esa matrícula y, por lo tanto,
         * no se ha realizado ninguna actualización.
         */
        
        for (Vehiculo v:this.vehiculos) {
            
            if(v.getMatricula().equals(matricula)){
                v.setNumKM(kms);
                return true;
            }
            
        }
        return false;
        
    }
    
    public boolean eliminarVehiculo(String matricula){
        
        for (Vehiculo v:this.vehiculos) {
            
            if(v.getMatricula().equals(matricula)){
                this.vehiculos.remove(v);
                return true;
            }
            
        }
        return false;
        
    }
    
}
