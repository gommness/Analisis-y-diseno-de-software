/**
 * 
 * Esta clase representa los valores de las expresiones atómicas
 * 
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 * 
 */
package es.uam.eps.ads.p2.operaciones;

public class Valor extends Expresion {
	private double valor;
	/**
	 * Este metodo calcula el valor del objeto
	 * @return valor de valor
	 */
	public double calcular() {
		return getValor();
	}
	/**
	 * Este metodo dice si el valor es valido o no lo es
	 * @return true si es valido el valor, false si no lo es
	 */
	public boolean isValida() {
		// return (this.valor != Double.NaN) ? true : false;
		return true;
	}
	/**
	 * este metodo devuelve el atributo valor del objeto
	 * @return el valor de valor
	 */
	public double getValor() {
		return this.valor;
	}
	/**
	 * constructor de valor
	 * @param val el valor de valor
	 */
	public Valor(double val) {
		this.valor = val;
	}
	/**
	 * Este metodo devuelve como cadena de caracteres la representacion del objeto
	 * @return convierte a string el valor
	 */
	public String toString() {
		return "" + this.getValor();
	}
}
