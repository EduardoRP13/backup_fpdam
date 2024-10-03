package controlador;

import java.sql.Connection;
import java.util.List;

import controlador.factory.DAOFactory;
import model.dao.EmpleadoDAO;
import model.vo.Empleado;
import vista.Vista;

public class Controller {

	static List<Empleado> empleados;
	
	public static void main(String[] args) {
		//Create factory
		DAOFactory mySQLFactory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		//Create dAO
		EmpleadoDAO empDAO=mySQLFactory.getEmpleadoDAO();
		
		//CargarEmpleados
		
			
			
		
		
		//Inicializar todo
		//...
		
		
		//Vista
		Vista v=new Vista();
		Connection con;
		int opcion=1;
		while (opcion !=0) {
			opcion=v.mostrarMenu();
			switch(opcion){
				case 1:
					
					try {
						con=mySQLFactory.getConnection();
						empleados=empDAO.getAll(con);
						mySQLFactory.releaseConnection(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String output=new String();
					for(int i=0;i<empleados.size();i++) {
						output+=" empno= "+empleados.get(i).getEmpno()+", ename="+empleados.get(i).getEname()+", deptno="+empleados.get(i).getDeptno()+"\n";
					}
					v.showMessage(output);
					break;
				case 2:
					int empno=v.getEmpno();
					Empleado emp=new Empleado();
					emp.setEmpno(empno);
					try {
						con=mySQLFactory.getConnection();
						boolean b= empDAO.delete(emp, mySQLFactory.getConnection());
						mySQLFactory.releaseConnection(con);
						if(b)
							System.out.println("Empleado "+ empno+ " borrado");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
			}
		}
		
		try {
			mySQLFactory.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Bye bye");
	}
	
	
}
