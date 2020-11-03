
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

			int idConcur = 1;
			while (contarConcursantes < cantidadConcursantes) {
				int cantTiros = 0;
				Concursante concursante = new Concursante();
				// Leemos 3 lineas, ya que son 3 tiros por concursante.
				while ((cantTiros < 3 && (linea = br.readLine()) != null)) {
					String[] datos = linea.split("\t");
					Tiro tiros = new Tiro(Float.parseFloat(datos[0]), Float.parseFloat(datos[1]));
					concursante.agregarTiro(tiros);
					cantTiros++;
				}
				concursante.setIdConcursante(idConcur);
				torneo.agregarConcursante(concursante);
				contarConcursantes++;
				idConcur++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		return torneo;
	}

	public void escribirArchivo(int[] podioConsistencia, int[] podioDistancia) {
		File fileEscritura = null;
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fileEscritura = new File(this.nombreArchivo);
			fw = new FileWriter(fileEscritura);
			pw = new PrintWriter(fw);

			String cadenaImprimir = "";
			for (int idConcur : podioConsistencia) {
				cadenaImprimir += idConcur + " ";
			}
			cadenaImprimir += '\n';
			for (int idConcur : podioDistancia) {
				cadenaImprimir += idConcur + " ";
			}
			pw.println(cadenaImprimir);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// aprovechamos el finally para asegurarnos que se cierra el fichero
				if (null != pw)
					pw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
