package parte1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YateTest {
	
	Yate yate1;

	
	
	@Test
	@DisplayName("Comprobando Excepción si matrícula no es válida")
	void test1_1() {
		assertThrows(IllegalArgumentException.class, () -> {
			yate1= new Yate("A12", "El barco de Chanquete", 3,10,Categorias.PRIMERA,"A1234567X");
		});
		
	}
	

	
	@Test
	@DisplayName("Comprobando Excepción si nombre no es válid0")
	void test1_2() {
		//probar excepción si nombre no válido
		
		String nombre= "";
		for (int i=1; i<=10; i++) {
			nombre= nombre.concat("ABCDEFGHIJ");
		}
		final String nombrePrueba= nombre.concat("A");
		
		
		assertThrows(IllegalArgumentException.class, () -> {

			yate1= new Yate("AB123", nombrePrueba, 3,10,Categorias.PRIMERA,"A1234567X");
		});
		
	}
	
	@Test
	@DisplayName("Comprobando Excepción si num tripulantes no es válido")
	void test1_3() {
		assertThrows(IllegalArgumentException.class, () -> {
			yate1= new Yate("AB123", "El barco de Chanquete", 0,10,Categorias.PRIMERA,"A1234567X");
		});
		
	}
	
	@Test
	@DisplayName("Comprobando Excepción si num pasajeros no es válido")
	void test1_4() {
		assertThrows(IllegalArgumentException.class, () -> {
			//probar excepción si numPasajeros no válido
			yate1= new Yate("AB123", "El barco de Chanquete", 3,-1,Categorias.PRIMERA,"A1234567X");
		});
		
	}
	
	@Test
	@DisplayName("Comprobando Excepción si CIF no es válido")
	void test1_5() {
		assertThrows(IllegalArgumentException.class, () -> {
			//probar excepción si CIF no válido
			yate1= new Yate("AB123", "El barco de Chanquete", 3,10,Categorias.PRIMERA,"A12345X");
		});
		
	}
	
	@Test
	@DisplayName("Comprobando creación correcta de Yate")
	void test1_6(){
		
		yate1= new Yate("AB123", "El barco de Chanquete", 3,10,Categorias.PRIMERA,"A1234567X");
		assertNotNull(yate1);
		assertTrue(yate1 instanceof Yate);
		assertTrue(yate1 instanceof Barco);
		assertTrue(yate1 instanceof Alquilable);
	}
	
	@Test
	@DisplayName("Comprobando métodos recibidosde la interfaz para cCategoría primera")
	void test2_1(){
		yate1= new Yate("AB123", "El barco de Chanquete", 3,10,Categorias.PRIMERA,"A1234567X");
		assertTrue( yate1.precioSinTripulacion()==20000.0);
		assertTrue( yate1.precioConTripulacion()==35000.0);
	}
	
	@Test
	@DisplayName("Comprobando métodos recibidosde la interfaz para cCategoría tercera")
	void test2_2(){
		yate1= new Yate("AB123", "El barco de Chanquete", 3,10,Categorias.TERCERA,"A1234567X");
		assertTrue( yate1.precioSinTripulacion()==5000.0);
		assertTrue( yate1.precioConTripulacion()==20000.0);
	}
	
	

}
