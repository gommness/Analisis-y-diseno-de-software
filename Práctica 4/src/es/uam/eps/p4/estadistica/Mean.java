package es.uam.eps.p4.estadistica;

import es.uam.eps.p4.model.IncrementalFunction;

/**
 * Esta clase gestiona la media incremental de ciertos numeros
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Mean implements IncrementalFunction {
	private double sumValues;
	private int numValues;

	public Mean() {
		this.sumValues = 0;
		this.numValues = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.IncrementalFunction#addValue(double)
	 */
	@Override
	public void addValue(double value) {
		this.numValues++;
		this.sumValues += value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.IncrementalFunction#getResult()
	 */
	@Override
	public double getResult() {
		if (this.numValues == 0)
			return 0;
		return this.sumValues / this.numValues;
	}

}
