/**
 * 
 */
package electrodomestico.television;

import electrodomestico.Electrodomestico;
import electrodomestico.caracteristicas.ClaseEnergetica;

/**
 * Esta clase representa las televisiones
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Television extends Electrodomestico {

	private double pulgadas;

	/**
	 * @param marca
	 *            la marca de la television
	 * @param modelo
	 *            el modelo de la television
	 * @param precioBase
	 *            el precio base de la television
	 * @param claseEnergetica
	 *            la clase energetica de la television
	 */
	public Television(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica) {
		super(marca, modelo, precioBase, claseEnergetica);
	}

	/**
	 * @param marca
	 *            la marca de la television
	 * @param modelo
	 *            el modelo de la television
	 * @param precioBase
	 *            el precio base de la television
	 * @param claseEnergetica
	 *            la clase energetica de la television
	 * @param pulgadas
	 *            las pulgadas que mide la television
	 */
	public Television(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			double pulgadas) {
		this(marca, modelo, precioBase, claseEnergetica);
		this.pulgadas = pulgadas;
	}

	/**
	 * Este metodo crea una television mediante los datos almacenados en una
	 * lista de Strings
	 * 
	 * @param args
	 *            la lista de Strings con los datos requeridos
	 * @throws Exception
	 *             en caso de que el numero de datos fuera incorrecto
	 */
	public Television(String[] args) throws Exception {
		super(args);
		if (args.length < 5)
			throw new Exception("Error en el numero de argumentos");
		double pulgadas = Double.parseDouble(args[4]);
		this.pulgadas = pulgadas;
	}

	/**
	 * @return las pulgadas que mide la television
	 */
	public double getPulgadas() {
		return pulgadas;
	}

	/**
	 * @param pulgadas
	 *            las pulgadas a asignar
	 */
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	/**
	 * Este metodo calcula el precio extra que tendria la television de ser
	 * vendida a domicilio
	 * 
	 * @return el precio en euros de los costes de envio
	 */
	public double calcularPortes() {
		if (this.pulgadas <= 40) {
			if (this.getPrecioBase() > 500)
				return 0;
			else
				return 35;
		} else
			return 35 + (this.pulgadas - 40);
	}

}
