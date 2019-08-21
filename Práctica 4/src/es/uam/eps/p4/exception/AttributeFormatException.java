/**
 * 
 */
package es.uam.eps.p4.exception;

/**
 * Esta excepcion se lanza si el formato del atributo es incorrecto
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class AttributeFormatException extends Exception {
	private static final long serialVersionUID = -7784020886579423391L;

	public AttributeFormatException() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return "El formato del atributo es incorrecto";
	}
}
