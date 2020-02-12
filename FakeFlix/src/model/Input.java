package model;

import java.util.Scanner;
/**
 * 
 * @author David.
 * Clase para recogida de datos
 *
 */

	public class Input {
	
	public Input() {
		
	}
	/**
	 * @author David.
	 * @return int recogido por teclado.
	 * modificación a estático por Pablo.
	 */
	public static int readInt() {
	return new Scanner(System.in).nextInt();
	}
	
	/**
	 * @author David.
	 * @return String recogido por teclado.
	 * modificación a estático por Pablo.
	 */
	public static String readString() {
		return new Scanner(System.in).nextLine();
	}
}
