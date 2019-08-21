/**
 * 
 * Esta clase abstracta representa el operador
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 */
package es.uam.eps.ads.p2.operaciones;

public abstract class Operador extends Expresion {
	/**
	 * Este metodo devuelve si un operador es o no es valido
	 * @return true si es valido el operador, false si no lo es
	 */
	public boolean isValida() {
		return true;
	}
}
