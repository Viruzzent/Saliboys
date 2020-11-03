import java.util.LinkedList;
import java.util.List;

public class Concursante implements Comparable<Concursante> {
	private List<Tiro> tiros = new LinkedList<Tiro>();
	private int idConcursante;
	private boolean descalificado=false;
	private double consistencia;
	
	public void agregarTiro(Tiro tiros) {
		if(tiros.porcentajeTiro() == 0.0)
			this.descalificado=true;
		this.tiros.add(tiros);
	}

	public boolean estaDescalificado() {
		return descalificado;
	}

	public int getIdConcursante() {
		return idConcursante;
	}

	public void setIdConcursante(int idConcursante) {
		this.idConcursante = idConcursante;
	}
	
	public void obtenerConsistenciaTiros() {
		Tiro promedioTiros=getMeanTiro();
		double tempD = 0;
		double tempA = 0; 
		for (Tiro a : this.tiros) {
			tempD += Math.pow(a.getDistancia() - promedioTiros.getDistancia(), 2);
			tempA += Math.pow(a.getAngulo() - promedioTiros.getAngulo(),2);
		}
		this.consistencia=( (tempD / ( this.tiros.size() - 1)) + ( tempA / (this.tiros.size() - 1)) ) /2;
	}/// Hago un promedio entre las dos varianzas para obtener la consistencia del tiro

	public double getConsistencia() {
		return consistencia;
	}

	public Tiro getMeanTiro() {
		double sumaDistancia=0;
		double sumaAngulo=0;
		for (Tiro tiro : tiros) {
			sumaDistancia+=tiro.getDistancia();
			sumaAngulo+=tiro.getAngulo();
		}
		return  new Tiro(sumaDistancia/tiros.size(),sumaAngulo/tiros.size());
	}
	
	public double getMeanAngulo() {
		double sum = 0;
		for (Tiro a : this.tiros)
			sum += a.getAngulo();
		return sum / this.tiros.size();
	}

	public double obtenerDistanciaTiros() {
		double acumuladorDistancia = 0;
		for (Tiro t : this.tiros) {
			acumuladorDistancia += t.porcentajeTiro() * t.getDistancia();
		}
		return acumuladorDistancia;
	}

	@Override
	public int compareTo(Concursante concursante) {
		double cmp = this.obtenerDistanciaTiros() - concursante.obtenerDistanciaTiros();
		int cmpResultado = 0;
		if(cmp > 0)
			cmpResultado = 1;
		else if(cmp < 0)
			cmpResultado = -1;
		
		return cmpResultado;
	}///Quiero comparar de mayor a menor
}
