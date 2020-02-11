package control;

import DAO.DAO;
import DAO.DAOClients;
import DAO.DAOException;
import DAO.FactoryDAO;
import model.Client;
import model.Film;

public class Main {

	public static void main(String[] args) throws DAOException {
		
		DAO<Film, Integer> dao = FactoryDAO.getInstance().getDAO();
		//dao.get(1);
		System.out.println(dao.getAll());
		//dao.cargarDatos(); Cargar los datos del fichero de peliculas en la base de datos
		DAOClients<Client,Integer> dao1 = FactoryDAO.getInstance().getDAOClient();
		//dao1.getAll();
		

		//dao.cargarDatos();
		//dao1.saveUser();
		//dao.deleteUser();

		
	}


}
