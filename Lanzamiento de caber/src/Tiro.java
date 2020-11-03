
public class Tiro {
	private double distancia;
	private double angulo;
	
//	public Tiro(float distancia, float angulo) {
//		this.distancia = distancia;
//		this.angulo = angulo;
//	}

	public Tiro(double dist, double ang) {
		this.distancia = dist;
		this.angulo = ang;
		// TODO Auto-generated constructor stub
	}
	
	public double porcentajeTiro(Tiro tiro) {
		if(Math.abs(tiro.angulo) <= 30)
			return 1;
		else if(Math.abs(tiro.angulo) <= 90) 
			return 0.8;
		return 0;	
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	
}
