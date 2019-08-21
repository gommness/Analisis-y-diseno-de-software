package es.uam.eps.p4.exception;

/**
 * Esta excepcion se lanza si hay algún valor no válido
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class InvalidValuesException extends Exception {

	private static final long serialVersionUID = 3059421875357740364L;

	public InvalidValuesException() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return "Alguno de los valores no es valido";
	}
}
