import java.util.Comparator;

public class ComparadorPorConsistencia implements Comparator<Concursante> {

	@Override
	public int compare(Concursante c1, Concursante c2) {
		double cmp = c1.getConsistencia() - c2.getConsistencia(); 
		int cmpRetorno = 0;
		
		if(cmp > 0)
			cmpRetorno = 1;
		else if(cmp < 0)
			cmpRetorno = -1;
		
		return cmpRetorno;
	}
}
