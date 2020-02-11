/**
 * Metodos de la interfaz DAO declarados
 * @author Álvaro Muñoz
 * 
 */

package DAO;

import java.util.List;

public interface DAO<T, K> {
	
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

	//Leer el fichero peliculas_cat.txt e introducir los datos en la base de datos
	void cargarDatos() throws DAOException;

}//DataAccessObject
