/**
 * 
 * Esta clase abstracta representa las operaciones que requieren dos expresiones
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 */
package es.uam.eps.ads.p2.operaciones;

public abstract class Binaria extends Operador {

	private Expresion[] operadores = new Expresion[2];

	/**
	 * Constructor de binaria
	 * 
	 * @param expr1
	 *            primera expresion
	 * @param expr2
	 *            segunda expresion
	 */
	protected Binaria(Expresion expr1, Expresion expr2) {
		this.operadores[0] = expr1;
		this.operadores[1] = expr2;
	}

	/**
	 * Este metodo dice si la expresion binaria es valida o no, basandose en sus operadores
	 * @return true si binaria es valida, false si no
	 */
	public boolean isValida() {
		if (operadores[0].isValida() && operadores[1].isValida())
			return true;
		else
			return false;
	}

	/**
	 * Este metodo devuelve el primer operador que conforma la expresion binaria
	 * @return primer operador de binaria
	 */
	protected Expresion getOperador1() {
		return this.operadores[0];
	}

	/**
	 * Este metodo devuleve el segundo operador que conforma la expresion binaria
	 * @return segundo operador de binaria
	 */
	protected Expresion getOperador2() {
		return this.operadores[1];
	}

}
