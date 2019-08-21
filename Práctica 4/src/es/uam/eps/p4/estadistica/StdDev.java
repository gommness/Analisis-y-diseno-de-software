package es.uam.eps.p4.estadistica;

/**
 * Esta clase gestiona la desviacion tipica incremental de ciertos numeros
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class StdDev extends Variance {

	public StdDev() {
		n = 0;
		mean = 0.0;
		m2 = 0.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.IncrementalFunction#getResult()
	 */
	@Override
	public double getResult() {
		return Math.sqrt(super.getResult());
	}

}
