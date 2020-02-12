package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAOClients<T, K> {
	
	//Obtener
	public T get(K t) throws DAOException;
	
	//Obtener Todos
	public List<T> getAll() throws DAOException;
	
	//Guardar
	public void save(T t) throws DAOException;
	
	//Eliminar
	public void delete(int t) throws DAOException;
	
	//Actualizar
	public void update(T t) throws DAOException;
	
	//subir usuario a la base de datos
	public void saveUser() throws DAOException;
	
	//borrar usuario de la base de datos.
	public void deleteUser() throws DAOException;
	
	//generar un listado de películas visibles para un cliente.
	public void getFilmsByUser() throws DAOException;

}
