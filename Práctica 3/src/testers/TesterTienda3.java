package testers;

import electrodomestico.Electrodomestico;
import electrodomestico.LecturaElectrodomesticos;

import java.util.List;
import java.io.*;

/**
 * Segundo tester el tercer apartado de la P2 DEBE EJECUTARSE CON UN ARGUMENTO
 * EN LA LINEA DE COMANDOS
 *
 * @param args[0]
 *            El primer y �nico argumento ser� el nombre del archivo de texto a
 *            leer
 * @author Profesores ADS
 * 
 */

public class TesterTienda3 {
	public static void main(String[] args) {
		List<Electrodomestico> productos = null;
		try {
			productos = LecturaElectrodomesticos.leer(args[0]);
		} catch (IOException e) {
			System.out.println(e);
			return;
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		for (Electrodomestico e : productos) {
			System.out.println(">> " + e);
		}

	}
}
