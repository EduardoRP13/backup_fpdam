/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.prog11.princ;

/**
 *
 * @author pereiras-house
 */
import com.prog11.bbdd.ConnectionDB;
import com.prog11.bbdd.PropietariosDAO;
import com.prog11.bbdd.VehiculosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prog11_Principal {

    public static void main(String[] args) {

        /*
        // eso se agrega al pom.xml
        <dependencies>
            <!-- https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->
            <dependency>
                <groupId>org.mariadb.jdbc</groupId>
                <artifactId>mariadb-java-client</artifactId>
                <version>3.3.3</version>
            </dependency>
        </dependencies>
        
        // teste de conexion
        ConnectionDB conexion = new ConnectionDB();
        try {
            conexion.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Prog11_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        */
        
        /*
        Ejemplo se usamos DBConnectionManager en MAIN
        public class Prog11_Principal {

    public static void main(String[] args) {
        try {
            System.out.println("Insertar varios vehículos y propietarios.");

            if (PropietariosDAO.insertarPropietario(6, "prop 1", "12345678A") == 0) {
                System.out.println("Se ha insertado el propietario prop 1");
            } else {
                System.out.println("No se ha insertado el propietario prop 1");
            }

            if (PropietariosDAO.insertarPropietario(7, "prop 2", "12345678B") == 0) {
                System.out.println("Se ha insertado el propietario prop 2");
            } else {
                System.out.println("No se ha insertado el propietario prop 2");
            }

            if (VehiculosDAO.insertarNuevoVehiculo("123ABC", "Seat", 70000, 7000, "Ibiza", 7) == 0) {
                System.out.println("Se ha insertado el vehiculo con matricula 123ABC");
            } else {
                System.out.println("No se ha insertado el vehiculo con matricula 123ABC");
            }

            if (VehiculosDAO.insertarNuevoVehiculo("123CBA", "Peugeout", 80000, 1000, "3008", 5) == 0) {
                System.out.println("Se ha insertado el vehiculo con matricula 123CBA");
            } else {
                System.out.println("No ha insertado el vehiculo con matricula 123CBA");
            }

            System.out.println("Listar todos los vehículos.");

            ArrayList<String> datos = VehiculosDAO.recuperarTodosVehiculos();

            for (String dato : datos) {
                System.out.println(dato);
            }

            // Resto del código...

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnectionManager.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
        */
        
        ArrayList<String> datos = new ArrayList<>();
        ConnectionDB conexion = new ConnectionDB();

        System.out.println("Insertar varios vehículos y propietarios.");

        if (PropietariosDAO.insertarPropietario(conexion, 6, "prop 1", "12345678A") == 0) {
            System.out.println("Se ha insertado el propietario prop 1");
        } else {
            System.out.println("No se ha insertado el propietario prop 1");
        }

        if (PropietariosDAO.insertarPropietario(conexion, 7, "prop 2", "12345678B") == 0) {
            System.out.println("Se ha insertado el propietario prop 2");
        } else {
            System.out.println("No se ha insertado el propietario prop 2");
        }

        if (VehiculosDAO.insertarNuevoVehiculo(conexion, "123ABC", "Seat", 70000, 7000, "Ibiza", 7) == 0) {
            System.out.println("Se ha insertado el vehiculo con matricula 123ABC");
        } else {
            System.out.println("No se ha insertado el vehiculo con matricula 123ABC");
        }

        if (VehiculosDAO.insertarNuevoVehiculo(conexion, "123CBA", "Peugeout", 80000, 1000, "3008", 5) == 0) {
            System.out.println("Se ha insertado el vehiculo con matricula 123CBA");
        } else {
            System.out.println("No ha insertado el vehiculo con matricula 123CBA");
        }

        System.out.println("Listar todos los vehículos.");

        datos = VehiculosDAO.recuperarTodosVehiculos(conexion);

        for (String dato : datos) {
            System.out.println(dato);
        }

        System.out.println("Actualizar propietario de un vehículo.");

        if (VehiculosDAO.actualizarVehiculo(conexion, "2230FVD", 7) == 0) {
            System.out.println("Vehiculo con matricula 2230FVD ha cambiado de propietario con id 7");
        } else {
            System.out.println("No se ha podido cambiar el propietario");
        }

        System.out.println("Listar todos los vehículos.");

        datos = VehiculosDAO.recuperarTodosVehiculos(conexion);

        for (String dato : datos) {
            System.out.println(dato);
        }

        System.out.println("Eliminar un vehículo que exista.");

        if (VehiculosDAO.eliminarVehiculo(conexion, "2230FVD") == 0) {
            System.out.println("Se ha eliminado el vehiculo con matricula 2230FVD");
        } else {
            System.out.println("No se ha podido eliminar el vehiculo");
        }

        System.out.println("Eliminar un vehículo que no exista.");

        if (VehiculosDAO.eliminarVehiculo(conexion, "1111AAA") == 0) {
            System.out.println("Se ha eliminado el vehiculo con matricula 1111AAA");
        } else {
            System.out.println("No se ha podido eliminar el vehiculo");
        }

        System.out.println("Listar todos los vehículos.");

        datos = VehiculosDAO.recuperarTodosVehiculos(conexion);

        for (String dato : datos) {
            System.out.println(dato);
        }

        System.out.println("Listar los vehículos de una marca.");

        datos = VehiculosDAO.recuperarTodosVehiculosPorMarca(conexion, "Citroen");

        for (String dato : datos) {
            System.out.println(dato);
        }

        System.out.println("Listar todos los vehículos de un propietario.");

        datos = PropietariosDAO.recuperarVehiculos(conexion, "03475050X");

        for (String dato : datos) {
            System.out.println(dato);
        }

        System.out.println("Eliminar un propietario con vehículos.");

        if (PropietariosDAO.eliminarPropietario(conexion, "03475050X") == 0) {
            System.out.println("Se ha eliminado el propietario con el dni 03475050X");
        } else {
            System.out.println("No se ha eliminado el propietario con el dni 03475050X");
        }

        System.out.println("Eliminar un propietario sin vehículos.");

        if (PropietariosDAO.eliminarPropietario(conexion, "123456789A") == 0) {
            System.out.println("Se ha eliminado el propietario con el dni 123456789A");
        } else {
            System.out.println("No se ha eliminado el propietario con el dni 123456789A");
        }
        
    }

}
