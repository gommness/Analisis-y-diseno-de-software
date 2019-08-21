/**
 * 
 * Esta clase abstracta representa las expresiones
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 * 
 */
package es.uam.eps.ads.p2.operaciones;

public abstract class Expresion {
	/**
	 * Aqui tenemos dos metodos abstractos que definiremos en sus clases hijas y
	 * un metodo que te dice si una expresion es mayor que otra
	 */

	/**
	 * calcula la expresion llamando al metodo de las clases hijas con
	 * este mismo metodo definido en ellas.
	 * @return el valor calculado
	 */
	public abstract double calcular();

	/**
	 * 
	 * @return devuelve true si la expresion es valida, false si no lo es
	 */
	public abstract boolean isValida();

	/**
	 * Este metodo hace que el objeto se compare con otra Expresion dada y dice si es o no es mayor que dicha Expresion
	 * @param expresion la expresion con la que se compara
	 * @return true si es mayor, false si no.
	 */
	public boolean isMayor(Expresion expresion) {
		if (this.calcular() > expresion.calcular())
			return true;
		else
			return false;
	}
}
