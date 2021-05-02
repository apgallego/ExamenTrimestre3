package parte1;

/**
 * Clase abstracta para gestionar un Barco
 * @author Carlos Herrero
 *
 */
public abstract class Barco {
	
	//propiedades
	private String matricula;
	private String nombre;
	private int numTripulantes;
	private int numPasajeros;
	

	/**
	 * Constructor u&acute;nico de la clase a partir de sus propiedades
	 * 
	 * @param matricula      matri&acute;cula del barco, con el patro&acute;n AB123
	 * @param nombre         nombre nombre del barco, de hasta 100 caracteres
	 * @param numTripulantes nu&acute;mero de miembros de la tripulacio&acute;, debe
	 *                       ser >0
	 * @param numPasajeros   nu&acute;mero de pasajeros, debe ser mayor o igual a 0
	 * @throws IllegalArgumentException si falla la validacio&acute;n de alguna de
	 *                                  las propiedades
	 */
	public Barco(String matricula, String nombre, int numTripulantes, int numPasajeros) throws IllegalArgumentException{
		super();
		//las propiedades nombre y matrícula las validamos en el constructor.
		//no existirán setters de estas propiedades, para evitar cambiarlas despuès
		if (matricula.matches("[A-Z]{2}\\d{3}")) {
			this.matricula = matricula;
		} else {
			throw new IllegalArgumentException ("La matrícula debe cumplir el patrón \"AB123\"");
		}
		
		if (nombre.length()>0 && nombre.length()<=100) {
			this.nombre = nombre;
		} else {
			throw new IllegalArgumentException ("El nombre debe tener entre 1 y 100 caracteres");
		}
		
		//las otras propiedades las validamos en su método set
		try {
			setNumTripulantes(numTripulantes);
			setNumPasajeros(numPasajeros);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	//métodos getXxX y setXxX
	public String getMatricula() {
		return matricula;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public int getNumTripulantes() {
		return numTripulantes;
	}
	public void setNumTripulantes(int numTripulantes) {
		if (numTripulantes >0) {
			this.numTripulantes = numTripulantes;
		} else {
			throw new IllegalArgumentException ("El número de tripulantes debe ser mayor de 0");
		}
		
	}
	public int getNumPasajeros() {
		return numPasajeros;
	}
	public void setNumPasajeros(int numPasajeros) {
		if (numPasajeros >=0) {
			this.numPasajeros = numPasajeros;
		} else {
			throw new IllegalArgumentException ("El número de pasajeros no puede ser negativo");
		}
	}
	
	@Override
	public String toString() {
		
		return " Matrícula:  "+ getMatricula() +
				"\tNombre   :"+getNombre()+
				"\tTripulantes:  "+getNumTripulantes()+
				"\tPasajeros:  "+getNumPasajeros();
		
	}

}
