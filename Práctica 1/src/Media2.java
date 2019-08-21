/**
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 * Esta aplicacion calcula la media de n parametros.
 */
public class Media2 {
/**
 * Punto de entrada a la aplicacion.
 *
 * Este metodo imprime la media de n parametros
 *
 * @param args Los argumentos de la linea de comando. Se esperan n numeros como parametros
 */
public static void main(String[] args) {
	if (args.length<1){
		System.out.println("Se espera al menos un numero como parametro.");
		return;
	}
	
	int i=0;
	double media=0;
	double num;
	
	while (i<args.length) {
	num= Double.parseDouble(args[i]);	//convierto cada uno de los argumentos de entrada a double
	media +=num;
	i++;
	}

	media/=i;	//Aqui obtengo el valor de la media en si.
	System.out.println("Hay "+args.length+" parametros recibidos");
	
	if(args.length%2==0){
	System.out.println("Que es un numero par");
	}
	else{
	System.out.println("Que es un numero impar");
	}
	System.out.println("Su media es: " + media);
	}
}
