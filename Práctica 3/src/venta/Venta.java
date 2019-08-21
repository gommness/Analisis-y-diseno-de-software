package venta;

import java.text.DecimalFormat;
import java.util.*;

import electrodomestico.Electrodomestico;

/**
 * Esta clase representa la venta
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Venta {

	private Electrodomestico vendido;
	private Electrodomestico devuelto;

	static private List<Venta> ventas = new ArrayList<Venta>();

	/**
	 * Este constructor se usa cuando se vende un electrodomestico sin devolver
	 * otro.
	 * 
	 * @param vendido
	 *            el electrodomestico que se vende
	 */
	public Venta(Electrodomestico vendido) {
		this.vendido = vendido;
		this.devuelto = null;
		Venta.ventas.add(this);
	}

	/**
	 * Este constructor es mas ampliado. Se usa en el caso en el que se venda un
	 * electrodomestico y el cliente devuelva otro
	 * 
	 * @param vendido
	 *            el electrodomestico que se vende
	 * @param devuelto
	 *            el electrodomestico que se devuelve
	 */
	public Venta(Electrodomestico vendido, Electrodomestico devuelto) {
		this(vendido);
		this.devuelto = devuelto;
	}

	/**
	 * @return el electrodomestico vendido
	 */
	public Electrodomestico getVendido() {
		return vendido;
	}

	/**
	 * @return el electrodomestico devuelto
	 */
	public Electrodomestico getDevuelto() {
		return devuelto;
	}

	/**
	 * @return the ultimaVenta
	 */
	public static Venta ultima() {
		return Venta.ventas.get(Venta.ventas.size() - 1);
	}

	public static Venta anular() {
		int index;
		if (Venta.ventas.isEmpty() == true)
			return null;
		index = Venta.ventas.size() - 1;
		return Venta.ventas.remove(index);
	}

	/**
	 * Este metodo calcula el descuento aplicado debido a la diferencia de las
	 * clases energeticas del electrodomestico devuelto
	 * 
	 * @return el descuento que se aplica a la venta
	 */
	public double calcularDescuento() {
		if (this.devuelto == null)
			return 0;
		else {
			if (this.devuelto.isClaseEnergeticaDesconocida() == true)
				return 10;
			else
				return 25 + 15 * this.vendido.compareTo(this.devuelto);
		}
	}

	/**
	 * este metodo calcula el precio total de la venta aplicando descuentos
	 * 
	 * @return el precio final de la venta
	 */
	public double calcularTotal() {
		double total;
		total = this.vendido.getPrecioBase() - this.calcularDescuento();
		return total;
	}

	/**
	 * Esta funcion crea un String con los datos que identifican al producto
	 * junto con su precio y su descuento
	 * 
	 * @return el String formateado con los datos, el precio y el descuento
	 */
	public String getData() {
		String output;
		DecimalFormat df = new DecimalFormat("0.00");
		output = "--------------------------------------------\n";
		output += "Producto vendido: " + this.vendido.toString() + "\n";
		output += "--------------------------------------------\n";
		output += "Precio producto:\t" + String.format("%7s", df.format(this.vendido.getPrecioBase())) + " Euros\n";
		output += "Descuento entrega:\t" + String.format("%7s", df.format(this.calcularDescuento())) + " Euros\n";
		return output;
	}

	/**
	 * Este metodo devuelve una cadena de caracteres que corresponder�a a la
	 * linea con el total calculado
	 * 
	 * @return String de la linea del total
	 */
	private String getTotal() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "TOTAL:\t\t\t" + String.format("%7s", df.format(this.calcularTotal())) + " Euros";
	}

	/**
	 * Esta funcion crea un String formateado con los datos necesarios que
	 * deberian aparecer en el ticket de venta
	 * 
	 * @return el String formateado con todos los datos necesarios
	 */
	public String getTicket() {
		String output;
		output = this.getData();
		output += this.getTotal();
		return output;
	}

	/**
	 * Este metodo calcula el resumen de todas las ventas
	 * 
	 * @return String con un resumen de todas las ventas
	 */
	public static String resumenVentas() {
		String output = "\nRESUMEN DE VENTAS\n";
		for (Venta v : Venta.ventas) {
			output += v.getTotal() + "\n";
		}
		return output;
	}

	/**
	 * Este metodo calcula el resumen de todas las ventas cuyo precio fue
	 * superior al minimo especificado
	 * 
	 * @param min
	 *            el valor que el precio de una venta ha de superar para
	 *            aparecer en el resumen de ventas
	 * @return String con el resumen de ventas cuyo precio fue superior al
	 *         minimo especificado
	 */
	public static String resumenVentas(int min) {
		String output = "\nRESUMEN DE VENTAS\n";
		for (Venta v : Venta.ventas) {
			if (v.calcularTotal() >= 500)
				output += v.getTotal() + "\n";
		}
		return output;
	}

	/**
	 * Este metodo hace un resumen de las ventas que contienen la subcadena str
	 * dentro de la marca del electrodomestico vendido
	 * 
	 * @param str
	 *            la subcadena que deben contener las marcas de los
	 *            electrodomesticos
	 * @return un String con el resumen de ventas cuyo electrodomestico contiene
	 *         a str en su marca
	 */
	public static String resumenVentas(String str) {
		String output = "\nRESUMEN DE VENTAS\n";
		for (Venta v : Venta.ventas) {
			if (v.vendido.getMarca().toUpperCase().contains(str.toUpperCase()) == true)
				output += v.getTotal() + "\n";
		}
		return output;
	}

}
