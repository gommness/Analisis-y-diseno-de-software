package es.uam.eps.p4.model;

import java.util.List;

import es.uam.eps.p4.exception.InvalidValuesException;

/**
 * Esta interfaz es de donde se implementan los tipos de problema
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public interface Type<T> {
	/**
	 * @return la lista de atributos del tipo de problema
	 */
	public List<Attribute<T>> getAttributes();

	/**
	 * @param values
	 *            los valores de la instancia
	 * @return la instancia creada con dichos valores
	 * @throws InvalidValuesException la excepcion
	 */
	public Instance<T> newInstance(List<String> values) throws InvalidValuesException;

	/**
	 * @return las clases del tipo de problema
	 */
	public List<String> getClasses();
}
