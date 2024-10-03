/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pereiras-house
 */
public class ConnectionDB {
    
    private Connection conexion;
    
    /*
    // una mejora 
    Crea una clase DBConnectionManager que gestione la conexión a la base de datos.
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class DBConnectionManager {
        private static Connection connection;
        private static final String URL = "jdbc:mariadb://localhost:3306/tu_base_de_datos";
        private static final String USER = "tu_usuario";
        private static final String PASSWORD = "tu_contraseña";

        private DBConnectionManager() { }

        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        }

        public static void closeConnection() throws SQLException {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    
    
    //Ejemplo de modificacion de la clase 
    
    public class PropietariosDAO {
    public static int insertarPropietario(int id, String nombre, String dni) {
        String sql = "INSERT INTO propietarios (id, nombre, dni) VALUES (?, ?, ?)";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, nombre);
            statement.setString(3, dni);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
     */
    
    public void openConnection() throws SQLException{
        this.conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/concesionario", "root", "casa1996");
    }
    
    public void closeConnection() throws SQLException{
        this.conexion.close();
    }
    
    public Connection getConnection(){
        return this.conexion;
    }
    
}
