package electrodomestico;

import electrodomestico.subElectrodomestico.Frigorifico;
import electrodomestico.subElectrodomestico.Lavadora;
import electrodomestico.television.Television;

import java.util.*;
import java.io.*;

/**
 * Esta clase contiene el metodo estatico para leer desde fichero y crear
 * electrodomesticos. No comprueba repeticiones Existe unicamente con el
 * proposito de que el profesor pueda replicar el resultado del apartado 2
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class LecturaElectrodomesticos_old {

	/**
	 * lee de un fichero cuya ruta es pasada por argumento y crea los objetos
	 * que indique el fichero
	 * 
	 * @param fichero
	 *            el path completo del fichero a leer
	 * @return una lista con los electrodomesticos creados segun los datos
	 *         especificados en el fichero
	 * @throws IOException
	 *             en caso de que no se haya podido leer el fichero
	 * @throws Exception
	 *             en caso de que se intentara crear un electrodomestico con
	 *             insuficientes atributos
	 */
	public static List<Electrodomestico> leer(String fichero) throws IOException, Exception {
		String linea;
		String[] st;
		Electrodomestico e;
		List<Electrodomestico> output = new ArrayList<Electrodomestico>();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));

		while ((linea = buffer.readLine()) != null) {
			st = linea.split("=");
			e = null;
			switch (st.length) {
			case 9:
				e = new Frigorifico(st);
				break;
			case 5:
				e = new Television(st);
				break;
			case 10:
				e = new Lavadora(st);
				break;
			}
			if (e != null)
				output.add(e);
		}

		buffer.close();
		return output;
	}

}
