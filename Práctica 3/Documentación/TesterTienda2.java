package es.uam.eps.ads.practica3;

import java.util.List;

/**
 * Segundo tester el tercer apartado de la P2
 * DEBE EJECUTARSE CON UN ARGUMENTO EN LA LINEA DE COMANDOS
 *
 * @param args[0] El primer y único argumento será el nombre del archivo de texto a leer
 * @author Profesores ADS

 */

public class TesterTienda2 {
    public static void main(String[] args) {
    	List<Electrodomestico> productos = LecturaElectrodomesticos.leer( args[0] );
    	for (Electrodomestico e : productos) { 
    		System.out.println(">> " + e ); 
    	}
    		
    }
}
