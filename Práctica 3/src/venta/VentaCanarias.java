/**
 * 
 */
package venta;

import java.text.DecimalFormat;

import electrodomestico.Electrodomestico;

/**
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class VentaCanarias extends VentaDomicilio {

	/**
	 * @param vendido
	 *            el electrodomestico vendido
	 */
	public VentaCanarias(Electrodomestico vendido) {
		super(vendido);
	}

	public double calcularTotal() {
		double total;
		total = this.getVendido().getPrecioBase() * 1.07;
		return total;
	}

	public String getPortes() {
		DecimalFormat df = new DecimalFormat("0.00");
		double portes = this.getVendido().getPrecioBase() * 0.07;
		return "Coste porte:\t\t" + String.format("%7s", df.format(portes)) + " Euros\n";
	}

}
