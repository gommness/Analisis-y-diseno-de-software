package agent;

import element.Cell;

public interface IBasicAgent {
	/**
	 * devuelve la celda a la que pertenece
	 * @return la celda a la que pertenece
	 */
	public Cell cell();
	/**
	 * devuelve una copia del agente
	 * @return una copia del agente
	 */
	public IBasicAgent copy();
}
