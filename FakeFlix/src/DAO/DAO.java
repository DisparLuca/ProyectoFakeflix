package DAO;

import java.util.List;

import model.Film;

public interface DAO<T, K> {

	// Obtener
	public T get(K t) throws DAOException;

	// Obtener Todos
	public List<T> getAll() throws DAOException;

	// Guardar
	public void save(T t) throws DAOException;

	void cargarDatos() throws DAOException;

	public void getFilmByGender() throws DAOException;

	// introducir películas.
	void introducirPeliculas() throws DAOException;

	List<String> getMostLikedFilms() throws DAOException;

	List<Film> getNotViewedFilms(int t) throws DAOException;

	void getMostViewedFilms() throws DAOException;


}// DataAccessObject
