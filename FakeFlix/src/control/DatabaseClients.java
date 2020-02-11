package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import DAO.DAOClients;
import DAO.DAOException;
import model.Client;
import model.Film;

public class DatabaseClients implements DAOClients<Client, Integer>{
	
	private Connection connection;
	private final String GET= "SELECT shirt_num, name, position FROM players WHERE shirt_num = ?";
	private static final String SQL_SELECT = "SELECT idCliente, name, dateBirth, city, premium FROM cliente";
	
	private final static Logger LOGGER = Logger.getLogger("CargarDatosBD");
	
	public DatabaseClients(Connection connection) {
		this.connection= connection;
	}
	
	public List <Client> getAll() throws DAOException {
		
		List<Client> listaClientes = new ArrayList<Client>();
		
		ResultSet rs= null;
		PreparedStatement stmt = null;
		
		
		try {
            stmt = connection.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
            	                
            	int id_cliente = rs.getInt("idCliente");
            	String name = rs.getString("name");
            	String city = rs.getString("city");
            	boolean premium = rs.getBoolean("premium");
            	int birthDate = rs.getInt("dateBirth");
                
                Client cliente = new Client();
                cliente.setId_cliente(id_cliente);
                cliente.setName(name);
                cliente.setCity(city);
                cliente.setPremium(premium);
                cliente.setBirthdate(birthDate);
                
                listaClientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
        }
		System.out.println(listaClientes);	
		return listaClientes;
		
		
	}
	
	
	public void save(Client cliente) {
		
	}
	
	
	public void delete(int t) {
		
	}
	
	
	public void update(Client cliente) {
		
	}

	void cargarDatos() {
		
	}

	@Override
	public Client get(Integer t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
