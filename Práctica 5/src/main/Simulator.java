package main;

import java.util.*;
import java.util.stream.Collectors;

import agent.Agent;
import agent.IBasicAgent;
import element.Cell;
import element.FactoryElementImpl;
import exception.IllegalPositionException;
import matrix.MatrixImpl;

public class Simulator {

	protected MatrixImpl<Cell> matrix;

	/**
	 * constructor del simulador
	 * 
	 * @param rows
	 *            el numero de filas de su matriz
	 * @param cols
	 *            el numero de columnas de su matriz
	 */
	public Simulator(int rows, int cols) {
		this.matrix = new MatrixImpl<Cell>(rows, cols, new FactoryElementImpl<Cell>());
	}

	/**
	 * la entrada de ejecucion
	 * 
	 * @param args
	 * @throws IllegalPositionException
	 */
	public static void main(String[] args) throws IllegalPositionException {
		Simulator s = new Simulator(10, 10);
		Agent random = new Agent("random");
		Agent outer = new Agent("outer");
		random.addBehaviour(agent -> { // se ejecuta siempre, movemos el agente
										// a una casilla aleatoria vecina
			List<Cell> neighbours = agent.cell().neighbours();
			Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
			agent.moveTo(destination);
			return true;
		});
		outer.addBehaviour(agent -> agent.cell().getElement().size() > 5,
				// Lo ejecutamos si hay más de 5 agentes
				// en la celda actual
				agent -> { // nos movemos a la celda destino con menos agentes
					List<Cell> neighbours = agent.cell().neighbours();
					Integer minAgents = neighbours.stream().mapToInt(c -> c.agents().size()).min().getAsInt();
					List<Cell> destinations = neighbours.stream().filter(c -> c.agents().size() == minAgents)
							.collect(Collectors.toList());
					Cell destination = destinations.get(new Random().nextInt(destinations.size()));
					agent.moveTo(destination);
					return true;
				});
		s.create(random, 100, 5, 5); // Crear 100 agentes random
		s.create(outer, 100, 7, 7); // Crear 100 agentes "outer"
		s.run(60); // Ejecutar 60 pasos de simulacion
	}

	/**
	 * ejecuta los comportamientos de todos los elementos de la matriz e imprime
	 * el resultado
	 * 
	 * @param time
	 *            el numero de iteraciones a ejecutar
	 */
	private void run(int time) {
		int i, j;
		Cell cell;
		Set<IBasicAgent> agents = new HashSet<>();
		for (int iter = 0; iter < time; iter++) {
			for (i = 0; i < this.matrix.getRows(); i++) {
				for (j = 0; j < this.matrix.getCols(); j++) {
					try {
						cell = this.matrix.getElementAt(i, j).getElement();
						if (cell != null) {
							for (IBasicAgent a : cell.agents()) {
								if (a != null) {
									((Agent) a).exec();
									agents.add(a);
								}
							}
						}
					} catch (IllegalPositionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(this.matrix);
			for (IBasicAgent a : agents) {
				((Agent) a).move();
			}
		}

	}

	/**
	 * crea n agentes en la posicion especificada
	 * 
	 * @param agent
	 *            el agente del que crear las copias
	 * @param number
	 *            el numero de copiar a crear
	 * @param i
	 *            la posicion i donde crear
	 * @param j
	 *            la posicion j donde crear
	 * @throws IllegalPositionException
	 */
	private void create(Agent agent, int number, int i, int j) throws IllegalPositionException {
		int iter = 0;
		Cell c = this.matrix.getElementAt(i, j).getElement();
		if (c == null) {
			c = new Cell(i, j, new LinkedList<>(), this.matrix);
			agent.setCell(c);
			c.add(agent);
			iter++;
			this.matrix.getElementAt(i, j).setElement(c);
		}
		for (; iter < number; iter++) {
			agent.copy();
		}

	}

}
