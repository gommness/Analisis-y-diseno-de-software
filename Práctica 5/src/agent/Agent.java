package agent;

import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;

import element.Cell;
import element.Pair;

public class Agent extends BasicAgent implements IAgent {

	private LinkedList<Pair<Predicate<IAgent>, Function<IAgent, Boolean>>> behaviours = new LinkedList<>();
	private Cell dest = null;

	/**
	 * Constructor de agentes
	 * 
	 * @param nombre
	 *            el nombre del agente
	 */
	public Agent(String nombre) {
		super(nombre);
	}

	/* (non-Javadoc)
	 * @see agent.IAgent#moveTo(element.Cell)
	 */
	@Override
	public void moveTo(Cell destination) {
		this.dest = destination;
	}

	/**
	 * actualiza la posicion del agente
	 */
	public void move() {
		if (this.dest != null) {
			this.cell().getElement().remove(this);
			this.setCell(this.dest);
			this.cell().add(this);
		}
		this.dest = null;
	}

	/* (non-Javadoc)
	 * @see agent.IAgent#exec()
	 */
	@Override
	public void exec() {
		boolean flag;
		for (Pair<Predicate<IAgent>, Function<IAgent, Boolean>> par : this.behaviours) {
			flag = false;
			if (par.first.test(this) == true) {
				flag = par.second.apply(this);
			}
			if (flag == false)
				break;
		}
	}

	/* (non-Javadoc)
	 * @see agent.IAgent#addBehaviour(java.util.function.Predicate, java.util.function.Function)
	 */
	@Override
	public IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
		this.behaviours.add(new Pair<>(trigger, behaviour));
		return this;
	}

	/* (non-Javadoc)
	 * @see agent.IAgent#addBehaviour(java.util.function.Function)
	 */
	@Override
	public IAgent addBehaviour(Function<IAgent, Boolean> behaviour) {
		this.behaviours.add(new Pair<>(agent -> true, behaviour));
		return this;
	}

	/* (non-Javadoc)
	 * @see agent.BasicAgent#copy()
	 */
	@Override
	public IAgent copy() {
		Agent clone = new Agent(this.getNombre());
		clone.behaviours = this.behaviours;
		this.getCell().add(clone);
		clone.setCell(this.getCell());
		return clone;
	}

}
