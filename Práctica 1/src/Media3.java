/**
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 *
 * <p>
 *
 * Esta aplicacion calcula la mediana de hasta 20 parametros.
 */
public class Media3 {
/**
 * Punto de entrada a la aplicacion.
 *
 * Este metodo imprime la mediana de hasta 20 parametros
 *
 * @param args Los argumentos de la linea de comando. Se esperan de 1 a 20 numeros como parametros
 */
public static void main(String[] args) {
	if (args.length<1 || args.length>20){
		System.out.println("Se espera un numero de parametros entre 1 y 20.");
		return;
	}
	double[] num = new double[20]; //en num guardare los argumentos parseados a double
	int i, j, min;	//i y j son contadores de bucles, min sera el valor minimo de la tabla en cada iteracion del bucle
	double aux;	//variable auxiliar para hacer swap

	for(i=0;i<args.length;i++){
	num[i]=Double.parseDouble(args[i]); //parseo cada uno de los argumentos a double
	}

	//Hacemos SelectSort
	for ( i=0; i< (args.length-1); i++ ) {
		min=i;
		for(j=i+1;j< args.length ;j++){
			if(num[j]<num[min]){
			min=j;
			}
		}
		//Swap
		aux=num[i];
		num[i]=num[min];
		num[min]=aux;
	}
	
	System.out.println("Los numeros ordenados son:");
	for(i=0;i<args.length;i++){
	System.out.println(num[i]);	
	}
	
	//Dependiendo de si el numero de argumentos es par o impar calculo la mediana como es debido y la imprimo por pantalla
	if(args.length%2==0){
	i=(args.length-1)/2;
	System.out.println("La mediana es: "+((num[i]+num[i+1])/2));
	}
	else{
	i=(args.length-1)/2;
	System.out.println("La mediana es: "+num[i]);
	}	
}
}
