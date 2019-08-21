package testers;

import electrodomestico.Electrodomestico;
import electrodomestico.caracteristicas.ClaseEnergetica;
import electrodomestico.caracteristicas.Dimension;
import electrodomestico.television.TelevisionCurva;
import venta.*;

/**
 * tester del apartado 5. Contiene a todos los demas testers (excepto al del
 * apartado 2 por redundancia)
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class TesterTienda5 {

	public static void main(String[] args) {

		System.out.println("\n\nTESTER 1:\n");
		TesterTienda1.main(args);
		System.out.println("\n\nTESTER 3:\n");
		TesterTienda3.main(args);
		System.out.println("\n\nTESTER 4:\n");
		TesterTienda4.main(args);
		System.out.println("\n\nPARTE DE TESTEO DE LAS NUEVAS CLASES:\n");

		Electrodomestico tele1 = new TelevisionCurva("Loewe", "Art 48 4K Plata", 1699.00, ClaseEnergetica.A, 48, 200,
				new Dimension(1, 1, 1));
		Electrodomestico tele2 = new TelevisionCurva("Loewe", "Art 48 4K Plata", 1699.00, ClaseEnergetica.A, 48, 200,
				new Dimension(2, 1, 1));

		Venta venta = new VentaCanarias(tele1);
		System.out.println(venta.getTicket());
		venta = new VentaCanarias(tele2);
		System.out.println(venta.getTicket());
		venta = new VentaDomicilio(tele2);
		System.out.println(venta.getTicket());
	}

}
