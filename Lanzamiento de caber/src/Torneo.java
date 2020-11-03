import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Torneo {
	private List<Concursante> concursantes = new ArrayList<Concursante>();

	public boolean agregarConcursante(Concursante concursante) {
		return this.concursantes.add(concursante);
	}

	public List<Concursante> podioConsistencia() {
		List<Concursante> consistentes= new ArrayList<Concursante>();
		// recorrer la lista de concursantes
		for ( Concursante concur : this.concursantes) {
			if( ! concur.estaDescalificado() ) {
				concur.obtenerConsistenciaTiros();
				consistentes.add(concur);
			}
		}
		consistentes.sort(new ComparadorPorConsistencia());
	    int cantidadGanadores = consistentes.size()>3 ? 3 : consistentes.size();
		List<Concursante> podioConsistencia = consistentes.subList(0, cantidadGanadores);
		return podioConsistencia;
	}

	public int[] podioDistancia() {
		// recorrer la lista de concursantes
		int [] podio = new int [3];
		Collections.sort(concursantes);
		// ver que concursantes con la mayor distancia
	    for(int i =0 ; i < 3 ; i ++)
	    	podio [i]= concursantes.get(i).getIdConcursante();
		return podio;
	}
}
