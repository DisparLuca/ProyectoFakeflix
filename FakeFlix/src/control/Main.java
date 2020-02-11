package control;


import DAO.DAO;
import DAO.DAOClients;
import DAO.DAOException;
import DAO.FactoryDAO;
import model.Client;
import model.Film;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static Logger logger;

	static {
		try {
			// you need to do something like below instead of Logger.getLogger(....);
			// Logger.getLogger se usaba hasta la versi�n 2.7 y muchos ejemplos de internet
			// estan asi
			logger = LogManager.getLogger(Main.class);
		} catch (Throwable e) {
			System.out.println("Don't work");
		}
	}

	
	public static void main(String[] args) throws DAOException {
		
		logger.info("empieza");
		
		DAO<Film, Integer> dao = FactoryDAO.getInstance().getDAO();
		//dao.get(1);

		logger.trace("DAO creado");
		//dao.cargarDatos(); Cargar los datos del fichero de peliculas en la base de datos
		DAOClients<Client,Integer> dao1 = FactoryDAO.getInstance().getDAOClient();
		dao1.getAll();
		
		logger.trace("DAO1 creado");
		
		//dao.cargarDatos();
		dao.saveUser();
		//dao.deleteUser();

		logger.trace("DAO saveUser hecho");
		
		logger.info("termina");
	}


}
