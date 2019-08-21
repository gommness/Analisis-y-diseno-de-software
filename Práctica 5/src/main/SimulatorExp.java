package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import agent.Agent;
import agent.AgentWithState;
import agent.IBasicAgent;
import element.Cell;
import exception.IllegalPositionException;

public class SimulatorExp extends Simulator {

	public SimulatorExp(int rows, int cols) {
		super(rows, cols);
	}

	/**
	 * la entrada de ejecucion
	 * @param args
	 * @throws IllegalPositionException
	 */
	public static void main(String[] args) throws IllegalPositionException {
		SimulatorExp simulator = new SimulatorExp(10, 10);

		AgentWithState outer = new AgentWithState("outer", "idle", "active"); // dos estados: idle y active

		outer.state("idle").toState("active", agent -> agent.cell().agents().size() > 5);
		outer.state("active").toState("idle", agent -> agent.cell().agents().size() <= 5);
		outer.state("active").addBehaviour(agent -> {
			List<Cell> neighbours = agent.cell().neighbours();
			Cell destination = neighbours.get(new Random().nextInt(neighbours.size()));
			agent.moveTo(destination);
			return true;
		});
		simulator.create(outer, 100, 7, 7); // Crear 100 agentes "outer"

		simulator.run(60); // Ejecutar 60 pasos de simulacion
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
									((AgentWithState) a).exec();
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
	private void create(AgentWithState agent, int number, int i, int j) throws IllegalPositionException {
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
