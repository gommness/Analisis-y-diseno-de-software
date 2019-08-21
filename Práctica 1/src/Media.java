/**
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 * Esta aplicacion calcula la media de 2 parametros.
 */
public class Media {
/**
 * Punto de entrada a la aplicacion.
 *
 * Este metodo imprime la media de 2 parametros
 *
 * @param args Los argumentos de la linea de comando. Se espera dos numeros como parametros
 */
public static void main(String[] args) {
if (args.length!=2){
	System.out.println("Se esperan 2 numeros como parametros.");
	return;
}

	String arg1 = args[0];   // una variable String que obtiene el primer parametro
	String arg2 = args[1];	 // una variable String que obtiene el segundo parametro		
	double x= Double.parseDouble(arg1); // una variable double, que convierte arg1 a numerico
	double y= Double.parseDouble(arg2); // una variable double, que convierte arg2 a numerico
	System.out.println("La media de "+arg1+" y "+arg2+" es: "+(x+y)/2);
	}
}
