/**
 *	Representa a un usuario de la aplicacion FakeFlix
 * @author Pablo Muñoz
 */


package model;
import java.util.Date;


public class Client {
	
	private int id_cliente;
	private String name;
	private String city;
	private boolean premium;
	private int birthDate;
	
	public Client() {
		super();
	}

	public Client(int id_cliente, String name, String city, boolean premium, int birthDate) {
		this.id_cliente = id_cliente;
		this.name = name;
		this.city = city;
		this.premium = premium;
		this.birthDate = birthDate;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public int getBirthdate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", name=" + name + ", city=" + city + ", premium=" + premium
				+ ", birthdate=" + birthDate + "]";
	}
	
	
	

}
