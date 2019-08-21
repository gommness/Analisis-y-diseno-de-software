package es.uam.eps.p4.apartado5;

import es.uam.eps.p4.estadistica.*;

/**
 * Esta clase la usamos para tener la media y la desviacion tipica almacenada en
 * una sola variable
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class CaseEstadistico {
	private Mean media;
	private StdDev desviacion;

	/**
	 * @param media
	 *            a asignar
	 * @param desviacion
	 *            a asignar
	 */
	public CaseEstadistico(Mean media, StdDev desviacion) {
		this.media = media;
		this.desviacion = desviacion;
	}

	/**
	 * @return the media
	 */
	public Mean getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(Mean media) {
		this.media = media;
	}

	/**
	 * @return the desviacion
	 */
	public StdDev getDesviacion() {
		return desviacion;
	}

	/**
	 * @param desviacion
	 *            the desviacion to set
	 */
	public void setDesviacion(StdDev desviacion) {
		this.desviacion = desviacion;
	}

}
