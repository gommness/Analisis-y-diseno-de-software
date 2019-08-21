package element;

import java.util.*;

import agent.IBasicAgent;
import exception.IllegalPositionException;
import matrix.IMatrix;

public class Cell extends MatrixElementImpl<LinkedList<IBasicAgent>>{
	
	private IMatrix<Cell> master;
	
	
	
	/**
	 * Constructor de la celda
	 * @param i la posicion i en la matriz
	 * @param j la posicion j en la matriz
	 * @param list la lista de agentes que contendra la celda
	 */
	public Cell(int i, int j, LinkedList<IBasicAgent> list, IMatrix<Cell> master){
		super(i, j, list);
		this.master = master;
		/*for(IBasicAgent elem : list)
			elem.setCell(this);*/
			
	}
	
	/**
	 * añade un agente a las celdas
	 * @param e el agente a añadir
	 */
	public void add(IBasicAgent e){
		this.getElement().add(e);
	}
	
	/* (non-Javadoc)
	 * @see element.MatrixElementImpl#toString()
	 */
	@Override public String toString(){
		return "" + this.getElement().size();
	}

	/**
	 * devuelve una lista de las celdas vecinas a esta
	 * @return la lista de las celdas vecinas
	 */
	public List<Cell> neighbours() {
		List<IMatrixElement<Cell>> aux;
		List<Cell> output = new ArrayList<>();
		Cell cell;
		try {
			aux = this.master.getNeighboursAt(this.getI(), this.getJ());
		} catch (IllegalPositionException e) {
			e.printStackTrace();
			return null;
		}
		for(IMatrixElement<Cell> e : aux){
			if(e.getElement() != null)
				output.add(e.getElement());
			else
			{
				cell = new Cell(e.getI(),e.getJ(),new LinkedList<>(), this.master);
				e.setElement(cell);
				output.add(cell);
			}
		}
		return output;
	}

	/**
	 * devuelve la lista de los agentes de esta celda
	 * @return la lista de los agentes de esta celda
	 */
	public List<IBasicAgent> agents() {
		return this.getElement();
	}
	public IMatrix<Cell> getMaster(){
		return this.master;
	}

}
