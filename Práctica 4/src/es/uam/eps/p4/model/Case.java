package es.uam.eps.p4.model;

/**
 * Esta interfaz es de donde se implementan los casos
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public interface Case<T> {
	/**
	 * @return la instancia de este caso
	 */
	Instance<T> getInstance(); // devuelve la instance

	/**
	 * @return el nombre de la clase
	 */
	String getClassName(); // devuelve la clase en la que está clasificada la
							// instancie

}
