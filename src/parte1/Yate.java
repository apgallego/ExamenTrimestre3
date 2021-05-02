package parte1;

/**
 * Tipo enumerado con la lista de categori&acute;as a las que puede pertenecer un Yate
 * @author Alumno
 *
 */
enum Categorias{
	PRIMERA, SEGUNDA, TERCERA
}

/**
 * Clase para gestionar un Yate, heredando de Barco e implementando la interfaz Alquilable
 * @author Carlos Herrero
 *
 */
public class Yate extends Barco implements Alquilable {
	
	//constantes que se utilizaran para el c�lculo de los precios del alquiler
	final double PRECIO_PRIMERA=20000;
	final double PRECIO_SEGUNDA=10000;
	final double PRECIO_OTRAS=5000;
	final double PRECIO_TRIPULANTE=5000;
	
	//propiedades nuevas de Yate
	private Categorias categoria;
	private String cif;

	/**
	 * Constructor u&acute;nico dando valor a todas sus propiedades, e invocando al constructor del padre
	 * @param matricula matri&acute;cula del barco, con el patro&acute;n AB123
	 * @param nombre nombre nombre del barco, de hasta 100 caracteres
	 * @param numTripulantes nu&acute;mero de miembros de la tripulacio&acute;, debe ser >0
	 * @param numPasajeros nu&acute;mero de pasajeros, debe ser mayor o igual a 0
	 * @param categoria uno de los valores del tipo enumerado Categorias
	 * @param cif CIF de la empresa propietaria del Yate, bajo el patron A1234567X
	 * @throws IllegalArgumentException si falla la validacio&acute;n de alguna de las propiedades
	 */
	
	public Yate(String matricula, String nombre, int numTripulantes, int numPasajeros, 	
			Categorias categoria, String cif) throws IllegalArgumentException {
		super(matricula, nombre, numTripulantes, numPasajeros);
		// las propiedades categor�a y cif las asignamos y validamos en el constructor
		//no tendr�n m�todos setXxX para impedir modificarlas despu�s
		this.categoria = categoria;
		//validamos el cif con expresi�n regular
				if (cif.matches("[A-HJNP-SU-W]\\d{7}[A-Z]")) {
					this.cif = cif;
				} else {
					throw new IllegalArgumentException("El CIF no es correcto");
				}
	}

	//m�todos getXxX y setXxX
	
	public Categorias getCategoria() {
		return categoria;
	}

	

	public String getCif() {
		return cif;
	}



	/**
	 * Implementacio&acute;n del m�todo precioSinTripulacion, cuyo ca&acute;lculo dependera&acute; de la Categori&acute; del Yate
	 */
	@Override
	public double precioSinTripulacion() {
		
		return switch(this.categoria) {
				case PRIMERA -> { yield PRECIO_PRIMERA; }
				case SEGUNDA -> { yield PRECIO_SEGUNDA; }
				default -> { yield PRECIO_OTRAS;}
				
		};
	}

	/**
	 * Implementacio&acute;n del m�todo precioConTripulacion, cuyo ca&acute;lculo dependera&acute; de la Categori&acute; del Yate
	 * , asi&acute; como del nu&acute;mero de tripulantes.
	 */
	@Override
	public double precioConTripulacion() {
		return (precioSinTripulacion()+ getNumTripulantes()*PRECIO_TRIPULANTE);
		
	}
	
	@Override
	public String toString() {
		return super.toString()+ "\t Categor�a: "+ getCategoria()+
				"\t CIF+  "+getCif();
	}

}
