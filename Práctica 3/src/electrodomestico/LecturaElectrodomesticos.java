package electrodomestico;

import electrodomestico.subElectrodomestico.Frigorifico;
import electrodomestico.subElectrodomestico.Lavadora;
import electrodomestico.television.Television;
import electrodomestico.television.TelevisionCurva;

import java.util.*;
import java.io.*;

/**
 * Esta clase tiene los metodos estaticos que se encargaran de leer datos de un
 * fichero y crear electrodomesticos segun �stos. Si hay un electrodomestico
 * repetido, no lo crear�a. (Notese que se contempla el caso de que haya
 * televisiones curvadas debido a la actualizacion que fue necesaria hacer tras
 * realizar el apartado 5)
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class LecturaElectrodomesticos {

	/**
	 * Este metodo sirve para averiguar si el string que se le pasa por
	 * argumento puede ser parseado a Double o no.
	 * 
	 * @param str
	 *            el string a comprobar
	 * @return si puede ser parseado: true. De lo contrario: false
	 */
	private static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Este metodo se encarga de leer de un fichero datos para crear
	 * electrodomesticos
	 * 
	 * @param fichero
	 *            el path completo del fichero del que se leeran los datos
	 * @return una lista con los electrodomesticos creados, sin repeticiones
	 * @throws IOException
	 *             en caso de que no se pudiera abrir el fichero
	 * @throws Exception
	 *             en caso de que hubiera un error creando los electrodomesticos
	 */
	public static List<Electrodomestico> leer(String fichero) throws IOException, Exception {
		String linea;
		String[] st;
		Electrodomestico e;
		List<Electrodomestico> repeated = new ArrayList<Electrodomestico>();
		List<Electrodomestico> output = new ArrayList<Electrodomestico>();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));

		while ((linea = buffer.readLine()) != null) {
			st = linea.split("=");
			e = null;
			switch (st.length) {
			case 9:
				if (isDouble(st[st.length - 1]) == true)
					e = new TelevisionCurva(st);
				else
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
				if (output.contains(e) == false)
					output.add(e);
				else
					repeated.add(e);
		}

		buffer.close();
		for (Electrodomestico ind : repeated) {
			System.out.println("Duplicado no a�adido:\n" + ind);
		}
		return output;
	}

}
