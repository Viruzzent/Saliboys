import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class CaberTest {

	@Test
	public void ejemploEnunciado_01() {
		ArchivoCaber arch = new ArchivoCaber("flujoNormal.in");
		Torneo t = new Torneo();
		try {
			t = arch.leerArchivo();
			
			int [] arrayDist = new int [3];
			arrayDist[0] = 2;
			arrayDist[1] = 1;
			arrayDist[2] = 3;
			
			int [] arrayConsis = new int [2];
			arrayConsis[0] = 1;
			arrayConsis[1] = 2;
			
			assertArrayEquals(arrayDist, t.podioDistancia());
			assertArrayEquals(arrayConsis, t.podioConsistencia());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void escribirArchivo_02() {
		ArchivoCaber arch = new ArchivoCaber("flujoNormal.in");
		Torneo t = new Torneo();
		try {
			t = arch.leerArchivo();
			int[] podioDist = t.podioDistancia();
			int[] podioConsis = t.podioConsistencia();

			ArchivoCaber escritura = new ArchivoCaber("flujoNormal.out");
			escritura.escribirArchivo(podioConsis, podioDist);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void angulo30Positivo_03(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,30));
		assertEquals(2.5, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo45Positivo_04(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,45));
		assertEquals(2.5*0.8, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo90Positivo_05(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,90));
		assertEquals(2.5*0.8, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo100Positivo_06(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,100));
		assertEquals(0, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo30Negativo_07(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,-30));
		assertEquals(2.5, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo45Negativo_08(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,-45));
		assertEquals(2.5*0.8, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo90Negativo_09(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,-90));
		assertEquals(2.5*0.8, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void angulo100Negativo_10(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,-100));
		assertEquals(0, c.obtenerDistanciaTiros(), 0);
	}
	
	@Test
	public void concursanteConsistenteCalificado_11(){
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5,-100));
		
		assertTrue(c.estaDescalificado());
	}
	
	@Test
	public void concursanteConsistenteDescalificado_12() {
		Concursante c = new Concursante();
		c.agregarTiro(new Tiro(2.5, 80));
		
		assertFalse(c.estaDescalificado());
	}
	
	@Test
	public void ganadorMejorAngulo_13() {
		ArchivoCaber arch = new ArchivoCaber("mismasDistancias.in");
		Torneo t = new Torneo();
		try {
			t = arch.leerArchivo();
			
			int [] arrayDist = new int [3];
			arrayDist[0] = 1;
			arrayDist[1] = 2;
			arrayDist[2] = 3;
			
			assertArrayEquals(arrayDist, t.podioDistancia());	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ganadorMejorConsistencia_14() {
		ArchivoCaber arch = new ArchivoCaber("mejorConsistencia.in");
		Torneo t = new Torneo();
		try {
			t = arch.leerArchivo();
			
			int [] arrayConsis = new int [3];
			arrayConsis[0] = 2;
			arrayConsis[1] = 3;
			arrayConsis[2] = 1;
			
			assertArrayEquals(arrayConsis, t.podioConsistencia());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
