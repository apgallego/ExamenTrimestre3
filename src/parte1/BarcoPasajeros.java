package parte1;

/**
 * Clase para gestionar un Barco de Pasajeros, heredando de Barco
 * 
 * @author Carlos Herrero
 *
 */
public class BarcoPasajeros extends Barco {

	// propiedades nuevas
	private String trayecto;
	private int capacidad;

	/**
	 * Constructor u&acute;nico dando valor a todas sus propiedades, e invocando al
	 * constructor del padre
	 * 
	 * @param matricula      matri&acute;cula del barco, con el patro&acute;n AB123
	 * @param nombre         nombre nombre del barco, de hasta 100 caracteres
	 * @param numTripulantes nu&acute;mero de miembros de la tripulacio&acute;, debe
	 *                       ser >0
	 * @param numPasajeros   nu&acute;mero de pasajeros, debe ser mayor o igual a 0
	 * @param trayecto       Trayecto que realiza el barco, hasta 100 caracteres
	 * @param capacidad      N�mero m�ximo de pasajeros que admite el barco, debe
	 *                       ser >0
	 * @throws IllegalArgumentException si falla la validacio&acute;n de alguna de
	 *                                  las propiedades
	 */

	public BarcoPasajeros(String matricula, String nombre, int numTripulantes, int numPasajeros, String trayecto,
			int capacidad) throws IllegalArgumentException {
		super(matricula, nombre, numTripulantes, numPasajeros);
		try {
			setTrayecto(trayecto);
			setCapacidad(capacidad);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	// m�todos getXxX y setXxX

	public String getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(String trayecto) {
		if (trayecto.length() > 0 && trayecto.length() <= 100) {
			this.trayecto = trayecto;
		} else {
			throw new IllegalArgumentException("El trayecto debe tener entre 1 y 100 caracteres");
		}

	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		if (capacidad > 0) {
			this.capacidad = capacidad;
		} else {
			throw new IllegalArgumentException("LA capacidad debe ser mayor de 0");
		}
		this.capacidad = capacidad;
	}

	/**
	 * M�todo para incrementar el n�mero de pasajeros del barco
	 * 
	 * @param cantidad n�mero de pasajeros que suben al barco
	 * @throws IllegalArgumentException si el n�mero total de pasajeros supera la
	 *                                  capacidad m�xima
	 */
	public void aumentarPasaje(int cantidad) throws IllegalArgumentException {
		if (cantidad + getNumPasajeros() <= getCapacidad()) {
			// no se supera la capacidad m�xima; se puede incrementar el pasaje
			setNumPasajeros(getNumPasajeros() + cantidad);
		} else {
			throw new IllegalArgumentException("El n�mero de pasajeros no puede superar la capacidad del barco");

		}
	}

	/**
	 * M�todo para disminuir el n�mero de pasajeros del barco
	 * 
	 * @param cantidad n�mero de pasajeros que descienden del barco * @throws
	 *                 IllegalArgumentException si el n�mero final de pasajeros es
	 *                 inferior a 0
	 */
	public void disminuirPasaje(int cantidad) throws IllegalArgumentException {
		if (getNumPasajeros() - cantidad >= 0) {
			// el n�mero de pasajeros no ser� negativo
			setNumPasajeros(getNumPasajeros() - cantidad);
		} else {
			throw new IllegalArgumentException("El n�mero de pasajeros no puede ser negativo");

		}
	}

	@Override
	public String toString() {
		return super.toString() + "\t Trayecto: " + getTrayecto() + "\t Capacidad m�xima+  " + getCapacidad();
	}

}
