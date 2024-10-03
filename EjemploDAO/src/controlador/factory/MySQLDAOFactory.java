package controlador.factory;

import java.sql.Connection;
import java.sql.SQLException;
import controlador.pool.BasicConnectionPool;
import model.dao.EmpleadoDAO;

public class MySQLDAOFactory extends DAOFactory {

	final static  String url = "jdbc:mysql:///empDept";
	final static String user = "root";
	final static String password = "root1234";
	static BasicConnectionPool bcp;

	public MySQLDAOFactory(){

		try {
			bcp=BasicConnectionPool.create(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public Connection getConnection() throws SQLException {
		return bcp.getConnection();
	}
	@Override
	public boolean releaseConnection (Connection connection){
		return bcp.releaseConnection(connection);
	}
	@Override
	public int getSize() {
		return bcp.getSize();
	}

	//add getUser, getURL....
	@Override
	public void shutdown() throws SQLException {
		bcp.shutdown();
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new EmpleadoDAO();
	}

	/*
	 * @Override public DepartamentoDAO getDepartamentoDAO() { // TODO
	 * Auto-generated method stub return new DepartamentoDAO(); }
	 * 
	 * @Override public ProyectoDAO getProyectoDAO() { // TODO Auto-generated method
	 * stub return new ProyectoDAO(); }
	 * 
	 * @Override public FamiliarDAO getFamiliarDAO() { // TODO Auto-generated method
	 * stub return FamiliarDAO(); }
	 */

}
