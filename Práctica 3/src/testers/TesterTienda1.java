package testers;

import electrodomestico.Electrodomestico;
import electrodomestico.caracteristicas.ClaseEnergetica;
import electrodomestico.caracteristicas.Dimension;
import electrodomestico.subElectrodomestico.Frigorifico;
import electrodomestico.subElectrodomestico.Lavadora;
import electrodomestico.television.Television;
import venta.Venta;
import venta.VentaDomicilio;

/**
 * Primer tester de la práctica 3
 * 
 * @author Profesores ADS
 */

public class TesterTienda1 {

	/**
	 * @param args
	 *            no sirve para nada
	 */
	public static void main(String[] args) {

		Electrodomestico tele1 = new Television("Loewe", "Art 48 4K Plata", 1699.00, ClaseEnergetica.A, 48);
		Electrodomestico tele2 = new Television("LG", "32LF592U", 271.92, ClaseEnergetica.C, 32);
		Electrodomestico lava1 = new Lavadora("Indesit", "XWE 91483 X", 329.0, ClaseEnergetica.A,
				new Dimension(59.5, 60.5, 85.0), 72, 9.5, 1500);
		Electrodomestico frigo1 = new Frigorifico("Bosch", "KGN39VW21", 599.0, ClaseEnergetica.A,
				new Dimension(60, 65, 201), 83.0, true);

		Venta[] ventas = new Venta[6];
		ventas[0] = new Venta(tele1);
		ventas[1] = new VentaDomicilio(tele1);
		ventas[2] = new Venta(tele1,
				new Lavadora("Superkin", "", 0.0, ClaseEnergetica.Desconocida, new Dimension(59.5, 60.5, 85.0), 100)); // sin
																														// carga
																														// ni
																														// rpm
		ventas[3] = new VentaDomicilio(lava1, frigo1);
		ventas[4] = new Venta(tele2, new Television("Telefunken", "", 0.0, ClaseEnergetica.D, 32));
		ventas[5] = new VentaDomicilio(lava1, tele2);

		for (Venta venta : ventas)
			System.out.println(venta.getTicket());
	}

}
