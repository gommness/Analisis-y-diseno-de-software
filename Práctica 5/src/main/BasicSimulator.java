package main;

import java.util.Arrays;
import java.util.LinkedList;

import agent.BasicAgent;
import agent.IBasicAgent;
import element.Cell;
import element.FactoryElementImpl;
import exception.IllegalPositionException;
import matrix.MatrixImpl;

public class BasicSimulator{

	private MatrixImpl<Cell> matrix;
	
	/**
	 * Constructor del simulador basico
	 * @param rows el numero de filas de su matriz
	 * @param cols el numero de columnas de su matriz
	 */
	public BasicSimulator(int rows, int cols) {
		this.matrix = new MatrixImpl<Cell>(rows,cols,new FactoryElementImpl<Cell>());
	}
	
	/**
	 * la entrada de ejecucion
	 * @param args
	 * @throws IllegalPositionException
	 */
	public static void main(String[] args) throws IllegalPositionException {
		BasicSimulator s = new BasicSimulator(10,10);
		BasicAgent random = new BasicAgent("random");
		BasicAgent outer = new BasicAgent("outer");

		s.create(random, 10, 5, 5); // Crea 10 agentes de tipo random en la posición (5,5)
		s.create(outer, 10, 7, 7); // Crea 10 agentes de tipo outer en la posición (7,7)
		s.run(2);
	}

	/**
	 * imprime todos su matri tantas veces como indique time
	 * @param time el numero de iteraciones a ejecutar
	 */
	private void run(int time) {
		int i;
		for(i=1; i<=time; i++){
			System.out.println("++++++++++++++++++++++++");
			System.out.println("time: " + i);
			System.out.println(this.matrix);
		}
	}

	/**
	 * crea un numero <<number>> de agentes en la posicion indicada
	 * @param agent el agente del que copiar
	 * @param number el numero de agentes que se desean tener
	 * @param i la posicion i
	 * @param j la posicion j
	 * @throws IllegalPositionException
	 */
	private void create(IBasicAgent agent, int number, int i, int j) throws IllegalPositionException {
		int iter = 0;
		Cell c = this.matrix.getElementAt(i, j).getElement();
		if(c == null)
		{
			c = new Cell(i,j,new LinkedList<>(Arrays.asList(agent)),this.matrix);
			iter ++;
			this.matrix.getElementAt(i, j).setElement(c);
		}
		for(;iter<number;iter++){
			this.matrix.getElementAt(i, j).getElement().add(agent.copy());
		}
		
	}

}
