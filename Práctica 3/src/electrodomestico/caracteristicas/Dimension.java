/**
 * 
 */
package electrodomestico.caracteristicas;

/**
 * Esta clase representa las dimensiones de ancho largo y alto.
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Dimension {

	private double ancho;
	private double largo;
	private double alto;

	/**
	 * @param ancho
	 *            la anchura del objeto (en metros)
	 * @param largo
	 *            la largura del objeto (en metros)
	 * @param alto
	 *            la altura del objeto (en metros)
	 */
	public Dimension(double ancho, double largo, double alto) {
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
	}

	/**
	 * este metodo creara una dimension a partir de una lista de Strings que
	 * contienen los datos
	 * 
	 * @param args
	 *            la lista de Strings con los datos
	 * @throws Exception
	 *             en caso de que el numero de datos sea incorrecto
	 */
	public Dimension(String... args) throws Exception {
		if (args.length < 3)
			throw new Exception("Error en el numero de argumentos");
		this.ancho = Double.parseDouble(args[0]);
		this.largo = Double.parseDouble(args[1]);
		this.alto = Double.parseDouble(args[2]);
	}

	/**
	 * @return el ancho del objeto (en metros)
	 */
	public double getAncho() {
		return ancho;
	}

	/**
	 * @param ancho
	 *            la anchura a asignar (en metros)
	 */
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return la largura del objeto (en metros)
	 */
	public double getLargo() {
		return largo;
	}

	/**
	 * @param largo
	 *            la largura a asignar (en metros)
	 */
	public void setLargo(double largo) {
		this.largo = largo;
	}

	/**
	 * @return la altura del objeto (en metros)
	 */
	public double getAlto() {
		return alto;
	}

	/**
	 * @param alto
	 *            la altura a asignar (en metros)
	 */
	public void setAlto(double alto) {
		this.alto = alto;
	}

	/**
	 * este metodo calcula el volumen en metros cubicos
	 * 
	 * @return el volumen del objeto (en metros cubicos)
	 */
	public double volumen() {
		return this.alto * this.ancho * this.largo;
	}

}
