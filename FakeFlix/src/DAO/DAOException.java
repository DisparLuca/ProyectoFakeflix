/**
 * Gestion de errores del DAO
 * @author �lvaro Mu�oz
 */

package DAO;

public class DAOException extends Exception {

	
	public DAOException(String message, Throwable cause) {
		
		super(message, cause);
		
	}//DAOException

	public DAOException(String message) {
		
		super(message);
		
	}//DAOException

	public DAOException(Throwable cause) {
		
		super(cause);
		
	}//DAOException
	

	
}//DAOException