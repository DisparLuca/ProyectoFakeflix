package DAO;

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


}
