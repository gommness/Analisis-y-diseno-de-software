package es.uam.eps.p4.model.iris.apartado2;

import java.io.*;
import java.util.*;

import es.uam.eps.p4.exception.InvalidValuesException;
import es.uam.eps.p4.model.*;
import es.uam.eps.p4.model.iris.apartado1.Iris;

/**
 * Esta clase se encarga de leer los casos de un fichero
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public abstract class CSVCaseReader {

	/**
	 * @param path
	 *            la direccion del fichero
	 * @param separador
	 *            el separador a usar para leerlo
	 * @param charSet
	 *            el juego de caracteres
	 * @param problem
	 *            el tipo de problema
	 * @param <T> el tipo de lista de casos
	 * @return la lista de casos
	 * @throws IOException la excepcion
	 * @throws InvalidValuesException la excepcion
	 */

	public static <T> List<Case<T>> leer(String path, String separador, String charSet, Type<T> problem)
			throws IOException, InvalidValuesException {
		List<Case<T>> cases = new ArrayList<>();
		int i;
		String linea;
		String[] st;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(path), charSet));
		while ((linea = buffer.readLine()) != null) {
			if (linea.length() != 0)/* Si la linea esta en blanco se ignora */
			{
				// continue;
				st = linea.split(separador);
				List<String> values = new ArrayList<String>();
				for (i = 0; i < st.length - 1; i++) {
					values.add(st[i]);
				}
				Case<T> cas = new CaseImpl<T>(problem.newInstance(values), st[i]);
				cases.add(cas);
			}
		}
		buffer.close();
		return cases;
	}

	/**
	 * Aquí probamos si el lector ha funcionado correctamente imprimiendo los
	 * casos leídos
	 * @param args nada
	 */
	public static void main(String[] args) {
		Iris iris = new Iris();
		try {
			List<Case<Iris>> casos = CSVCaseReader.<Iris> leer("txt/bezdekIris.data",
					",", "UTF-8", iris);
			for (Case<Iris> c : casos)
				System.out.println(c);
		} catch (IOException | InvalidValuesException e) {
			e.printStackTrace();
		}
	}
}
