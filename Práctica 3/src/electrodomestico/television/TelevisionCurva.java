package electrodomestico.television;

import electrodomestico.caracteristicas.ClaseEnergetica;
import electrodomestico.caracteristicas.Dimension;

/**
 * Esta clase representa las televisiones curvadas, incorporadas en el ejercicio
 * 5
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class TelevisionCurva extends Television {

	private double peso;
	private Dimension dimension;

	/**
	 * @param marca
	 *            la marca de la television curvada
	 * @param modelo
	 *            el modelo de la television curvada
	 * @param precioBase
	 *            el precio base de la television curvada
	 * @param claseEnergetica
	 *            la clase energetica de la television curvada
	 * @param pulgadas
	 *            las pulgadas de la television curvada
	 * @param peso
	 *            el peso de la television curvada
	 * @param dimension
	 *            un objeto de tipo Dimension con las dimensiones de la
	 *            television curvada
	 */
	public TelevisionCurva(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			double pulgadas, double peso, Dimension dimension) {
		super(marca, modelo, precioBase, claseEnergetica, pulgadas);
		this.peso = peso;
		this.dimension = dimension;
	}

	/**
	 * Este metodo crea una television curvada a partir de una lista de Strings
	 * que contiene los datos
	 * 
	 * @param args
	 *            la lista de Strings que contiene los datos
	 * @throws Exception
	 *             en caso de que el numero de datos sea incorrecto
	 */
	public TelevisionCurva(String[] args) throws Exception {
		super(args);
		if (args.length < 9)
			throw new Exception("Error en el numero de argumentos");
		double peso = Double.parseDouble(args[5]);
		Dimension dimension = new Dimension(args[6], args[7], args[8]);
		this.peso = peso;
		this.dimension = dimension;
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
	 * @return la dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            la dimension a asignar
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public double calcularPortes() {
		double output = super.calcularPortes();
		output += this.getDimension().volumen() * 25;
		return output;
	}

}
