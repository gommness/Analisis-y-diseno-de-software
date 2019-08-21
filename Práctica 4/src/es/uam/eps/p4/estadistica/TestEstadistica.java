package es.uam.eps.p4.estadistica;

/**
 * Este tester se encarga de probar que las clases estadisticas func
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class TestEstadistica {

	public static void main(String[] args) {
		Mean mean = new Mean();
		Variance variance = new Variance();
		StdDev stdDev = new StdDev();
		System.out.println("La media inicial es: " + mean.getResult());
		System.out.println("La varianza inicial es: " + variance.getResult());
		System.out.println("La Desviacion Tipica inicial es: " + stdDev.getResult());
		System.out.println("Introducimos los valores: " + 5 + ", " + 3 + ", " + 7 + " y " + 12);
		mean.addValue(5);
		mean.addValue(3);
		mean.addValue(7);
		mean.addValue(12);
		double media = (5 + 3 + 7 + 12) / 4.0;
		System.out.println("La media es: " + mean.getResult() + ", siendo la media esperada: " + media);

		variance.addValue(5);
		variance.addValue(3);
		variance.addValue(7);
		variance.addValue(12);
		double varianza = (Math.pow((media - 5), 2) + Math.pow((media - 3), 2) + Math.pow((media - 7), 2)
				+ Math.pow((media - 12), 2)) / 4;
		System.out.println("La varianza es: " + variance.getResult() + ", siendo la varianza esperada: " + varianza);

		stdDev.addValue(5);
		stdDev.addValue(3);
		stdDev.addValue(7);
		stdDev.addValue(12);
		double desvtip = Math.sqrt(varianza);
		System.out.println("La Desviacion Tipica es: " + stdDev.getResult() + ", siendo la desviacion tipica esperada: "
				+ desvtip);
	}

}
