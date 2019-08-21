package venta;

import java.text.DecimalFormat;

import electrodomestico.Electrodomestico;

/**
 * Esta clase representa las ventas a domicilio. Es una clase más particular que
 * la clase Venta
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class VentaDomicilio extends Venta {

	/**
	 * Este constructor es mas ampliado. Se usa en el caso en el que se venda un
	 * electrodomestico y el cliente devuelva otro
	 * 
	 * @param vendido
	 *            el electrodomestico que se vende
	 * @param devuelto
	 *            el electrodomestico que se devuelve
	 */
	public VentaDomicilio(Electrodomestico vendido, Electrodomestico devuelto) {
		super(vendido, devuelto);
	}

	/**
	 * Este constructor se usa cuando se vende un electrodomestico sin devolver
	 * otro.
	 * 
	 * @param vendido
	 *            el electrodomestico que se vende
	 */
	public VentaDomicilio(Electrodomestico vendido) {
		super(vendido);
	}

	public String getPortes() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "Coste porte:\t\t" + String.format("%7s", df.format(this.getVendido().calcularPortes())) + " Euros\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see apartado1.Venta#getData()
	 */
	public String getData() {
		String output;
		output = super.getData();
		output += this.getPortes();
		return output;
	}

	/**
	 * este metodo calcula el precio total de la venta aplicando descuentos y
	 * los costes de envio
	 * 
	 * @return el precio final de la venta
	 */
	public double calcularTotal() {
		double total;
		total = this.getVendido().getPrecioBase() + this.getVendido().calcularPortes() - this.calcularDescuento();
		return total;
	}

}
