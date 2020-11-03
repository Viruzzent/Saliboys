import java.util.Comparator;

public class ComparadorPorConsistencia implements Comparator<Concursante> {

	@Override
	public int compare(Concursante c1, Concursante c2) {
		return (int) (c1.getConsistencia()-c2.getConsistencia());
	}
}
