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
	
	private static final String SQL_INSERT = "INSERT INTO pelicula(name, year, category) VALUES(?, ?, ?)";
	private static final String getAllFilms = "SELECT * FROM pelicula";

	private final static Logger LOGGER = Logger.getLogger("CargarDatosBD");
	private File archivo = null;
	private FileReader fr =null;
	private BufferedReader br = null;
	

	public Database(Connection connection) {
		this.connection= connection;
	}

	@Override
	public Film get(Integer idFilm) throws DAOException {	
		return null;
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
				String yearString = parts[1];
				String categoria = parts[2];
				int yearInt = Integer.parseInt(yearString);	
				pelicula = new Film(nombrePelicula,categoria,yearInt);
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
		List<Film> listaClientes = new ArrayList<Film>();
		
		ResultSet rs= null;
		PreparedStatement stmt = null;
		
		
		try {
            stmt = connection.prepareStatement(getAllFilms);
            rs = stmt.executeQuery();
            while(rs.next()){
            	                
            	String name = rs.getString("name");
            	String category = rs.getString("category");
            	int year = rs.getInt("year");
            	
                
                Film f = new Film();
                f.setName(name);
                f.setCategory(category);
                f.setYear(year);
                
                listaClientes.add(f);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
        }
		return listaClientes;
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
