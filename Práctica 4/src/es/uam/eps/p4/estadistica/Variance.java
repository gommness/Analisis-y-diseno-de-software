package es.uam.eps.p4.estadistica;

import es.uam.eps.p4.model.IncrementalFunction;

/**
 * Esta clase gestiona la varianza incremental de ciertos numeros
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Variance implements IncrementalFunction {
	protected int n;
	protected double mean;
	protected double m2;

	public Variance() {
		n = 0;
		mean = 0.0;
		m2 = 0.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.IncrementalFunction#addValue(double)
	 */
	@Override
	public void addValue(double value) {
		this.n++;
		double delta = value - this.mean;
		this.mean += delta / n;
		this.m2 += delta * (value - this.mean);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.IncrementalFunction#getResult()
	 */
	@Override
	public double getResult() {
		if (this.n < 2)
			return 0; // en el algoritmo original se devuelve float('nan') en
						// lugar de 0
		else
			return this.m2 / (this.n - 1);
	}

}
