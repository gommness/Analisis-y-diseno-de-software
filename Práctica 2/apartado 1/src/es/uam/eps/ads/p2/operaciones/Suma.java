/**
 * 
 * Esta clase representa las sumas
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 */
package es.uam.eps.ads.p2.operaciones;

public class Suma extends Binaria {
	/**
	 * constructor de objetos de clase Binaria
	 * @param expr1 primera expresion de binaria
	 * @param expr2 segunda expresion de binaria
	 */
	public Suma(Expresion expr1, Expresion expr2) {
		super(expr1, expr2);
	}
	/**
	 * Este metodo suma las dos expresiones de la clase
	 * @return devuelve la suma
	 */
	public double calcular() {
		double sumando1 = this.getSumando1().calcular();
		double sumando2 = this.getSumando2().calcular();
		return sumando1 + sumando2;
	}
	/**
	 * Este metodo devuelve la primera expresion de la clase (el primer sumando)
	 * @return primer sumando de suma
	 */
	public Expresion getSumando1() {
		return super.getOperador1();
	}
	/**
	 * Este metodo devuelve la segunda expresion de la clase (el segundo sumando)
	 * @return segundo sumando de suma
	 */
	public Expresion getSumando2() {
		return super.getOperador2();
	}
	/**
	 * Este metodo devuelve como cadena de caracteres, la representacion del objeto
	 * @return La cadena de caracteres que representa al objeto
	 */
	public String toString() {
		return "(" + this.getSumando1() + " + " + this.getSumando2() + ")";
	}
}
