package parte1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class BarcoPasajerosTest {
	
	BarcoPasajeros barco1;
	static BarcoPasajeros barco2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		barco2= new BarcoPasajeros("AB123", "El barco de Chanquete", 3,10, "Valencia->Mahón",50);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		barco2=null;
	}

	@Test
	@DisplayName("Comprobando Excepción si trayecto no es válid0")
	void test1_1() {

		
		String nombre= "";
		for (int i=1; i<=10; i++) {
			nombre= nombre.concat("ABCDEFGHIJ");
		}
		final String nombrePrueba= nombre.concat("A");
		
		
		assertThrows(IllegalArgumentException.class, () -> {

			barco1= new BarcoPasajeros("AB123", "El barco de Chanquete", 3,10, nombrePrueba,100);
		});
		
	}
	
	
	
	@Test
	@DisplayName("Comprobando Excepción si capacidad no es válida")
	void test1_2() {

		
		assertThrows(IllegalArgumentException.class, () -> {

			barco1= new BarcoPasajeros("AB123", "El barco de Chanquete", 3,10, "Valencia->Mahón",0);
		});
		
	}
	
	@Test
	@DisplayName("Comprobando creación correcta de BarcoPasajeros")
	void test1_6(){
		
		barco1= new BarcoPasajeros("AB123", "El barco de Chanquete", 3,10, "Valencia->Mahón",100);
		assertNotNull(barco1);
		assertTrue(barco1 instanceof BarcoPasajeros);
		assertTrue(barco1 instanceof Barco);
		
	}
	
	@Test
	@DisplayName("Probando correcto funcionamiento del método para aumentar el pasaje")
	void test2_1(){
		barco2.aumentarPasaje(20);
		assertTrue(barco2.getNumPasajeros()==30);			
	}
	
	@Test
	@DisplayName("Comprobando que no se puede aumentar el pasaje por encima de la capacidad")
	void test2_2() {

		
		assertThrows(IllegalArgumentException.class, () -> {
			barco2.aumentarPasaje(21);
		});
		
	}
	
	@Test
	@DisplayName("Probando correcto funcionamiento del método para disminuir el pasaje")
	void test3_1(){
		barco2.disminuirPasaje(15);
		assertTrue(barco2.getNumPasajeros()==15);			
	}
	
	@Test
	@DisplayName("Comprobando que no se puede reducir el pasaje a menos de 0")
	void test3_2() {

		
		assertThrows(IllegalArgumentException.class, () -> {
			barco2.disminuirPasaje(16);
		});
		
	}
	
	

}
