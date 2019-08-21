/**
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 * Esta clase es unaria
 */
package es.uam.eps.ads.p2.operaciones;

public abstract class Unaria extends Operador {
	private Expresion operador;
	/**
	 * constructor de unaria
	 * @param expr la expresion de unaria
	 */
	protected Unaria(Expresion expr) {
		operador = expr;
	}
	/**
	 * 
	 * @return el operador de unaria
	 */
	protected Expresion getOperador() {
		return operador;
	}
}
