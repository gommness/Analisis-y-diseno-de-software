package es.uam.eps.p4.model;

/**
 * Esta interfaz es de donde se implementan las funciones incrementales
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public interface IncrementalFunction {
	/**
	 * @param value
	 *            el valor a añadir
	 */
	void addValue(double value);

	/**
	 * @return el resultado de la operacion
	 */
	double getResult();
}
