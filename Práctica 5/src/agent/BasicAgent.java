package agent;

import element.Cell;

public class BasicAgent implements IBasicAgent{

	private Cell cell = null;
	private String nombre;
	
	/**
	 * constructor de basic agent
	 * @param nombre el nombre del agente
	 */
	public BasicAgent(String nombre){
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see agent.IBasicAgent#cell()
	 */
	@Override
	public Cell cell() {
		return this.cell;
	}

	/* (non-Javadoc)
	 * @see agent.IBasicAgent#copy()
	 */
	@Override
	public IBasicAgent copy() {
		return new BasicAgent(this.nombre);
	}

	/**
	 * devuelve la celda a la que pertenece
	 * @return la celda a la que pertenece
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * asigna una celda al agente
	 * @param cell la celda a asignar
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	/**
	 * devuelve el nombre del agente
	 * @return el nombre del agente
	 */
	public String getNombre(){
		return this.nombre;
	}
	/**
	 * le asigna un nombre al agente
	 * @param nombre el nombre del agente
	 */
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
}
