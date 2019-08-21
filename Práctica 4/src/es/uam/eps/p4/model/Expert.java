package es.uam.eps.p4.model;

import java.io.InvalidClassException;

/**
 * Esta interfaz es la que implementa nuestro sistema experto
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public interface Expert<T> {
	/**
	 * @param aCase
	 *            el caso a añadir al sistema experto
	 * @throws InvalidClassException la excepcion
	 */
	void addCase(Case<T> aCase) throws InvalidClassException;

	/**
	 * @param instace
	 *            la instancia a añadir
	 * @param aClass
	 *            la clase asociada a añadir
	 * @throws InvalidClassException la excepcion
	 */
	void addCase(Instance<T> instace, String aClass) throws InvalidClassException;

	/**
	 * @param instance
	 *            la instancia que se va a clasificar
	 * @return la clase a la que se le clasifica
	 */
	String testInstance(Instance<T> instance);
}
