import java.util.ArrayList;
import java.util.List;

public class Torneo {
	private List<Concursante> concursantes = new ArrayList<Concursante>();
	
	public boolean agregarConcursante(Concursante concursante) {
		return this.concursantes.add(concursante);
	}
	
	public int[] podioConstancia() {
		//recorrer la lista de concursantes
		//Si esta en juego se calcula, sino F
		//averiguar para todos ellos las consistencias de sus tiros
		//calcular varianza de distancia y angulo(porcentaje)
	}
	
	public int[] podioDistancia() {
		//recorrer la lista de concursantes
		//ver que concursantes con la mayor distancia 
		//la distancia se la multiplica por su angulo obtenido en el tiro
	}
}

