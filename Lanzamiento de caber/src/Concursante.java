import java.util.LinkedList;
import java.util.List;

public class Concursante {
	private List<Tiro> tiros = new LinkedList<Tiro>();
	private int idConcursante;
	private static int ContadorConcursantes=1;
	
	public Concursante(){
		this.idConcursante=ContadorConcursantes++;
	}
	
	public void agregarTiro(Tiro tiros) {
		this.tiros.add(tiros);
	}

	public int getIdConcursante() {
		return idConcursante;
	}
	
	public double obtenerConsistenciaTiros() {
		///hacer varianza (?????????
		
		return 0.1;
	}
//	public double getVariance() {
//        double mean = getMean();
//        double temp = 0;
//        for(double a : data)
//            temp += (a-mean)*(a-mean);
//        return temp/(size-1);
//	}
//	
//	public double getMean() {
//        double sum = 0.0;
//        for(double a : data)
//            sum += a;
//        return sum/size;
//    }
	
	public double getVarianceDistancia() {
        double mean = getMeanDistancia();
        double temp = 0;
        for(Tiro a : this.tiros)
            temp += (a.getDistancia()-mean)*(a.getDistancia()-mean);
        return temp/(this.tiros.size()-1);
	}
	
	public double getMeanDistancia() {
     
        return obtenerDistanciaTiros()/this.tiros.size();
    }
	
	public double getVarianceAngulo() {
        double mean = getMeanAngulo();
        double temp = 0;
        for(Tiro a : this.tiros)
            temp += (a.getAngulo()-mean)*(a.getAngulo()-mean);
        return temp/(this.tiros.size()-1);
	}
	
	public double getMeanAngulo() {
        double sum = 0;
        for(Tiro a : this.tiros)
            sum += a.getDistancia();
        return sum/this.tiros.size();
    }
        
	
	public double obtenerDistanciaTiros() {
		double acumuladorDistancia=0;
		for(Tiro t : this.tiros) {
			acumuladorDistancia+=t.porcentajeTiro(t)*t.getDistancia();		
		}
		return acumuladorDistancia;
	}
}

