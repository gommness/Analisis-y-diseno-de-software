package electrodomestico;

import electrodomestico.caracteristicas.ClaseEnergetica;

/**
 * Esta clase representa los electrodomesticos. Creada para el apartado 1
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */

public abstract class Electrodomestico {

	private String marca;
	private String modelo;
	private double precioBase;
	private ClaseEnergetica claseEnergetica;
	private int stock;

	/**
	 * @param marca
	 *            la marca del electrodomestico
	 * @param modelo
	 *            el modelo del electrodomestico
	 * @param precioBase
	 *            el precio base del electrodomestico
	 * @param claseEnergetica
	 *            la clase energetica del electrodomestico
	 */
	public Electrodomestico(String marca, String modelo, double precioBase, ClaseEnergetica claseEnergetica) {
		this.marca = marca;
		this.modelo = modelo;
		this.precioBase = precioBase;
		this.claseEnergetica = claseEnergetica;
		this.stock = 0;
	}

	/**
	 * Este metodo recibe los datos de un electrodomestico en forma de lista de
	 * Strings y se encarga de parsearlos al tipo de dato correcto para poder
	 * crear el electrodomestivo
	 * 
	 * @param una
	 *            lista de Strings que contienen los datos del electrodomestico
	 * @throws Exception
	 *             en caso de que el numero de argumentos sea incorrecto
	 */
	public Electrodomestico(String[] args) throws Exception {
		if (args.length < 4)
			throw new Exception("Error en el numero de argumentos");
		String marca = args[0];
		String modelo = args[1];
		double precioBase = Double.parseDouble(args[2]);
		ClaseEnergetica claseEnergetica = ClaseEnergetica.valueOf(args[3]);
		this.marca = marca;
		this.modelo = modelo;
		this.precioBase = precioBase;
		this.claseEnergetica = claseEnergetica;
		this.stock = 0;
	}

	/**
	 * @return el stock del electrodomestico
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            el stock a asignar al electrodomestico
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return la marca del electrodomestico
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca
	 *            la marca a asignar
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return el modelo del electrodomestico
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            el modelo a asignar
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return el precio base del electrodomestico
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * @param precioBase
	 *            el precio base a asignar
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * @return la clase energetica del electrodomestico
	 */
	public ClaseEnergetica getClaseEnergetica() {
		return claseEnergetica;
	}

	/**
	 * @param claseEnergetica
	 *            la clase energetica a asignar
	 */
	public void setClaseEnergetica(ClaseEnergetica claseEnergetica) {
		this.claseEnergetica = claseEnergetica;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + this.marca + " " + this.modelo + ", " + this.precioBase + " Euros";
	}

	/**
	 * este metodo compara las clases energeticas de dos electrodomesticos
	 * 
	 * @param other
	 *            el electrodomestico con el que se compara
	 * @return la diferencia de niveles de clase energetica que hay entre los
	 *         electrodomesticos. (valor negativo si la clase energetica de
	 *         other es mayor)
	 */
	public int compareTo(Electrodomestico other) {
		if (other == null)
			return 0;
		else {
			return this.getClaseEnergetica().compareTo(other.getClaseEnergetica());
		}
	}

	/**
	 * este metodo comprueba si la clase energetica del electrodomestico es
	 * Desconocida
	 * 
	 * @return true si la clase es desconocida, false si no es desconocida
	 */
	public boolean isClaseEnergeticaDesconocida() {
		if (this.getClaseEnergetica() == ClaseEnergetica.Desconocida)
			return true;
		else
			return false;
	}

	/**
	 * Este metodo sera definida mas adelante y se encargara de calcular los
	 * gastos de envio de un electrodomestico
	 * 
	 * @return los gastos de envio del electrodomestico
	 */
	public abstract double calcularPortes();

	/**
	 * este metodo añadira uno al stock del electrodomestico
	 */
	public void addOneStock() {
		this.stock += 1;
	}

	/**
	 * este metodo restara uno al stock del electrodomestico
	 */
	public void removeOneStock() {
		this.stock += 1;
	}

	/*
	 * debido a que utilizaremos contains en el lector, nos conviene sobrecargar
	 * este metodo, ya que contains emplea este metodo equals
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		return (object instanceof Electrodomestico) ? equals((Electrodomestico) object) : false;
	}

	/**
	 * Este es el metodo de comparacion esclusivo para electrodomesticos.
	 * 
	 * @param e
	 *            el electrodomestico con el que comparar
	 * @return true si son iguales, false si son distintos
	 */
	public boolean equals(Electrodomestico e) {
		return (e.marca.compareTo(this.marca) == 0 && e.modelo.compareTo(this.modelo) == 0
				&& e.getClass() == this.getClass());
	}

}
