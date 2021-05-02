package parte1;

/**
 * Interfaz Alquilable que implementar�n los barcos que puedan ser alquilados
 * @author Carlos Herrero
 *
 */

public interface Alquilable {
	
	/**
	 * M�todo para calcular el importe del alquiler de un barco sin contratar la tripulaci�n
	 * @return precio diario del alquiler sin tripulaci�n
	 */
	public double precioSinTripulacion();
	
	
	/**
	 * M�todo para calcular el importe del alquiler de un barco, si se contrata adem�s la tripulaci�n
	 * @return precio diario del alquiler, incluyendo la tripulaci�n
	 */
	public double precioConTripulacion();

}
