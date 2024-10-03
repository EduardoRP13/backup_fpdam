package controlador.factory;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.EmpleadoDAO;

public abstract class DAOFactory {
	// List of DAO types supported by the factory
	  public static final int MYSQL = 1;
	 

	  public abstract Connection getConnection() throws Exception ;
	  // There will be a method for each DAO that can be 
	  // created. The concrete factories will have to 
	  // implement these methods.
	  public abstract EmpleadoDAO getEmpleadoDAO();

		/*
		 * public abstract DepartamentoDAO getDepartamentoDAO(); 
		 * public abstractProyectoDAO getProyectoDAO();
		 *  public abstract FamiliarDAO getFamiliarDAO();
		 */
	  
	  public static DAOFactory getDAOFactory(
	      int whichFactory) {
	  
	    switch (whichFactory) {
	      case MYSQL: 
	          return new MySQLDAOFactory();
	      default           : 
	          return null;
	    }
	  }
	public boolean releaseConnection(Connection connection) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void shutdown() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
