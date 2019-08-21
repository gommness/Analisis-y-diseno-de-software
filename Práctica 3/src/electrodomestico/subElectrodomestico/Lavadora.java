package electrodomestico.subElectrodomestico;

import electrodomestico.caracteristicas.ClaseEnergetica;
import electrodomestico.caracteristicas.Dimension;

/**
 * Esta clase representa las Lavadoras
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Lavadora extends SubElectrodomestico {

	private double carga;
	private double rpm;

	/**
	 * @param marca
	 *            la marca de la lavadora
	 * @param modelo
	 *            el modelo de la lavadora
	 * @param precioBase
	 *            el precio base de la lavadora
	 * @param claseEnergetica
	 *            la clase energetica de la lavadora
	 * @param dimension
	 *            las dimensiones de la lavadora
	 * @param peso
	 *            el peso de la lavadora
	 */
	public Lavadora(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			Dimension dimension, double peso) {
		super(marca, modelo, precioBase, claseEnergetica, dimension, peso);
	}

	/**
	 * @param marca
	 *            la marca de la lavadora
	 * @param modelo
	 *            el modelo de la lavadora
	 * @param precioBase
	 *            el precio base de la lavadora
	 * @param claseEnergetica
	 *            la clase energetica de la lavadora
	 * @param dimension
	 *            las dimensiones de la lavadora
	 * @param peso
	 *            el peso de la lavadora
	 * @param carga
	 *            los kilogramos de carga de la lavadora
	 * @param rpm
	 *            las revoluciones por minuto de la lavadora
	 */
	public Lavadora(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			Dimension dimension, double peso, double carga, double rpm) {
		this(marca, modelo, precioBase, claseEnergetica, dimension, peso);
		this.carga = carga;
		this.rpm = rpm;
	}

	/**
	 * Este metodo crea una Lavadora con los datos almacenados en la lista de
	 * Strings
	 * 
	 * @param args
	 *            la lista de Strings con los datos
	 * @throws Exception
	 *             en caso de que el numero de datos sea incorrecto
	 */
	public Lavadora(String[] args) throws Exception {
		super(args);
		if (args.length < 10)
			throw new Exception("Error en el numero de argumentos");
		double carga = Double.parseDouble(args[8]);
		double rpm = Double.parseDouble(args[9]);
		this.carga = carga;
		this.rpm = rpm;
	}

	/**
	 * @return los kilogramos de carga de la lavadora
	 */
	public double getCarga() {
		return carga;
	}

	/**
	 * @param carga
	 *            los kilogramos de carga a asignar
	 */
	public void setCarga(double carga) {
		this.carga = carga;
	}

	/**
	 * @return las revoluciones por minuto del objeto
	 */
	public double getRpm() {
		return rpm;
	}

	/**
	 * @param rpm
	 *            las revoluciones por minuto a asignar
	 */
	public void setRpm(double rpm) {
		this.rpm = rpm;
	}

	/**
	 * este metodo calcula el precio extra que tendría el objeto de ser vendido
	 * a domicilio
	 * 
	 * @return el precio en euros de los costes de envio
	 */
	public double calcularPortes() {
		if (this.getPeso() <= 50)
			return 35;
		else
			return 35 + 0.5 * Math.ceil(this.getPeso() - 50);
	}

}
