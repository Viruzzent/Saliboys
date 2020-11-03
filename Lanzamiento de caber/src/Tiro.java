
public class Tiro {
	private double distancia;
	private double angulo;
	
	public Tiro(double dist, double ang) {
		this.distancia = dist;
		this.angulo = ang;
	}
	
	public double porcentajeTiro() {
		if(Math.abs(this.angulo) <= 30)
			return 1;
		else if(Math.abs(this.angulo) <= 90) 
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
