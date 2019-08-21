/**
 * 
 * Esta clase representa los logaritmos
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 */
package es.uam.eps.ads.p2.operaciones;

public class Logaritmo extends Unaria {
	/**
	 * constructor del logaritmo
	 * 
	 * @param expr expresion a la que aplicar el logaritmo
	 */
	public Logaritmo(Expresion expr) {
		super(expr);
	}
	/**
	 * Este metodo calcula el logaritmo de la expresion que contiene el objeto
	 * @return devuelve el resultado de la operacion
	 */
	public double calcular() {
		return Math.log(this.getOperando().calcular());
	}
	/**
	 * Devuelve si la expresion es valida para aplicar un logaritmo
	 * @return true si el logaritmo es valido
	 */
	public boolean isValida() {
		Expresion valida = this.getOperando();
		if (valida.calcular() <= 0)
			return false;
		else
			return true;
	}
	/**
	 * Devuelve la expresion contenida en el objeto
	 * @return devuelve el operando del logaritmo
	 */
	public Expresion getOperando() {
		return super.getOperador();
	}
	/**
	 * Este metodo devuelve como cadena de caracteres la representacion del objeto
	 * @return la expresion convertida a string
	 */
	public String toString() {
		return "ln( " + this.getOperando() + " )";
	}
}
