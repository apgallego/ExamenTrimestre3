package parte1;

/**
 * Interfaz Alquilable que implementarán los barcos que puedan ser alquilados
 * @author Carlos Herrero
 *
 */

public interface Alquilable {
	
	/**
	 * Método para calcular el importe del alquiler de un barco sin contratar la tripulación
	 * @return precio diario del alquiler sin tripulación
	 */
	public double precioSinTripulacion();
	
	
	/**
	 * Método para calcular el importe del alquiler de un barco, si se contrata además la tripulación
	 * @return precio diario del alquiler, incluyendo la tripulación
	 */
	public double precioConTripulacion();

}
