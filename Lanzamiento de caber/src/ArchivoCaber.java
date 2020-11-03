
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ArchivoCaber {
	private String nombreArchivo;

	public ArchivoCaber(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Torneo leerArchivo() throws IOException {
		Torneo torneo = new Torneo();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(nombreArchivo);
			br = new BufferedReader(fr);
			String linea;
			// Cantidad de concursantes.
			int cantidadConcursantes = Integer.parseInt(br.readLine());
			int contarConcursantes = 0;

			while (contarConcursantes < cantidadConcursantes) {
				int cantTiros = 0;
				Concursante concursante = new Concursante();
				// Leemos 3 lineas, ya que son 3 tiros por concursante.
				while ((linea = br.readLine()) != null && cantTiros < 3) {
					String[] datos = linea.split(" ");
					Tiro tiros = new Tiro(Float.parseFloat(datos[0]), Float.parseFloat(datos[1]));
					concursante.agregarTiro(tiros);
					cantTiros++;
				}
				torneo.agregarConcursante(concursante);
				contarConcursantes++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		return torneo;
	}

	//Arreglar/ver escribir con espacios y revisar salida
	public void escribirArchivo(ArrayList <Concursante> podioConsistencia, int [] podioDistancia ) {

		FileWriter fichero = null;
		BufferedWriter bw = null;
		try {
			fichero = new FileWriter(this.nombreArchivo);
			bw = new BufferedWriter(fichero);// Crear instancia de PrintWriter.
			for ( Concursante concur : podioConsistencia) {
				bw.write(concur.getIdConcursante()+" ");
			}
			bw.write("\n");
			for (int idconcur : podioDistancia) {
				bw.write(idconcur+" ");
			}
			bw.write("\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// aprovechamos el finally para asegurarnos que se cierra el fichero
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

/*
 * n = 3
 * 
 * a = 0 while a < n for(0<3) guardar los tiros de cada concursante guardo
 * a(concursante) en vector Torneo a++
 */