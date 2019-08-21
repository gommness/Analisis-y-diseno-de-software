package es.uam.eps.p4.model;

/**
 * Esta interfaz es de donde se implementan las instancias
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public interface Instance<T> {
	/**
	 * @param a
	 *            el atributo del que se va a obtener el valor
	 * @return el valor de la instancia correspondiente
	 */
	double getValue(Attribute<T> a);

	/**
	 * @return el tipo de la instancia
	 */
	Type<T> getType();
}
