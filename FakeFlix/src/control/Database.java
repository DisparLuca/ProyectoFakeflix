package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.DAO;
import DAO.DAOException;
import model.Client;
import model.Film;
import model.Input;
import mysqlConnection.DBConnection_MySQL;

public class Database implements DAO<Film, Integer> {

	private Connection connection;
	private final String GET= "SELECT shirt_num, name, position FROM players WHERE shirt_num = ?";
	private static final String SQL_INSERT = "INSERT INTO pelicula(name, year, category) VALUES(?, ?, ?)";

	private static final String SQL_INSERTUSER = "INSERT INTO cliente(name, dateBirth, city, premium) VALUES(?, ?, ?, ?)";
	private static final String SQL_DELETEUSER = "DELETE FROM cliente where idCliente = ?";
	

	private final static Logger LOGGER = Logger.getLogger("CargarDatosBD");
	private File archivo = null;
	private FileReader fr =null;
	private BufferedReader br = null;
	

	public Database(Connection connection) {
		this.connection= connection;
	}

	@Override
	public Film get(Integer idFilm) throws DAOException {
		ResultSet resultSet= null;
		PreparedStatement preparedStatement= null;
		Film film= null;

		try {
			
			preparedStatement= connection.prepareStatement(GET);
			preparedStatement.setInt(1, idFilm);
			resultSet= preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String name= resultSet.getString("name");
				String category=resultSet.getString("category");
				int year = resultSet.getInt("year");
				
				film= new Film(name, category,year);
				System.out.println(film.getName());
			
			}//if
			
		} catch (SQLException e) {throw new DAOException("Excepción SQL", e);
		
		} finally {
			
			try {
				
				preparedStatement.close();
				resultSet.close();
				
			} catch (SQLException e) {throw new DAOException("Excepción SQL", e);}
			
		}//finally
		
		return film;
	}
	
	@Override
    public void save(Film pelicula) throws DAOException {
    	
        PreparedStatement stmt = null;
      
        try {
            
            stmt = connection.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getName());
            stmt.setInt(2, pelicula.getYear());
            stmt.setString(3, pelicula.getCategory());
            stmt.executeUpdate();
            
            System.out.println("ejecutando query:" + SQL_INSERT);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
        	   
        }
        
        
    }
	
	/**
	 * @author David Pacios Fernández
	 * Creación del método que intorduce un/a cliente en la base de datos. no había tocado base de datos nunca, muy divertido.
	 * El método pide al usuario los datos del cliente: nombre, fecha de nacimiento, ciudad y si es o no cliente premium. 
	 */
	@Override
	public void saveUser() {
				
		 PreparedStatement stmt = null;
	     Client u = new Client();
	     Input in = new Input();
		
	     System.out.println("now select the client's name: ");
	     String name = in.readString();
	     u.setName(name);
	     System.out.println("select the client's date of birth: ");
	     int dateBirth = in.readInt();
	     u.setBirthdate(dateBirth);
	     
	     System.out.println("select the client's city of residence: ");
	     String city = in.readString();
	     u.setCity(city);
	     System.out.println("select if the client's contract is of the premium modality(Y/N):");
	     int isPremium = 0;
	     String modality;
	     do {
	    	 modality = in.readString();
	    	 if (modality.equalsIgnoreCase("y")) {
	    		 isPremium = 1;
	    	 } else if (modality.equalsIgnoreCase("n")) {
	    		 isPremium = 0;
	    	 } else {
	    		 LOGGER.log(Level.SEVERE, "sorry, only 'Y' or 'N' are acceptable responses");
	    	 }
	     	} while(!modality.equalsIgnoreCase("y") && !modality.equalsIgnoreCase("n"));
	 
	     try {
	            
	          stmt = connection.prepareStatement(SQL_INSERTUSER);
	          stmt.setString(1, u.getName());
	          stmt.setInt(2, u.getBirthdate());
	          stmt.setString(3, u.getCity());
	          stmt.setInt(4, isPremium);
	          stmt.executeUpdate();
	            
	          System.out.println("ejecutando query:" + SQL_INSERTUSER);
	        } catch (SQLException ex) {
	            ex.printStackTrace(System.out);
	        }
	        finally{
	        	   
	        }
	}
	
	/**
	 * @author David
	 * método para pedir la id de un usuario y borrarlo de la base de datos. 
	 */
	@Override
	public void deleteUser() {
		
		PreparedStatement stmt = null;
		Input in = new Input();
		System.out.println("Select the id of the user to delete: ");
		int idToDelete = in.readInt();
		
		try {
			
			stmt = connection.prepareStatement(SQL_DELETEUSER);
			stmt.setInt(1, idToDelete);
			stmt.executeUpdate();
			System.out.println("ejecutando query:" + SQL_DELETEUSER);
			
		} catch(SQLException ex) {
			
		}	finally {
			
		}
	}
	
	@Override
	public void cargarDatos() {
		
		LOGGER.log(Level.INFO,"Leyendo fichero de peliculas");
		try {
			
			archivo = new File ("./FakeFlix/settings/peliculas_cat.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
						
			String linea=null;
					
			Film pelicula;
			while((linea=br.readLine())!=null) {
			
				String[] parts = linea.split(",");
				String nombrePelicula = parts[0]; 
				String a�oString = parts[1];
				String categoria = parts[2];
				int a�oInt = Integer.parseInt(a�oString);	
				pelicula = new Film(nombrePelicula,categoria,a�oInt);
				save(pelicula);
				System.out.println(pelicula);
				
				}
			LOGGER.log(Level.INFO,"Peliculas leidas correctamente");
									
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if(null != fr) {
					fr.close();
				}
			}catch(Exception e2){
					e2.printStackTrace();
				}
		}
	
	}
	
	@Override
	public List <Film> getAll() throws DAOException {
		
		return null;
	}


	@Override
	public void delete(int t) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Film t) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
