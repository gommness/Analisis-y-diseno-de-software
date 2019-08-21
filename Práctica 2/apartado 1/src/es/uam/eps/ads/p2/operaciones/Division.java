/**
 * 
 * Esta clase representa las divisiones
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 */
package es.uam.eps.ads.p2.operaciones;

public class Division extends Binaria {
	/**
	 * constructor de division
	 * 
	 * @param expr1
	 *            dividendo
	 * @param expr2
	 *            divisor
	 */
	public Division(Expresion expr1, Expresion expr2) {
		super(expr1, expr2);
	}

	/**
	 * Este metodo calcula al división entre las dos expresiones contenidas en el objeto
	 * @return devuelve el resultado de la division
	 */
	public double calcular() {
		if (isValida() == true) {
			double dividendo = this.getDividendo().calcular();
			double divisor = this.getDivisor().calcular();
			return dividendo / divisor;
		} else
			return Double.NaN;
	}

	/**
	 * Este metodo devuelve la expresion que representa el dividendo del objeto
	 * @return dividendo de la division
	 */
	public Expresion getDividendo() {
		return super.getOperador1();
	}

	/**
	 * Este metodo devuelve la expresion que representa el divisor del objeto
	 * @return divisor de la division
	 */
	public Expresion getDivisor() {
		return super.getOperador2();
	}

	/**
	 * Este metodo devuelve como cadena de caracteres la representacion del objeto
	 * @return la cadena de caracteres que representa al objeto
	 */
	public String toString() {
		return "(" + this.getDividendo() + " / " + this.getDivisor() + ")";
	}

	/**
	 * Este metodo dice si el objeto es una expresion valida o no lo es
	 * @return true si la expresion es valida, false si no lo es
	 */
	public boolean isValida() {
		double d2 = this.getDivisor().calcular();
		if (d2 == 0)
			return false;
		else
			return true;
	}
}
