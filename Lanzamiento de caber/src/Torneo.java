import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {
	private List<Concursante> concursantes = new ArrayList<Concursante>();

	public boolean agregarConcursante(Concursante concursante) {
		return this.concursantes.add(concursante);
	}

	public int[] podioConsistencia() {
		List<Concursante> consistentes = new ArrayList<Concursante>();
		
		// recorrer la lista de concursantes
		for ( Concursante concur : this.concursantes) {
			if( ! concur.estaDescalificado() ) {
				concur.obtenerConsistenciaTiros();
				consistentes.add(concur);
			}
		}
		
		int [] podioResultado = new int[3];
		if(consistentes.size() < 3)
			podioResultado = new int[consistentes.size()];
		
		consistentes.sort(new ComparadorPorConsistencia());
		
		for(int i = 0; i < podioResultado.length; i++) {
			Concursante c = consistentes.remove(0);
			podioResultado[i] = c.getIdConcursante();
		}
			
		return podioResultado;
	}
	

	public int[] podioDistancia() {
		// recorrer la lista de concursantes
		int [] podio = new int [3];
		Collections.sort(this.concursantes, Collections.reverseOrder());
		// ver que concursantes con la mayor distancia
	    for(int i = 0; i < 3 ; i++) 
	    	podio [i] = concursantes.get(i).getIdConcursante();

		return podio;
	}
}
