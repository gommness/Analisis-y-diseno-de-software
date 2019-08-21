package es.uam.eps.p4.model;

import es.uam.eps.p4.exception.AttributeFormatException;

/**
 * Esta interfaz es de donde se implementan los atributos
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public interface Attribute<T> {

	/**
	 * @return el nombre del atributo
	 */
	String getName();

	/**
	 * @param v
	 *            el valor a parsear a double
	 * @return el valor pasado parseado a double
	 * @throws AttributeFormatException la excepcion
	 */
	double fromString(String v) throws AttributeFormatException;

	/**
	 * @return el ordinal correspondiente al atributo
	 */
	int getOrdinal();
}
