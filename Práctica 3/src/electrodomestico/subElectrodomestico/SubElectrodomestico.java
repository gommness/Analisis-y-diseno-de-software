package electrodomestico.subElectrodomestico;

import electrodomestico.Electrodomestico;
import electrodomestico.caracteristicas.ClaseEnergetica;
import electrodomestico.caracteristicas.Dimension;

/**
 * Esta clase representa un tipo de electrodomestico más concreto
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public abstract class SubElectrodomestico extends Electrodomestico {

	private double peso;
	private Dimension dimension;

	/**
	 * @param marca
	 *            la marca del electrodomestico
	 * @param modelo
	 *            el modelo del electrodomestico
	 * @param precioBase
	 *            el precio base del electrodomestico
	 * @param claseEnergetica
	 *            la clase energetica del electrodomestico
	 * @param dimension
	 *            las dimensiones del electrodomestico
	 * @param peso
	 *            el peso del electrodomestico
	 */
	public SubElectrodomestico(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			Dimension dimension, double peso) {
		super(marca, modelo, precioBase, claseEnergetica);
		this.peso = peso;
		this.dimension = dimension;
	}

	/**
	 * Este metodo creara un SubElectrodomestico mediante los datos almacenados
	 * en la lista de Strings que se le pasa por argumento
	 * 
	 * @param args
	 *            la lista de Strings
	 * @throws Exception
	 *             en caso de que el numero de argumentos sea incorrecto
	 */
	public SubElectrodomestico(String[] args) throws Exception {
		super(args);
		if (args.length < 8)
			throw new Exception("Error en el numero de argumentos");
		Dimension dimension = new Dimension(args[4], args[5], args[6]);
		double peso = Double.parseDouble(args[7]);
		this.dimension = dimension;
		this.peso = peso;
	}

	/**
	 * @return el peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            el peso a asignar
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return las dimensiones
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            las dimensiones a asignar
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

}
