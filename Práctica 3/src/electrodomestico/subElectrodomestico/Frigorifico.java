/**
 * 
 */
package electrodomestico.subElectrodomestico;

import electrodomestico.caracteristicas.ClaseEnergetica;
import electrodomestico.caracteristicas.Dimension;

/**
 * Esta clase representa los frigorificos
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Frigorifico extends SubElectrodomestico {

	public enum Frost {
		Frost, NoFrost
	};

	private boolean frost;

	/**
	 * @param marca
	 *            la marca del frigorifico
	 * @param modelo
	 *            el modelo del frigorifico
	 * @param precioBase
	 *            el precio base del frigorifico
	 * @param claseEnergetica
	 *            la clase energetica del frigorifico
	 * @param dimension
	 *            las dimensiones del frigorifico
	 * @param peso
	 *            el peso del frigorifico
	 */
	public Frigorifico(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			Dimension dimension, double peso) {
		super(marca, modelo, precioBase, claseEnergetica, dimension, peso);
	}

	/**
	 * @param marca
	 *            la marca del frigorifico
	 * @param modelo
	 *            el modelo del frigorifico
	 * @param precioBase
	 *            el precio base del frigorifico
	 * @param claseEnergetica
	 *            la clase energetica del frigorifico
	 * @param dimension
	 *            las dimensiones del frigorifico
	 * @param peso
	 *            el peso del frigorifico
	 * @param frost
	 *            indica si el frigorifico es frost
	 */
	public Frigorifico(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica,
			Dimension dimension, double peso, boolean frost) {
		super(marca, modelo, precioBase, claseEnergetica, dimension, peso);
		this.frost = frost;
	}

	/**
	 * Este metodo se encargara de convertir los datos almacenados en una lista
	 * de Strings en un Frigor�fico
	 * 
	 * @param args
	 *            la lista de Strings con los datos
	 * @throws Exception
	 *             en caso de que el numero de datos sea incorrecto
	 */
	public Frigorifico(String[] args) throws Exception {
		super(args);
		if (args.length < 9)
			throw new Exception("Error en el numero de argumentos");
		boolean frost = isItFrost(args[8]);
		this.frost = frost;
	}

	/**
	 * @return si el frigorifico es frost o no es frost
	 */
	public boolean isFrost() {
		return frost;
	}

	/**
	 * @param frost
	 *            valor que asignar al frigorifico para determinar si es frost o
	 *            no es frost
	 */
	public void setFrost(boolean frost) {
		this.frost = frost;
	}

	/**
	 * este metodo calcula los gastos de envio que tendria el frigorifico si se
	 * vendiera a domicilio
	 * 
	 * @return el precio de los gastos de envio
	 */
	public double calcularPortes() {
		return Math.round(this.getDimension().volumen() * 70);
	}

	/**
	 * Este metodo evalua un String para comprobar si este contiene Frost
	 * 
	 * @param str
	 *            el string a comprobar
	 * @return true si en el String hay escrito Frost. false de lo contrario
	 */
	private boolean isItFrost(String str) {
		return (Frost.valueOf(str) == Frost.Frost);
	}

}
